package object.day7;

import object.day7.Square;

/*
 * 다형성이 어떻게 구현되는 것인지 확인하기
 * ㄴ 자료구조 필요합니다. 배열을 사용해 봅시다.
 */

public class B12PolymorphismExam {
    
    public static void main(String[] args) {
        
        Shape[] shapes = new Shape[5];

        shapes[0] = new Diamond();
        shapes[0].setShapeName("🔶");

        shapes[1] = new Triangle("세모님", 120, 40, 45);

        shapes[2] = new Square();
        shapes[2].setShapeName("🆘🆘🆘");

        shapes[3] = new Diamond();
        shapes[3].setShapeName("💠💠💠");

        shapes[4] = new Square();
        shapes[4].setShapeName("💟💟💟");

        //여기까지 부모타입 배열에 자식 객체들을 생성해서 참조 시켜놓았습니다.

        //다형성 : 자료구조에 저장된 객체가 하나의 타입 Shape 이지만 실행되는 draw 동작은 모두 다릅니다.
        for(int i=0; i<shapes.length; i++) {
            System.out.println(i + " 번 도형입니다. ");
            shapes[i].draw();
            //부모타입으로 참조되는 객체들이 재정의된 draw() 메소드를 실행합니다.
            //다형성은 메소드는 한가지를 통일해서 실행하나 결과는 여러 형태로 보이는것 입니다.
            //                      ㄴ 자식클래스가 ※메소드 오버라이드※를 할 수 있기 때문에 가능합니다.
        }
        System.out.println("~~~~~ 자식객체의 실제 타입을 검사하는 instanceof 연산 ~~~~~");
        for(int i=0; i<shapes.length; i++) {
            System.out.println("도형 : " + shapes[i].getShapeName());
            //부모 객체를 다운캐스팅 하기전에 instanceof로 자식객체의 타입을 검사해줍니다
            System.out.println("\t shapes[i] instanceof Triangle ? " + (shapes[i] instanceof Triangle));
            System.out.println("\t shapes[i] instanceof Diamond ? " + (shapes[i] instanceof Diamond));
            System.out.println("\t shapes[i] instanceof Square ? " + (shapes[i] instanceof Square));
        }

        System.out.println("~~~~~ shapes 배열에 저장된 객체 중 삼각형 Triangle 객체는 넓이를 구해서 출력하기 ~~~~~");
        // 4번 인덱스 도형을 새로운 Triangle 객체로 참조해서 아래 코드 실행해보세요.
        shapes[4] = new Triangle("⚠⚠", 45, 12, 68);
        System.out.println("삼각이면 angle 필드값도 출력합니다.");
        for(int i=0; i<shapes.length; i++) {
            if(shapes[i] instanceof Triangle) {
                //반드시 실제 객체가 Triangle일때만 강제캐스팅 합니다. 그렇지 않으면 오류.
                Triangle tempTriangle = (Triangle) shapes[i];
                System.out.println("\t i = " + i + " 는 삼각형입니다. 넓이 : " + shapes[i].calculateArea());
                tempTriangle.printAngle();
            }
        }
        
        System.out.println("~~~~~ shapes 배열에 저장된 객체 중 다이아몬드를 draw 하기 ~~~~~");
        //for문 반복할 때 알아서 순서대로 1개씩 배열 요소를 가져오기. 인덱스 i 값을 사용하지 않습니다.
        for(Shape temp : shapes) {
            if(temp instanceof Diamond){
                temp.draw();
            }
            //Up Casting
            Shape sh = new Diamond();
            
            
            //Down Casting -sh의 실제 객체가 다운 캐스팅하려는 타입인지 검사 필수. instanceof 연산으로 검사하기.
            // (아래 예시) sh의 실제 객체가 아닌 것(Triangle,Square)을 Diamond 로 캐스팅하면 오류.
            Diamond diamond = (Diamond)sh;

            // 자식객체의  인스턴스 메소드 iamDiamond는 반드시 다운캐스팅을 해야실행가능
            
        }

       
        
        
        
    } 
    /*
     * 3. 클래스 상속에 대한 설명으로 맞는 것을 모두 고르세요. 
     * 
  
     *  1)상속의 장점은 중복된 코드를 줄일 수 있고 통일성과 다형성을 구현할 수 있다.
        
        정답 : O

     *  상속의 장점은 처음에 설명했던 것과 큰 차이가 없다. 
     *  중복된 코드를 줄일 수 있고, 유지 보수가 편리하며, 코드간의 '통일성'이 있고
     *  하나의 코드로 다양하게 사용할 수 있는 '다형성'을 구현할 수 있다. 
  

     *  2) 부모 클래스의 private를 갖는 필드는 자식 클래스가 직접 사용이 가능하다.
     * 
     *  정답 : X
     * 
     *  private 접근제한자를 갖는 필드를 자식클래스에서 사용하기 
     *  위해서는 getter setter메소드를 사용해야 한다.

     * 
     *  3) 자식 클래스 객체가 생성될 때 부모클래스의 생성자가 반드시 실행된다.

     *  정답 : O
     * 
     *  자식 클래스 객체가 생성될떄 자식 클래스를 
     *  초기화 하기위해서는
     *  부모 클래스가 먼저 초기화 되어야 하기 때문에 
     *  부모 생성자는 반드시 실행되어야한다.
     * 
     * 
     *  4) 자식 객체는 부모 클래스 타입의 변수로 참조될 수 없다.
     *  정답 : X
     * 
     *  자바는 다형성을 위해 부모클래스로의 타입변환을 허용한다 
     *  즉, 부모타입에 모든 자식객체가 대입될 수 있다.
     *
     * 
     *  5) 자식타입에서 사용할수 있는 객체 멤버갯수가 더 많기 때문에
     *     부모 객체는 자식 클래스 타입의 변수로 참조 될 수 없다.
     * 
     *  정답 : X
     * 
     *  자식타입에서 사용할수 있는 객체 멤버갯수가 더 많기 때문에
     *  부모 객체는 자식 클래스 타입의 변수로 참조 될 수 없다.
     * 
     * 
     * 
     * 
     * 8. 자식클래스에서 직접 부모 클래스의 메소드를 재정의하기위해
     *    메소드 오버라이딩을 사용합니다.
     */
}
