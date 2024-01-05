package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {
    public static void main(String[] args) {
        
        String userid = "히용";
        String[] productNames= {"김치", "배추", "양상추", "피클", "빵"};
        int[] prices = {500,100,900,1500,100000};

 
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        //유저 이름
        cart.setUserid(userid);
        System.out.println(cart.getUserid()+" 님 환영합니다.");
        
        // 상품 별 가격 목록

        cart.setProductNames(productNames);
        cart.setPrices(prices);


        int choice = 0;

        for(int i=0; i<productNames.length; i++){
            System.out.println(String.format(" %10d.  상품명: %s\t 가격: %d\t", i,productNames[i],prices[i]));
        }
        int[] arr = new int[cart.getProductNames().length]; 
         for(int i = 0; i<productNames.length; i++){

            System.out.print("구매하실 상품을 선택해 주십시오. : ");     
            choice = sc.nextInt();
            System.out.println(("\n"+cart.getProductNames()[choice])+"을(를) 선택하셨습니다.\n"+"해당 물품의 가격 :"+(cart.getPrices()[choice]));
           
                arr[i] = prices[choice]; 
                cart.setTotal_Money(arr);
        
                //arr[i] =  cart.getPrices()[choice];
            }  
            System.out.println("선택한 품목들의 총 가격은 : "+cart.getTotal_Money());
            // sum += cart.getPrices()[choice];
            
            System.out.println("\n종료하려면 -1을 입력해 주십시오.");
        

        System.out.println("총가격은"+cart.getTotal_Money()+"입니다.");

        // cart.setTotal_Money(prices);
        // System.out.println("총가격은"+cart.getTotal_Money()+"입니다.");
                    // isOk = sc.nextInt();
            //     if(isOk != 1){
            //         sum += cart.getPrices()[choice];
            //         break;
            //     }

    }
}
