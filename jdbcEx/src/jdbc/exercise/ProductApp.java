package jdbc.exercise;

public class ProductApp {
    public static void main(String[] args) {
        Product[] cart = new Product[10];
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[1] = new Electronic(35000, "USB");
        cart[5] = new Electronic(527000, "스마트TV");
        cart[7] = new Electronic(2250000,"lg냉장고");

    }
}
