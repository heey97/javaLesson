package basic.day4;
//문자열은 문자의 집합. 따라서 문자열을 구성하는 문자 하나씩 가져와 배열에 저장해 봅시다.
public class A28CharArray {
    
    public static void main(String[] args) {
        String message = "Hello~ World~ 맛있다.";
        char[] messageArray = new char[message.length()];


        for(int i=0;i<messageArray.length;i++){
            char temp = message.charAt(i);
            System.out.println(temp);
            messageArray[i] = temp;
        }
        System.out.println(messageArray);
        char a = 'H'+7;
        System.out.println(a);

        //고대암호 : '모모'가 '나연'이 한테 비밀 메세지를 보냅니다. 암호문을 만듭니다.
        //           두 사람이 알고 있는 비밀키 값 key=7을 정했습니다. 암호문은??
        int key = 7;
        for(int i=0; i<message.length();i++){
            messageArray[i]+=key;
        }
        System.out.print("비밀 메세지 : ");
        System.out.println(messageArray);
        
        for(int i=0; i<message.length();i++){
            messageArray[i]-=key;
        }
        System.out.println("나연이는 받은 메세지를 읽으려합니다. 해독 한 암호문은 : ");
        System.out.println(messageArray);
    }
}
