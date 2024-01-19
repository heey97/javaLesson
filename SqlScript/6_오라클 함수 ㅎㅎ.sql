-- 수업 날짜 : 1월 19일
/* 문자열함수
 * INITCAP // 첫글자 대문자
 * UPPER // 대문자로 변경
 * LOWER // 소문자로 변경
 * LENGTH // 문자열 길이
 * SUBSTR(3,5) // 3(이상)부터 5개 추출   (문자열,위치,길이) 오라클의 문자열위치는 1부터 시작 위치 -면 뒤에서부터
 * REPLACE // 문자열바꾸기 ('java program','pro','프로') = java 프로gram
 * INSTR // 자바의 indexof ('java program','og') = 8
 * trim // 앞뒤공백제거
 */

/* 숫자 함수
 * trunc // 소수점 이하 자리수 맞추기위해서 버림 (3.177567,2) = 3.17 
 * round // 반올림 (3.177567,2) = 3.18
 * ceil // 실수를 정수로 올림 변환 (3.177567) = 4
 * floor // 실수를 정수로 내림 변환 (3.177567) = 3
 */ 

/* 날짜 함수
 * to_char (날짜 형식을 문자열로 변환) to_char(SYSDATE,'yyyy-mm-dd');
 * to_date (문자열을 날짜형식으로 변환) 시분초는 자동캐스팅이안되서 to_date로 찍음 'yyyy-mm-dd hh24:mi:ss'
 * SELECT SYSDATE,SYSTIMESTAMP FROM DUAL; -- SYSTIMESTAMP 는 표준시와의 시차(타임존 표시)
 * ADD_MONTH(SYSDATE,3) -- 오늘 날짜 3개월 이후, 첫번째 인자는 날짜형식 . 두번쨰 더해지는값
 * TO_CHAR(ADD_MONTHS(SYSDATE,3),'YYYY/MM/DD') -- 문자열패턴 기호- 또는 / 또는 구분기호 없음가능
 * MONTHS_BETWEEN(SYSDATE,TO_DATE('2022-09-23')) -- 지정된 2개의 날짜 사이에 간격 (월). 결과는 소수점
 * TRUNC(SYSDATE)-TO_DATE('20240110','YYYYMMDD') -- 2개의 날짜형식 값 간격
 */
SELECT
	SUBSTR('java program', 3, 5)
  FROM
	DUAL;

SELECT TRUNC(SYSDATE)-TO_DATE('20240110','YYYYMMDD') FROM DUAL;
SELECT TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'yyyymmdd')-TRUNC(SYSDATE) FROM DUAL;