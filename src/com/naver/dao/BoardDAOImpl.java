package com.naver.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.naver.vo.BoardDTO;
import com.sun.jdi.connect.spi.Connection;



public class BoardDAOImpl {
	//DBCP 커넥션 풀 연결법에 의해서 오라클 DB연결
	DataSource ds; //기본값 null로 초기화 커넥션 풀 관리 ds
	java.sql.Connection con;
	PreparedStatement pt; // 쿼리문 수행
	ResultSet rs; //검색결과 저장문
	String sql; //쿼리 저장문
	
	
	public BoardDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/xe");
			//JNDI 디렉토리 서비스에 의해서 커넥션 풀 관리 ds 생성 => server.xml에 설정된 오라클 xe 데이터 접근
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//게시판 저장
	public int insertBoard(BoardDTO b) {
		/*
		 게시판에 저장되게 하는 insertBoard() 메서드를 작성 
		 */
		int result = -1; //저장 실패시 반환값
		
		try {
			
			con=ds.getConnection();
			//커넥션 풀 관리 ds로 db연결 con 생성
			//sql="insert into boardT8 values(boardNo_seq.nextval,?,?,?,?,sysdate);";
			
			sql="insert into boardT8 (board_no, board_name, board_title,board_cont)" 
					+ "values(boardNo_seq.nextval,?,?,?);";
			
			pt=con.prepareStatement(sql);//쿼리문을 미리 컴파일 하여 수행할 sql 생성
			pt.setString(1, b.getBoard_name() ); //쿼리문의 첫 물음표에 문자열로 글쓴이 저장
			pt.setString(2, b.getBoard_title() );
			pt.setString(3, b.getBoard_cont() );
			
			/*	pt.setString(1, b.getBoard_name() );
				pt.setString(2, b.getBoard_title() );
				pt.setString(3, b.getBoard_cont() );
			*/
			
			
			result=pt.executeUpdate();
			//저장 쿼리문 수행 후 성공한 레코드 행의 개수 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pt !=null) pt.close();
				if(con !=null) con.close();
			} catch (Exception e) {e.printStackTrace();}
		}
		return result;
		
	}

	//게시판 목록 가져오기
	public List<BoardDTO> getBoardList() {
		//여기 작성해야함
		
		
		return null;
	}
}
