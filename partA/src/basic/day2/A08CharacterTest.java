package basic.day2;

import java.util.Scanner;

//char 문자형 데이터 연습
public class A08CharacterTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("값을 입력해 주십시오. : ");
		char start = scan.next().charAt(0);
		System.out.println(start);
		char last = 'Z';
		
		if(start != 'A' || " ".equals(start) )
		{
			
			System.out.println("A가아니다. 다시입력하거라.");
			home();

		}else{

			do {
				System.out.print(last--);
			} while (last>='A');

			System.out.print("\n\n");

			while(start <= 'Z'){
				System.out.print(start++);
			}
		}
	}

	public static void home(){
		
		main(null);
	}

}
