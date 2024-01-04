package object.day5;

public class ScoreMain {
    public static void main(String[] args) {
        // 학생 4명의 성적을 저장해보세요
        // 1학년 2명(모모,다현) 3과목 2학년 2명(나연,쯔위) 4과목
        // 점수는 맘대로

        Score sc = new Score(); // 참조 할 클래스 선언
        // 이름 데이터
        String momo = "모모";
        String dahyun = "다현";
        String nayeon = "나연";
        String zzyui = "쯔위";
        
        // 학년 데이터
        int grade1 = 1;
        int grade2 = 2;
       
        // 성적 데이터
        int[] momoSc = {30, 55, 25};
        int[] dahyunSc = {100, 100, 100};
        int[] nayeonSc = {70, 80, 90, 100}; 
        int[] zzyuiSc = {10,80,60,40};
        
       
        //모모의 정보
        sc.setName(momo);        //모모
        sc.setGrade(grade1);     //1
        sc.setJumsues(momoSc);   //30, 55, 25
        sc.printData();          //출력
        
        //다현의 정보             
        sc.setName(dahyun);      //다현
        sc.setJumsues(dahyunSc); //100, 100, 100
        sc.printData();          //출력
        
        //나연의 정보
        sc.setName(nayeon);      //나연
        sc.setGrade(grade2);     //2
        sc.setJumsues(nayeonSc); //70, 80, 90, 100
        sc.printData();          //출력
        
        //쯔위의 정보
        sc.setName(zzyui);       //쯔위
        sc.setJumsues(zzyuiSc);  //10,80,60,40
        sc.printData();          //출력 
    }
}
