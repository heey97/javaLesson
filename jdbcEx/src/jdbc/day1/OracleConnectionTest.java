package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {
    public static void main(String[] args) {
        // 1) ojdbc11.jar 라이브러리 프로젝트에 추가
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String user = "c##idev";
        String password = "9999";
        try {
            // 2) ojdbc11.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            Class.forName(driver);          //런타임 시점에 지정된 클래스명 로드
            // 3) Connection 구현 객체를 생성-DriverManager는 드라이버 관리하는 유틸리티 클래스
            conn = DriverManager.getConnection(url,user,password);
                                    //SQLException 예외 처리 필요.
            System.out.println("데이터베이스 연결 객체 :" + conn);
            if(conn != null){
                System.out.println("Connection 객체의 구현 클래스 : " + 
                                        conn.getClass().getName()); // Connection 구현 클래스 이름 확인
                                        //oracle.jdbc.driver.T4Connection 은 오라클의 COnnection 구현 클래스
                System.out.println("오라클 데이터베이스 연결 성공");
            }
        } catch (Exception e) {
            System.out.println("오라클 데이터베이스 연결 실패");
            System.out.println("예외발생 : "+ e.getMessage());
        }finally{
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}
