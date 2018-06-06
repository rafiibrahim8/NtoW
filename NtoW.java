import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;


public class NtoW {

	private JFrame frame;
	NumWord myNum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NtoW window = new NtoW();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NtoW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Number to Word");
		frame.setResizable(false);
		
		JScrollPane scrollPaneOut = new JScrollPane();
		scrollPaneOut.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneOut.setBounds(10, 157, 414, 93);
		frame.getContentPane().add(scrollPaneOut);
		
		JTextArea textWord = new JTextArea();
		textWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPaneOut.setViewportView(textWord);
		textWord.setWrapStyleWord(true);
		textWord.setLineWrap(true);
		
		JScrollPane scrollPaneIn = new JScrollPane();
		scrollPaneIn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneIn.setBounds(10, 28, 414, 36);
		frame.getContentPane().add(scrollPaneIn);
		
		JTextArea numText = new JTextArea();
		numText.setFont(new Font("Calibri", Font.BOLD, 16));
		scrollPaneIn.setViewportView(numText);
		
		JCheckBox isUpper = new JCheckBox("Upper Case");
		isUpper.setFont(new Font("Arial", Font.BOLD, 14));
		isUpper.setBounds(300, 110, 128, 23);
		frame.getContentPane().add(isUpper);
		
		JButton convButton = new JButton("Convert");
		convButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=numText.getText();
				int err=isInv(str);
				if(err>0)
				{
					switch(err) {
					case 1:
						JOptionPane.showMessageDialog(null, "Input is too long.");
		                break;
		            case 2:
		            	JOptionPane.showMessageDialog(null, "Input is empty.");
		                break;
		            case 3:
		            	JOptionPane.showMessageDialog(null, "Input is not valid.");
		                break;
		            default:
		                break;
					}
				}
				else
				{
					myNum=new NumWord(str);
					textWord.setText(myNum.display(isUpper.isSelected()));
				}
			}
		});
		convButton.setBackground(new Color(255, 218, 185));
		convButton.setFont(new Font("Calibri", Font.BOLD, 20));
		convButton.setBounds(115, 85, 159, 48);
		frame.getContentPane().add(convButton);
		
		JLabel rLvl = new JLabel("In Word:");
		rLvl.setFont(new Font("Arial", Font.BOLD, 14));
		rLvl.setBounds(10, 132, 95, 14);
		frame.getContentPane().add(rLvl);
		
		JLabel lblNewLabel = new JLabel("Enter A Number:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 147, 14);
		frame.getContentPane().add(lblNewLabel);

	}
	
    public static int isInv(String s){
        int r=0;
        if(s.length()>66)
            return 1;
        else if(s.length()==0)
        	return 2;
        char[] arr=s.toCharArray();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]<'0' || arr[i]>'9')
            {
                r=3;
                break;
            }
        }
        return r;
    }
}
