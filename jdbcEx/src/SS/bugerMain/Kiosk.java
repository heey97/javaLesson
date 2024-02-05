package SS.bugerMain;

import java.util.ArrayList;
import java.util.List;

import SS.bugerDao.BuyListDao;
import SS.bugerDao.FoodDao;
import SS.bugerVo.BuyListVo;
import SS.bugerVo.FoodVo;


public class Kiosk {

    private String id = null;
    private BuyListDao buyDao = new BuyListDao();
    public FoodDao foodDao = new FoodDao();
    public static Kiosk app = new Kiosk();
    private int chk = 0;
    private String cate = null;
    


    public static void main(String[] args) {
        app.start();
    }

    // 메뉴 
    public void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[L] 메뉴    [S] 메뉴 검색     [I]주문 하기     [D] 주문 취소");
        System.out.println("[M] 주문 수정    [B] 구매 내역   [X] 구매 종료");
        System.out.println(".".repeat(70));
    }
    // 메인에서 제일 처음 실행 될 메소드
    public void start() {
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __ ");
        id = System.console().readLine();
        if(id != )
        System.out.println( id+" 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            
            System.out.println("\n\t"+"-".repeat(10)+" 짭데리아 메뉴 목록 입니다. "+"-".repeat(10));
            showMenu();
            System.out.print("\n선택하세요>>> ");   
            String select = System.console().readLine();
            switch (select.toUpperCase()) {
                case "L": 
                // 메뉴 선택 (전체메뉴조회, 저렴한 버거 검색, 저칼로리 버거 검색, 추천 버거 검색)
                menu();
                    break;
                case "S":
                // 메뉴 조회
                    break;  
                case "I":
                insBuyList();
                    break;
                case "D":
                delBuyList();
                    break;
                case "M":
                System.out.println(buyDao.selList(id));
                    break;
                case "B":
                selBuyList();
                    break;
                case "X":
                    run=false;
                    break;       
                default:
                    break;
            }
            
        }

    }
    // 메뉴집합 메뉴
    public void menu(){
        
        boolean run = true;
        while(run){
        try {
        System.out.println("\n"+".".repeat(70));
        System.out.println("[1] 전체 메뉴 조회     [2] 버거 조회    [3] 치킨 조회    [4] 디저트 조회    [5] 음료수 조회");
        System.out.println("[6] 아이스크림 조회    [7] 알뜰 버거 조회    [8] 저칼로리 버거 조회     [9] 버거 세트 조회    [10] 추천 세트 조회( 10% 할인 행사 !) ");
        System.out.println("[0] 주문 하기.");
        System.out.println(".".repeat(70));
        System.out.print("\n원하시는 항목의 번호를 입력해주세요. >>> ");
        
            chk = Integer.parseInt(System.console().readLine());

            switch (chk) {
                case 1:
                selFoodList();
                    break;
                case 2: //버거조회
                cate = "BUGER";
                categoryPrint(cate); 
                    break;
                case 3: //치킨조회
                cate = "CHICKEN";
                categoryPrint(cate); 
                    break;
                case 4:
                cate = "DESSERT";
                categoryPrint(cate);
                    break;
                case 5:
                cate = "DRINK";
                categoryPrint(cate);
                    break;
                case 6:
                cate = "ICE";
                categoryPrint(cate);
                    break;
                case 7:
                cheapsbuger();
                    break;
                case 8:
                lowKcal(); 
                    break;
                case 9:
                recommend();
                    break;
                case 10:
                recommend();
                    break;
                case 0:
                run = false;
                break;
                default:
                System.out.println("\n잘못된 입력입니다. 보기 중 입력해주세요.");
                    break;
            }

        } catch (Exception e) {
            System.out.println("\n잘못된 입력입니다. 다시 입력해주십시오.");
            continue;
    }}
    
}
    //전체 메뉴 조회
    public void selFoodList(){
        List<FoodVo> list = new ArrayList<>(); 
        list = foodDao.selAll();
        print();
        for(FoodVo vo : list){
            System.out.println(vo);
        }
    }
    //리스트로 가져온 카테고리를 vo로 출력하기위해 메소드로 묶음
    public void categoryPrint(String category){
        List<FoodVo> list = new ArrayList<>();
        list = foodDao.selCategory(cate);
        for(FoodVo vo : list){  
            System.out.println(vo);
        }
    }
    // 저렴한 버거 메뉴
    public void cheapsbuger(){
        System.out.println("\n\t"+"-".repeat(10)+" 저렴한 5000원 이하 버거 목록 입니다. "+"-".repeat(10));
        print();
        
        foodDao.cheapsbuger();
    }

    // 칼로리가 적은 메뉴
    public void lowKcal(){
        System.out.println("\n\t"+"-".repeat(10)+" 400Kcal 이하 버거입니다. "+"-".repeat(10));
        print();        
        foodDao.lowkcal();
    }

    //랜덤함수 메뉴 추천
    public void recommend(){

        System.out.println("추천 메뉴 구매 시 10% 할인된 가격으로 구매 가능합니다.");
        int lastNumB = foodDao.selCategory("BUGER").size();
        int lastNumDessert = foodDao.selCategory("DESSERT").size();
        int lastNumDrink = foodDao.selCategory("DRINK").size();

        int ranBugger = (int)(Math.random()*lastNumB);
        int ranDessert = (int)(Math.random()*lastNumDessert);
        int ranDrink = (int)(Math.random()*lastNumDrink);

        print();
        System.out.println(foodDao.selCategory("BUGER").get(ranBugger));
        System.out.println(foodDao.selCategory("DESSERT").get(ranDessert));
        System.out.println(foodDao.selCategory("DRINK").get(ranDrink));
    }

    // public void setMenu(){
    // int size = foodDao.selCategory("BUGER").size();

    //     for(int i =0; i< size; i++){
    //         System.out.println((foodDao.selCategory("BUGER").get(i))+);
    //     }
    // }

    //주문 내역
    public void selBuyList(){
        System.out.println("구매내역 입니다.");
        for(BuyListVo vo : buyDao.selList(id)){
            System.out.println(vo);
        }
    }

    //주문하기
    public void insBuyList(){
        System.out.println(" 주문하기 전 메뉴 확인 ");
        menu();
        System.out.print("\n주문하실 상품의 코드를 입력해주세요. __");
        String fcode = System.console().readLine();
        System.out.print("\n주문하실 수량을 입력해주세요. __");
        int quantity = Integer.parseInt(System.console().readLine());
        BuyListVo vo = new BuyListVo(0, id, fcode, quantity, null);
        buyDao.insList(vo);
    }

    public void upBuyList(){

    }

    //주문 취소
    public void delBuyList(){
        System.out.println("현재 구매내역 입니다.");
        selBuyList();
        System.out.print("취소 하실 항목의 번호를 선택해 주십시오.__ ");       
        int idx = Integer.parseInt(System.console().readLine());
        
        if( buyDao.selMap(idx).equals(idx)){
            if(buyDao.delList(idx)==1){
                System.out.println("구매취소 성공!");
            }
        }else{
            System.out.println("권한이 없거나 없는 구매번호입니다.");
        }
    }

    public String chkLogin(){

        return
    }
    // 출력
    public void print(){
        System.out.println(String.format("\n%10s %19s %41s %8s %9s %8s","[코드]","[상품명]","[항목]","[가격]","[중량]","[칼로리]")+"\n");
    }
}