package object.day8_interface;

public class B16MyclassAMain {
    public static void main(String[] args) {
        
        //인터페이스는 객체 생성 못함.
        //단, 익명 내부 타입으로는 정의 가능
    
        MyClassA mya = new MyClassA();
        

        //구현 클래스로 객체생성
        InterfaceA ifa = new MyClassA(); // 업캐스팅
        MyClassA temp = (MyClassA)ifa; //다운캐스팅

        System.out.println("참조타입 변수와 상관없이 똑같이 실행됩니다.");
        mya.methodA();
        ifa.methodA();
    }
}
                                                  