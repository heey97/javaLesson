package basic.day1;

import java.util.Scanner;

public class ProbChangeMoney {
    public static void main(String[] args) {
        int syWon = 1000000; // 여행 경비
        double toYen; // 환전한 엔화 값

        int cost;  //여행비용
        int myYen; //남은 여행 경비
        double toWon; // 남은 경비 환전한 값

        Double yenTowonRate=9.29; // 1엔이 몇 원? 살때
        Double wonToyenRate=8.97; // 1엔이 몇 원? 팔때

        System.out.println("::: 한/일 23.12.28 기준 환율:::");
        System.out.println("살 때 1엔 = " + yenTowonRate + "원");
        System.out.println("팔 때 1엔 = " + wonToyenRate + "원");

        System.out.println("::: 원화를 엔화로 환전하기 :::");
        System.out.println("환전할 원화는 : " + syWon + "원 입니다.");
        
       
        toYen = syWon/yenTowonRate;
        String Result = String.format("%.0f",toYen);
        System.out.println("원화를 엔화로 바꿀 때 : " + Result + " 엔 입니다.");

        System.out.println("::: 엔화를 원화로 환전할 경우 :::");
        
        cost = 98760;
        myYen = (int)toYen-cost;
        System.out.println("일본에서 사용한 금액은 : " + cost + " 엔 입니다.");
        System.out.println("남은 엔화는 얼마인가요? : " + myYen+" 엔");

        toWon = myYen*wonToyenRate;
        String Result2 = String.format("%.0f",toWon);
        System.out.println("엔화를 원화로 바꿀 때 : "+ Result2 +" 원");
        
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();

    }
}
