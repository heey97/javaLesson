package io.day12;

import java.io.File;
import java.io.IOException;

//File 클래스
public class D02CheckedExceptionTest {
    public static void main(String[] args) {

        //생성하려는 파일의 이름으로 file 객체를 정의
        //File file = new File("F:\\테스트.md"); // 없는 드라이브를 경로로 지정하여 에러발생
        File file = new File("테스트2.md");
        //프로젝트와 같은 폴더에 디렉토리를 지정하지않으면 에러남
        //파일을 생성하는 메소드

        //파일의 내용을 가져오려면 Stream 을 만들어야한다.
        try {
            //if(file.exists()) //파일잇냐
            System.out.println("파일잇냐"+file.exists());
            file.createNewFile();
            System.out.println("파일의 길이" + file.length());
            
        } catch (IOException e) {
            System.out.println("파일 생성에 오류가 발생했습니다.");
            System.out.println(e.getMessage());
        }
        
    }
}
