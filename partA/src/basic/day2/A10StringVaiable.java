package basic.day2;

//char 문자형 데이터 연습
public class A10StringVaiable {

	public static void main(String[] args) {
		
		//String 은 문자열 : 문자(' ')의 집합. 문자열 리터럴은 기호 "" 사용합니다.

		String message = "Hello~ 안녕!! 하이하이";
		
		System.out.println(message);
		System.out.println("메세지"+message+"'의 길이" + message.length());
		System.out.println("-------"+message.isEmpty());
		//String 으로 선언된 변수는 '객체'입니다. 그래서 메소드를 갖고 여러가지 필요한 기능들을 제공해줍니다.
		System.out.println("----"+message);
		//char imo = '😄'; // char은 2바이트 이모지는 4바이트. 문자형으로 저장안됨.
		String imo = "😀"; // 이모지는 문자열로 저장해야 합니다.

		System.out.println("?"+imo);
		int a = 6;
		int b = 9;

		int c = (6<9)? 1:2;
		System.out.println(c);
		System.out.println("-------"+message.indexOf("o"));

		System.out.println("-------"+message.replaceAll("!","1"));
		System.out.println(message.substring(5));

		String vv = " ";
		System.out.println(vv.isBlank());
		System.out.println("----" + message.lastIndexOf("!"));

		String zz[] = message.split(" ");

		System.out.println("-------" + zz[0]);
		System.out.println("-------" + zz[1]);
		// System.out.println("-------" + zz[2]);

		System.out.println("Hello~ 안녕!! 하이하이".equals(message));

		System.out.println(message.replace(" ", "a"));

		// message.split(a) -----문자열을 a로 나누어 각 배열로 담음 ex (zzzabbbaccc) = [0]zzz / [1]bbb / [2]ccc

		//length() -----  문자열의 갯수검색

		//substring(a) ----- 0부터 a주소 까지의 문자 제거

		//"String".trim() ----- 문자열의 양끝의 공백 제거

		//"String".replaceAll(a,b) ----- String문자열 전체의 a 문자를 b로 변경 (정규식 사용x) 
			//replace로 변환하지 못하는 단어들을 한번에 변경할때 사용

		//"String".replace(a,b) ----- String문자열 전체의 a 문자를 b로 변경 (정규식사용 x)

		//concat(a) ----- 문자열 마지막에 a 추가

/*--------------------------------------------------------------------------*/
		//isempty() ----- 문자열이 빈값인지 아닌지 검사 true or false 

		//isBlank() ----- 공백인지 아닌지 검사 true or false
		
		//"string".equals(a) ----- 문자열이 a와 같은지 검사 true or false
/*--------------------------------------------------------------------------*/

		//indexof(a) ----- (문자열을 각 문자로 배열에 담아 앞쪽에서부터 a 주소 검색) 

		//lastindexof(a) ----- (문자열을 각 문자로 배열에 담아 뒤쪽에서부터 a 주소 검색) 

		System.out.println(message.concat("-1"));
	}
}
