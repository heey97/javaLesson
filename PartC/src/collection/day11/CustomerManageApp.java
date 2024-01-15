package collection.day11;

import java.util.*;


/*----------------------- 요구사항 -------------------*/ 
/* 메뉴선택 
 * 등록
 * 검색
 * 삭제
 * 수정
 * 전체출력
 */

public class CustomerManageApp {
    
    // 데이터를 담을 리스트 생성
    private List<Customer> list = new ArrayList<>(); 
    
    // 제일 처음 시작되는 메인메소드
    public static void main(String[] args) {            
        CustomerManageApp app = new CustomerManageApp();        
        app.start();
        
    }

    //앱 시작 메소드
    private void start(){
        initialize();
        while(true){
            System.out.println(String.format("%27s",":::::::관리 메뉴:::::::"));
            System.out.println("1.회원목록 || 2.회원등록 || 3.회원수정 \n4.회원삭제 || 5.회원검색 || 6.작업종료.");
            System.out.print("\n원하는 작업에 해당하는 번호를 입력해주십시오. >>>>>> ");
            String sel = System.console().readLine();
            switch (sel) {
                case "1": PrintAllList(); //회원목록
                break;
                case "2": addWord(); //등록
                break;
                case "3": SetListEx(); //수정
                break;
                case "4": RemoveList(); //삭제
                break;
                case "5": SearchList(); //조회
                break;
                case "6": System.out.println("프로그램을 종료합니다.");
                        System.exit(0);         
                break;
                default: System.out.println("잘못누르셨습니다 번호에 맞게 입력해주십시오.");
                return;
            }
        }
    }

    //집어넣을 데이터 메소드. String이름 String폰 int그룹
    private void initialize() {
       list.add(new Customer("heeyoung", "01091425624", 1));
       list.add(new Customer("youngwoo", "01012345687", 3));
       list.add(new Customer("soohwan", "01033394933", 2));
       list.add(new Customer("jiyeon", "01012345568", 3));
    }

    private void PrintAllList(){
        System.out.println("-회원목록-을 선택 하셨습니다!"); 
        System.out.println("\n\t:::::: -회원 목록- ::::::");
        PrintList(list); 
    }
    private void PrintList(List<Customer> allList){
        System.out.println(String.format("%-15s %-15s\t %9s","<NAME>","<PHONE>","<GROUP>"));
        for(Customer all : allList) {
            System.out.println(String.format("%-15s %-13s\t %9d",all.getName(), all.getPhone(), all.getGroup()));
        }
    }

/****************************************  등록  ****************************************************/

    private void addWord() {
        System.out.println("\n\t::::::: -등록- :::::::\n");

        System.out.print("\n이름을 입력하세요. : ");
        String name = System.console().readLine();
        System.out.print("\n핸드폰 번호를 입력하세요. : ");
        String phone = System.console().readLine();
        System.out.print("\n그룹을 입력하세요.(숫자) : ");
        int group = Integer.parseInt(System.console().readLine());

        list.add(new Customer(name,phone,group));
        System.out.println("등록완료.");
    }

/****************************************  조회  ****************************************************/
   
