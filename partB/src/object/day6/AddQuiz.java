package object.day6;

import java.util.Arrays;

public class AddQuiz {
    private int data1;
    private int data2;
    private int userAnswer;
    private String[] arr;

    //getter
    public String getArr() {
        return this.arr[10];
    }
    public int getData1() {
        return this.data1;
    }
    public int getData2() {
        return this.data2;
    }
    public int getUserAnswer() {
        return this.userAnswer;
    }

    //setter
    public void setData1(int data1) {
        this.data1 = data1;
    }
    public void setData2(int data2) {
        this.data2 = data2;
    }
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
    public void setArr(String arr[]) {
        this.arr = arr;
    }


    public boolean isRight(){
        return this.data1+this.data2 == this.userAnswer?true:false;
    }
    public void printAnswer(){
        for(int i=0; i<10; i++){
            System.out.println(this.arr[i]);
        }
    }
}
