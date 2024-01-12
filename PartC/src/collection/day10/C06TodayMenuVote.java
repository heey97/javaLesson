package collection.day10;

import java.util.*;
import java.util.Map.Entry;// Map 안에서 구성요소로 정의된 Entry 내부 클래스

public class C06TodayMenuVote {
    public static void main(String[] args) {
        
        Map<String,Integer> map = new LinkedHashMap();
        Iterator<String> mapIterator = map.keySet().iterator();
        String menu = "Chiken, Spaghetti, Gopchang, Bulgogi, Pork belly";

        map.put("Chiken",0);
        map.put("Spaghetti",0);
        map.put("Gopchang",0);
        map.put("Bulgogi",0);
        map.put("Pork belly",0);

        System.out.println("오늘의 메뉴 투표합니다.");
        System.out.println("메뉴 : " + menu);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("영문 메뉴 이름 입력 >>>");
            String key = sc.nextLine();

            if(key.equals("end")) break;
            if(map.containsKey(key)){   
                int i = map.get(key);
                map.put(key,++i);
                System.out.println("투표 성공");
            }else if(!map.containsKey(key)){
        
                System.out.println("없는 메뉴입니다. 다시 선택하십시오.");
            }
        }
        System.out.println("투표가 종료되었습니다.");
        System.out.println("map");
        System.out.println(Collections.max(map.keySet()));
        System.out.println(Collections.max(map.values()));
        //value 최대값의 key는 무엇?? // key의잡합과,value의집합을 한쌍으로 만들려면 Entry타입으로 하나로 묶을 수 있다.

        // Comparator<Entry<String,Integer>> comparator = new Comparator<>() {
        
        //     @Override
        //     public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                
        //         return o1.getValue()-o2.getValue();
        //     }
        // };
        // Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),comparator);
        //     System.out.println("최다 득표 결과");
        //     System.out.println("\t 메뉴이름 :"+ maxEntry.getKey());
        //     System.out.println("\t 메뉴이름 :"+ maxEntry.getValue());
        
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println("key : " + entry.getKey());
                System.out.println("value : " + entry.getValue());
            }

            Set<Entry<String,Integer>> en = map.entrySet();
                        System.out.println(map);
                sc.close();
    };

}


