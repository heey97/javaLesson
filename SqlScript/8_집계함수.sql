/*
 * SQL 집계함수 
 * 
 * 그룹함수 COUNT , SUM , AVG , MAX , MIN 등은 group by 와 많이 사용됩니다 (다른 컬럼과 같이 조회하고싶어성)
 * 
 * 
 * RANK 순위매기는 함수
 * 
 */
-- 1) '성적' 테이블의 전체 행 개수
SELECT
	COUNT(*)
FROM
	TBL_SCORE;

-- 2) '성적' 테이블의 과목 컬럼 '국어' 값을 갖는 전체 행 개수
SELECT
	COUNT(*)
FROM
	TBL_SCORE ts
WHERE SUBJECT = '국어';

-- 3) '성적' 테이블의 'Jumsu' 컬럼의 합꼐
SELECT
	SUM(JUMSU)
FROM
	TBL_SCORE ts ;
-- 4) '성적' 테이블의 '국어' 과목 '점수' 컬럼의 합계
SELECT
	SUM(JUMSU)
FROM
	TBL_SCORE ts 
WHERE SUBJECT = '국어';

--5) '성적'테이블의 'Jumsu' 컬럼의 평균
SELECT
	AVG(JUMSU)
FROM
	TBL_SCORE ts ;

--6) '성적' 테이블의 '국어'과목 'Jumsu' 컬럼의 평균
SELECT
	AVG(JUMSU)
FROM
	TBL_SCORE ts
WHERE SUBJECT = '국어';
--7) '성적' 테이블의 'Jumsu' 컬럼의 최댓값
SELECT
	MAX(JUMSU)
FROM
	TBL_SCORE ts;
	--8) '성적' 테이블의 '영어' 과목 'Jumsu' 컬럼의 최대값
SELECT
	MAX(JUMSU)
FROM
	TBL_SCORE ts
WHERE
	SUBJECT = '영어';
-------그룹 바이
SELECT
	SUBJECT,
	COUNT(*)
FROM
	TBL_SCORE ts
GROUP BY
	SUBJECT;
	
SELECT * FROM TBL_SCORE ts
ORDER BY STUNO;

--예시1 학번별로 수강한 갯수와 평균을 조회 해보세요

SELECT STUNO,COUNT(*)||'개'"갯수",ROUND(AVG(JUMSU),2)
FROM TBL_SCORE 
GROUP BY STUNO
ORDER BY STUNO;
SELECT STUNO
FROM TBL_SCORE ts; 
--예시2 위의 결과에 대해 평균이 80점 미만인 학번(학생)을 조회 해보세욤
SELECT STUNO,COUNT(*)||'개'"갯수",ROUND(AVG(JUMSU),2)
FROM TBL_SCORE 
GROUP BY STUNO
HAVING AVG(JUMSU) < 80
ORDER BY STUNO;

--예시3 점수가 80점 이상 데이터만 예시 1번을 실행하도록 한다면 where jumsu >= 80group by stuno
SELECT STUNO,COUNT(*)||'개'"갯수",ROUND(AVG(JUMSU),2)
FROM TBL_SCORE
WHERE jumsu >= 80
group BY stuno;

SELECT * FROM TBL_SCORE;