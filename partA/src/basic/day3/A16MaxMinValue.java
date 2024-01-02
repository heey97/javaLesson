package basic.day3;

public class A16MaxMinValue {
    public static void main(String[] args) {
        
      int n1 = 23;
      int n2 = 34;
      int n3 = 32;
      int max = 0;
      int min = 0;

      if(n1<n2){
        min =n1;
        max =n2;
      }else{
        min=n2;
        max=n1;
      }

      if(min>n3)min =n3;
      if(n3>max)max = n3;


      System.out.println("max값은 : "+max+"이지롱 ");
      System.out.println("min값은 : "+min+"이지롱 ");
     }
}
