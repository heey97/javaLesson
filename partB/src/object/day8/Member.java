package object.day8;

public class Member {
    protected int age;
    protected String name;

    public Member(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
		return this.age;
	}

	public String getName() {
		return name;
	}
	
	//   setter
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    public boolean isAdopt(Animal animal) {
        // return false;
		if(animal instanceof Puppy && age >=15) return true;
		else if(animal instanceof Cat && age >=18) return true;
		else if(animal instanceof Rabbit && age >=13) return true;
		else if(age >=20) return true;
		else return false;
    }
}
