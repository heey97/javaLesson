package object.day9;

import java.util.Arrays;
import java.util.Comparator;

public class C21ArraySortTest {
    public static void main(String[] args) {
        int[] numbers = {67,34,77,89,82};

        System.out.println("초기numbers" + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("정렬후numbers" + Arrays.toString(numbers));

        String[] names = {"momo","nayeon","dahyun","Zewyi","Beo"};

        System.out.println("초기names" + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("정렬후names" + Arrays.toString(names));

        //C21번 내림차순 하러갑니다!

        //Arrays.sort(배열변수) : 기본형 배열, String 배열의 오름 차순 정렬 가능합니다 (●'◡'●)(❁´◡`❁)╰(*°▽°*)╯(*/ω＼*)
        // -> 내림 차순 정렬 또는 다른 참조타입에 대한 정렬은 메소드 두번째 인자로 정렬 기준 공식을 인터페이스로 전달합니다.

        //순차정렬 알고리즘 : 가장 단순한 알고리즘
        //선택정렬
        //삽입정렬
        //버블정렬
        // 오름차순 정렬에서는 왼쪽값 < 오른쪽값이 되어야 합니다.

        //내림차순 정렬 - Comparator는 <> 제너릭타입에 기본형을 사용 못합니다.
        // 기본형은 Wrapper 클래스 쓴다.  ex) int(기본형) -> Integer
        Integer[] numbers2 = {67,34,77,89,82};
        Arrays.sort(numbers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }  
        });
        System.out.println("정렬후names" + Arrays.toString(numbers2));

        Arrays.sort(numbers2,(o1,o2)->{return o2-o1;});
        System.out.println("정렬후names" + Arrays.toString(numbers2));
    }
}
