package jdbc.exercise;

public class Bike extends Product{
    private int price;
    private String prdName;
    private int speed;

    @Override
    public String sell(Object o) {
        return String.format("[%s]행사 -%d%%인하",super.prdName,o);
    }
    public Bike(int price, String prdName, int speed){
        price = this.price;
        prdName = this.prdName;
        speed = this.speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String ride(){
       String result = String.format("당신은 이것을 시속 %dkm 로 탈수있습니다.", this.speed);
        return result;
    }
}
class Electronic extends Product{
    private double kwh;
    private int price;
    private String prdName;

    public Electronic(int price, String prdName) {
        this.price = price;
        this.prdName = prdName;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh){
        kwh = this.kwh;
    }
    public double power(){

        return this.kwh*(double)24;
    }

    @Override
    public String sell(Object o) {
        
        String result = String.format("[%s] 증정 -%s",super.prdName,o);

        return result;
    }
    
}
