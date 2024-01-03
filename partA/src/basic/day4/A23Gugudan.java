package basic.day4;

public class A23Gugudan {
    public static void main(String[] args) {
        int rs =0;
        
          //6) 구구단 출력 1 < 10
          rs =1;
          //System.out.print("숫자를 입력하시오 : ");
          for(int i=1; i<10; i++){
  
              System.out.println("\n\n");
  
               for(int j =1; j<10; j++){
  
                  rs = j*i;
                  System.out.println(String.format("문제6) %d X %d = %d ",i,j,rs));
               }
                 
          }
    }
}
