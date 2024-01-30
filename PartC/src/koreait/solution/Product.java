package koreait.solution;

public abstract class Product {
    protected int price;
    protected String prdName;
    // 같은패키지면 자식이 직접 접근가능
     //object는 자바의 최상위 클래스 이기떄문에 인자로 사용하면 하위 어떤 변수가 들어와도 리턴 가능 (좋다 이거 자주써야겠따ㅣ)
    public abstract String sell(Object o);
    @Override
    public String toString() {
        return "prdName ="+ prdName + "price =" + price;
    }
    //메소드 시그니처 - 리턴타입, 메소드이름 , 메소등 인자형식과 개수
}
