SELECT * FROM V$VERSION;




--JOIN 등등

SELECT * FROM MEMBER;

SELECT * FROM BOOKLIST;

SELECT * FROM T_RENTAL;

--JOIN을 하긴 했는데 T_RENTAL 데이터만 있으면 될듯?
SELECT R1.*   
        FROM T_RENTAL R1
            JOIN MEMBER M1 ON M1.ID = R1.RENT_ID;
                    


--공지사항 테이블!!!!!
CREATE TABLE T_NOTICE(
      NO NUMBER PRIMARY KEY
    , UP_DATE DATE NOT NULL
    , CONTENTS VARCHAR(300) NOT NULL
);

CREATE SEQUENCE SEQ_NOTICE_NO NOCACHE;

SELECT * FROM T_NOTICE;

--삭제주의
--DROP TABLE T_NOTICE;

INSERT INTO T_NOTICE (NO, CONTENTS)
VALUES (SEQ_NOTICE_NO.NEXTVAL, ?) ;



--요청사항 테이블!!!!!!
CREATE TABLE T_REQUEST(
      NO NUMBER PRIMARY KEY
    , ID VARCHAR(20) NOT NULL
    , CONTENTS VARCHAR(300) NOT NULL
);

CREATE SEQUENCE SEQ_REQUEST_NO NOCACHE;

SELECT * FROM T_REQUEST;

--삭제주의
--DROP TABLE T_REQUEST;

INSERT INTO T_REQUEST (NO, ID, CONTENTS)
VALUES (SEQ_REQUEST_NO.NEXTVAL, ?, ?) ;




