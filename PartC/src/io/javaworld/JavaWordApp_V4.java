package io.javaworld;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

/**
 * JavaWordApp_V4 : 객체지향 프로그래밍은 최대한 객체로 분리시켜서 
 *                  실행되는 환경에 독립적이 되도록합니다
 * 
 * JavaWordList : 단어장 객체를 생성할 때 읽어올 단어장 파일을 꼭 전달해야합니다.
 *                단어장 파일의 데이터로 리스트를 초기화 했습니다.
 *             
 */
public class JavaWordApp_V4{
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    private JavaWordList jList = new JavaWordList("D:\\Class231228\\java\\note.txt");
    
    //JavaWordApp_V4 : 메모장 List 초기화를 단어장 파일에서 읽어오도록 변경
    //프로그램 실행을 시작하는 메소드
    private void start(){
            //단어 등록,목록,검색,삭제 기능을 메뉴로 구현합니다.
        jList.fileload();
        System.out.println("단어장 프로그램 시작합니다.~~" + "~".repeat(30));
        while(true){
            System.out.println("\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.print("선택 > ");
            int select = Integer.parseInt(System.console().readLine());   
                switch (select) {
                    case 1:
                        addWord();         
                        break;
                    case 2: listWord();  break;    
                    case 3: searchWordBy();  break;   
                    case 4: removeWord();  break;
                    case 5: 
                        System.out.println("프로그램을 종료합니다.");
                        jList.fileSave();
                        System.exit(0);      //main 실행을 종료  
                        break;    
                    default:
                        System.out.println("잘못된 선택값 입니다.");
                        return;
                }
            }
    }

    /**********************************************단어 삭제******************************************************************************************* */
    // private void removeWord() {
    //     System.out.println("\t::단어 삭제합니다.::");
    //     System.out.print("삭제할 단어를 영문으로 입력하세요. _");
    //     String find = System.console().readLine();
    //     for(int i=0;i<jList.list().size();i++){
    //         if(jList.indexOfWord(find, i) == -1){
    //             System.out.println("삭제할 단어는 단어장에 없습니다.");
    //         }
    //         System.out.println("단어를 찾았습니다. ->" + jList.getWord(i));
    //         System.out.print("\n삭제하려면 엔터, 취소는 n 을 입력하세요._");
    //         if(System.console().readLine().equals("n"))
    //             continue;
    //         else {
    //             jList.remove(jList.indexOfWord(find, i)); 
    //             System.out.println("단어 삭제 완료!!");
    //             i--;
    //         }            
    //     }  
    // }
    private void removeWord(){
        System.out.println("\t::단어 삭제합니다.::");
        System.out.print("삭제할 단어를 영문으로 입력하세요. _");
        String find = System.console().readLine();
        int position = jList.indexOfWord(find,0);
        if(position == -1){
            System.out.println("찾는단어가없습니다.");
            return;
        }
        while (position != -1) {
            System.out.println("삭제할 단어 - "+jList.getWord(position));
            System.out.print("\n삭제하려면 엔터, 취소는 n 을 입력하세요._");
            if(!System.console().readLine().equals("n")){
                jList.remove(position);
                System.out.println("단어삭제완료!");
                position--;
            }
            position = jList.indexOfWord(find, ++position);
        }
    }      
    /**********************************************단어 조회******************************************************************************************* */
    private void searchWordBy(){
        System.out.println("\t::단어 검색합니다.(단어 조회는1, 레벨 조회는 2::)");
        List<JavaWord> list = null;  //조회되는 결과를 리턴받아 참조할 변수
        switch (System.console().readLine()){ // 키보드가 입력할 변수를 switch문에 담음
            case "1":
                System.out.print("검색할 단어를 영문으로 입력하세요. >>>> ");
                list = jList.searchAllByEnglish(System.console().readLine());
            break;
            case "2":
                System.out.print("검색할 레벨을 입력하세요. >>>>");
                list = jList.searchAllByLevel(Integer.parseInt(System.console().readLine()));
            break;
            default:
            System.out.println("1,2만 입력하세요.");
            return;
        }
        System.out.println("\t :: 검색 결과 입니다. :: ");
        if(jList.list().size()==0) System.out.println("찾는 단어가 단어장에 없습니다.:");
        else jList.print(list);
    }
    private void addWord() {
        System.out.println("\t::단어 등록합니다.::");
        System.out.print("영어 단어 입력하세요. _ ");
        String english = System.console().readLine();
        System.out.print("한글 의미 입력하세요. _ ");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요.(1:초급 2:중급 3:고급) _");
        int level = Integer.parseInt(System.console().readLine());
        jList.add(new JavaWord(english, korean, level));
        System.out.println("단어등록 성공\n"+jList.searchFirstByEnglish(english));
     }

    private void listWord() {
        System.out.println("\t::단어 목록 출력합니다.::");
        System.out.println(String.format("%-15s %-15s\t %9s","<english>","<korean>","<level>"));
        
        jList.print();
     }


    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 
        //          (메소드로 기능을 분리할 때 main이 호출하는 static 을 없애기 위함.)
        //         start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V4 app = new JavaWordApp_V4();
        app.start();
    }

    
}