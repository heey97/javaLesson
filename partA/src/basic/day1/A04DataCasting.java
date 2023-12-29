package basic.day1;

import java.util.Scanner;

//변수 활용 연습  (1줄 주석 단축키는 ctrl + / , 여러줄 주석은 ctrl + shift + /)
/*문제  : 어떤 학생의 중간고사 총점은 322 , 과목수는 4개 입니다. 모두 항상 정수입니다.
	이 학생의 평균을 구하려고 합니다. 변수는 총점은 sum, 과목개수는 count 로 합니다.
	평균(나눗셈 연산은 / )를 계산합니다. 정수/정수 = 정수, 외 = 실수
	1) 평균을 저장 할 변수를 정수형 avgInt   2) 평균을 저장 할 변수를 실수형 avgDouble 각각 해보세요.
	계산한 1) 2)를 각각 출력 합니다. => 오류가 생길까요?
*/
public class A04DataCasting {

	public static void main(String[] args) {
		// int sum;
		// int count;
		// int avgInt;
		// double avgDouble;

		// Scanner scan = new Scanner(System.in);
		// //업데이트 예정 : 사용자로부터 값을 입력하도록 합니다.
		// System.out.println("총 점수를 입력해주십시오. : ");
		// sum = scan.nextInt();
		// System.out.println("과목 갯수를 입력해주십시오. : ");
		// count= scan.nextInt();
		// avgInt = sum/count;
		// avgDouble = sum/count;		
		// // sum/count 는 정수연산으로 결과는 80. 이 값이 double 변수에 저장되면서 .0 만 생깁니다. 
		// System.out.println("문자열을 입력해주십시오. : ");
		// System.out.println("정수형식 평균 :" + avgInt);
		// System.out.println("실수형식 평균 :" + avgDouble);
		
		// // sum 또는 count 중 하나를 실수 형식으로 바꾸어서 나눗셈을 하면 결과가 80.5 가 나옵니다.
		// avgDouble = (double)sum/count;			//sum을 강제로 변환(캐스팅) -1)번과의 차이점
		// // 322.0 나누기 4 =>실수값 소수점 이하 자리수 계산
		// System.out.println("실수형식으로 변환 후 평균 :" + avgDouble);

		// System.out.println("😍형변환(캐스팅)에는 자동과 강제 2가지가 있습니다.");
		// double dnum = 34; // dnum은 double형식, 34는 정수형식. 정수를 실수로 변환은 자동
		// //int inum = 3.1415; // inum은 int형식, 3.1415는 실수형식. 실수를 정수로 변환하는건 강제
		// int inum =(int)3.1415;

		// System.out.println("자동 캐스팅 된 34 : " + dnum);
		// System.out.println("자동 캐스팅 된 3.1415 : " + inum);
		// inum = (int)3.6789;
		// System.out.println("자동 캐스팅 된 3.6789 : " + inum);

		int a;
		int b;
		int c;
		double d;
		Scanner scan = new Scanner(System.in);
		System.out.println("a입력");
		a = scan.nextInt();
		System.out.println("b입력");

		b = scan.nextInt();

		if(b > a){
			System.out.println("b보다 a가 클수없습니다.");
		}
		else{
		c = a/b;
		System.out.println("a/b = " + c);
		d = (double)a/b;
		System.out.println("a/b = " + d);
		}
		/*
		 * 복습 : 기본 자료형을 크기 순서대로 나열해 봅시다.
		 * 
		 * byte < short < int < long < float(실수) < double (실수)
		 * 1        2	   4      8       4            8 (바이트)
		 * 
		 * char 문자형을 코득밧 구하기 위해 정수로 캐스팅할 때에는 0~65535 를 충분히 저장할 수 있는
		 * int 정수형으로 캐스팅 합니다. 
		 */
	}
}
