package basic.day3;

public class A15MinValue {
    public static void main(String[] args) {
        
      int n1 = 23;
      int n2 = 34;
      int n3 = 32;
      int min = 0;

      min = n1<n2? n1:n2;
      min = n3<min? n3:min;

      System.out.println("------------1 : "+min);
    
      if(n1<n2){
        min = n1;
      }else{
        min = n2;
      }
      if(n3<min){
        min = n3;
      }
      System.out.println("------------2 : "+min);
      

      if(n1<n2){
        min = n1;
      }else{
        min = n2;
      }
      if(n3<min){
        min = n3;
      }
      System.out.println("------------3 : "+min);


      n1 = 99;
      n2 = 88;
      n3 = 77;
      //조건 삼항연산을 대입문에 활용해 봅니다.
      System.out.println("::조건 삼항연산으로 다시 구현해보기");

      min = 0;

      min = (n1>n2?n1:n2);
      min = (min>n3?n3:min);
      System.out.println("n1="+n1+",n2="+n2+",n3="+n3);
      System.out.println("최대값 min 는 = " + min);
      




    int max1 =0;
    for(int i=0; i<=3000;i++){

        if(max1<=i){
            max1 = i;
        }
    }
    System.out.println(max1);



     int y=27;
     for(int x=0; x<30; x++){
      if(x==y){
        System.out.println("y의값은 "+x+"입니다");
        break;
      }else{
        System.out.println("y의값까지"+(y-x)+"만큼 남았습니다.");
      }

     }
     }
}
