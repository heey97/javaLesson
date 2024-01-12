package object.day8_interface.beable;

public class Dog implements Runnable {
    
    @Override
    public String beAble(){
        return "달리기";
    }

    @Override
    public String run(int speed){
        return "강아지는"+speed+"km/h로 달립니다.\n최대속도 100km/h...";
    }
    
}
