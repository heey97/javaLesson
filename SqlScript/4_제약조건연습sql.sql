/*  제약조건 constraint - 테이블에 저장되는 데이터가 '요구사항에 대한 부적절한 값'을 갖지 않도록 규정.
 *	1) 반드시 값이 있어야한다. 	NULL 허용안함 
 *  2) 같은 값을 가질 수 없다. 	UNIQUE (유일한)
 *  3) 1~4 범위도로만 한다.		CHECK
 * 
 * ----------------------------------------
 *  기본키
 *  ....
 */

-- 제안조건 컬럼레벨 설정하기

CREATE TABLE TBL_CONSTR(
	aname varchar2(20) NOT NULL,
	bname varchar2(20) UNIQUE, -- NULL 허옹
	cno NUMBER (4) NOT NULL UNIQUE,
	dno NUMBER (4) CHECK (dno BETWEEN 1 AND 4)
	eno NUMBER (4)
);

INSERT INTO TBL_CONSTR(aname,cno)
	   VALUES('apple',3);
	   VALUES('apple','banana',3); -- 컬럼 값 중복
	  
	   
SELECT * FROM TBL_CONSTR;
