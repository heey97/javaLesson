package jdbc.day2;

import java.util.List;
import java.util.Map;

import jdbc.dao.TblBuyDao;
import jdbc.dao.TblCustomerDao;
import jdbc.dao.TblProductDao;
import jdbc.vo.CustomBuyVo;
import jdbc.vo.CustomerVo;
import jdbc.vo.ProductVo;

public class CustomerMain {
    public static void main(String[] args) {
        // System.out.println("[고객관리시스템]고객을 조회합니다.");
        // System.out.print("고객 아이디 입력 __");
        // String customerId = System.console().readLine();
        // System.out.println("\n 조회결과");

        // TblCustomerDao dao = new TblCustomerDao();
        // CustomerVo vo = dao.getCustomer(customerId);
        // Map<String,CustomerVo> vo2 = dao.getCustomerMap(customerId);


        // if(vo==null)
        // System.out.println("조회한 고객이 존재하지 않습니다.!BB");
        // else
        //     System.out.println(vo);
        //     System.out.println(vo2);

            // System.out.println("입력해라.");
            // String category = System.console().readLine();
            // TblProductDao dao1 = new TblProductDao();
            // Map<String, ProductVo> categorySel = dao1.selectByCategory(category);
            // System.out.println(categorySel);

            // System.out.println("이름으로적어라");
            // String name = System.console().readLine();
            // List<ProductVo> nameSel = dao1.selectByName(name);
            // System.out.println(nameSel);

            System.out.println("이름으로적어라");
            String name = System.console().readLine();
            TblBuyDao buydao = new TblBuyDao();
            List<CustomBuyVo> selBuy = buydao.selectBuyList(name);
            
            System.out.println(selBuy);

            
    }
}
