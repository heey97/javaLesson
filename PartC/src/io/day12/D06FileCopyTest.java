package io.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D06FileCopyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\KakaoTalk_20240115_164444448.jpg");
            fos = new FileOutputStream("뚱이.png");
            int count = 0;
            int b;
            while((b=fis.read()) != -1){
                fos.write(b);
                count++;
            }
            System.out.println("count : " + count);      
        } catch (IOException e) {
            System.out.println("파일 입출력 예외"+ e.getMessage());
        }finally{
            try {fis.close(); fos.close();} catch (Exception e) {}
        }
    }
}
