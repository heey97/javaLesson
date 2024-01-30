package jdbc.day2;

import java.util.List;
import java.util.Map;

import jdbc.dao.TblBuyDao;
import jdbc.dao.TblProductDao;
import jdbc.vo.BuyVo;
import jdbc.vo.CustomBuyVo;
import jdbc.vo.CustomerVo;
import jdbc.vo.ProductVo;

public class CartApp_2 {

    //static이 많아지면 상속의 특징을 사용할 수 없습니다.


    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회    [P] 상품명 검색    [M] 나의 구매내역");
        System.out.println("[B] 구매하기    [D] 구매 취소    [Q] 구매 수량 변경    [X] 구매 종료");
        System.out.println(".".repeat(50));
    }

    //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
    //또는 상품명으로 검색 (구매할 상품 조회)
    //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
        
    public void showMypage(){

    }

    public void showCategory(){

    }
    public static void main(String[] args) {
        TblBuyDao bDao = new TblBuyDao();
        TblProductDao pDao = new TblProductDao();

        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customid = System.console().readLine();
        System.out.println(customid+" 환영한다.");

        boolean run = true;
        
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택>>>>>>>>>>\t");
            //int select = Integer.parseInt(System.console().readLine());
            String select = System.console().readLine();
            switch (select.toUpperCase()) {
                case "C":
                System.out.println("카테고리 : A1 - 과일 A2 - 수입과일 B1 - 인스턴스 B2 - 선물세트 C1 - 과자류");
                System.out.print("카테고리 입력__ ");
                String category = System.console().readLine();
                List<ProductVo> plist = pDao.selectByCategory(category);
                for(ProductVo vo : plist){
                    System.out.println(vo);
                }
                break;
                case "M":   //나의구매내역
                List<CustomBuyVo> clist = bDao.selectBuyList(customid);
                for(CustomBuyVo vo : clist){
                    System.out.println(vo);
                }
                break;
                case "P":
                System.out.print("상품명 검색어 입력__");
                String pname = System.console().readLine();
                

                plist = pDao.selectByName(pname);
                for(ProductVo vo: plist){
                    System.out.println(vo);
                }
                    break;
                case "B":
                //DOWON123a동원참치선물세트54000   CJBAb12g햇반 12개입14500 JINRMn5진라면 5개입6350 APLE5kg청송사과 5kg66000 MANGOTK4r애플망고 1kg32000
                //idx,custimid,pcode,quantity,buydate
                System.out.println("코드    상품명    가격");
                System.out.println("DOWON123a    동원참치선물세트    54000\n"+
                                   "CJBAb12g    햇반 12개입    14500\n"+
                                   "JINRMn5    진라면 5개입    6350\n"+
                                   "APLE5kg    청송사과 5kg    66000\n"+
                                   "MANGOTK4r    애플망고 1kg    32000");

                System.out.print("구매할 상품의 코드를 입력해주십시오__ ");
                String code = System.console().readLine();
                System.out.print("구매할 상품의 수량을 입력해주십시오__ ");
                int quantity = Integer.parseInt(System.console().readLine());
                
                BuyVo vo2 = new BuyVo(0, customid, code, quantity, null);
                bDao.insert(vo2);
                System.out.println("구매성공 완료하였습니다."+vo2);
                    break;
                case "D":
                    System.out.println("현재 구매내역 입니다.");
                    clist = bDao.selectBuyList(customid);
                    
                    for(CustomBuyVo vo : clist){
                        System.out.println(vo);
                    }
                    System.out.println("삭제할 항목의 번호를 선택해 주십시오.");
                    int idxNum = Integer.parseInt(System.console().readLine());
                    bDao.delete(idxNum);

                    System.out.println("삭제성공!");
                    break;
                case "Q":
                System.out.println("현재 구매내역 입니다.");
                clist = bDao.selectBuyList(customid);
                
                for(CustomBuyVo vo : clist){
                    System.out.println(vo);
                }
                    System.out.print("구매 수량을 수정할 항목의 번호를 선택해주십시오__ ");
                    idxNum = Integer.parseInt(System.console().readLine());
                    System.out.print("변경 하실 구매수량을 입력해주십시오. __");
                    quantity = Integer.parseInt(System.console().readLine());
                    BuyVo modify = new BuyVo(idxNum, null, null, quantity, null);
                    
                    bDao.modify(modify);
                    System.out.println("변경된 항목 : " + modify);
                    break;
                case "X":
                    run=false;
                    break;
                default:
                    break;
            }
        }

    }
}  
 // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java 
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java  
    //         테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.     
    //         insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.       
