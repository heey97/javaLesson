/* ### 데이터베이스 구축 시나리오
(1월 19일)

식료품을 판매하는 매장의 판매 관리를 위한 시스템을 구축합니다. 이 쇼핑몰에서 `고객` 은  필요한 `상품`을
`구매`할 수 있습니다. 고객은 회원가입 후 상품을 구매할 수 있습니다. 

+ `회원` 은  고유ID , 이름, 이메일, 나이 , 가압날짜로 관리하며
   PK

+ `상품` 은  상품코드, 카테고리, 상품명, 가격이 필요합니다.
   PK
 
+ `구매` 는  상품을 구매한 회원의 고유ID, 상품코드 , 구매수량, 구매날짜를 저장하여 관리합니다. 
   PK 
   FK
 */



------------------------회원 테이블 생성--------------------------
CREATE TABLE TB_CUSTOMER(
	ID VARCHAR2(100) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(100) NOT NULL UNIQUE,
	AGE NUMBER (3) NOT NULL,
	REGDATE DATE NOT NULL);
------------------------상품 테이블 생성--------------------------
CREATE TABLE TB_PRODUCT(
	CODE VARCHAR2(100) PRIMARY KEY,
	CTG VARCHAR2(100) NOT NULL,
	PDTNAME VARCHAR2(100) NOT NULL UNIQUE,
	PRICE NUMBER (25) NOT NULL);
------------------------구매 테이블 생성--------------------------
CREATE TABLE TB_BUY(
	ID VARCHAR2(100) NOT NULL,
	CODE VARCHAR2(100) NOT NULL,
	QUANTITY NUMBER(10) NOT NULL,
	BUYDATE DATE NOT NULL,
	FOREIGN KEY(ID) REFERENCES TB_CUSTOMER(ID),
	FOREIGN KEY(CODE) REFERENCES TB_PRODUCT(CODE));
------------------------회원 데이터--------------------------
INSERT INTO TB_CUSTOMER
	   VALUES('mina012',
	   		  '김미나',
       		  'kimm@gmail.com',
        	  20,
        	  to_date('2022-03-10 14:23:25', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TB_CUSTOMER
	   VALUES('hongGD',
              '홍길동',
       	      'gil@korea.com',
	   		  32,
	   		  to_date('2021-10-21 11:12:23', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TB_CUSTOMER
	   VALUES('twice',
	   		  '박모모',
	   		  'momo@daum.net',
	   		  29,
	   		  to_date('2021-12-25 19:23:45', 'yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TB_CUSTOMER
	   VALUES('wonder',
	   		  '이나나',
	   		  'lee@naver.com',
	  		  40,
	  		  SYSDATE);
	  		 DELETE FROM TB_CUSTOMER WHERE name = '이나나';
------------------------상품 데이터--------------------------
INSERT INTO TB_PRODUCT
	   VALUES('DOWON123a',
	  	      'B2',
	  	      '동원참치선물세트',
	  	      54000);
	  	     
INSERT INTO TB_PRODUCT
	   VALUES('CJBAb12g',
	  		  'B1',
	 		  '햇반 12개입',
			  14500);
	  	     
INSERT INTO TB_PRODUCT
	   VALUES('JINRMn5',
	  		  'B1',
	 		  '진라면 5개입',
			  6350);

INSERT INTO TB_PRODUCT
	   VALUES('APLE5kg',
	  		  'A1',
	 		  '청송사과 5kg',
			  66000);
	  	     
INSERT INTO TB_PRODUCT
	   VALUES('MANGOTK4r',
	   		  'A2',
	   		  '애플망고 1kg',
	   		  32000);
	   		 
------------------------구매 데이터--------------------------
INSERT INTO TB_BUY
	   VALUES('mina012', 
	   		  'CJBAb12g',
	   		  5,
	   		  TO_DATE('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
	   
INSERT INTO TB_BUY
	   VALUES('mina012',
	   		  'APLE5kg',
	   		  2,
	   		  to_date('2022-03-10 14:33:15', 'yyyy-mm-dd hh24:mi:ss'));
	   
INSERT INTO TB_BUY
	   VALUES('mina012',
		      'JINRMn5',
	   		  2,
	   		  to_date('2022-04-16 10:13:15', 'yyyy-mm-dd hh24:mi:ss'));
	   
INSERT INTO TB_BUY
	   VALUES('twice',
	   		  'JINRMn5',
	   		  3,
	   		  to_date('2021-12-25 19:32:15', 'yyyy-mm-dd hh24:mi:ss'));
	   
INSERT INTO TB_BUY
	   VALUES('twice',
	   		  'MANGOTK4r',
	   		  2,
	   		  to_date('2021-12-25 19:32:15', 'yyyy-mm-dd hh24:mi:ss'));
	   
INSERT INTO TB_BUY
	   VALUES('hongGD',
	   		  'DOWON123a',
	   		  1,
		   	  to_date('2021-10-21 11:13:25', 'yyyy-mm-dd hh24:mi:ss'));
	   
INSERT INTO TB_BUY
	   VALUES('hongGD',
	   		  'APLE5kg',
	   		  1,
     	   	  to_date('2022-04-21 11:13:25', 'yyyy-mm-dd hh24:mi:ss'));

-------------------데이터 조회-----------------------

SELECT *
FROM TB_PRODUCT;

SELECT *
FROM TB_BUY;

--구매 날짜가 2021년12월 20일 부터 2022년 03월 16일인 구매내역의 아이디별 상품 구매수량을 조회하시오.
SELECT ID "회원ID", SUM(QUANTITY) "구매 수량",CODE "상품코드"
  FROM TB_BUY
 WHERE BUYDATE BETWEEN TO_DATE('2021-12-20','yyyy-mm-dd') 
    			   AND TO_DATE('2022-03-16','yyyy-mm-dd')
  GROUP BY CODE,ID
  ORDER BY ID ASC;
 
 --2022년 4월 동안 판매된 물품과 사간 이의 이름은?

SELECT A.NAME "이름",
	   B.PDTNAME "상품명",
	   C.QUANTITY "수량",
	   C.BUYDATE "구매일시"
FROM TB_CUSTOMER A,
	 TB_PRODUCT B,
	 TB_BUY C
WHERE A.ID = C.ID
  AND B.CODE = C.CODE
  AND C.BUYDATE BETWEEN TO_DATE('2022-04-01','yyyy-mm-dd') 
				    AND TO_DATE('2022-04-30','yyyy-mm-dd')
ORDER BY A.NAME;
 
 --구매날짜 2021년 1월1일~2022년 3월1일 사이에 가장 많이 산 사람의 이름은?
SELECT A.NAME "이름"
FROM TB_CUSTOMER A, TB_BUY B
WHERE A.ID=B.ID
AND B.BUYDATE BETWEEN TO_DATE('2021-01-01','yyyy-mm-dd') 
	    		  AND TO_DATE('2022-03-01','yyyy-mm-dd')
AND B.QUANTITY = MAX(QUANTITY);

 
 SELECT A.NAME,B.PDTNAME 
 FROM TB_CUSTOMER A, TB_PRODUCT B, TB_BUY C
 WHERE A.ID = C.ID
 AND B.CODE = C.CODE
 AND C.BUYDATE = TO_DATE('2022-04','yyyy-mm');

 SELECT ID
 FROM TB_BUY
 WHERE BUYDATE = TO_DATE('2022-04','yyyy-mm');

SELECT BUYDATE "구매날짜", CODE "구매물품" 
FROM TB_BUY 
WHERE TO_CHAR(BUYDATE,'YYYY-MM') ='2022-04'
ORDER BY BUYDATE, CODE;

