--JOIN 등등


SELECT * FROM MEMBER;

SELECT * FROM BOOKLIST;

SELECT * FROM T_RENTAL;

--JOIN을 하긴 했는데 T_RENTAL 데이터만 있으면 될듯?
SELECT R1.*   
        FROM T_RENTAL R1
            JOIN MEMBER M1 ON M1.ID = R1.RENT_ID;
                    
