package object.day9;

import java.util.Arrays;

public class SortTestClass implements SortTestIfUp,SortTestIfDown {

    @Override
    public String a() {
        return "출력완료!";
    }

    @Override
    public void sortUp(int[] array) {
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){    
                int temp = array[j];          // 비교한 숫자를 담을 변수 선언 담은 변수와 교환할 array[j]값 비교 해서 교환
                if(temp < array[i]){
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        System.out.println(String.format("%d회전 오름차순 순차 배열 : %s",i+1,Arrays.toString(array)));
        }
        System.out.println("오름차순 정렬 후 numbers :" + Arrays.toString(array));
    }

    @Override
    public void sortDown(int[] array) {
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){    
                int temp = array[j];          // 비교한 숫자를 담을 변수 선언 담은 변수와 교환할 array[j]값 비교 해서 교환
                if(temp > array[i]){
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        System.out.println(String.format("%d회전 내림차순 순차 배열 : %s",i+1,Arrays.toString(array)));
        }
        System.out.println("내림차순 정렬 후 numbers :" + Arrays.toString(array));
    }
        
}

