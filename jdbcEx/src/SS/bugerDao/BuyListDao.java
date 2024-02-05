package SS.bugerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import SS.bugerVo.BuyListVo;


public class BuyListDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    
    //구매 메소드
    public int insList(BuyListVo vo){
        String sql = "INSERT INTO TBL_BUYLIST                "+ 
                     "VALUES(LIST_SEQ.NEXTVAL,?,?,?,sysdate)";
        int chk = 0;
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getFcode());
            pstmt.setInt(3, vo.getQuantity());    
            
            chk = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("주문 실행 예외 :" + e.getMessage());
        }
        return chk;
    }


    //주문 취소 메소드
    public int delList(int idx){
        int chk = 0;
        String sql = "DELETE FROM TBL_BUYLIST "+
                     "WHERE idx = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idx);
            chk = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("주문 취소 실행 예외 : "+e.getMessage());
        }
        return chk;
    }

    public int upList(int idx,int quantity){
        int chk = 0;
        String sql = "UPDATE TBL_BUYLIST "+
                     "SET QUANTITY = ?   "+
                     "WHERE idx = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, idx);
            chk = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("주문 취소 실행 예외 : "+e.getMessage());
        }
        return chk;
    }

    //구매 내역 데이터 추출
    public Map<Integer,BuyListVo> selMap(int idx){
        String sql = "SELECT *         "+ 
                     "FROM TBL_BUYLIST ";
        Map<Integer,BuyListVo> map = new LinkedHashMap<>();
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    BuyListVo vo = new BuyListVo(rs.getInt(1),
                                                         rs.getString(2), 
                                                         rs.getString(3),
                                                         rs.getInt(4),
                                                         rs.getDate(5));
                map.put(idx,vo);
            }
        } catch (SQLException e) {
            System.out.println("주문 내역 조회 실행 예외 :" + e.getMessage());
        }
        return map;
    }


    public List<BuyListVo> selList(String id){
        String sql = "SELECT *         "+ 
                     "FROM TBL_BUYLIST  "+
                     "WHERE ID = ?";
        List<BuyListVo> list = new ArrayList<>();
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {       
                pstmt.setString(1, id);    
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                BuyListVo vo = new BuyListVo(rs.getInt(1),
                                                         rs.getString(2), 
                                                         rs.getString(3),
                                                         rs.getInt(4),
                                                         rs.getDate(5));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("주문 내역 조회 실행 예외 :" + e.getMessage());
        }
        return list;
    }

    public List<BuyListVo> selAllList(){
        String sql = "SELECT *         "+ 
                     "FROM TBL_BUYLIST";
        List<BuyListVo> list = new ArrayList<>();
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {    
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                BuyListVo vo = new BuyListVo(rs.getInt(1),
                                                         rs.getString(2), 
                                                         rs.getString(3),
                                                         rs.getInt(4),
                                                         rs.getDate(5));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("주문 내역 조회 실행 예외 :" + e.getMessage());
        }
        return list;
    }
}
