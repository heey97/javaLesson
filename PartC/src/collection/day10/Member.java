package collection.day10;

public class Member {
    private String name;
    private int age;

    /*
     * 아래 Member 클래스는 생성될 때 초기화하면 변경 못합니다.
     * hashCode, equals 메소드 재정의
     * 이러한 특징의 객체를 VO라고 합니다. Value Object 값을 담은 객체 setter가 없어서 변경은못함
     */
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Member  [name = " + name + "]"+"[age = "+ age +"]";
    }

    //중요 : 객체의 동일성(같은 객체) 검사를 위해서 hashCode 메소드, equals 메소드 재정의 하여 사용한다
    //    -> 해시코드갑싱 같고 인스턴스 필드의 내용이 같으면 동일한 객체다
    @Override
    public int hashCode() {
        //인스턴스 필드값으로 해시코드 생성하기 : ()
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
            //대상이되는 obj 와 현재 this객체의 인스턴스 필드값이 모두같으면 참을 리턴
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    
    
    
}
