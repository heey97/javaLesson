package object.day5;

import java.util.Arrays;

public class Score {

    private String name;    // 학생이름
    private int grade;      // 학년
    private int[] jumsues;  // 점수들이 저장될 배열
                            // 배열의 크기는 학년마다 다를 수 있음.

    //getter
    public String getName(){
        return this.name;
    }
    public int getGrade(){
        return this.grade;
    }
    public int[] getJumsues(){
        return this.jumsues;
    }

    //setter
    public void setName(String nm){
        this.name = nm;
    }
    public void setGrade(int gr){
        this.grade = gr;
    }
    public void setJumsues(int[] jm){
        jumsues = new int[jm.length];
        for(int i=0; i<jm.length; i++){
            jumsues[i] = jm[i];     
        }
    }
    
    //합계 추출 메소드
    public int sum(){
        int sum =0;
    
        for(int i=0; i<jumsues.length; i++){
           sum += jumsues[i];
        }
        return sum;
    }
    
    //평균 추출 메소드
    public double average(){
        int avg =0;
        for(int i=0; i<jumsues.length; i++){
           avg = sum()/jumsues.length;
        }
        return avg;
    }

    //모든 인스턴스 값을 출력해주는메소드
	public void printData(){
        System.out.println("\n학생 이름: "+name+" || 학년: "+grade+" || 성적: "+Arrays.toString(jumsues)+" || 총점: "+sum()+" || 평균: "+average());
	}


    //점수의 합계를 리턴하는 sum() 메소드

    //점수의 평균을 리턴하는 (double) average() 메소드

    //모든 인스턴스 필드값을 확인 출력하는 printScore() 메소드
}
