package object.day5;

import java.util.Arrays;

public class MyClass2 {

	//인스턴스 필드 - 객체를 생성해서 사용.
	//private 키워드 : 현재 클래스 외에 다른 클래스에서 사용 못함.
	private String field1;
	private int field2;
	private double[] field3; //참조 값 변수저장
	final int a = 1;
	public String getField1() {
		return this.field1;
	}
	public int getField2() {
		return this.field2;
	}
	public double[] getField3() {
		return this.field3;
	}


	public void setField1(String f1) {
		this.field1 = f1;
	}
	public void setField2(int f2) {
		this.field2 = f2;
	}
	public void setField3(double[] f3) {
		field3 = new double[f3.length];
		for(int i=0; i<f3.length; i++){
			field3[i] = f3[i];
		}
	}

	//모든 인스턴스 값을 출력해주는메소드
	public void printData(){
		System.out.println("field1 = " + field1 + "field2 = " + field2
		 + "field3 = " + field3 +Arrays.toString(field3));
	}


	//static 필드-클래스이름으로 사용.
	private static final int FIELD4=999;
	private static int field5;

	//priate의 필드값을 가져오는 메소드 : getter
	// public String getField1(){
	// 	return field1;
	// }
	// public String getField1(){
	// 	return field1;
	// }
	// public String getField1(){
	// 	return field1;
	// }
	// //private로 필드값을 저장하는 메소드 : setter
	// public void setField1(String f1){
	// 	field1 = f1;
	// }
}
