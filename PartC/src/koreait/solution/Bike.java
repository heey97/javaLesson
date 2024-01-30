package koreait.solution;

//객체의 구성요소 : 인스턴스 필드와 인스턴스 메소드
//클래스의 구성요소 : 객체의 구성요소 + static 메소드와 필드까지 들어간다
// 클래스는 객체가 만들어지는 인스턴스 요소를 정의하는 상위개념
public class Bike extends Product {
    private int speed;

    public Bike(int price, String prdName, int speed){
        super.price = price;
        super.prdName = prdName;
        this.speed = speed;
        // 자식클래스는 부모생성자를 반드시 호출해야한다. 하지만 -super()는 생략 가능하다.
        //super();
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public String ride(){
        //this. 생략 가능하나 speed 가 객체의 필드 변수라는 것을 가독성 있게 해줍니다.
        return "당신은 이것을 "+this.speed+"km로 탈수 있습니다.";
    }
    // 부모 클래스의 sell 메소드 재정의
    @Override
    public String sell(Object o) {
        return String.format("[%s] 행사 - %d %% 인하",this.prdName,o);
    }
    //toString 재정의
    @Override
    public String toString() {
        return "Bike["+super.toString()+", speed="+ speed+"]";
        //부모에서 재정의해놓은 toString 을 가져와서 재정의할수도있다 (코드가 짧아짐 이것도 좋다)
    }
}
//부모 객체를 다운캐스팅 하기전에 instanceof로 자식객체의 타입을 검사해줍니다
class Electronics extends Product{

     
    private double kwh;
    //필드 변수 = 클래스의 소속된변수 , 클래스 전역변수라고도 함
    public Electronics(int price, String prdName){
        //super();
        this.price=price;
        this.prdName=prdName;
    }
    //getter,setter,ride 메소드 : 인스턴스 필드를 대상으로 값을 변하게 하거나 처리하는 기능을 갖는 메소드를 인스턴스 메소드라고 부른다.
                                // 객체=인스턴스
    public double power(){
        return this.kwh*24;
    }
    public void setKwh(double kwh) {
        this.kwh = kwh;
    }
    //추상클래스를 상속받았으므로 반드시 추상메소드를 구현
    @Override
    public String sell(Object o) {
        //object는 자바의 최상위 클래스 이기떄문에 인자로 사용하면 하위 어떤 변수가 들어와도 리턴 가능 (좋다 이거 자주써야겠따ㅣ)
        return String.format("[%s] 증정 - %s",this.prdName,o);
    }
    @Override
    public String toString() {
        return "Bike["+super.toString()+", kwh="+ kwh+"]";
        //부모에서 재정의해놓은 toString 을 가져와서 재정의할수도있다
    }
}