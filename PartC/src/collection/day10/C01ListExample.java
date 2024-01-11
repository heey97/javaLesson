package collection.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C01ListExample {
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<String>();
        //List 인터페이스를 구현한 클래스가 ArrayList 입니다.

        strlist.add("트와이스");
        strlist.add("잇지");
        strlist.add("아이브");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스");
        
        System.out.println("문자열 LIST strlist size : " + strlist.size()); //?
        System.out.println("\n데이터 추가");
        strlist.add("르세라핌");
        System.out.println("항목 추가 후 리스트 :" + strlist);

        System.out.println("\n데이터 삭제");
        strlist.remove("원더걸스");
        strlist.remove(1);
        System.out.println("항목 삭제 후 리스트 :" + strlist);

        System.out.println("\n 데이터 항목 변경");
        strlist.add(2,"??????");
        strlist.set(2,"!!!!!!");
        System.out.println("항목 변경 후 리스트 :" + strlist);

        System.out.println("\n 특정 인덱스 위치 요소값 가져오기");
        System.out.println("strlist.get(0) = "+strlist.get(0));
        System.out.println("strlist.get(3) = "+strlist.get(3));
        System.out.println("strlist.get(5) = "+strlist.get(5));
        List<String> strlist2 = new ArrayList<String>();
        strlist2.add("1");
        strlist2.add("2");
        strlist2.add("3");
        strlist2.add("4");
        strlist.addAll(0,strlist2);
        System.out.println("strlist2 전체 추가 후 리스트2 :" + strlist);
        System.out.println(strlist.contains("아이브"));
        
        strlist.sort(Comparator.naturalOrder());
        System.out.println("ASC정렬 :" + strlist);
        strlist.sort(null);

        System.out.println("ASC정렬 :" + strlist);
        
        strlist.sort(Comparator.reverseOrder());
        System.out.println("DESC정렬 :" + strlist);

        System.out.println(strlist.contains(2));
        
    }
}
/* 추가add 삭제remove 수정set((index),(넣을 값)) 인덱스 안적으면 값만 들어가거나 삭제됨 일반 문자열과 배열과 다르게 길이 메소드 size()
 * addAll list.addAll(1,list2) list 인덱스1위치에 list2값 전체 add 인덱스 지정하지않으면 끝으로 들어감
 * (Asc)list.sort(Comparator.naturalOrder()) 리스트 정렬  (Desc)list.sort(Comparator.reverseOrder())
 * removeAll list.addAll(list2) list2 인값 전체 삭제
 * list.indexOf("문자"); (문자가 0부터 몇번째에있는지검색)
 * list.contains 잇냐없냐 단일검색(true or false);
 * indexof()
 * 인덱스 요소값 가져오기 list.get(index);
 * List 구현 클래스 특징 : 배열처럼 인덱스를 갖는다. 배열에 없는 '삭제' 기능이 있다 그외에도 조회와 관련된 기능이 있다.
 *                        배열에 없는 '삭제' 기능이 있다.
 *                        그 외에도 조회 관련 기능 등 조작과 조회를 다양하게 할 수 있습니다.
 */
