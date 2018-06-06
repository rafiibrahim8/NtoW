
public class NumWord {
    private String wordConv="";
    private char[] numArr;
    
    private void toWord(int a,int b,int c){
        if(numArr[b]!='1')
        {
            wordConv=toFarWord(numArr[a])+toMiddleWord(numArr[b],numArr[c])+toBaseWord(numArr[c])+wordConv;
            
        }
        else
        {
            wordConv=toFarWord(numArr[a])+toMiddleWordTeen(numArr[c])+wordConv;
        }
    }
    
    private void addSuff(int a,int b,int c){
        if(!(numArr[a]=='0' && numArr[b]=='0' && numArr[c]=='0'))
                wordConv=getSuff(c)+wordConv;
    }
    
    private String toFarWord(char a){
        String str="";
        if(a!='0')
        {
            str=toBaseWord(a)+"hundred ";
        }
        return str;
    }
    
    private String toBaseWord(char a){
        String str="";
        switch (a) {
            case '1':
                str="one ";
                break;
            case '2':
                str="two ";
                break;
            case '3':
                str="three ";
                break;
            case '4':
                str="four ";
                break;
            case '5':
                str="five ";
                break;
            case '6':
                str="six ";        
                break;
            case '7':
                str="seven ";
                break;
            case '8':
                str="eight ";
                break;
            case '9':
                str="nine ";
                break;
            default:
                break;
        }
        return str;
    }
    
    private String getSuff(int a){
        String str="";
        switch (a) {
            case 3:
                str="thousand";
                break;
            case 6:
                str="million";
                break;
            case 9:
                str="billion";
                break;
            case 12:
                str="trillion";
                break;
            case 15:
                str="quadrillion";
                break;
            case 18:
                str="quintillion";
                break;
            case 21:
                str="sextillion";
                break;
            case 24:
                str="septillion";
                break;
            case 27:
                str="octillion";
                break;
            case 30:
                str="nonillion";
                break;
            case 33:
                str="decillion";
                break;
            case 36:
                str="undecillion";
                break;
            case 39:
                str="duodecillion";
                break;
            case 42:
                str="tredecillion";
                break;
            case 45:
                str="quattuordecillion";
                break;
            case 48:
                str="quindecillion";
                break;
            case 51:
                str="sexdecillion";
                break;
            case 54:
                str="septendecillion";
                break;
            case 57:
                str="octodecillion";
                break;
            case 60:
                str="novemdecillion";
                break;
            case 63:
                str="vigintillion";
                break;
            default:
                break;
        }
        if(wordConv.length()!=0)
            str=str+", ";
        
        return str;
    }
    
    private String toMiddleWord(char a,char p){
        String str="";
        switch (a) {
            case '2':
                str="twenty";
                break;
            case '3':
                str="thirty";
                break;
            case '4':
                str="forty";
                break;
            case '5':
                str="fifty";
                break;
            case '6':
                str="sixty";
                break;
            case '7':
                str="seventy";
                break;
            case '8':
                str="eighty";
                break;
            case '9':
                str="ninety";
                break;
            default:
                break;
        }
        if(p!='0' && a!='0')
            str=str+"-";
        else if(a!='0')
            str=str+" ";
        return str;
    }
    private String toMiddleWordTeen(char a){
        String str="";
        switch (a) {
            case '1':
                str="eleven ";
                break;
            case '2':
                str="twelve ";
                break;
            case '3':
                str="thirteen ";
                break;
            case '4':
                str="fourteen ";
                break;
            case '5':
                str="fifteen ";
                break;
            case '6':
                str="sixteen ";
                break;
            case '7':
                str="seventeen ";
                break;
            case '8':
                str="eighteen ";
                break;
            case '9':
                str="nineteen ";
                break;
            case '0':
                str="ten ";
                break;
            default:
                break;
        }
        return str;
    }
    
    public String display(boolean c){
    	if(wordConv.length()==0)
    		wordConv=wordConv+"zero";
    	if(c)
    		wordConv=wordConv.toUpperCase();
        return wordConv;
    }
            
    
    public NumWord(String input)
    {
        char[] inputArr=input.toCharArray();
        numArr=new char[66];
        for(int i=0;i<66;i++)
        {
            numArr[i]='0';
        }
        
        for(int i=inputArr.length-1,j=0;i>=0;i--,j++)
        {
            numArr[j]=inputArr[i];
        }
        
        for(int i=0;;)
        {
            toWord(i+2,i+1,i);
            i+=3;
            if(i>65)
                break;
            addSuff(i+2,i+1,i);
        }
        
    }
}
