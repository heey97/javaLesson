package io.day12;

import java.io.FileOutputStream;
import java.io.IOException;

public class D04KeyInputFileOut {
    public static void main(String[] args) throws IOException {
        int b;
        System.out.print("입력하기");
        FileOutputStream op = null;
        try {
            op = new FileOutputStream("note.txt");
            int count = 0;
            while((b=System.in.read())!= -1){
                //System.out.println(b) //문자 인코딩 안하고 정수값 출력
                //System.in.read() 로 입력받은 정수값을 문자로 인코딩 하는 메소드
                //System.out.write(b)               //표준 출력
                op.write(b);                        //파일출력스트림으로 데이터 보내기
                count++;
            }
            System.out.println("총입력바이트 수 : "+ count);
        } catch (Exception e) {
            System.out.println("예외 : "+e.getMessage());
        }finally{
            //입출력 자원해제는 여기서 하세용~~ 예외 발생 상관없이 처리해드려용~
             op.close();
        }
    }
}
// File Input -> 화면(표준)출력
// File Input -> file output (파일복사)
// 바이트 기반 스트림은 문자 형식의 파일이 아닐때 !
// 문자기반 스트림 : 문자단위 입출력 