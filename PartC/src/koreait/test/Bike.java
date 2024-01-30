package koreait.test;


public class Bike extends Product{
    
    private int speed;
    
    //생성자
    public Bike(int price, String prdName, int speed){
        super.price = price;
        super.prdName = prdName;
        this.speed = speed;
    }
    //getter
    public int getSpeed() {
        return speed;
    }
    //setter
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //ride 메소드
    public String ride(){
        return String.format("당신은 이것을 %dkm로 탈수 있습니다.", this.speed);
    }
    // 부모 클래스의 sell 메소드 재정의
    @Override
    public String sell(Object o) {
        
        return String.format("[%s] 행사 - %d %% 인하",super.prdName,o);
    }
    //toString 재정의
    @Override
    public String toString() {
        return "Bike [상품명=" + super.prdName + "]"+"Bike [price=" + super.price + "]"+"Bike [speed=" + this.speed + "]";
    }

}

class Electronics extends Product{

    private double khw;
    
    //커스텀 생성자
    public Electronics(int price, String prdName){
        super.price = price;
        super.prdName = prdName;
    }
    //1일당 전력 구하는 메소드
    public double power(){
        return this.khw*(double)24;
    }
    //부모 클래스의 sell 메소드 재정의
   
    @Override
    public String sell(Object o) {
        return String.format("[%s] 증정 - %s",this.prdName,o);
    }
    //getter
    public double getKhw() {
        return khw;
    }
    //setter
    public void setKhw(double khw) {
        this.khw = khw;
    }
    //toString 재정의
    @Override
    public String toString() {
        return "Bike [상품명=" + super.prdName + "]"+"Bike [price=" + super.price + "]"+"Bike [khw=" + this.khw + "]";
    }
    
}

