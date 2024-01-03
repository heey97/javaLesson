package basic.day4;

import java.util.Scanner;

//for 문 복습 1~5 까지 구현
public class A22ForReview {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        int sum = 0;
        int rs = 0;
        
        
        //1) 1부터 정수 n(100)까지 더하기
        n = 100;
        for(int i=1; i<=n; i++){
            sum += i;    
        }
        System.out.println(String.format("문제1) 1부터 %d 까지의 합계 : %d", n,sum));
        //2) 1부터 정수 n까지 곱하기
        rs = 1;
        n = 10;
        for(int i=1; i<=n; i++){
            rs *= i;
        }
        System.out.println(String.format("문제2) 1부터 %d 까지의 곱 : %d", n,rs));
        //3) 시작값 정수 m부터 마지막 값 n 까지 더하기
        sum = 0;
        n = 10;

        for(m = 7; m<=n; m++){
            sum +=m;
        }
        System.out.println(String.format("문제3) %d부터 %d 까지의 합계 : %d",m, n,sum));
        //4) 시작값 정수 m부터 마지막 값 n 까지 곱하기
        n = 9;
        rs = 1;

        for(m = 5; m<=n; m++){
            rs *=m;
        }
        System.out.println(String.format("문제4) %d부터 %d 까지의 곱 : %d",m, n,rs));
        //5) 2의 n승 곱하기 (2진수에서는 많이 사용되는 연산)
        rs = 1;
        n = 8;
        for(int i = 1; i<=n; i++){
            rs *= 2;
             System.out.println(String.format("문제5) 2 의 %d 승은 : %d 입니다",i,rs));
        }
       
       
        // Scanner sc = new Scanner(System.in);
        
       
     


        
    }
}
