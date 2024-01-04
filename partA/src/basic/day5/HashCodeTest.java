package basic.day5;

public class HashCodeTest {
    public static void main(String[] args) {
        int[] iArray = new int[10];
        String message = "Hello~ World~~";

        //hashcode 는 참조값(식별값)을 만들기위해 '해쉬 함수'로 생성 된 결과입니다.
        System.out.println(iArray); //베열의 식별값을 보여줌 (16찐수)
        System.out.println(iArray.hashCode()); //해쉬코드값을 가져옴
        System.out.println(Integer.toHexString(iArray.hashCode())); //10찐수를 16찐수로 변환!

        iArray[3] = 99;
        System.out.println("배열 요소값을 변경한 후 해시코드 : "+ iArray.hashCode());
        System.out.println("결론 : 배열 값이 변경되어도 메모리의 위치는 동일합니다. ");

        System.out.println("\n String 변수 message의 해시코드 값 : " + message.hashCode());
        message = message + "~Goodㅇㅇㅇ";
        System.out.println("message를 변경한 후 해시코드 값 : " + message.hashCode());
        System.out.println("결론 : 문자열 String은 내용이 변경되면 메모리의 위치가 바뀝니다. ");

        /*
         * 객체란 ? 여러종류의 데이터가 모여있는 데이터 덩어리. (기본형은 데이터의 최소단위)
         * 객체는 참조형 변수를 사용합니다.(변수가 주소를 저장한다.)
         * 객체를 메모리에 저장햇어용. ---> 초기에 저장한 데이터를 바꿀 쑤 있따(배열) - 가변객체
         *                           ---> 초기에 저장한 데이터를 바꿀 수 없다.(String) - 불변객체
         * 
         */
    }
}
