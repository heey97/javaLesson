package collection.myapp;

import java.util.*;
// JavaWord 여러개를 저장할 클래스 입니다.
// 조회 기능에 유리한 Map을 사용하겠습니다.
public class JavaWordBook {
    //굳이 List 대신 Map 을 사용한 이유 : Key 값으로 조회를 하기 위해
    //조회 이외에는 (특히 출력) map.values()로 value 값만 사용
    private Map<String,JavaWord> wordBook;
    //key : 영어단어
    //value : JavaWord(영어,한글,레벨)
    public JavaWordBook(){
        this.wordBook = new TreeMap<>();
        //key 값인 영어 단어 순으로 정렬하여 접근
    }
    
    public Map<String,JavaWord> getWordBook(){
        return this.wordBook;
    }

    //단어 추가
    public void addWord(JavaWord word){
        this.wordBook.put(word.getEnglish(),word);
        
    }

    //--------------조회----------------
    //map 의 특징 - db의 기본키와 비슷함
    // 단어로 조회
    public List<JavaWord> searchWord(String english){
        List<JavaWord> rs = new ArrayList<>();
        for( JavaWord word : this.wordBook.values()){
            if(english == word.getEnglish()){
                    rs.add(word);
            }
        }
        return rs;
    }
    // 레벨로 조회
    public List<JavaWord> seaerchWordsByLevel(int level){
        List<JavaWord> results = new ArrayList<>();
        //인자로 전달된 level만 result로 리스트에 저장하기
        for( JavaWord word : this.wordBook.values()){
            if(level == word.getLevel()){
                    results.add(word);
            }
        }
        return results;
    }

    //단어 삭제
    public void removeWord(String english){
        this.wordBook.remove(english);
    }

    public List<JavaWord> wordAll(){
        
        List<JavaWord> all = new ArrayList<>(this.wordBook.values()); //**** 맵의 값만 가져와서 리스트로 만듦*/
        return all;
    }

    public void Print(){
        System.out.println("~".repeat(20)+"~단어장~"+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %9s","<english>","<korean>","<level>"));
        for(JavaWord word : wordBook.values()){
            System.out.println(String.format("%-15s %-15s\t %d",word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

    public static void wordListPrint(List<JavaWord>list){
        System.out.println("~".repeat(20)+"~단어장~"+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %9s","<english>","<korean>","<level>"));
        for(JavaWord word : list){
            System.out.println(String.format("%-15s %-15s\t %d",word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
    
  
}
