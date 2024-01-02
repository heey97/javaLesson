package basic.day3;
import java.util.*;
// if ~ else if ~ else if ~ ....
public class A18IfElseIfTest {

	public static void main(String[] args) {
		
		// Scanner sc = new Scanner(System.in);
		// int menu;

		// System.out.println(":::: 쇼핑몰 사용자 마이페이지 ::::");
		// System.out.println("1:장바구니   2:찜 상품   3.배송 조회   4.구매 목록  5.종료");
		// System.out.print("선택 하세요. >>>> "+(menu = sc.nextInt()));
		
		// //동일한 값인지 비교 : 관계연산자 == 또는 != 
		// if(menu==1) {
		// 	System.out.println("장바구니 🎁🎁🎁🎁 .많이 담아 주세요.");
		// }else if(menu ==2) {
		// 	System.out.println("찜 상품 입니다.❤❤");
		// }else if(menu ==3) {
		// 	System.out.println("배송 조회 🚚🚛🚚🚛 ");
		// }else if(menu ==4) {
		// 	System.out.println("구매 목록 입니다.");
		// }else if(menu ==5) {
		// 	System.out.println("종료 입니다.");
		// }else {
		// 	System.out.println("잘못된 선택 입니다.");
		// }
		
		// System.out.println("메뉴 선택 종료합니다.");
	System.out.println("**************학점계산기 시작*************");
		if(abb()==0){
			System.out.println("정상적으로 값이 출력되었습니다.");
		}
	}

	public static int abb(){
	
		Scanner sc = new Scanner(System.in);

		System.out.print("점수를 입력해 주십시오. : ");
		int jumsu = sc.nextInt();
		System.out.println("\n\n"+jumsu+" 점을 입력하였습니다.");
		
		String grade;

		if(jumsu >=0 && jumsu<=100)
		{
			if(jumsu >=90){
				grade = "A";
			}else if(jumsu >=80){
				grade = "B";
			}else if(jumsu >=70){
				grade = "C";
			}else if(jumsu >=60){
				grade = "D";
			}else{
				grade = "F";
			}
			System.out.println("\n\n귀하의 학점은 "+grade+" 입니다.\n\n");
		}else{
			System.out.println("\n\n잘못된 값을 입력하였습니다. 0 ~ 100 사이의 숫자를 입력해 주십시오.");

			return abb();
		}
		return 0;
	}

		//점수가 100~90 이면 'A', 점수가 89~80이면 'B', 점수가 79~70이면 'C', 점수가 69~60이면 'D', 점수가 60 미만이면 'F',		
		

}
	
