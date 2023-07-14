package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.naver.vo.MemberTVO;

public class MemberDAOImpl {//DBCP 커넥션 풀에 의해서 데이터 베이스 연결

	Connection con=null;//DB연결 con
	PreparedStatement pstmt=null;//쿼리문 수행 pstmt
	ResultSet rs=null;//검색 결과 레코드를 저장할 rs
	DataSource ds=null; //DBCP 커넥션 풀 관리 ds
	String sql=null; //쿼리문 저장 변수
	
	public MemberDAOImpl() {
       try {
    	   Context ctx=new InitialContext();
    	   ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");//JNDI 디렉토리 서비스에 의해서
    	   //server.xml에 설정된 oracle 데이터베이스 xe를 찾는다.
       }catch(Exception e) {e.printStackTrace();}
	}//생성자

	//아이디 중복 검색
	public MemberTVO idCheck(String id) {
		MemberTVO m=null;
		
		try {
			con = ds.getConnection();
			sql = "select * from memberT8 where mem_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);//쿼리문의 첫번째 물음표에 문자열로 아이디값 저장
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				m = new MemberTVO();
				m.setMem_id(rs.getString("mem_id"));//mem_id컬럼으로 부터 문자열 레코드 아이디를 가져와서
				//setter()메서드에 저장
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return m;
	}//idCheck()
}








