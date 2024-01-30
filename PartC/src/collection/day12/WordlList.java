package collection.day12;

import java.util.List;

import collection.myapp.JavaWord;

//자바 단어장 클래스는 아래의 추상 메소드를 꼭 개현해야합니다.(기능 또는 규칙)
public interface WordlList {
    //최대 단어 개수 100개를 설정한다면
    //추상메소드 정의 - 구현내용은 클래스의 특징에따라 정의됩니다 ex)개(기능),사람(기능)
    int MAX_LENGTH=100;
    //개발단계에서 인터페이스를 먼저 정의헤놓고 구현단계에서 override로 재정의한다
    JavaWord getWord(int i);
    List<JavaWord> list();
    void add(JavaWord word);
    int indexOfWord(String english,int position);
    JavaWord remove(int index);
    List<JavaWord> searchAllByEnglish(String english);
    void print();

    //만약에, 이미 구현된 클래스 외에 이후 
    //구현에 적용하고싶은 메소드가 있다면
    // default 키워드로 정의하기
    default List<JavaWord> search(Object object){
        return null;
    }
}
