package SS.bugerMain;

public class KioskMain {

public static void main(String[] args) {
    KioskMain kiosk = new KioskMain();
    kiosk.start();

}

    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("1. 주문 하기\t 2. 주문 수정\t 3. 주문 취소");
        System.out.println("4. 구매내역\t 5. 메뉴검색\t 6. 전체 메뉴 조회\t 7. 구매 종료");
        System.out.println(".".repeat(70));
    }


    public void start() {
        
        System.out.println("로그인이 필요한 서비스입니다.");
        System.out.print("아이디 입력 __");
        String id = System.console().readLine();
        System.out.println( " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택하세요>>> ");   
           String select = System.console().readLine();
            switch (select.toUpperCase()) {
                case "1": 
                // orderMenu() - 주문하기
                    break;
                case "2":
                // modifyOrder() - 주문수정
                    break;  
                case "3":
                // cancelOrder() - 주문취소
                    break;
                case "4":
                // buyHistory() - 구매내역
                    break;
                case "5":
                // searchMenu() - 메뉴검색
                    break;    
                case "6":
                // viewMenu() - 전체메뉴조회
                    break;
                case "7":
                    run=false;
                    break;                
                default:
                    break;
            }
        }

    }
}
