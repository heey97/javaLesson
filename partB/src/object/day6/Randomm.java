package object.day6;

public class Randomm {
    public static void main(String[] args) {
        // 0<난수<1 => 로또 값처럼 1<= 로또번호 <= 45
        // 원래 난수값 범위에 *45를 하고 0<난수*45<45
        // 그값에 다시+1 하면 됩니다. 1<난수*45 <45
        // 난수의 범위를 start ~ end 범위로 조정하려면
        //(int)(Math.random()*(end-start+1))+start
        int start = 1; int end = 45;
        for(int i=0; i<10; i++){
            int temp = (int)(Math.random()*(end-start-1))+start;
            System.out.println("1~45범위의 변수 :" +temp);
        }
    }
}
