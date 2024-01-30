--상품검색하기 ProductVo, TblProductDao ㅏㅁㄴ들기 , selectByCategory, selectByName 메소드만들깅


INSERT INTO TBL_PRODUCT tp VALUES('BUSA211','B2','부사 사과3 kg 박스',25000); -- 데이터추가

SELECT DISTINCT CATEGORY FROM TBL_PRODUCT tp; -- 어떤카테고리가 있는지 보여주기

SELECT * FROM TBL_PRODUCT tp -- 특정카테고리에 대해 상품목록 보여주기
WHERE CATEGORY = 'B1';

SELECT * FROM TBL_PRODUCT tp -- 상품유사검색
WHERE PNAME LIKE '%'||'사과'||'%'; --프로그램에서 매개변수 처리를 위해 연결연산으로 합니당.



SELECT * FROM TBL_PRODUCT tp ;


--mypage 기능의 메소드를 위한 SQL

SELECT BUY_IDX ,tb.PCODE,PNAME,QUANTITY ,BUY_DATE 
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp
ON tb.PCODE =tp.PCODE
WHERE tb.CUSTOMID = 'mina012'
ORDER BY BUY_IDX;