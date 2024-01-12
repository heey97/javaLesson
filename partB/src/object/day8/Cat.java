package object.day8;

public class Cat extends Animal {
	public static final String TYPE ="고양이 ";
	
	public Cat() {
	}
	
	public Cat(String name, String color) {
		super(name,color);
	}
    
    public Cat(String color){
        setColor("그레이");
    }
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 고양이는 야옹😺😺하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}

	//toString을 재정의 하지 않으면 부모 toString이 실행되고 부모의 TYPE 상수값 출력
	//static 필드 또는 메소드는 객체의 재정의 특징에 해당되지 않습니다.
}
