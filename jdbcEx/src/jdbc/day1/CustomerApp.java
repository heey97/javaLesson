package jdbc.day1;

import jdbc.dao.TblCustomerDao;
import jdbc.vo.CustomerVo;

public class CustomerApp {

    TblCustomerDao dao = new TblCustomerDao();
    public static void main(String[] args) {

        CustomerApp app = new CustomerApp();

        System.out.println("우리 쇼핑몰 원하는 작업을 선택해주세요.");
        System.out.println("\n 1.회원가입 || 2.회원정보수정 || 3.회원탈퇴");
        int chkNum = Integer.parseInt(System.console().readLine());
        while(true){
            int stop;
            switch (chkNum) {
                case 1:
                    app.join();
                    break;
                case 2:
                    app.update();
                    break;
                case 3:
                    app.delete();
                    break;
                case 4:
                    break;
                default:
                break;
            }
        }
    }   //main end

    public  void join(){
        System.out.println("우리 쇼핑몰 [회원가입] 환영합니다.");
        System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");
        
        System.out.print(" 아이디를 입력하세요. __ ");
        String customId = System.console().readLine();
        
        System.out.print(" 이름을 입력하세요. __ ");
        String name = System.console().readLine();

        System.out.print(" 이메일을 입력하세요. __ ");
        String email = System.console().readLine();

        System.out.print(" 나이를 입력하세요. __ ");
        int age = Integer.parseInt(System.console().readLine());

        CustomerVo vo = new CustomerVo(customId, name, email, age, null);


        dao.join(vo);

        System.out.println("회원 가입이 완료 되었습니다.");
    }

    public void update(){
        System.out.println("우리 쇼핑몰 [회원정보]-이메일과 나이 수정 합니다.");
    

        System.out.print(" 아이디를 입력하세요. __ ");
        String   customId = System.console().readLine();
        
        System.out.print(" 이메일을 입력하세요. __ ");
        String  email = System.console().readLine();

        System.out.print(" 나이를 입력하세요. __ ");
        int  age = Integer.parseInt(System.console().readLine());

        CustomerVo vo1 = new CustomerVo(customId, null, email, age, null);
        dao.modify(vo1);
    }

    public void delete(){
        
        System.out.println("우리 쇼핑몰 [회원탈퇴]- 합니다.");
        System.out.print(" 아이디를 입력하세요. __ ");
        String customId = System.console().readLine();
        dao.delete(customId); //메소드를 완성해서 테스트하기

    }

    // public void sel(){
        
    //     System.out.println("우리 쇼핑몰 [회원조회]- 합니다.");
    //     System.out.print(" 아이디를 입력하세요. __ ");
    //     customId = System.console().readLine();
    //     dao.getCustomer(customId); //메소드를 완성해서 테스트하기
    // }
    //이 클래스는 TblCustomerDao 의 메소드 테스트를 위한 실행ㄴ 클래스 입니다.

}
