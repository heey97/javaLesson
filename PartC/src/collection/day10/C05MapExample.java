package collection.day10;

import java.util.*;

/*
 * Map<K,V> : Key 값으로 value 를 가져오기
 *            'key'는 중복된 값을 가질 수 없습니다. key와value 모두 순서가 없습니다.
 *            맵에 입력한 순서대로 접근해야 한다면 LinkedHashMap 또는 
 *            정렬된 방식으로 접근해야한다면 TreeMap
 * Map의 구성요소 : Key, Value 중에서 Key는 Set의 특성을 갖고있습니다.
 * 
 * 
 */

public class C05MapExample {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스");
        map.put("js", "뉴진스");
        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);
    
        Scanner sc = new Scanner(System.in);
        
        while(true){
        System.out.print("찾을 값에 대한 키를 입력하세요");
        String key = sc.nextLine();
        if(key.equals("end")) break;
        System.out.println("당신의 원하는 Key의 값= " + map.get(key));
        }

        System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
        System.out.println("\t map.keySet()");
        Iterator<String> mapIterator = map.keySet().iterator();
        int cnt =0;

        while(mapIterator.hasNext()) {
         String temp =mapIterator.next();                                                   //반복자가 가져온 값은 key 입니다.
         System.out.println(String.format("count=%d , key= %s , value=%s",
                                                                        cnt++,  
                                                                        temp,               //key를 가져옴
                                                                        map.get(temp)));    //key값을 넣어서 해당하는 value값을 가져옴
      }
      System.out.println("==for 반복자로 출력하기==");
      for(String key:map.keySet()){ //map의 key 값들로 반복자 실행하기
        System.out.println(String.format("Count = %d, key = %s, value = %s", 
                                                                        cnt++,
                                                                        key,
                                                                        map.get(key)));
      } 
      
      System.out.println("map.value()? " + map.values());
      //조회
      System.out.println("map.containsKey(\"tt\")? " + map.containsKey("tt"));
      System.out.println("map.containsKey(\"js\")? " + map.containsKey("js"));
      System.out.println("map.containsValue(\"에스파\")? " + map.containsValue("에스파"));
      System.out.println("map.containsValue(\"잇지\")? " + map.containsValue("잇지"));
    }
}
