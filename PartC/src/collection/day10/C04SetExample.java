package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        //set은 인덱스가 없습니다
        // 원래 for문 안댐
        
        set.add("트와이스");
        set.add("아이브");
        set.add("잇지");
        set.add("뉴진스");
        set.add("트와이스");
        set.add("소녀시대");
        System.out.println("set : " + set);
        System.out.println("set.size : " + set.size());


        System.out.println("~~~~~~~~~~~~~~~~~LinkedHashSet~~~~~~~~~~~~~~~~~~~~~~~~~");
        Set<String> set2 = new LinkedHashSet<>();
         //본래의 set은 순서가 없지만 LinkedHashSet은 객체의 입력 순서대로 다음 데이터의 찹조값을 저장하여 접근하게해준다
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("트와이스");
        set2.add("소녀시대");
        System.out.println("set2 : " + set2);
        System.out.println("set2.size : " + set2.size());

        
        System.out.println("~~~~~~~~~~~~~~~~~TreeSet~~~~~~~~~~~~~~~~~~~~~~~~~");
        Set<String> set3 = new TreeSet<>();
         //TreeSet 정렬돼서 출력댐 (ASC) 이진트리 검색알고리즘 이용해서 검색
        set3.add("트와이스");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("트와이스");
        set3.add("소녀시대");
        System.out.println("set3 : " + set3);
        System.out.println("set3.size : " + set3.size());
        
    }
}

/*
 * Set : 수학시간에 배운 집함
 * 순서(인덱스)가 없다.
 * 중복값이 없다.
 * Map의 구성요소 : Key, Value 중에서 Key는 Set 특성을 갖고 있습니다.
 */
