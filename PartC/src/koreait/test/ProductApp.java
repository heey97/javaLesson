package koreait.test;

import koreait.test.Bike;
import koreait.test.Product;

public class ProductApp {
    public static void main(String[] args) {
        Product[] cart = new Product[10];
        
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[1] = new Electronics(0, null);
        cart[0] = new Bike(123000, "MTB", 25);
        
        
    }
}
