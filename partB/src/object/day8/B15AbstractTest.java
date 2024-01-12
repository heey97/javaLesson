package object.day8;

public class B15AbstractTest {
    public static void main(String[] args) {
        //Animal ani = new Animal(); // new 객체생성 못해용. 이유 : 추상클래스라서 

        //Anonymous(익명) Inner(내부 클래스) Type : 클래스 이름이 없는 내부 클래스 형식
        Animal animal = new Animal() { // 강요된 추상메소드 재정의 하면서 내부 클래스 정의(일회용)
            @Override
            public void sound() {
                System.out.println("익명으로 만들어진 동물 클래스: 소리는 모름");
            }
        };

        Puppy puppy = new Puppy("푸들이","브라운");
        puppy.sound();
        System.out.println("puppy toString = " + puppy);
    }
}
