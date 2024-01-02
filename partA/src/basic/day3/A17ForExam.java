package basic.day3;

public class A17ForExam {
    public static void main(String[] args) {
        
      String message = "Hello, World~ Hoi";

      // System.out.println("1. 문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
      // for(int i=0; i<message.length(); i++){
      //   char temp = message.charAt(i);
      //   System.out.println("i="+i+",문자="+temp);
      // }



      // int k=0;
      
      // while(k <= message.length()){
      //   char temp = message.charAt(k);
      //   System.out.println("k="+k+",문자="+temp);
      //   k++;
      // }

      System.out.println("\n2.문자열 길이 만큼 반복문 실행하면서 if 조건문으로 문자열 검색하기");
      System.out.println("\t문자열에서 알파벳 o의 갯수를 구해봅시다.");
      int count = 0;
      char temp;

      for(int i =0; i<message.length(); i++){
        temp = message.charAt(i);
        //  if(i<=message.length()){
        //  System.out.print("\n k= "+i+",문자= "+temp+"\t"+(temp == 'o'));
        // }
        if(temp == 'o'){
          count++;
        }
      }
      System.out.println("\n\n"+count+"개입니다.");
     }
}
