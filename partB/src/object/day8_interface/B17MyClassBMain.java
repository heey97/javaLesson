package object.day8_interface;

public class B17MyClassBMain {
    public static void main(String[] args) {
        MyClassB myb = new MyClassB();

        myb.methodA();
        myb.methodB(0);
        myb.methodC("ㅋㅋ");
        myb.methodX();
        myb.methodD();
        InterfaceX ifx= new MyClassB();
        InterfaceA ifa = new MyClassB();

        myb.methodA();
        ifa.methodA();
        
        
        //ifx.methodA(); //methodA는 InterfaceA의 추상메소드. //다른 인터페이스 참조 타입으로는 메소드 실행 불가. = err;

        myb.methodX();
        ifx.methodX();

        //ifa.methodX(); //methodX는 InterfaceX의 추상메소드. // 다른 인터페이스 참조 타입으로는 메소드 실행 불가. = err;

        InterfaceX ix = (InterfaceX)ifa;
        ix.methodX();
        
    }
}
