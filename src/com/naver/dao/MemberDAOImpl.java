package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl {//DBCP 커넥션 풀에 의해서 데이터 베이스 연결

	Connection con=null;//DB연결 con
	PreparedStatement pstmt=null;//쿼리문 수행 pstmt
	ResultSet rs=null;//검색 결과 레코드를 저장할 rs
	DataSource ds = null;//DBCP 커넥션 풀 관리
	String sql=null;//쿼리문 저장 변수
	
	public MemberDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
			//server.xml에 설정된 oracle 데이터베이스 xe를 찾는다
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자
}
