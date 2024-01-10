package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class Randomm {
//     숙제할 때 테스트하고 사용해야할 코드
// System.out.println(" 난수(컴퓨터가 만들어주는 임의 값) - random");
// System.out.println(" 난수값을 만들어주는 방법은 Math.random()");
// System.out.println(" 0~1 사이의 double 실수를 무작위로 만들어줍니다.");
// System.out.println("Math.random() = " + Math.random());
// System.out.println("Math.random() = " + Math.random());
// System.out.println("Math.random() = " + Math.random());
// System.out.println("Math.random() = " + Math.random());
// System.out.println("Math.random() = " + Math.random());
// System.out.println("Math.random() = " + Math.random());
// System.out.println("Math.random() = " + Math.random());
//    // 0 < 난수 < 1    => 로또 값처럼 1 <= 로또번호 <= 45
//    //  원래 난수값 범위에 *45를 하고       0 < 난수*45 < 45   
//    //  그 값에 다시 +1 하면 됩니다.        1 < 난수*45+1 < 46
//    //  난수의 범위를 start ~ end 범위로 조정하려면
//    //  (int)(Math.random()*(end-start+1))+start
    public static void main(String[] args) {
        AddQuiz addQuiz = new AddQuiz();
        Scanner sc = new Scanner(System.in);

        int start = 11; int end = 99;
        int answer= 0;
        int[] arrays = new int[3];
        

        System.out.println("덧셈 10문제 퀴즈를 시작합니다.");
        for(int i=1; i<=3;i++){
            int temp1 = (int)(Math.random()*(end-start-1))+start;
            int temp2 = (int)(Math.random()*(end-start-1))+start;
            addQuiz.setData1(temp1);
            addQuiz.setData2(temp2);
            
            System.out.print(String.format("%d번. %5d+%d=  ?\n",i,addQuiz.getData1(),addQuiz.getData2()));
            int[] arrays2   = {i,addQuiz.getData1(),addQuiz.getData2()};
            System.out.print("답 입력하세요. >>> ");
            addQuiz.setUserAnswer(answer=sc.nextInt());
            arrays[i-1] = arrays2[i-1];
            System.out.println(Arrays.toString(arrays));
        }
        System.out.println(String.format(":::::: 채점 하고 있습니다. ::::::"));
        System.out.println(String.format("%10s %18s %20s %23s", "문제", "제출한답", "정답", "채점"));
        for(int i=1; i<=3; i++){
            
            System.out.print(String.format("%d번. %5d+%d %15d\n",i,addQuiz.getData1(),addQuiz.getData2(),addQuiz.getUserAnswer()));
        }  
    }
}
