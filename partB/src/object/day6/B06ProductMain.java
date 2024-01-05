package object.day6;

import java.util.Arrays;

public class B06ProductMain {
    public static void main(String[] args) {
        
        //product 객체를 4개 만들어보겠습니다.
        Product snack = new Product("새우깡", 1200, "농심", new String[3],new String[4]);
        Product drink = new Product("칠성사이다", 2200, "롯데", new String[3],new String[4]);
        Product fruit = new Product("사과", 12000, "우리농원", new String[3],new String[4]);
        Product icecream = new Product("투게더", 7000, "빙그레", new String[3],new String[4]);

        //출력해봅시다!
        // System.out.println(snack.getData());
        // System.out.println(drink.getData());
        // System.out.println(fruit.getData());
        // System.out.println(icecream.getData());


        //퀴즈 snack의 etc 필드 배열요소 0번에 "10개 묶음" 문자열을 저장하세요.
        //String[] temp = {"10개묶음","50개 묶음","100개 묶음"};
        String[] temp =snack.getEtc();
        temp[0] = "10개묶음";
        temp[1] = "50개묶음";
        temp[2] = "100개묶음";
        
        String[] toto = snack.getSs();
        toto[0] = "1000";
        toto[1] = "1001";
        toto[2] = "1002";
        toto[3] = "1003";

        System.out.println(snack.getData());

        Product[] mycarts = new Product[5];
        
        mycarts[0] = drink;
        mycarts[1] = icecream;
        //mycarts[2] =
        mycarts[3] = fruit;
        mycarts[4] = snack;
        

        for(int i = 0; i<mycarts.length; i++){
            if(mycarts[i]!=null){
                System.out.println(mycarts[i].getData());   // 클래스 참조할때 배열로 호출했으면 []붙이고 메소드호출
            }
        }
        




        // System.out.println(snack);
        // System.out.println(drink);
        // System.out.println(fruit);
        // System.out.println(icecream);
        // object.day6.Product@2f92e0f4    -  2f92e0f4은 객체 참조값(식별값) -> 주소라고 부릅시다.
        // object.day6.Product@28a418fc    -  object.day6.Product는 패키지이름.클래스이름.
        // object.day6.Product@5305068a
        // object.day6.Product@1f32e575
    }
}
