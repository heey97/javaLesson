package collection.day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("momo",23));
        list.add(new Member("nana",22));
        list.add(new Member("momo",25));
        list.add(new Member("dahy",21));
        list.add(new Member("sana",26));
        

        //hashCode,equals 메소드 재정의하기 before & after을 비교하세요.
        //컴파일러는 객체의 hashCode 같으면 equals 검사합니다. 둘다 통과하면 동일객체로 결정
        //                                                   ㄴ remove or indexOf 등 메소드에 동일 객체 검사할때 사용

        System.out.println("현재 리스트 내용 : " + list + "크기 : " + list.size());
        list.remove(new Member("momo", 23));

        System.out.println("삭제 후 리스트 내용 : " + list);
        Comparator<Member> nameAscending = new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2){
                return o1.getName().compareTo(o2.getName());         //내림차순 o1>o2 이 되어야합니다.
            }                                                        // o2-o1 < 0이면 교환하지 않습니다.
        };
        list.sort((o1,o2)->{
            return o2.getName().compareTo(o1.getName());
        });

        list.sort(nameAscending);
        System.out.println("오름차순 정렬 이름 : " + list);
        //new Member("momo",23) 에서 인스턴스 필드값이 같다고 동일한 객체가 아니다.
        //remove , indexof 등의 메소드는 동일한 객체를 찾아서 삭제하거나 조회합니다.
        // string 은 불변객체라 문자열 리터럴이 같으면 주소가 같아서 삭제가능하다
        // 일반적으로 만들어진 클래스는 hashcode 로 메모리의 참조위치가 결정됌
        //                            인스턴스 필드 내용이 같으면 hashcode를 동일하게 만들도록 재정의합니다.

        //정수,실수,문자열 타입은 list.sort(null); 로 오름차순 정렬합니다.
        //그외에는 Comparator 를 구현해야 합니다.

        //List의 static 메소드
        //           ㄴ 테스트용 리스트 만들때 사용합니다. 불변객체입니다.
        //List.of 한번에 넣을수있어서 편한대신 불변이라 삭제추가수정안댐
        List<String> names = List.of("momo","dahy","nana","sana");
        System.out.println("names :" + names);

        names.add("xxyyzz");    //ImmutableCollections 불변객체라 항목을 추가삭제 x
    }
}
