/*
 * 
 * 프로시저 직접 만드러보기
 * money_of_day
 * 매개변수 in 고객id 날짜
 * 매개변수 OUT : in으로 받은 값들을 tb1_buy 에서 상품코드를 조회하여 '총 구매 금액'을 구합니다.
 * 
 * 프로시저 싱행
 * 
 * DECLARE
 * 		vmoney number(8);
 * 	    vid varchar2(20);
 * 		vdate varchar2(20);
 * BEGIN
 * 		vid :='mina012';
 * 		vdate := '2023-11-10';
 * 		money_of_day('vid',vdate,vmoney);
 * 		dbms_output.put_line(CHR(10)|| '고객ID : ' || vid || '날짜 : ' || vdate);
 * 		dbms_output.put_line('고객님의 구매금액은 ' || vmoney || '입니다');
 * END;
 * 
 * */
SELECT * FROM TBL_BUY;
SELECT * FROM TBL_PRODUCT;
SELECT SUM(PRICE)
	FROM TBL_PRODUCT;


CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
	I_CUSTOMID IN VARCHAR2,
	I_DATE IN VARCHAR2,
	O_MONEY OUT NUMBER
)
IS 
V_MONEY NUMBER(10);
V_CNT NUMBER(10);
V_PCODE VARCHAR2(100);

BEGIN
	SELECT PCODE,QUANTITY 				-- 1일 1구매 조건으로 오직 1개의 행이 ㅈ호ㅚ됩니다.
	INTO V_PCODE,V_CNT 					-- 조회 결과가 n개의 행이면 프로시저의 커서 기능을 이용합니다.(나중에 진도 나갑니다.)
	-- INTO 는 프로시저에서만 사용합니다. 조회 결과를 변수에 저장합니다.
	FROM TBL_BUY
	WHERE TO_CHAR(BUY_DATE,'yyyy-mm-dd') = I_DATE
	  AND CUSTOMID = I_CUSTOMID;
	
	SELECT PRICE
	INTO V_MONEY
	FROM TBL_PRODUCT
	WHERE PCODE=V_PCODE;
	
	SELECT V_MONEY * V_CNT
	INTO O_MONEY
	FROM DUAL;

		commit ;
	EXCEPTION 			-- EXCEPTION 추가하여 처리 -> 메시지 출력, rollback 
		WHEN NO_DATA_FOUND THEN 
		dbms_output.put_line('실행 실패');
		p_money :=0;
		rollback ;		-- 오류가 발생한 sql 앞의 insert,update,delete를 취소.
END;


DECLARE
	vmoney NUMBER(20);														-----프로시저 실행결과 OUT 매개변수저장.(꼭필요한변수)
    vid varchar2(20);														-----프로시저 실행에 필요한 IN매개변수값 저장변수
	vdate varchar2(20);														-----없어도 되지만 출력 등 편의상 선언합니다.
BEGIN
	vid :='mina012';
	vdate := '2023-11-10';
	money_of_day(vid,vdate,vmoney);
	dbms_output.put_line(CHR(10)|| '고객ID : ' || vid || '날짜 : ' || vdate);
	dbms_output.put_line('고객님의 구매금액은 ' || vmoney || '입니다');
END;

SELECT PCODE,QUANTITY 
	FROM TBL_BUY
	WHERE TO_CHAR(BUY_DATE,'yyyy-mm-dd') = '2023-11-10' 
	  AND CUSTOMID = 'mina012';