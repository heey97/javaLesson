package basic.day2;

//char 문자형 데이터 연습
public class A09HangulCharTest {

	public static void main(String[] args) {
		char start = '나';
		char end = '낟';
		int codeNa = start;
		int codeNet = end;
		

		System.out.println((char)codeNa);
		while(start <= end){
			
			System.out.print(" " + start++);
		};
		
		

		System.out.println("\n"+(char)codeNet);
		System.out.println(codeNa);
		System.out.println(codeNet);

		System.out.println("\n '나' 부터 '낟' 까지의 총 갯수는 "+ (codeNet-codeNa+1) +" 개 입니다.");
			// char s = '나';
			// int code = s;
			// System.out.println(s); 
			// System.out.println(code);
			// System.out.println(codeNet);
			// char x = (char)codeNet;
			// System.out.println(x);
	}

}
