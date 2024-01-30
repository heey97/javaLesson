package io.day12;

import java.util.Scanner;

public class D01TryCatchTest {
    
    public static void main(String[] args) {
        try {
            numberException();
        } catch (Exception e) {
            System.out.println("인덱스 범위는 배열의 길이-1 까지입니당");
            System.out.println(e.getMessage());
        }
        
    }
    public static void indexException(){
        int[] arrays = {11,22,33,44,55};
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        System.out.println(arrays[arrays.length-1]);
        System.out.println(arrays[arrays.length]);
        
    }
    public static void numberException(){
        Scanner sc = new Scanner(System.in);

        System.out.print("점수를 입력하세요 >>>>> ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("입력한 값 : " + num);
        sc.close();

        indexException();
    }
    

}
