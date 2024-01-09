package object.day6;

import java.util.Scanner;

public class QuizMain {

    public static void main(String[] args) {
        AddQuiz addQuiz = new AddQuiz();
        Scanner sc = new Scanner(System.in);

        int start = 11; int end = 99;
        String[] arr = new String[10];

        System.out.println("덧셈 10문제 퀴즈를 시작합니다.");
        for(int i=1; i<=10; i++){
            int temp1 = (int)(Math.random()*(end-start-1))+start;
            int temp2 = (int)(Math.random()*(end-start-1))+start;
            
            addQuiz.setData1(temp1);
            addQuiz.setData2(temp2);
            int x = addQuiz.getData1();
            int y = addQuiz.getData2();
            
            System.out.println(String.format("%d번. %5d+%d=  ?",i,x,y)); 
            System.out.print("답 입력하세요. >>> ");
            addQuiz.setUserAnswer(sc.nextInt());
            
            arr[i-1] = String.format("%d번. %5d+%d %10d %15d %10s",
                                    i,x,y,addQuiz.getUserAnswer(),x+y,addQuiz.isRight()?"O":"X");
            if(i >=10){
                arr[i-1] = String.format("%d번. %4d+%d %10d %15d %10s",
                                        i,x,y,addQuiz.getUserAnswer(),x+y,addQuiz.isRight()?"O":"X");
            }
            addQuiz.setArr(arr);
        }

        System.out.println(String.format(":::::: 채점 하고 있습니다. ::::::"));
        System.out.println(String.format("%10s %14s %7s %10s", "문제","제출한답","답","채점"));
        addQuiz.printAnswer();
    }
}
