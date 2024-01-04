package basic.day5;

import java.util.Arrays;

public class A29ArrayVarTest {
    public static void main(String[] args) {
        int[] iArray = {1,2,3,4,5};
        double[] dArray = new double[]{12,3,4};
        char[] cArray = new char[5];

        cArray[0] = 'j';
        cArray[1] = 'a';
        cArray[2] = 'v';
        cArray[3] = 'a';
        cArray[4] = '!';

        System.out.print("\n1.   ");
        System.out.println(iArray);
        System.out.print("\n2.   ");
        System.out.println(Arrays.toString(dArray));
        System.out.print("\n3.   ");
        System.out.println(cArray);


        int[] temp;
        temp = iArray;
        System.out.print("\n4.   ");
        System.out.println(temp);

        System.out.println("\n5. 참조값을 전달받은 temp 배열 확인");
        temp[3] = 999;
        System.out.println("temp[3] =" + temp[3]);
        System.out.println("temp 배열의 값 : " + Arrays.toString(temp));
        System.out.println("\n6. 어라?? iArray도 똑같네 ~~ !!!");
        System.out.println("iArray[3] =" + iArray[3]);
        System.out.println("iArray 배열의 값 : " + Arrays.toString(temp));


        //다른 인덱스의 값도 확인
        iArray[1] = 1234;
        System.out.println("\n7. temp배열과 iArrays 는 하나의 배열을 가리킵니다. !!!");
        System.out.println("temp 배열의 값 :" + Arrays.toString(iArray));

        int age =23;
        int itemp;
        itemp = age;
        age = 100; //age만 변경, itemp 는 23 => 기본형 타입 변수는 값을 전달하기 떄문입니다.
    }
}
