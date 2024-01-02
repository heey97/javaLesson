package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        
      int n1 = 23;
      int n2 = 34;
      int n3 = 32;
      int max = 0;

      max = n1>n2? n1:n2;
      max = n3>max? n3:max;

      System.out.println("------------"+max);
    
      if(n1>n2){
        System.out.println(n1);
         if(n1<n3){
            System.out.println(n3);
         }
         
      }else{
        System.out.println(n2);
        if(n2<n3){
            System.out.println(n3);
        }
      }

      if(n1>n2){
        max = n1;
      }else{
        max = n2;
      }
      if(n3>max){
        max = n3;
      }
      System.out.println(max);


      n1 = 99;
      n2 = 88;
      n3 = 77;
      //조건 삼항연산을 대입문에 활용해 봅니다.
      System.out.println("::조건 삼항연산으로 다시 구현해보기");

      max = 0;

      max = (n1>n2?n1:n2);
      max = (max>n3?n3:max);
      System.out.println("n1="+n1+",n2="+n2+",n3="+n3);
      System.out.println("최대값 max 는 = " + max);
      
    int max1 =0;
    for(int i=0; i<=3000;i++){

        if(max1<=i){
            max1 = i;
        }
    }
    System.out.println(max1);
     }
}
