package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionUtil {
     
    //Connection 타입 객체 생성하는 메소드.
    //Connection conn = OracleConnectionUtil.getConnection(); 로 사용할 것 입니다.
    // url 은 변하지 않으니까 상수처리
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USER = "c##idev";
    public static final String PASSWORD = "9999";

     public static Connection getConnection() {
        // 1) ojdbc11.jar 라이브러리 프로젝트에 추가
        Connection conn = null;
        
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            System.out.println("오라클 데이터베이스 연결 예외 발생 \n\t "+e.getMessage());
        }
        return conn;
    }
    //실행순서 : 1)getConnection        2) SQL 실행         3) close
    //SQL 실행 1 : 개발 프로그램에서 가장 많이 실행시키는 SQL은 DML 입니다. 
    //             OracleConnectionUtil 은 1), 3)에서 사용될 것입니다.

    //인자로 전달된 Connection 객체를 close. sql 실행이 끝나면 close 해야 합니다
    public static void close(Connection conn){
        try {
            if(conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("오라클 데이터베이스 연결 해제 예외 발생 \n\t "+e.getMessage());
        }
    }
}
