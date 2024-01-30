package jdbc.day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertDMLTest {
    public static void main(String[] args) {
        Connection conn = OracleConnectionUtil.getConnection();
        
        if (conn != null) System.out.println("데이터베이스 연결 성공 ㅎㅎ");

        String sql = "INSERT INTO TBL_CUSTOM(CUSTOM_ID,NAME,EMAIL,AGE,REG_DATE)"+
                     "VALUES(?,?,?,?,sysdate)";
                     //statement 는 실행하면서 컴파일함으로 create drop alter에 알맞습니다 . stmt.execute(sql)
        //preparedStatement 는 매개변수를 ?로 표기하고 sql을 미리 컴파일 합니다. dml에 알맞습니다 보안상으로 나중에 바인딩되어서 안전
        //                     매개변수 ?에 대입되는(바인딩) 값은 sql execute 메소드 이전에 합니다.
        try (PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            //auto close 위한 try 형식 - pstmt.close()필요하므로 try - with - resources
            //매개변수 바인딩 ?는 순서대로 인덱스를 갖습니다. 시작값1
            //                  응용프로그램에서 매개변수에 저장될 값은 사용자 입력값 입니다.
            pstmt.setString(1, "sana");
            pstmt.setString(2, "최사나");
            pstmt.setString(3, "sana@naver.com");
            pstmt.setInt(4, 26);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql 실행 예외 발생 \n\t "+e.getMessage());
        }finally{
            OracleConnectionUtil.close(conn);
        }
    }
    

    public static void fixed_data(){

    }
}
