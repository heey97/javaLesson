package object.day9;

import java.util.Arrays;

public class C22MySortTest {
    public static void main(String[] args) {
        int[] numbers = {67,34,65,89,54};
        
        System.out.println("정렬 초기 numbers = "+Arrays.toString(numbers));
        SortTestClass sort = new SortTestClass();  

        SortTestIfUp soup = new SortTestClass();
        SortTestIfDown sodown = new SortTestClass();

        soup.sortUp(numbers);
        sort.sortUp(numbers);

       

        
        System.out.println("\n정렬 초기 numbers = "+Arrays.toString(numbers));
        System.out.println("인터페이스를 사용하여 호출 후 내림차순 정렬");
        sort.sortDown(numbers);
        sodown.sortDown(numbers);

        System.out.println(sort.a());
    }
 
}