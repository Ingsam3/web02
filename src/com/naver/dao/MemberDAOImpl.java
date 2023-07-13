package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAOImpl {//DBCP 커넥션 풀에 의해서 데이터 베이스 연결

	Connection con=null;//DB연결 con
	PreparedStatement pstmt=null;//쿼리문 수행 pstmt
	ResultSet rs=null;//검색 결과 레코드를 저장할 rs
}
