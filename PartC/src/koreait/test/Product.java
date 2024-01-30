package koreait.test;

public abstract class Product {
    protected int price;
    protected String prdName;
    // 같은패키지면 접근가능
    public abstract String sell(Object o);
}
