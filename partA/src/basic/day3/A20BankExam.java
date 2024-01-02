package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int menu=0;
        long money=0;
        int balance=0;
        boolean run = true;
        DecimalFormat formatter = new DecimalFormat("###,###");

        while(run){

            System.out.println("--------------------------------------");
		 	System.out.println("1:예금 || 2:출금 || 3.잔액 || 4.종료");
            System.out.println("--------------------------------------");
		 	System.out.print("선택 하세요. >>>> ");
			
            menu = sc.nextInt();
            System.out.println("\n메뉴선택 >>> " + menu);

            switch (menu) {
                case 1:
    
                    System.out.print("예금을 실행합니다. 입금할 금액을 입력해주십시오. : ");
                    money = sc.nextInt();
                    System.out.println(formatter.format(money)+"원이 입금 되었습니다.\n");
                    break;
                case 2:

                    System.out.println("출금을 실행합니다. 출금할 금액을 입력해주십시오.");
                    balance = sc.nextInt();
                    
                        if(money-balance > 0){
                            money -= balance;    
                            System.out.println(formatter.format(balance)+"원이 출금 되었습니다.");
                            break;
                        }else{
                            System.out.println("고객님의 잔액이 출금액 보다 부족합니다.");
                        }
                    System.out.println("남은 잔액은 "+ formatter.format(money)+" 원 입니다.\n");

                case 3:

                    System.out.println("잔액을 확인합니다." + formatter.format(money));
                    break;
                case 4:

                    System.out.println("프로그램을 종료 합니다.\n");System.out.println("프로그램을 종료 합니다.\n");System.out.println("프로그램을 종료 합니다.\n");
                    run = false;
                    break;
            
                default:
                    break;
            }

        }
    }
}
