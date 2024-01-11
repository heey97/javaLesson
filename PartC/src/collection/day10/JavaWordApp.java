package collection.day10;

import java.util.*;



public class JavaWordApp {
    public static void main(String[] args) {
        
        //단어장을 시작하는 프로그램입니다.

        JavaWordBook myBook = new JavaWordBook();
        
        System.out.println("단어장을 시작하는 프로그램 입니다.");
        
        Scanner sc = new Scanner(System.in);
        //1. 단어장을 생성
        myBook.addWord(new JavaWord("public", "공용의", 1));
        myBook.addWord(new JavaWord("private", "개인적인", 1));
        myBook.addWord(new JavaWord("protected", "보호하는", 1));
        myBook.addWord(new JavaWord("Iterate", "반복하다", 3));
        myBook.addWord(new JavaWord("Collection", "수집", 2));
        myBook.addWord(new JavaWord("Application", "응용 프로그램", 2));
        myBook.addWord(new JavaWord("binary", "2진수의", 3));
        myBook.addWord(new JavaWord("binary1", "2진수의", 3));

        //단어장 출력
        myBook.wordAllPrint();

        
        String addEn;
        String addKo;
        int addLev;
        /******************추가********************/
        System.out.println("단어 추가하기를 선택하셨습니다.");
        System.out.print("추가할 영어 단어를 입력해주세요 >>> "+(addEn = sc.nextLine()));
        System.out.print("추가할 한글 단어를 입력해주세요 >>> "+(addKo = sc.nextLine()));
        System.out.print("추가할 단어의 레벨을 입력해주세요 >>> "+(addLev = sc.nextInt()));
    
        JavaWord newWord = new JavaWord(addEn,addKo,addLev);
        System.out.println("추가된 단어 = "+ newWord);
        /******************조회********************/
        // //단어로조회
        // System.out.print("조회 할 단어를 입력해주세요 >>>> ");
        // String findText = sc.nextLine();
    
        // List<JavaWord> listWord = myBook.searchWord(findText);
        // myBook.wordListPrint(listWord);
        // //레벨로조회
        // List<JavaWord> listLevel = myBook.seaerchWordsByLevel(3);
        // myBook.wordListPrint(listLevel);
       
       
        // /******************삭제********************/
        // System.out.println("삭제 할 단어를 입력해주세요 >>>>");
        // String remove = sc.nextLine();
        // myBook.removeWord(remove);
        // myBook.wordAllPrint();
        
        
        
        
        
        //while(true){
            
        // String key = sc.nextLine();

        // int sel;
        // System.out.print("단어장 메뉴 1) 단어조회 2) 단어추가 3)단어삭제 4)종료 >>>>> "+(sel =sc.nextInt()));

        // if(sel == 1){
            
        // }
        //1) 영어단어 입력하면 찾아주기
        
        //}

        //2) List<JavaWord> searchWordByLevel(int level) : 레벨로 조회하기

        //4. 단어 삭제
        
        
        
        //2. 단어 추가

        //3. 단어 조회

        //4. 단어 삭제
    }
}

    

