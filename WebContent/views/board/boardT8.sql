--boardT8 테이블 생성
create table boardT8(
  board_no int primary key --게시판 번호
  ,board_name varchar2(50) not null -- 글쓴이
  ,board_title varchar2(200) not null -- 글제목
  ,board_cont varchar2(4000) not null --글내용
  ,board_hit number(38) default 0 -- 조회수
  ,board_date date default sysdate -- 등록날짜,  default sysdate 제약조건을 주면 해당  컬럼에 굳이 레코드를 저장하지 않아도 기본값인
  --오라클 sysdate함수에 의해서 오늘 날짜와 시간값이 저장된다.
  );
  
  select * from boardT8 order by board_no desc; --게시판 번호를 기준으로 내림차순 정렬
  
  --boardNo_seq라는 시퀀스 생성
  create sequence boardNo_seq
  start with 1 -- 1부터 시작
  increment by 1 -- 1 씩 증가
  nocache;
  
  --boardNo_seq라는 시퀀스 다음번호값 확인
  select boardNo_seq.nextval as "시퀀스 번호값" from dual;
  
  
  