package basic.day4;

import java.util.Scanner;

public class A25MySampleMethod {

    public static void main(String[] args) {
        //A22번 1) ~ 5)를 각각 메소드로 정의해보기
        // 1) sumToN 2) multiplyToN 3) sumMToN 4) multiplyMToN 5)multiplyNof2
        //6) 구구단 '출력' 하는 메소드. 리턴은 void printGuguDan  
        Scanner sc = new Scanner(System.in);
        //1
        System.out.println(sumToN(5));
        
        //2
        System.out.println(multiplyToN(10));
        
        //3
        System.out.println(sumMToN(3,5));
        
        //4
        System.out.println(multiplyMToN(3,5));
        
        //5
        System.out.print("2의 몇승을 확인하시겠습니까 : ");
        int n = sc.nextInt();
        int rs = multiplyNof2(n);
        System.out.println(String.format("문제5) 2 의 %d 승은 : %d입니다",n,rs));
        
        //6
        printGuguDan();
        addMToN(2,5);
        boolean isOk = checkJumsu(67);
        if(isOk == true){
            System.out.println("참입니다.");
        }else System.out.println("거짓입니다.");
    }

    private static boolean checkJumsu(int i) {
        if(i >= 0 && i<=100){
            return true;
        }
        return false;
        
    }

    public static int addMToN(int i, int j){
        int sum = 0;
        for(int k=i; k<=j;k++){
            sum+=k;
        }
        return sum;
    }
    //1~n 더하기
    public static int sumToN(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;    
        }
        return sum;
    }
    //1~n곱하기
    public static int multiplyToN(int n){
        int rs = 1;
        for(int i=1; i<=n; i++){
            rs *= i;
        }
            return rs;
    }
    //n~m 더하기
    public static int sumMToN(int n,int m){
        int sum = 0;
        for(int i=n; i<=m; i++){
            sum +=i;
        }
        return sum;
    }
    //n~m 곱하기
    public static int multiplyMToN(int n, int m){
   
        int rs = 1;

        for(int i = n; i<=m; i++){
            rs *=i;
        }
        return rs;
    }
    // 2의 승 구하기
    public static int multiplyNof2(int n){
        int rs = 1;
        
        for(int i = 1; i<=n; i++){
            rs *= 2;
        }
        return rs;
    }
    // 구구단
    public static void printGuguDan(){
        int rs =1;
        for(int i=1; i<10; i++){

            System.out.println("\n\n");

             for(int j =1; j<10; j++){
                rs = j*i;
                System.out.println(String.format("문제6) %d X %d = %d ",i,j,rs));
             }          
        }
    }
}
