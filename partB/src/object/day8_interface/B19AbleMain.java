package object.day8_interface;

import object.day8_interface.beable.AI;
import object.day8_interface.beable.BeAble;
import object.day8_interface.beable.Cookable;
import object.day8_interface.beable.Dog;
import object.day8_interface.beable.Human;
import object.day8_interface.beable.Runnable;
import object.day8_interface.beable.Thinkable;
import java.lang.Math;

public class B19AbleMain {
    public static void main(String[] args) {
        Thinkable th1 = new AI();
        AI ai = (AI)th1; 
        ai.setOp('+');
        System.out.println((char)((Math.random()*(char)42)+2));
        Thinkable th2 = new Human();
        char a= '*';
        System.out.println(a);
        // Thinkable th3 = new Dog(); 멍멍이는 생각을 할수없어서 
        //멍멍이 클래스에 thinkable 인터페이스 정의안해줌

        Runnable run1 = new Human();
        Runnable run3 = new Human();
        Runnable run2 = new Dog();
        // Runnable run3 = new AI(); ai는 달릴수없어서 
        // ai클래스에 runnable 인터페이스 정의안해줌

        Cookable cook1 = new Human();

        BeAble[] beAbles = new BeAble[3];
        beAbles[0] = th1;
        beAbles[1] = th2;
        beAbles[2] = run2;

        System.out.println("Beable 테스트");
        for(BeAble able:beAbles){
            //System.out.println(able.beAble());
            if(able instanceof AI){
                //다운 캐스팅
                Thinkable temp = (Thinkable) able;
                System.out.println(able.getClass().getName()+"이 계산합니다.");
                char op = temp instanceof AI ? ((AI)temp).getOp() :'+';
                System.out.println("\t연산 :" + op);
                System.out.println("AI계산해 주세요. : "+temp.calculate(422, 19));
            }else{
                //다운 캐스팅
                System.out.println(able.getClass().getName()+"은 계산 못합니다.");
            }
            // 결론 : 업캐스팅 또는 다운캐스팅 목적은 상속과 같은 방식으로 사용합니다.
            // 업캐스팅 : 다형성. 업캐스팅 타입이 갖는 메소드만 실행합니다.
            // 다운캐스팅 : 업캐스팅 타입이 갖는 추상메소드가 아닌 다른 메소드 실행하기 위함.
        }
        
    }
}
