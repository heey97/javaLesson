package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jdbc.vo.CustomerVo;
import oracle.net.nt.ConnOption;

public class TblCustomerDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";
    

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void join(CustomerVo vo){
        
        String sql="INSERT INTO TBL_CUSTOM "+
                        "VALUES(?,?,?,?,sysdate)";
        //auto close
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
                
                pstmt.setString(1, vo.getCustomId());
                pstmt.setString(2, vo.getName());
                pstmt.setString(3, vo.getEmail());
                pstmt.setInt(4, vo.getAge());
                
                pstmt.executeUpdate();
                } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
            
        }
    }

       // 회원 정보 수정
    public void modify(CustomerVo vo) {
        String sql= "UPDATE TBL_CUSTOM "+
                       "SET EMAIL = ?, AGE = ? "+
                     "WHERE CUSTOM_ID = ?";
  
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, vo.getEmail());
                pstmt.setInt(2, vo.getAge());
                pstmt.setString(3, vo.getCustomId());

                pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("modify 실행 예외 발생 : " + e.getMessage());
        }

    }

    // 회원 탈퇴
    public void delete(String customerId) {
        String sql= "DELETE FROM TBL_CUSTOM "+
                    "WHERE CUSTOM_ID = ?";
  
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, customerId);

                pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("delete 실행 예외 발생 : " + e.getMessage());
        }
    }

    //회원 정보 조회 : select * from tbl_custom where custom_id = ?
    public CustomerVo getCustomer(String customerId) {
        CustomerVo vo = null;
        String sql = "SELECT * FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, customerId);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            vo = new CustomerVo(rs.getString(1), 
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getDate(5));
        }

        }catch (SQLException e) {
            System.out.println("예외발생");
        }
        return vo;   //자바객체 list와 매핑한 결과 list 를 리턴
    }

    // 관리자를 위한 기능 : 모든 회원 정보 조회 : select * from tbl_custom
    public List<CustomerVo> allCustomers() {
        List<CustomerVo> list = new ArrayList<>();
        String sql = "SELECT * "+
                     "FROM TBL_CUSTOM";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
    public Map<String,CustomerVo> getCustomerMap(String customerId)       {
        Map<String,CustomerVo> map = new LinkedHashMap<String,CustomerVo>();
        String sql = "SELECT * FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";

        
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
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
        return map;
    }
    
}
