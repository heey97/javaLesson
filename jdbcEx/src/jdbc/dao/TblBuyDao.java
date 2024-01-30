package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.vo.BuyVo;
import jdbc.vo.CustomBuyVo;

public class TblBuyDao {
    
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //구매하기
    public void insert(BuyVo vo){
        // 할일1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
        String sql="INSERT INTO TBL_BUY \r\n" + 
                "VALUES (buy_pk_seq.nextval, ?,?,?,sysdate)";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   
                //할일2 : 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행합시다.)
               pstmt.setString(1, vo.getCustomid());
               pstmt.setString(2, vo.getPcode());
               pstmt.setInt(3, vo.getQuantity());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally 없음
    }

    //회원정보수정
    public void modify(BuyVo vo) {

        String sql=  "UPDATE tbl_buy " + 
                "SET QUANTITY = ? " + 
                "WHERE BUY_IDX = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   //매개변수 바인딩
                pstmt.setInt(1, vo.getQuantity());
                pstmt.setInt(2, vo.getBuyIdx());
                pstmt.executeUpdate();          //실행
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }
    //구매 취소
    public void delete(int buyIdx) {

        String sql=  "DELETE FROM tbl_buy \r\n" + //
                "WHERE BUY_IDX=?";
        try (
            Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
        )
            {   
                //매개변수 바인딩
                pstmt.setInt(1, buyIdx);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }
    public List<CustomBuyVo> selectBuyList(String id){
        String sql ="SELECT BUY_IDX ,tb.PCODE,PNAME,PRICE,QUANTITY ,BUY_DATE "+ 
                    "FROM TBL_BUY tb        "+
                    "JOIN TBL_PRODUCT tp    "+
                    "ON tb.PCODE =tp.PCODE  "+
                    "WHERE tb.CUSTOMID = ?  "+
                    "ORDER BY BUY_IDX";
        List<CustomBuyVo> list = new ArrayList<>();
        try (Connection conn = getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                CustomBuyVo vo = new CustomBuyVo(rs.getInt(1),
                                                rs.getString(2) ,
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getInt(5),
                                                rs.getTimestamp(6));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
 }
