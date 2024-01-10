package object.day9;

import java.util.Arrays;

public class C24MemberCompareTest {
    
    //Member 객체를 비교하고 Member 배열 정렬도 할 수 있습니다.

    public static void main(String[] args) {
        Member momo = new Member("momo", 23);
        Member baba = new Member("baba", 20);

        System.out.print("모모와 나나의 나이 기준 비교 : ");
        System.out.println(momo.compareTo(baba)+"\n양수이면 momo가 nana보다 나이가 많습니다.");

        Member dahyun = new Member("dahyun", 21);
        Member sana = new Member("sana", 22);

        Member[] members = new Member[4];

        members[0] = momo;
        members[1] = baba;
        members[2] = dahyun;
        members[3] = sana;

        System.out.println("members 배열 \n" + Arrays.toString(members));
        Arrays.sort(members); // 배열 요소 Member 객체가 compareTo 메소드가 있으므로 정렬 됩니다.
        System.out.println("정렬 후"+ Arrays.toString(members));
    }
}
