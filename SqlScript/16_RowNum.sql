/*
 * 오라클 RowNUm컬럼 : 오라클이 select 결과에 부여하는 행번호
 * 					오라클이 내부적으로 관리를 위한 컬럼
 */

SELECT *
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC;



--2 rownum 컬럼을 출력해봅니다
SELECT ROWNUM, tp.*
FROM TBL_PRODUCT tp 
ORDER BY PRICE ASC;

--3) 서브쿼리로 변경
SELECT ROWNUM,tp.*
FROM(SELECT *
FROM TBL_PRODUCT tp
ORDER BY PRICE DESC)tp;

--4) ROWNUM 에 조거신
SELECT ROWNUM,tp.*
FROM(SELECT *
FROM TBL_PRODUCT tp
ORDER BY PRICE DESC)tp
WHERE ROWNUM =1;
--WHERE ROWNUM =3; -- 실행안됩니다 가능한조건식은 rownum이 1이 포함되는 경우에만 가능

--5) 중간의 일부를 가져오기위해 between and 연산을 사용 
--   단 서브쿼리를 또 써야합니다4번을대상으로 서브쿼리를 또써야함

--예상 : 게시판의 글목록에 대해 페이지 번호 적용합니다.
SELECT *
FROM 
(SELECT ROWNUM r,tp.*
FROM(SELECT *
FROM TBL_PRODUCT tp
ORDER BY PRICE DESC)tp)
WHERE r BETWEEN 2 AND 4;

--6) 오라클 12C 버전부터는 FECTCH 명령이 있습니다.
SELECT *
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC
FETCH FIRST 3 ROWS ONLY;