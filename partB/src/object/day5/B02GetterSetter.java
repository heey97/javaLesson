package object.day5;

import java.util.Arrays;

public class B02GetterSetter {
    public static class Gdg{
        int a;
        public static class Fk{int a;}
    }
    public static class Fsf{
        int a;
    }
    public static void main(String[] args) {
        Gdg gg = new Gdg() ;
        Gdg.Fk wew = new Gdg.Fk();
        Fsf a = new Fsf();
        
        wew.a = 4;
        System.out.println(gg.a);
        gg.a = 3;
        System.out.println(gg.a+","+wew.a);
        //myclass2 클래스 객체 선언;
        MyClass2 momo = new MyClass2();
        
        //field1
        System.out.println("MyClass2 의 field1 값(초기): " + momo.getField1());
        momo.setField1("나는 모모");
        System.out.println("MyClass2 의 field1 값(변경 후): " + momo.getField1());
        
        String message = "WELCOME~!!";
        momo.setField1(message);
        System.out.println("MyClass2 의 field1 값(변경 후): " + momo.getField1());


        //field2
        System.out.println("MyClass2 의 field2 값(초기): " + momo.getField2());
        momo.setField2(12345);
        System.out.println("MyClass2 의 field2 값(변경 후): " + momo.getField2());
        
        int test = 1234;
        momo.setField2(test);
        test -= 33;
        System.out.println("MyClass2 의 field2 값(변경 후): " + momo.getField2());




        // System.out.println("MyClass2 의 field3 값(초기): " + momo.getField3());

        
        // System.out.println("MyClass2 의 field3 값(변경 후): " + momo.getField3());

        // System.out.println("\n 지금까지 momo 객체의 값들은...");
        // momo.printData();

        // System.out.println("---------------field3은 double 배열 타입입니다.");
        // double[] dArray= momo.getField3();
        
        // System.out.println("field3 = " + Arrays.toString(dArray));
       
        // double[] dArraytemp = {1.2,3,44,67.12};
        
        // momo.setField3(dArraytemp);
      
        // dArraytemp[3] = 3.1415;
        
        // momo.printData();
        // System.out.println("adadaddaddaddfield3 = " + Arrays.toString(momo.getField3()));
        
    }

}

