package io.day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07ImageFileCopy {

    public static void main(String[] args) {
        //System에서 시작측정 메소드 : 나노세컨드 10억분의 1,ms 1000분의 1
        long start = System.nanoTime();
        //처리할 메소드
        copyByBuffer();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));
    }
    
    public static void copyByByte() {
        int b; int count=0;

        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
            FileOutputStream fos = new FileOutputStream("계곡복사.jpg");
            while((b=fis.read()) != -1){      //1바이트 씩 복사하기(파일fis에서 파일fos 로)
                fos.write(b);
                count++;
            }
        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    // count : 1325184
    // 소요시간 : 30,395,863,100 ns

    public static void copyByByteArray() {
        int b; int count=0;
        byte[] buffer = new byte[1024];

        //try with resources - try ()안에 close 해야할 자원(리소스, 파일 입출력 스트림) 을 선언하면
        //                   - finally 없이 close를 자동으로 합니다. 이 떄 자원은 Closeable 인터페이스 구현체여야 합니다.
        try
        { FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
          FileOutputStream fos = new FileOutputStream("sea.png");
            while((b=fis.read(buffer,0,buffer.length)) != -1){
                   
                fos.write(buffer,0,b);   
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
        // 복사한 파일 크기 : 바이트
        // 소요시간 : ns
        //소ㅓ요시간 줄이기위해 버퍼입출력씀

    public static void copyByBuffer(){
        int b;
        int count=0;
        byte[] buffer = new byte[1024];             //바이트배열을 이용해서 1024바이트씩 입출력
                                                    // -> 버퍼에서 사용. 버퍼입출력 스트림
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
            FileOutputStream fos = new FileOutputStream("ㅎㅎ계곡.jpg");
            BufferedInputStream bis = new BufferedInputStream(fis);                 //보조 버퍼입력스트림
            BufferedOutputStream bos = new BufferedOutputStream(fos);               //보조 버퍼출력스트림
                while((b=bis.read(buffer,0,buffer.length)) != -1){
                    //read(배열이름,시작위치,최대길이) 리턴값 b는 실제 읽어온 바이트 수
                    //길이 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리가능 
                    bos.write(buffer,0,b); //write(배열이름,시작인덱스,출력길이)
                    count+=b;
            }
        } catch (Exception e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    
}
