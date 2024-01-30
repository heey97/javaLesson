package jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import jdbc.vo.CustomerVo;

public class SelectDMLTest {
    
    static Connection conn = OracleConnectionUtil.getConnection();
    
    public static void main(String[] args) {
        //테이블 select 결과를 메소드 실행하여 받으면
        // 그 데이터는 콘솔 출력이 되거나 브라우저 화면 출력 또는 다른 목적으로 사용될 수 있으므로
        List<CustomerVo> result = selectAll_4();
        System.out.println("~~~~전체 회원 조회 결과~~~~");
        System.out.println(result);
    }
    public static List<CustomerVo> selectAll_4() {
        
        List<CustomerVo> list = new ArrayList<>();
        String sql = "SELECT * "+
                     "FROM TBL_CUSTOM";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                CustomerVo vo = new CustomerVo(rs.getString(1), 
                                               rs.getString(2),
                                               rs.getString(3),
                                               rs.getInt(4),
                                               rs.getDate(5));
                list.add(vo);
            }
                System.out.println(list);
        //dao 메소드에는 특별한 목적이 아니면 출력문 작성안합니다 출력은 메인에서
        } catch (SQLException e) {
            System.out.println("예외발생");
        }
        return list;   //자바객체 list와 매핑한 결과 list 를 리턴
    }
    
    public void selectAll_5(){
        
        Map<String,CustomerVo> map = new LinkedHashMap<String,CustomerVo>();
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                CustomerVo vo = new CustomerVo(rs.getString(1), 
                                               rs.getString(2),
                                               rs.getString(3),
                                               rs.getInt(4),
                                               rs.getDate(5));
                map.put(rs.getString(1),vo);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }



    public void selectAll_1() {
        
        //rs.next() 테스트 해보기 !!
        String sql = "select * from tbl_custom";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery(); // 쿼리 실행한 결과 행 집합을 처리하느 ㄴ인터페이스 : ResultSet

            rs.next();
            System.out.println(rs.getString(1)); // 1번 컬럼 값 가져오기
            System.out.println(rs.getString(2)); // 2번 컬럼 값 가져오기
            System.out.println(rs.getString(3)); // 3번 컬럼 값 가져오기
            System.out.println(rs.getInt(4)); // 4번 컬럼 값 가져오기
            //System.out.println(rs.getDate(5)); // 년월일
            System.out.println(rs.getTimestamp(5)); // 시분초까지
        } catch (SQLException e) {
            System.out.println("예외발생");
        };
    }

    public void selectAll_2() {
        //rs.next() 반복문을 이용하여 끝까지 출력하기
        String sql = "select * from tbl_custom";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            int count =0; 
            ResultSet rs = pstmt.executeQuery(); // 쿼리 실행한 결과 행 집합을 처리하느 ㄴ인터페이스 : ResultSet
            while(rs.next()){ // 읽어올 다음 레코드가 있으면 ~ TRUE
                System.out.println("no. " + ++count);
                System.out.print(rs.getString("custom_id")); // 1번 컬럼 값 가져오기
                System.out.print(", "+rs.getString("name")); // 2번 컬럼 값 가져오기
                System.out.print(", "+rs.getString("email")); // 3번 컬럼 값 가져오기
                System.out.print(", "+rs.getInt("age")); // 4번 컬럼 값 가져오기
                    //System.out.println(rs.getDate(5)); // 년월일
                System.out.println(", "+rs.getTimestamp("reg_date")); // 시분초까지
            }
            System.out.println("총"+count+"개의 레코드를 조회했습니다.");
        }catch (SQLException e) {
            System.out.println("예외발생");
        }
    }
    public void selectAll_3() {
        //3.레코드 행 1개를 자바 객체와 1:1로 매핑하기

        String sql = "SELECT * "+
                     "FROM TBL_CUSTOM";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                CustomerVo vo = new CustomerVo(rs.getString(1), 
                                               rs.getString(2),
                                               rs.getString(3),
                                               rs.getInt(4),
                                               rs.getDate(5));
                System.out.println(vo);
            }
        } catch (SQLException e) {
            System.out.println("예외발생");
        }
    }
    
}
