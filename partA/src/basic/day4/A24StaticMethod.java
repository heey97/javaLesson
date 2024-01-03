package basic.day4;

public class A24StaticMethod {

    public static void main(String[] args) {
        argumentTest();
        argumentTest(999); 
        argumentTest(100, 333);    //100,333은 실 매개변수
        //메소드가 실행될 때 실매개변수값이 형식매개변수로 전달, 저장됩니다.
        // argumentTest("100","333");  //형식에 맞는 메소드 없음.
        int a =100,b=999;
        argumentTest(a, b); // 실매개변수 a,b 클래스이름은 대문자로 시작 메소드이름은 소문자로 시작
        
        // resultIntTest(5);
        // resultBooleanTest();
        // resultStringTest();
        // resultCharTest();
        int c = resultIntTest();
        Boolean d =resultBooleanTest();
        String e = resultStringTest();
        char f = resultCharTest();

        System.out.println("resultIntTest() :  "+c);
        System.out.println("resultBooleanTest() :  "+d);
        System.out.println("resultStringTest() :  "+e);
        System.out.println("resultCharTest() :  "+f);
        double  g = add(1654,56451,115);
         System.out.println("add() :  "+g);


    }
    //1) ~ 4)는 리턴이 없습니다. 인자로 선언된 ()안의 변수는 메소드의 지역변수 입니다.
    //1) 인자값 없는 메소드
    public static void argumentTest(){
        System.out.println("인자값 없는 메소드 입니다.");
    }
    //2) 인가가 1개 있는 메소드
    public static void argumentTest(int i){        //인자로 사용된 변수 i는 argumentTest 메소드에서만 사용합니다.
        System.out.println("인자가 1개 정수" + i + "메소드 입니다.");
    }
    //3) 인자가 2개 있는 메소드
    public static void argumentTest(int i, int j){
        System.out.println("인자가 2개 정수 i= " + i +",j= "+j);
    }
    //4) 리턴값이 정수인 메소드
    public static int resultIntTest(){
        
        int i = 1;
        return i;
    }
    //5) 리턴값이 boolean 인 메소드
    public static boolean resultBooleanTest(){
        int a= 5;
        int b= 6;
        int c= a>b? 1:2;
        if(c == 1){
            return true;
        }else{
            return false;
        }
    }
    //6) 리턴값이 String 인 메소드
    public static String resultStringTest(){
        String a = "Hello World!";

        return a;
    }
    //7) 리턴값이 char 인 메소드
    public static char resultCharTest(){
        char a = 'A';
        
        return a;
    }
    //8) 인자와 리턴값을 갖는 메소드
    public static double add(double a, double b, double c){
        
       double s = a+b+c;

        return s;
    }
}
