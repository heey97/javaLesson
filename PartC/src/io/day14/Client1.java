package io.day14;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//socket.png 그림참고 : 클라이언트오 서버 각각 실행하는 메소드가 다릅니다.
//                      서버와 클라이언트 연결 과정이 다르기 떄문
//   프로그램 실행은 서버가 먼저 실행하기
public class Client1 {
    
    public static void main(String[] args) {
        Socket socket = null;
        try {
            System.out.println("클라이언트 프로그램 입니다.");
            socket = new Socket();
            //시간 중지 타임 설정
            Thread.sleep(3000); //3초간 중지 (3000ms);

            //서버에서 설정한 bind 정보와 같은 객체를 만듭니다.
            socket.connect(new InetSocketAddress("192.168.30.7",5050));
            System.out.println("연결 성공 하였습니다");

            
            //서버가 보낸 메세지 받기ㅣ
        
            InputStream is = socket.getInputStream();
            //정수,실수,문자열 보내는 스트림
            DataInputStream dis = new DataInputStream(is); // 보조 스트림
            String message = dis.readUTF();
            System.out.println(message);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            System.out.println("서버에게 보낼 메세지");
            message = System.console().readLine();
            dos.writeUTF("\tFrom 클라이언트 >>" +message);
        
            /******************* 파일****************************** */

            String filepath = "D:\\Class231228\\java\\hi.png";
            FileInputStream fis = new FileInputStream(filepath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int b;
            while((b=bis.read()) != -1){
                dos.write(b);
            }
            System.out.println("전송성공");
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally{//자원해제 , close처리
            try {socket.close();} catch (IOException e) {}
        }
    }
}
