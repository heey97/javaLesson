package basic.day4;

public class ProbStringReverse {
    public static void main(String[] args) {
        
        String message = "Hello World";
        char[] messageArray = new char[message.length()];
        int length = message.length();
        int count =0;

        // for(int i = length-1; 0<=i;i--){
        //     char temp = message.charAt(i);
            
        //     messageArray[count] = temp; 
        //     count++;
        // }
        // System.out.println(messageArray);
        
        int cidx = message.length()-1;
        for(int i=0; i<message.length();i++){
            char temp = message.charAt(i);
            messageArray[cidx] = temp;
            cidx--;
        }
    }
}