    private void SearchList(){
        List<Customer> searchList = new ArrayList<>();
        System.out.println("\n\t::::::: -검색- :::::::\n");
        String sel;
        System.out.print("1.이름 || 2.핸드폰 번호 || 3.그룹|| 4.전체"+
                            "\n\n검색하실 항목의 번호를 입력해 주십시오 >>>>>>");
        switch (sel = System.console().readLine()) {
            case "1":
                System.out.print("\n찾을 이름을 입력해주십시오 :");
                String findName = System.console().readLine(); 
                searchList=SearchWord(findName);
            break;
            case "2": 
                System.out.print("\n찾을 전화번호를 입력해주십시오 :");
                String findPhone= System.console().readLine();
                searchList=SearchWord(findPhone);  
            break;
            case "3": 
                System.out.print("\n찾을 그룹을 입력해주십시오 :");
                int findGroup= Integer.parseInt(System.console().readLine());
                searchList=SearchWord(findGroup);  
            break;
            case "4":
                System.out.print("\n찾을 이름을 입력해주십시오 :");
                findName = System.console().readLine();

                System.out.print("\n찾을 전화번호를 입력해주십시오 :");
                findPhone= System.console().readLine();

                System.out.print("\n찾을 그룹을 입력해주십시오 :");
                findGroup= Integer.parseInt(System.console().readLine());
                searchList=SearchWord(findName,findPhone,findGroup);  
            default:
                System.out.println("\n잘못누르셨습니다 번호에 맞게 입력해주십시오.");
            return;
            }
            
            System.out.println("\t::::::검색 결과::::::");
            if(list.size()==0) System.out.println("찾는 단어가 단어장에 없습니다.:");
            else PrintList(searchList);;
        } 
    private List<Customer> SearchWord(String s){
        List<Customer> rs = new ArrayList<>();
        for(Customer lists : list){
            if(lists.getName().matches(".*"+s.trim()+".*")) {
                rs.add(lists);
            }
        }
        return rs;
    }
    private List<Customer> SearchWord(int i){
        List<Customer> rs = new ArrayList<>();
        for(Customer lists : list){
            if(lists.getGroup() == i) {
                rs.add(lists);
            }
        }
        return rs;
    }
    private List<Customer> SearchWord(String s1,String s2,int i){
        List<Customer> rs = new ArrayList<>();
        for(Customer lists : list){
            if(lists.getName().matches(".*"+s1.trim()+".*") && lists.getPhone().matches(".*"+s2.trim()+".*")
                && lists.getGroup() == i) {
                rs.add(lists);
            }
        }
        return rs;
    }

/****************************************  삭제  ****************************************************/
    private void RemoveList() {
        System.out.println("\n\t::::::: -삭제- :::::::\n");
        System.out.print("삭제할 단어를 영문으로 입력하세요. _");
        String find = System.console().readLine();
        boolean isFind=false;           //단어 존재 유무 확인 변수
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(find)){
                isFind=true;
                System.out.println("인덱스 " + i + " 에서 단어를 찾았습니다.");
                System.out.print("삭제하려면 엔터, 취소는 n 을 입력하세요._");
                if(System.console().readLine().equals("n"))
                        continue;
                else {
                    //단어 삭제.
                    list.remove(i); System.out.println("단어 삭제 완료!!");
                }            
            }   //단어 비교 if end
        }   //for end
        if(!isFind)         //isFind==false
                System.out.println("삭제할 단어는 단어장에 없습니다.");
    }

/****************************************  수정  ****************************************************/

    private void SetListEx() {
        System.out.println("\n\t::::::: -수정- :::::::\n");
        System.out.print("수정할 번호와 그룹의 이름을 입력하세요. :");
        String name = System.console().readLine();
        boolean isFind=false;

        for(Customer lists : list){
            if(lists.getName().equals(name)){
                isFind=true;
                System.out.println("\n입력한 이름의 현재 번호 :"+lists.getPhone()+
                                   "\n입력한 이름의 현재 그룹 :"+lists.getGroup()+
                                   "\n수정하지 않으려면 엔터키를 눌러주십시오");
                System.out.print("번호를 수정하려면 입력값을 넣어주십시오. >>>>>");
                String phone = System.console().readLine();
                System.out.print("그룹을 수정하려면 입력값을 넣어주십시오. >>>>>");
                String a = System.console().readLine().trim();
                if(a.isBlank() == true){
                    a = "-999";
                }
                int group = Integer.parseInt(a);
                    if(phone.isBlank()==true){
                        lists.modify(lists.getPhone(),group);      
                    }else if(group == -999){ 
                        lists.modify(phone,lists.getGroup()); 
                    }else{
                        lists.modify(phone,group);
                    }
                        System.out.println("번호를"+lists.getPhone()+"로 수정하였습니다.");
                        System.out.println("그룹을"+lists.getGroup()+"로 수정하였습니다.");
            }else if(isFind == false){
                System.out.println("일치하는 이름이 없습니다.");
                return;
            }
        }
    }   
}

