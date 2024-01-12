package object.day7;

import object.day7.Shape;       // 다른 패키지 클래스는 import 필요.

// *Diamond와 Square 각각 사용할 수 있는 Shape 부모클래스 필드가 다릅니다.
// *B10 과 B11 둘 다 동일한 코드이지만 패키지가 달라지면서 또 실행이 불가능하다

public class Square extends Shape {
    

    // etc setter
    public void setEtc(String etc){
        this.etc = etc;         // Shape의 상속 클래스는 etc 필드 직접 사용
    }

    // round setter
    //public void setRound(int round){
        //this.round = round;     
        // 오류 : Shape과 같은 패키지 아니므로 직접 사용 못함.
    //}

    @Override
    public void draw() {
        System.out.println("정사각형 " + this.getShapeName() + " 를 그립니다.");
    }
    
}
