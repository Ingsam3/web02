create table boardT8(
    board_no int primary key -- �Խ��ǹ�ȣ
    ,board_name varchar2(20) not null --�۾��� 
    ,board_title varchar2(20) not null --������
    ,board_cont varchar2(20) not null --�۳���
    ,board_hit number(38) default 0 -- ��ȸ��
    ,board_date date default sysdate -- ��ϳ�¥
    -- ����Ŭ sysdate �Լ��� ���ؼ� ���� ��¥�� �ð����� ����ȴ�
);
insert into boardT8 values(0,'1','1','1','1',sysdate);

select * from boardT8 order by board_no desc;
delete from boardT8 where board_no =0;

select * from boardT8 order by board_no desc;
--ū���� ��ȣ������ ���� ����

-- ������ ����
create SEQUENCE boardNo_seq
start with 1
INCREMENT by 1
NOCACHE;

--������ ���� �� Ȯ��
select boardNo_seq.nextval as "��������ȣ��" from dual;










