
--테이블 조인 : 테이블의 칼럼을 합하는 연산
--(참고로 UNION 연산은 테입르의 행을 합하는 연산도 있다.)



--step 1 : from 뒤에 2개의 테이블을 나열해 보겠습니다.


SELECT * FROM TBL_CUSTOM;
SELECT * FROM TBL_PRODUCT;
SELECT * FROM TBL_BUY;

SELECT * FROM TBL_CUSTOM tc , TB_BUY tb 
WHERE tc.CUSTOM_ID = tb.id(+) ;
AND TO_CHAR(tb.BUYDATE ,'yyyy') = '2024';

SELECT CUSTOM_ID, EMAIL FROM TBL_CUSTOM tc , TBL_BUY tb  
WHERE tc.CUSTOM_ID = tb.CUSTOMID
AND TO_CHAR(BUY_DATE,'yyyy')='2024';


SELECT tp.PNAME, tb.QUANTITY, tp.PRICE, tb.QUANTITY * PRICE "구매 금액"
FROM TBL_PRODUCT tp , TBL_BUY tb  
WHERE tp.PCODE  = tb.PCODE  
AND tb.CUSTOMID = 'twice';

SELECT *
FROM TBL_PRODUCT tp , TBL_BUY tb 
WHERE tp.PCODE  = tb.PCODE ;


--이너 조인 형식 1) select * 
			    --from 테이블1 t1, 테이블2 t2 
			   --where t1.공통칼럼 = t2.공통칼럼

		--   2) select * from 테이블1 t1
					--   join 테이블2 t2
						 --on t1.공통칼럼=t2.공통칼럼


--아우터 조인
/*
 * select *
 * left [outer] join 테이블2 t2
 * on t1.공통칼럼 = t2.공통칼럼; 
 * 
 * */

-- 평소에 사용하는 아우터 조인
SELECT *
FROM TBL_CUSTOM tc 
LEFT JOIN TBL_BUY tb 
ON tc.CUSTOM_ID = tb.CUSTOMID
WHERE CUSTOMID IS NULL
ORDER BY CUSTOM_ID;

-- 오라클 아우터 조인
SELECT *
FROM TBL_CUSTOM tc , TBL_BUY tb 
WHERE tc.CUSTOM_ID = tb.CUSTOMID(+)
AND CUSTOMID IS NULL
ORDER BY CUSTOM_ID;

SELECT * FROM TBL_BUY tb ;


SELECT CUSTOM_ID,NAME,EMAIL, AGE
FROM TBL_CUSTOM tc
LEFT JOIN TBL_BUY tb 
ON tc.CUSTOM_ID = tb.CUSTOMID;

SELECT CUSTOM_ID,NAME,EMAIL, AGE
FROM TBL_CUSTOM tc
LEFT JOIN TBL_BUY tb
ON tc.CUSTOM_ID = tb.CUSTOMID
AND tb.CUSTOMID = '0';

SELECT CUSTOM_ID,NAME,EMAIL,AGE
FROM TBL_CUSTOM tc ;

SELECT CUSTOM_ID,NAME,EMAIL, AGE
FROM TBL_CUSTOM tc , TBL_BUY tb 
WHERE tc.CUSTOM_ID = tb.CUSTOMID(+)
AND CUSTOMID IS NULL
ORDER BY CUSTOM_ID;

SELECT * FROM TBL_STUDENT ts ;
SELECT * FROM TBL_SCORE ts ;

SELECT * FROM TBL_BUY tb ;

SELECT * 
FROM TBL_BUY tb WHERE;
SELECT * FROM TBL_CUSTOM;
SELECT * FROM TBL_PRODUCT;
SELECT 
SELECT *
FROM TBL_CUSTOM A, TBL_BUY B
WHERE A.CUSTOM_ID = B.CUSTOMID
AND (SELECT COUNT(CUSTOMID) FROM TBL_BUY) >=2
AND A.AGE >20
ORDER BY CUSTOMID ASC;

SELECT A.NAME,MAX(B.PRICE*C.QUANTITY)
FROM TBL_CUSTOM A, TBL_PRODUCT B, TBL_BUY C
WHERE A.CUSTOM_ID =C.CUSTOMID
AND C.PCODE = B.PCODE
GROUP BY A.NAME;
 
