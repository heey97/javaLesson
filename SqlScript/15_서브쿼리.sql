/*
	서브 쿼리 (sub query) : select 조회 결과(여러개의 행)가 다른 DML 명령어에 쓰일 수 있습니다.
						  							   ㄴ select, insert, update, delete
						  select, insert, update, delete 에 포함되는 select를 서브쿼리 라고 합니다.
 	select 함께 쓰이는 서브쿼리
 					  : select 컬럼1, 컬럼2 from (select.....)
 					  					 where 컬럼명1 = 값(select.....)
 	select 서브쿼리는 join으로도 가능합니다. 
**/
-- 1) where 에서 쓰는 서브쿼리 : twice 가 구매한 상품 정보
-- JOIN
SELECT tp.*
FROM TBL_PRODUCT tp , TBL_BUY tb 
WHERE tp.PCODE  = tb.PCODE 			-- 1) 크로스 연산
AND tb.CUSTOMID = 'twice' ;			-- 2) 조건식 연산

-- 서브쿼리
SELECT tp.*
FROM TBL_PRODUCT tp 
WHERE PCODE IN 			-- 2) 조건식 연산
-- ('CJBAb12g','APLE5kg','DOWON123a');
(SELECT PCODE FROM TBL_BUY tb WHERE CUSTOMID = 'twice');	-- 1) 조건식 연산

-- 2) from 에서 사용되는 서브 쿼리 : 컬럼명 또는 테이블명 별칭을 줄때 한글을 쓰려면 "" 안에 사용합니다.
SELECT 
saleMoney.PCODE, sum(QUANTITY), sum("구매 금액") 
FROM
(SELECT tp.PCODE , PNAME , tb.QUANTITY , tp.PRICE , tb.QUANTITY * tp.PRICE "구매 금액"
FROM TBL_PRODUCT tp , TBL_BUY tb 
WHERE tp.PCODE  = tb.PCODE) saleMoney
GROUP BY saleMoney.PCODE;


		
SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS TotalQuantity,
    SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
   
-- 오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다.
WITH saleMoney
AS
(SELECT tp.PCODE , PNAME , tb.QUANTITY , tp.PRICE , tb.QUANTITY * tp.PRICE "구매 금액"
FROM TBL_PRODUCT tp , TBL_BUY tb 
WHERE tp.PCODE  = tb.PCODE)
SELECT SALEMONEY.PCODE, sum(SALEMONEY.QUANTITY), sum("구매 금액")
FROM SALEMONEY
GROUP BY SALEMONEY.pcode;

-- 서브쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요.

-- 20살이상 고객님들의 구매한 상품
SELECT tp.*
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE  = tb.PCODE 
JOIN TBL_CUSTOM tc
ON tb.CUSTOMID = tc.CUSTOM_ID
WHERE tc.AGE > 20;

-- 고객별로 구매금액이 가장 높은 상품코드를 조회하세요.
--   ㄴ 오라클 RANK 함수

   
   
   
   
   
   
   
   
   
   
   
   
		
		
		
		
		
