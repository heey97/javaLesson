package io.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.myapp.JavaWord;

public class D08FileReader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis(); //1000분의 1초
        
        readByScanner2();
        long end = System.currentTimeMillis();
        System.out.println(String.format("실행 소요 시간 : %,d",(end-start)));

    }

    
    public static void readByChar(){
        String filePath = "단어장.txt";
        StringBuilder content = new StringBuilder();
        int charValue;
        int count=0;

       try( FileReader fr = new FileReader(filePath)){

         while ((charValue = fr.read()) != -1) { //read는 문자단위 입력      
             System.out.print((char)charValue); //문자단위이기때문에 표준출력이 가능하다.
             // int값을 char로 변환하여 StringBuilder에 추가
             //content.append((char)charValue);
             count++;
        }   
    } catch (Exception e) { }
        // FileReader 닫기
        // 파일에서 읽은 내용 출력
        System.out.println("\n~~~~~~~~~~~~~~~~~~~");
        System.out.println(content.toString());
        System.out.println("읽은 문자수 : "+count);
    }

    public static void readByCharArray(){
        String filePath = "C:\\Windows\\PFRO.log";
        // String filePath = "단어장.txt";
        //StringBuilder content = new StringBuilder();
        char[] charValues = new char[256];
        int count=0; int charcount=0;
        int b;

       try( FileReader fr = new FileReader(filePath)){ // try하고 괄호안에있으면 자동으로 close ㅎㅎ
        
         while ((b = fr.read(charValues,0,256)) != -1) { //문자단위 (배열이름,시작인덱스,최대문자길이)
            //읽은 문자의 갯수는 b에 저장
            System.out.print(new String(charValues,0,b)); 
                                                    //String 생성자 : 배열이름, 시작위치, 길이를 인자로 문자열 만듬
        // int 값을 char로 변환하여 StringBuilder에 추가
        //content.append(charValues,0,b);
            charcount+=b;                           //문자의 갯수를 세는 수식
            count++;                                //while문의 반복횟수
        }   
    } catch (Exception e) { }
        // FileReader 닫기

        // 파일에서 읽은 내용 출력
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        //System.out.println(content.toString());
        System.out.println("반복 횟수 : "+count);
        System.out.println("읽은 문자수 : "+charcount);
    }

    public static void ReadByCharBuffer(){
        String filePath = "C:\\Windows\\PFRO.log";
        int count=0;  // 읽은 라인수. 문자기반 버퍼스트림은 라인(줄) 단위로 입출력 기능이 있습니다.
        int b;
        try(
            BufferedReader br = new BufferedReader(new FileReader(filePath))
            ){
                String line;        //라인 단위로 읽어서 저장할 변수
                while((line = br.readLine()) != null){      //readline은 String 리턴
                    System.out.println(line);
                    count++;
                }
         }catch(IOException e){
            System.out.println("파일 입력 예외 : " +e.getMessage());
        }
    }

    //Scanner 클래스 : 1)한줄씩 읽어오는 nextLine() 메소드가있다 
                    //2)구분기호로 분리해서 읽어오는 방법          특징ㅎㅎ
    public static void readByScanner(){
        String filePath = "단어장.txt";
        int count=0;

        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n"); //구분기호를 , 또는 엔터

            // 파일의 끝까지 반복       // 더이상 데이터가 없으면 false
            while (fc.hasNext()) {              //구분기호로 분리된 데이터가 있으면 hasnext 참아니면 거짓으로나옴
                String token = fc.next();               // next로 가져오기
                System.out.println(token.trim());
                count++;
            }

    } catch (Exception e) { }

        System.out.println("읽은 단어수 : "+count);
    }

    public static void readByScanner2(){
        String filePath = "단어장.txt";
        int count=0;
        List<JavaWord> list = new ArrayList<>();
        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n"); //구분기호를 , 또는 엔터

            // 파일의 끝까지 반복       // 더이상 데이터가 없으면 false
            while (fc.hasNext()) {              //구분기호로 분리된 데이터가 있으면 hasnext 참아니면 거짓으로나옴
                list.add(new JavaWord(fc.next(),        //첫번째가져오기
                                      fc.next(),        //두번쨰가져오기
                                      Integer.parseInt(fc.next().trim()))); //세번째가져오기
                count++;
                
            }

    } catch (Exception e) { }
        System.out.println(list);
        System.out.println("읽은 객체수 : "+count);
        for(JavaWord word : list) System.out.println("생성된객체: "+word);
    }
    
}
