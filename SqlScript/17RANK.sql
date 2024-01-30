/*
 * 오라클의 RANK 함수
 * 예제 : 고객 - 상품별 최대 구매 금액을 구하고 해당 상품코드 조회하기
 * ㄴ 고객ID로 1차 그룹화, 고갠 내에서 상품코드로 2차 그룹화 
 */


INSERT INTO TBL_BUY tb  VALUES (BUY_PK_SEQ.NEXTVAL,'mina012','JINRMn5',13,'2024-01-26');

--1) group by
SELECT  tb.CUSTOMID , tb.PCODE ,SUM(tp.PRICE*tb.QUANTITY) "MONEY"
FROM TBL_BUY tb ,TBL_PRODUCT tp 
WHERE tb.PCODE = tp.PCODE
GROUP BY tb.CUSTOMID ,tb.PCODE
ORDER BY tb.CUSTOMID,"MONEY" DESC;

--2) 1)번 결과에 RANK 함수를 적용해 봅니다.

SELECT tb.CUSTOMID,
	   tb.PCODE,
	   SUM(tp.PRICE*tb.QUANTITY) "MONEY",
	   RANK() 
	   OVER (PARTITION BY tb.CUSTOMID 
	   	     ORDER BY SUM(tp.PRICE * tb.QUANTITY)DESC) "RANK"
FROM TBL_BUY tb, TBL_PRODUCT tp 
WHERE tb.PCODE = tp.PCODE
GROUP BY tb.CUSTOMID, tb.PCODE;

--4 3번을 서브쿼리로 하여 rank =1인 조건을 적용해보자

WITH customSale
AS
(
	SELECT tb.CUSTOMID,
	   tb.PCODE,
	   SUM(tp.PRICE*tb.QUANTITY) "MONEY",
	   RANK() 
	   OVER (PARTITION BY tb.CUSTOMID 
	   	     ORDER BY SUM(tp.PRICE * tb.QUANTITY)DESC) RANK
FROM TBL_BUY tb, TBL_PRODUCT tp 
WHERE tb.PCODE = tp.PCODE
GROUP BY tb.CUSTOMID, tb.PCODE
)
SELECT *
FROM customSale
WHERE RANK =1;