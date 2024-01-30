/*
 *스키마 : 데이터베이스 스키마는 데이터베이스에서 자료의 구조, 자료의 표현 방법,
 *	     지려간의 관게를 '형식 언어로 정의한 구조이다.
 *풀이 : 사용자가 계정을 받아서 여러가지 방법으로 데이터를 저장하고 관리하는 공간
 *오라클등 dbms는 스키마에 여러 객체를 생성하여 사용합니다. 
 *
 *VIEW (뷰) : 가상 테이블
 *ㄴ SELECT 조회 결과를 미리 컴파일하여 오라클 객체로 저장.
 *ㄴ SELECT 조회 할 때 테이블 처럼 사용하지만 insert,update,delete 의 제약이 많기때문에 거의 사용안함 
 * CREATE VIEW 는 권한이 별도로 필요합니다.
 */

CREATE VIEW  v_customsale
AS
	SELECT tb.CUSTOMID,
	   tb.PCODE,
	   SUM(tp.PRICE*tb.QUANTITY) "MONEY",
	   RANK() 
	   OVER (PARTITION BY tb.CUSTOMID 
	   	     ORDER BY SUM(tp.PRICE * tb.QUANTITY)DESC) RANK
FROM TBL_BUY tb, TBL_PRODUCT tp 
WHERE tb.PCODE = tp.PCODE
GROUP BY tb.CUSTOMID, tb.PCODE;

COMMIT;

SELECT * FROM V_CUSTOMSALE vc 
WHERE CUSTOMID = 'mina012';
