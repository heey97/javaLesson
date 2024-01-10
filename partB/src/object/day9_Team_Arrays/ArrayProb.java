package object.day9_Team_Arrays;

import java.util.Arrays;

public class ArrayProb {
    public static void main(String[] args) {
        
        /*****문제1*****/
        //다음 7자리 배열 iArr에 0부터 끝까지 숫자를 차례대로 집어넣었을 떄 배열의 합산을 출력하시오.
        /*1).*/ 
        int[] iArr1 = new int[7];
        int sum=0;  

        for(int i=0; i<iArr1.length; i++){
            iArr1[i]= i;
            sum += iArr1[i];
        }
        System.out.println(sum);




        String s = "hi_my_Name_is_3";
        String[] sArr1 = s.split("_");
        System.out.println(Arrays.toString(sArr1));


        /*****문제3*****/
        String[] sArr2 = new String[5];
        int idx = 0;
        for(int i=sArr2.length-1;i>=0;i--){
            sArr2[i] = sArr1[idx];
            idx++; 
        }
        s = String.join("_",sArr2);
        System.out.println(s);


        /*****문제4*****/
        //다음과 같은 iArr3[] 배열에 배열 temp[]를 저장하고 temp[2] 의 값을 20으로 재지정 하였다. 
        //이 떄 iArr3 배열을 출력했을때 적절한것은?
        int[] iArr2 = {53,26,66,20,101};
        int[] temp = iArr2;
        temp[2] =20;
        System.out.println(Arrays.toString(iArr2));
        // 1) 53,20,66,20,101, 2)53,26,66,20,101, 3)53,26,20,66,101, 4)53,26,20,20,101, 5)0,0,0,0,0
        //1. 

        /*****문제5*****/
        //다음 문자열을 char배열 messageArray의 각 인덱스에 담아 인덱스별로 -2한 후 출력하시오
        String message = "Jk o{ pcog ku 5";
        char[] messageArray = new char[message.length()];

        for(int i =0; i<messageArray.length;i++){
            char cha = message.charAt(i);
            messageArray[i] = cha;
        }
        for(int i=0; i<messageArray.length;i++){
            messageArray[i] -= 2;
        }
        System.out.println(Arrays.toString(messageArray));
    }
}
