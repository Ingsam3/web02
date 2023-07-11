create table boardT8(
    board_no int primary key -- 게시판번호
    ,board_name varchar2(20) not null --글쓴이 
    ,board_title varchar2(20) not null --글제목
    ,board_cont varchar2(20) not null --글내용
    ,board_hit number(38) default 0 -- 조회수
    ,board_date date default sysdate -- 등록날짜
    -- 오라클 sysdate 함수에 의해서 오늘 날짜와 시간값이 저장된다
);
insert into boardT8 values(0,'1','1','1','1',sysdate);

select * from boardT8 order by board_no desc;
delete from boardT8 where board_no =0;

select * from boardT8 order by board_no desc;
--큰숫자 번호순으로 먼저 생김

-- 시퀀스 생성
create SEQUENCE boardNo_seq
start with 1
INCREMENT by 1
NOCACHE;

--시퀀스 다음 값 확인
select boardNo_seq.nextval as "시퀀스번호값" from dual;










