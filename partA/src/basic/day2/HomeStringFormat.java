package basic.day2;

public class HomeStringFormat {
    public static void main(String[] args) {
     //주말과제 : String.format() 에 대한 예제를 작성하고 실행도 해보세요.

     //152499320을 3자 단위로 쉼표를 붙여서 출력하시오.

    int num = 152499320;

    System.out.println(String.format("%,d",num));
     
    //152499320을 3자 단위로 쉼표를 붙이고 15자로 출력하시오.

    System.out.println(String.format("%,15d",num));

    //152499320을 3자 단위로 쉼표를 붙이고 15자로 출력하고 길이를 확인하시오.

    System.out.println(String.format("%,15d",num).length());

    //152499320을 3자 단위로 쉼표를 붙이고 15자로 출력하고 뒤에 ~을 붙이시오.

    System.out.println(String.format("%,15d~",num));
    }
}
