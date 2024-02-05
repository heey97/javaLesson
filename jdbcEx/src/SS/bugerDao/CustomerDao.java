package SS.bugerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import jdbc.vo.CustomerVo;

public class CustomerDao {
        public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //////////////여기 하고있었음ㅎㅎ 멍청아
    public List<CustomerVo> selCustomer(String id){
        String sql ="SELECT * "+
                    "FROM TBL_CUSTOMER "+
                    "WHERE id = ?";
        List<CustomerVo> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                CustomerVo vo =  new CustomerVo(rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getDate(5));
                list.add(vo);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
}
