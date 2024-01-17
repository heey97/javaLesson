package io.day14;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class ThreadTest {
    public static void main(String[] args) {
        // 실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다.
        //  ㄴ 1초마다 , 출력하기 => 쓰레드로 만듭니다.
        // 1) Thread 클래스 상속받기 2) Runnable 인터페이스 구현하기

    //1) 쓰레드가 할일을 인터페이스 활용하여 정의합니다. => 정의클래스
    Runnable runnable = new Runnable() {
        @Override
        public void run(){
            boolean run = true;
            while(run){
                System.out.print(".");
                try {
                    Thread.sleep(500);    
                } catch (InterruptedException e) {
                    run = false;
                }
                //interrupt : 방해하다, 간섭하다, 끼어들다
            }
        }
    };
    //2) 쓰레드 생성하기. 할일은 생성자 인자로 전달
    Thread thread = new Thread(runnable);
    //3)쓰레드 실행하기
    thread.start();
    //System에서 시간측정 메소드 : 나노세컨드 10억분의 1, ms 1000분의 1
    long start = System.nanoTime();
    //처리할 메소드
        copyByByte(); //main 쓰레드 실행
    long end = System.nanoTime();
    System.out.println(String.format("소요시간 : %,d ns",(end-start)));

    thread.interrupt();
}
    public static void copyByByte(){
        int b; int count=0;

        try (FileInputStream fis = new FileInputStream("D:\\Class231228\\java\\hi.png");
        FileOutputStream fos= new FileOutputStream("뚱이.png");) {
             
                while((b=fis.read()) != -1 ){
                    fos.write(b);
                    count++;
                }
        } catch (Exception e) {
            System.out.println("\n파일 입출력 예외 :" + e.getMessage());
        }
        System.out.println(String.format("소요시간 %d ms",count));
    } 
}
