+package etc.day15;

import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {
    
    public static void main(String[] args) {
        
        System.out.println("1. 현재 날짜와 시간을 구하여 출력하기 ");
        LocalDate currnetDate = LocalDate.now();    
        //객체생성 메소드 now(), new 연산을 대신함.
        System.out.println("\tLocalDate 현재 날짜 : " + currnetDate);

        LocalTime currnTime = LocalTime.now();      //10억분의 1초(ns)까지 구해줍니다.
        System.out.println("\tLocalTime 현재 시간 : " + currnTime);
        
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("\tLocalDateTime 현재 날짜와 시간 : " + currDateTime);
        
        System.out.println("2. 특정 날짜와 시간을 지정해서 객체를 생성합니다. ");
        LocalDate mybirth = LocalDate.of(2000, 7, 12);
        //of 메소드 : 객체를 생성하고 값을 초기화 합니다.
        LocalTime mybirth_time = LocalTime.of(11, 20);
        System.out.println("\tLocalDate.of(2000, 7, 12) : " + mybirth);
        System.out.println("\tLocalTime.of(11, 20) : " + mybirth_time);
        
        //java.time 패키지에 다른 클래스 테스트
        System.out.println("3. 날짜 사이의 간격 계산하기 ");
        System.out.println("\t 내가 태어난지 ..년 ..월 ..일 이 지났습니다.");
        Period between = Period.between(mybirth, currnetDate);
        System.out.println(between.getYears() + " 년");
        System.out.println(between.getMonths() + " 월");
        System.out.println(between.getDays() + " 일");

        System.out.println("4. 날짜 사이의 간격 계산하기(단위 : 년 또는 월 또는 일)");
        System.out.println("\t 내가 태어나서 ..년(개월 또는 일)이 지났습니다.");
        System.out.println(ChronoUnit.DAYS.between(mybirth, currnetDate) + " 일");
        System.out.println(ChronoUnit.MONTHS.between(mybirth, currnetDate) + " 개월");
        System.out.println(ChronoUnit.YEARS.between(mybirth, currnetDate) + " 년");

        System.out.println("5. 내 생일로부터 10,000일이 되는 날짜는 ? ");
        LocalDate day10000 = mybirth.plusDays(10000);
        System.out.println("\t 10,000일 이후 = " + day10000);

        System.out.println("6. 오늘 날짜로부터 10,000일 이전 날짜는 ? ");
        LocalDate before10000 = currnetDate.minusDays(10000);
        System.out.println("\t 10,000일 이전 = " + before10000);
        
        System.out.println("7. 계산 검증 테스트 - 3일 이전과 이후 ");
        System.out.println(currDateTime.minusDays(3));
        System.out.println(currDateTime.plusDays(3));

        System.out.println("8. 날짜의 출력 패턴 설정하기 ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY년 MM월 DD일");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("YYYY년 MM월 DD일 hh시 mm분 ss초");

        //시간 = hh, 분 = mm, 초 = ss , ms(밀리세컨즈) = SSS
        System.out.println(currnetDate.format(formatter));
        System.out.println(currDateTime.format(formatter1));

        
    }
}
