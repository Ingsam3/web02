--memberT8 테이블 생성
create table memberT8(
 mem_id varchar2(50) primary key -- 회원 아이디
 , mem_pwd varchar2(100) not null --비밀번호
 , mem_name varchar2(50) not null --회원이름
 , mem_phone01 varchar2(10) --첫번째 자리 폰번호
 , mem_phone02 varchar2(10) --두번째 자리 폰번호
 , mem_phone03 varchar2(10) --세번째 자리 폰번호
 , mail_id varchar2(50) --메일 아이디
 , mail_domain varchar2(50) --메일 도메인 
 , mem_file varchar2(200) -- 첨부한 회원 프로필 사진 파일 경로
 , mem_date date --가입날짜
);

--아이디 중복검색을 위한 샘플 회원 저장
insert into  memberT8 (mem_id,mem_pwd,mem_name,mem_phone01,mem_phone02,mem_phone03,mail_id,mail_domain,
mem_date) values('aaaaaa','777777','홍길동','010','9999','9999','hong','naver.com',sysdate);

select * from memberT8 order by  mem_id asc;

