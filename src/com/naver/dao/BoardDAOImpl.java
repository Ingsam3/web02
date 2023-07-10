package com.naver.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		
	}//insertBoard()	

	//게시판 목록 가져오기
	public List<BoardDTO> getBoardList() {
		//여기 작성해야함
	List<BoardDTO> blist=new ArrayList<>();
		
		try {
			con=ds.getConnection();
			sql="select * from boardT8 order by board_no desc";
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();//검색 결과 레코드를 rs에 저장
			while(rs.next()) {//검색된 다음 레코드 행이 존재하면 참
				BoardDTO b=new BoardDTO();
				b.setBoard_no(rs.getInt("board_no"));//board_no컬럼으로 부터 정수 숫자 레코드를 가져와서
				//setter()메서드에 저장
				b.setBoard_name(rs.getString("board_name"));//board_name컬럼으로 부터 문자열 레코드를
				//가져와서 setter()메서드에 저장
				b.setBoard_title(rs.getString("board_title"));
				b.setBoard_hit(rs.getInt("board_hit"));
				b.setBoard_date(rs.getString("board_date"));
				
				blist.add(b);//컬렉션에 추가
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		
		return blist;
	}//getBoardList()

	public void updateHit(int board_no) {
	       /* 문제 1)번호를 기준으로 조회수를 증가 시켜보자. 개발자 테스트까지 해본다. */

	}

	public BoardDTO getBoardCont(int board_no) {
		/* 문제 2)번호를 기준으로 오라클 DB boardT8테이블로 부터 레코드를 가져오게 만들어 보자. 
	        */
		return null;
	}
	
	
}
