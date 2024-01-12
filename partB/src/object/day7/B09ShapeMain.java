package object.day7;

// Shape과 Triangle 을 객체 생성하고 메소드 테스트 해보세요.

public class B09ShapeMain {

    public static void main(String[] args) {
        Shape shape = new Shape("그냥 도형", 20, 15);
        Triangle triangle = new Triangle("세모", 30, 20, 60);

        System.out.println("~~~~~~~~ 재정의 메소드 실행 확인 ~~~~~~~~");
        System.out.println(shape.getShapeName() + "의 넓이 : " + shape.calculateArea());
        System.out.println(triangle.getShapeName() + "의 넓이 : " + triangle.calculateArea());

        System.out.println("~~~~~~~~ 부모 클래스가 정의한 메소드 실행 확인 ~~~~~~~~");
        shape.print();
        triangle.print();

        // getWidth, getHeight는 부모클래스 Shape 에서 정의했음. 자식이 실행가능.
        System.out.println("세모 너비 : " + triangle.getWidth());
        System.out.println("세모 높이 : " + triangle.getHeight());
        System.out.println("~~~~~~~~ 자식 클래스에서 정의한 메소드 실행확인 ~~~~~~~~");
        System.out.println("세모 각도 : " + triangle.getAngle());
        // shape.getAngle(); // 부모가 자식 객체의 메소드 실행 못함.

        // 상속에서의 변수 참조 타입 - 자식클래스 타입, 부모클래스 타입.
        // 1) 자식 객체를 부모 타입으로 참조하기 (중요 *****)
        Shape tempShape = new Triangle("임시세모2", 30, 40, 90);

        System.out.println("~~~~~~~~ 재정의 메소드 실행 확인 ~~~~~~~~");
        System.out.println("부모타입 참조이나 객체의 실체는 Triangle 이므로");
        System.out.println("\t 너비는 재정의 메소드로 실행됩니다.");
        System.out.println(tempShape.getShapeName() + "의 넓이 : " + tempShape.calculateArea());

        System.out.println("~~~~~~~~ 자식 클래스에서 정의한 메소드 실행확인 ~~~~~~~~");
        System.out.println("Triangle 자식 객체를 부모타입 Shape 으로 참조할 때에는 아래 메소드는 오류");
        System.out.println("\t ※ getAngle은 부모 타입에는 없는 메소드 입니다.");
        //System.out.println("세모 각도 : " + tempShape.getAngle());  // 오류
        System.out.println("세모 각도 :  + tempShape.getAngle());");

        // 2) 부모 객체를 자식 타입으로 참조할 수 있음 ??? 없음 XXXXX
        // Triangle tempTriangle = new Shape("임시도형", 30, 30); // 오류
        // 부모 객체를 자식 타입으로 참조하기 위해 강제 캐스팅.
        Triangle tempTriangle = (Triangle) new Shape("임시도형", 30, 30);
        // 강제 캐스팅은 했으나 Triangle에 필요한 인스턴스 필드가 안 만들어져 오류가 생긴다.

    }
}
