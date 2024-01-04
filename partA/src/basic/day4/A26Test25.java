package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {
        //A25 클래스에서 만든 메소드를 사용할 수 있습니다.
        int result = A25MySampleMethod.addMToN(2, 5);
        System.out.println(result);

        //메소드가 private 면 다른 클래스에서 정의할 수 없다
        //A25MySampleMethod.checkJumsu();

        //자바(또는 다른 프로그래밍언어)로 코딩할 떄
        //1. 자바에서 제공하는 클래스와 메소드를 잘 활용하기.
        //2. 필요에 따라 개발자가 직접 잘 만들어서 사용하기.
        String a ="11";                                       
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("시작 값 입력하세요. >>> ");
        int start = sc.nextInt();
        System.out.print("마지막 값 입력하세요. >>> ");
        int end = sc.nextInt();
        
        System.out.println(start + " ~ "+end+" 까지의 곱하기 결과 : " + A25MySampleMethod.multiplyMToN(start, end));
    }

}
