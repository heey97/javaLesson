package io.javaworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;
import io.day13.Score;

/**
 * JavaWordApp_V3 : 아래의 JavaWordList 를 이용해서 똑같이 메뉴가 동작하도록 
 *                  변경할 수 있습니다.
 */

 //클래스로 따로 구현한 이유 웹이나 브라우저등 다른환경에서 이 단어장을 사용할 떄 
 //메소드(기능)들을 명시하고 단어장도 객체로 생성될 수 잇게함.
 //최후정리 : 자바단어장 클래스에 적용될 인터페이스 생성
public class JavaWordList implements WordlList{
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    private List<JavaWord> words;
    private String filepath = "D:\\Class231228\\java\\note.txt";
    
    public JavaWordList(String filePath) {
        System.out.println("단어장의 단어 최대 개수 : " + WordlList.MAX_LENGTH);
        words = new ArrayList<>();
        this.filepath = filePath;
    }


    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }

    @Override
    //단어장 전체 리스트 리턴
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return words;
    }
    @Override
    //단어 추가
    public void add(JavaWord word) {
        if(words.size() == WordlList.MAX_LENGTH){
            System.out.println("꽉찼다.\n단어장 새로만들어라");
            return;
        }
        words.add(word);
    }

    //전달받은 영어 단어의 인덱스를 배열로 리턴합니다.-조회 및 삭제 기능에 사용할 새로운 메소드
    //해당배열의 검색할 **포지션**부터 검색
    @Override
    public int indexOfWord(String english,int position){
        for(int i=position;i<words.size();i++){
            if(words.get(i).getEnglish().equals(english))
                return i;       //찾으면 인덱스 리턴
        }   
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
        if(index < 0 || index > words.size())
                throw new IllegalArgumentException("삭제할 인덱스 범위가 잘못됐씁니다"); //가장많이쓰는 예외처리
                //새로운 Exception 객체를 생성하면 개발자가 만든 예외가 발생됩니다.
                // 발생시킬 익셉션 종류는 IllegalArgumentException("") 와 같은 이름으로 많이사용합니다
                // 예를 들면 웹개발 할떄는 모든 예외를 한번에 처리하기 위해 이런방법 씁니다.
        JavaWord word = words.remove(index);
        return word; //삭제한 데이터를 리턴
    }

    //단어 1개 조회(여러개 일때는 처음 1개)
    public JavaWord searchFirstByEnglish(String english) {
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english 와 같은 word 리턴(메소드 종료)
            }
        }
        return null;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    //인스턴스 메소드 : 인스턴스 필드 words 를 사용하여 동작하기떄문
    @Override
    public void print(){
        for(JavaWord word : words) {

            // for(int i =0; i<=words.size(); i++){
                
            //     if(min< word.getKorean().length())
            // }
            if(word.getKorean().length() ==3){
                System.out.println(String.format("%-15s %-15s %7s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
            }else if(word.getKorean().length() ==4){
                System.out.println(String.format("%-15s %-15s %6s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
            }
            else
                System.out.println(String.format("%-15s %-15s %8s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    // static 메소드 : 인스턴스필드를 사용하지 않고 메소드 인자를 받아서 동작
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

        //단어장txt에서 데이터를 읽어와서 words리스트에 담기
    public void fileload() {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine())!= null){
                String[] temp = line.split(","); 
                words.add(new JavaWord(temp[0].trim(),
                                       temp[1].trim(),
                                       Integer.parseInt(temp[2].trim())));
            }
        } catch (Exception e) {
            System.out.println("파일 입력 예외 : " +e.getMessage());
        }
    }
    //새로운 단어등록, 기존단어 삭제 등의 변경사항을 파일에 저장하기
    public void fileSave(){
        int count=0;
        File file = new File("D:\\Class231228\\java\\note.txt");
        try (PrintWriter pw = new PrintWriter(file);) {
            //words에 있는 리스트의 모든 데이터를 파일로 출력하기
            for(JavaWord jav : words) {
                pw.println(jav);     
                count++;
            }

        } catch (IOException e) {
            System.out.println("파일 출력 예외 발생 : " + e.getMessage());
        }
        System.out.println("저장한 라인수 : "+count);
    }
}