package koreait.solution;

public class ProductApp {
    public static void main(String[] args) {
        Product[] cart = new Product[10];
        
        cart[0] = new Bike(123000, "MTB", 25);
        cart[1] = new Electronics(35000,"USB");
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[5] = new Electronics(527000, "스마트TV");
        cart[7] = new Electronics(123000, "MTB");
        //자식객체를 생성하는데 부모를 참조변수로 
        //생성 가능한이유는 자식객체에 부모객체가 포함되어있기때문

        //power 메소드 : Electronics 자식 클래스의 메소드임
        // 현재부모타입으로 참조되어있는 상태를 자식타입으로 변경해야함. product -> electronics 이럴때 다운캐스팅
        //이때 부모 객체를 다운캐스팅 하기전에 instanceof로 자식객체의 타입을 검사해줍니다
        
        System.out.println("\n문제2");
        if(cart[5] instanceof Electronics){
            Electronics tv = (Electronics)cart[5];
            tv.setKwh(0.9);
            System.out.println(tv.power());
        }
        else
            System.out.println("Electronics 타입으로 변경 불가.");
        

            // 배열 10개중에 객체가 참조된것은5개
            // 반복문으로 실행할때 반드시 null이 아닌것만 하도록합니다
            // null 이면 메소드 실행 예외합니다. 중요 null 체크해야할상황 디게 만음
            // null 일경우까지 검사해버리면 에러가나버림
            System.out.println("\n문제3");
        for(Product p : cart){
            // 다른 패키지에 있으면 price 의 getter가 필요하지만 같은 패키지안에있는 protected 타입이기 때문에 에러가안남
                if(p != null && p.price >= 100000)
                System.out.println(p);
            }
            System.out.println("\n문제4");
        for(Product p : cart){
            if(p != null && p instanceof Electronics){
                Bike bike = (Bike)p;
                System.out.println(bike.ride());
            }
        }

        System.out.println("\n문제5");
        String result = cart[3].sell(20);
        System.out.println(result);

        System.out.println("\n문제6");
        System.out.println(cart[5].sell("사운드바"));
            }
        
/**
 * 
 * 자바 교재 204 페이지
 * 라이브러리 클래스 : Product, Bike , Electronics
 * ㄴ 프로그래밍에 필요한 재료로 사용되는 클래스
 * ㄴ 인스턴스 메소드와 static 메소드로 제공되는 기능을 사용함
 * 
 * 실행 클래스 : ProductApp
 * ㄴ main 메소드를 포함하여 프로그램을 실행함
 * ㄴ main 메소드는 반드시 static 이어야 합니다\
 * ㄴ main 메소드를 위한 객체를 먼저 생성할 수 없다. 그래서 static입니다.
 * 
 * 
 * 설명 예시 : Bike 클래스의 sell 메소드  Object 인자값은 외부에서 줍니다.
 * 여기서 외부는 이 메소드를 사용하는 main 또는 다른 클래스를 말합니다)
 * 라이브러리 클래스의 특히 인스턴스 필드 값은 실행 될 때 결정됩니다.
 */
}
