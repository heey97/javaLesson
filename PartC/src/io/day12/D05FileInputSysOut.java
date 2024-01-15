package io.day12;

import java.io.FileInputStream;
import java.io.IOException;

public class D05FileInputSysOut {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("테스트.md");
            int b;
            int count =0;
            //byte기반의 스트림 read 메소드는 데이터를 1바이트씩 읽어옵니다.
            while ((b=fis.read()) != -1){//파일에 끝을 만나면 -1입니다.
                System.out.write(b);
                count++;
            }
            System.out.println("count : "+ count);
        } catch (IOException e) {
            System.out.println("파일 입력 중 예외 발생"+ e.getMessage());
        }
    }
}
