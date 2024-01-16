package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09StringSplit {
    //전역변수 모둔 메소두 안에서 사용할수있움 static은static끼리
    private static String filePath = "D:\\Class231228\\java\\PartC\\score.txt";
    public static void main(String[] args) {
        for(Score sc : makeList()){
            System.out.println(sc);
        }
    }

    public static Score makeScore(String line){
        String[] temp = line.split(",");
        Score stu = new Score(temp[0],
                            Integer.parseInt(temp[1].trim()),
                            Integer.parseInt(temp[2].trim()),
                            Integer.parseInt(temp[3].trim()));
        return stu;
    }
    //1)score.txt에서 모든 데이터를 읽어오고2) Score객체로 변환하여3) 리스트에 담고 4)리턴하기
    public static List<Score> makeList(){

        List<Score> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = bf.readLine())!= null){
                list.add(makeScore(line));
            }
        } catch (IOException e) {
            System.out.println("파일 입력 오류:" + e.getMessage());
        }
        return list;
    }

    // BufferReader 클래스는 파일에서 1줄씩 읽어올 수 있습니다.
    // 1줄 읽고 -> Score 객체 만들기 -> 4개 객체 (변수명 momo,nana,sana,dahy)
    public static void split_test2(){
        String filePath = "D:\\Class231228\\java\\PartC\\score.txt";
        int count = 0;
        int b;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; 
            while((line = br.readLine()) != null){
                // String [] temp = line.split(",");
                // Score stu = new Score(temp[0],
                //             Integer.parseInt(temp[1]),
                //             Integer.parseInt(temp[2]),
                //             Integer.parseInt(temp[3]));
                Score score = makeScore(line);
                System.out.println(String.format("count=%d, score object =%s",count,score));
                count++;
            }
        } catch (IOException e) {
            System.out.println("파일 입력 오류:" + e.getMessage());
        }
        System.out.println("Score객체 : " + count + "개 생성완료!!");

    }


    public static void split_test1(){
        String stu = "김모모,67,77,88";

    // split 메소드는 지정된 구분자(구분기호)를 이용해서 문자열을 분리하고
    // 배열에 저장해서 리턴합니다.
    String[] temp = stu.split(",");
    System.out.println("스플릿 실행한 결과 문자열");
    System.out.println(Arrays.toString(temp)); 
    
    for(String t : temp){
        System.out.println("배열요소 = " + t);
    }
    
    System.out.println("2. 분리된 결과로 Score 객체로 만들면 ? ");
    //temp[0]이름 [1]~[3]

    Score score = new Score(temp[0],
                            Integer.parseInt(temp[1]),
                            Integer.parseInt(temp[2]),
                            Integer.parseInt(temp[3]));
    System.out.println("Score 출력1 : " + score.datas());
    System.out.println("Score 출력1 : " + score);                            
    }
    
}
