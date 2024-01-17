package io.day14;

import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//socket.png 그림참고 : 클라이언트오 서버 각각 실행하는 메소드가 다릅니다.
//                      서버와 클라이언트 연결 과정이 다르기 떄문
//   프로그램 실행은 서버가 먼저 실행하기
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress("192.168.30.7",5050));
            System.out.println("[서버프로그램 시작] : 연결 요청을 기다리는 중입니다. ");
            //클라이언트 요청(connect)에 한 수락
            socket = server.accept();    //입출력 스트림을만들 소켓
            System.out.println("연결을 수락합니다.");            //accept 정상 완료되면 실행
            
            //서버가 클라이언트에게 데이터 보내기 : 출력 스트림
            //클라이언트와 서버가 연결된 소켓으로 출력 스트림 생성((소켓)주소)
            OutputStream os = socket.getOutputStream();
            //정수,실수,문자열 보내는 스트림
            DataOutputStream dos = new DataOutputStream(os); // 보조 스트림
            dos.writeUTF("\tFrom 서버 >> 환영합니다 히영");

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String message = dis.readUTF();
            System.out.println(message);

            BufferedOutputStream bos = new BufferedOutputStream(
                                       new FileOutputStream("D:\\dog.png"));
             
            int b; int count =0;
            while((b=dis.read())!=   -1){ 
                bos.write(b); //버퍼 스트림 이용한 바이트 단위 출력
                 count++;}
                 System.out.println("받았다");     

        } catch (IOException e) {
            e.printStackTrace();
        } finally{//자원해제 , close처리
            try {server.close(); socket.close();} catch (IOException e) {}
        }
    }
}
