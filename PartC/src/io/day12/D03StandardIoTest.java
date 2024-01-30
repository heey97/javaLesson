package io.day12;

public class D03StandardIoTest {
    //표준 입출력 테스트
    public static void main(String[] args) {
        int b;
        System.out.println("입력하세요. ↓");
        try {
            int count = 0;
            while((b=System.in.read()) != -1){ // -1 은 입력끝을 의미하는 ctrl+Z
                //b=System.in.read();     //원초적입력
                //System.out.println(b); // 문자 인코딩 안하고 정수값 출력
                System.out.write(b);
                count++;
            }
            System.out.println("총 입력 : "+ count);

            b=System.in.read();     //원초적입력
            System.out.println(b);

            b=System.in.read();     //원초적입력
            System.out.println(b);

        } catch (Exception e) {
            System.out.println("예외 : "+e.getMessage());
        }
    }
}
