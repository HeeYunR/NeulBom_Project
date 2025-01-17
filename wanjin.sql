SELECT * FROM tblprotect WHERE id = '9wfsicg023';

select * from tblresident;

select * from tblprotect;

SELECT *
FROM tblresident r
JOIN tblprotect p ON r.resi_seq = p.resi_seq order by r.resi_seq asc;

select * from tblresident where id = 'resi001' order by resi_Seq;

select * from tblprotect order by protect_seq desc;

select * from tblconsult order by con_seq;
select * from tblcreply order by creply_seq;
select * from tblnomem;

create sequence nomemseq start with 70;
insert into tblnomem(nomem_seq, name, tel) values(52, '이순신', '010-1288-7766');


commit;

select * from tblresident;


update tblprotect set rid = 'resi001' where resi_seq = 1;

INSERT INTO tblprotect(protect_seq, id, pw, name, ssn, tel, email, resi_seq, relation, address, lv, rid)
VALUES(142, 'osdfme1', 'zxca1#@$', '이동재', '730101-2058671', '010-9584-1097', 'asdszxcf@naver.com', 125, '사위', '경기도 화성시', 7, 'resi125');

rollback;

desc tblprotect;

commit;

BEGIN
  FOR i IN 1..140 LOOP
    UPDATE tblprotect
    SET rid = 'resi' || LPAD(i, 3, '0')
    WHERE resi_seq = i;
  END LOOP;
END;
/
drop sequence rsequence;

create sequence nsequence start with 51 increment by 1;

CREATE SEQUENCE rsequence

    START WITH 141

    INCREMENT BY 1;
    

select * from tblconsult order by con_seq desc;

delete from tblconsult where con_seq > 71;

commit;

select * from tblnomem order by nomem_seq desc;

delete from tblnomem where nomem_seq > 70;

update tblprotect set rid = 'resi001' where resi_seq = 1;

update tblconsult set isreply = 'n' where con_seq >= 61;
select * from tblnomem;
select * from tblcreply;

commit;

SELECT *
FROM tblconsult
JOIN tblnomem ON tblconsult.nomem_seq = tblnomem.nomem_seq
ORDER BY tblconsult.con_seq;

CREATE VIEW vwconsult AS
SELECT *
FROM tblconsult
JOIN tblnomem ON tblconsult.nomem_seq = tblnomem.nomem_seq
ORDER BY tblconsult.con_seq;

CREATE or replace VIEW vwconsult AS
SELECT tn.nomem_seq as nomem_seq, tn.name as nomem_name, tn.tel as nomemtel, tc.con_seq as con_seq,
tc.title as con_title, tc.content as con_content, tc.con_date as con_date, tc.isreply, 
tc.thread, tc.depth, tcr.creply_seq, tcr.title, tcr.content, tcr.thread as tcrthread, tcr.depth as tcrdepth
FROM tblnomem tn
INNER JOIN tblconsult tc ON tc.nomem_seq = tn.nomem_seq
LEFT OUTER JOIN tblcreply tcr ON tc.con_seq = tcr.con_seq
ORDER BY tc.con_seq desc;

commit;

INSERT INTO tblconsult (con_seq, title, content, con_date, isreply, nomem_seq, thread, depth)
VALUES (conseq.nextVal, '하하하', '하하하', sysdate, 'n', nomemseq.nextVal, '0', '0');

select * from tblnomem order by nomem_seq desc;

delete tblnomem where nomem_seq > 70;

select tn.nomem_seq, tn.name, tc.con_seq, tc.title, tc.content, to_char(tc.con_date, 'yyyy-mm-dd') as con_date,
tc.isreply from tblnomem tn inner join tblconsult tc on tn.nomem_seq = tc.nomem_seq where con_seq = '111';

select * from vwconsult;

select * from vwconsult order by con_date desc;

select * from tblconsult;

select * from (select rownum as rnum, a.* from (select * from tblqna order by qna_seq desc) a);

select rnum, con_seq, con_title, nomem_name, TO_CHAR(con_date, 'YYYY-MM-DD') 
as con_date from (select rownum as rnum, a.* from (select * from vwconsult order by con_seq desc) a)
where rnum between 1 and 10; 

SELECT rnum, con_seq, con_title, nomem_name, TO_CHAR(con_date, 'YYYY-MM-DD') AS con_date 
FROM (
    SELECT ROWNUM AS rnum, a.* 
    FROM (
        SELECT * 
        FROM vwconsult 
        WHERE con_date BETWEEN TO_DATE('2023-06-01', 'YYYY-MM-DD') AND TO_DATE('2023-06-20', 'YYYY-MM-DD')
    ) a
) WHERE rnum BETWEEN 1 AND 10
ORDER BY con_seq DESC;

select * from tblprotect;

select * from tblnomem;

create sequence conseq start with 70;



