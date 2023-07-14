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

	//회원저장
	public int insertMember(MemberTVO m) {
		int re =-1;
		try {
			con = ds.getConnection();
			/*sql = "insert into memberT8 (mem_id,mem_pwd,mem_name,mem_phone01,mem_phone02,mem_phone03,mail_id,mail_domain,mem_file,mem_date) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";*/
			
			sql = "insert into  memberT8 (mem_id,mem_pwd,mem_name,mem_phone01,mem_phone02,mem_phone03,mail_id,mail_domain,mem_file,mem_date) values(?,?,?,?,?,?,?,?,?,sysdate);";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,m.getMem_id());
			pstmt.setString(2,m.getMem_pwd());
			pstmt.setString(3,m.getMem_name());
			pstmt.setString(4,m.getMem_phone01());
			pstmt.setString(5,m.getMem_phone02());
			pstmt.setString(6,m.getMem_phone03());
			pstmt.setString(7,m.getMail_id());
			pstmt.setString(8,m.getMail_domain());
			pstmt.setString(9,m.getMem_file());
			re=pstmt.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return re;
	}
	//로그인 인증
	public MemberTVO loginCheck(String login_id) {
		MemberTVO m=null;
		
		try {
			con = ds.getConnection();
			sql = "selet * from memberT8 where mem_id=?";
			pstmt.setString(1,login_id);

			rs=pstmt.executeQuery();
			if(rs.next()) {
				m= new MemberTVO();
				m.setMem_pwd(rs.getNString("mem_id"));
				m.setMem_file(rs.getNString("mem_file"));
				//프로필사진 경로와 파일명 저장
				
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
	}
}








