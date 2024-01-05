package object.day6;

import java.util.Scanner;

public class MyClassExMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;

        MyClassEx my = new MyClassEx();
        

        String[] temp = {"묵","찌","빠"};
        my.setGalba(temp);
    
        
        System.out.println("원하는 번호 눌러라");
        
        my.getData();
        System.out.print("번호 입력 : ");
        choice= sc.nextInt();
        
        System.out.println(my.select(choice));
        //my.random(choice);
        // 번호입력했을때 string 으로 해당하는 묵찌빠 출력까지 함 이제 랜덤함수 메소드 만들어서 난수랑 choice랑 비교해서 승패 출력하면 끝
      
    }
}
