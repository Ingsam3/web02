package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.naver.vo.BoardDTO;

public class BoardDAOImpl { //DBCP 커넥션 풀 연결법에 의해서 오라클 db연결
	
	DataSource ds;//기본값 null로 초기화, 커넥션 풀 관리 ds
	Connection con; //DB연결 con
	PreparedStatement pt;//쿼리문 수행 pt
	ResultSet rs;//검색 결과 레코드를 저장할 rs
	String sql;//쿼리문 저장 변수
	
	public BoardDAOImpl(){
		try {
          Context ctx=new InitialContext();
          ds = (DataSource)ctx.lookup("java:comp/env/jdbc/xe");//JNDI 디렉토리 서비스에 의해서 커넥션
          //풀 관리 ds생성 => server.xml에 설정된 오라클 xe데이터베이스명을 찾는다.
		}catch(Exception e) {e.printStackTrace();}
	}//기본 생성자

	//게시판 저장
	public int insertBoard(BoardDTO b) {
		int re=-1;//저장 실패시 반환값
		
		try {
			con = ds.getConnection();//커넥션 풀 관리 ds로 db연결 con생성
			sql = "insert into boardT8 (board_no,board_name,board_title,board_cont) "
				+" values(boardNo_seq.nextval,?,?,?)";
			pt=con.prepareStatement(sql);//쿼리문을 미리 컴파일 하여 수행할 pt생성
			pt.setString(1,b.getBoard_name());//쿼리문의 첫번째 물음표에 문자열로 글쓴이 저장
			pt.setString(2,b.getBoard_title());
			pt.setString(3,b.getBoard_cont());
			
			re=pt.executeUpdate();//저장 쿼리문 수행후 성공한 레코드 행의 개수 반환
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return re;
	}//insertBoard()	

	//게시판 목록
	public List<BoardDTO> getBoardList() {
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

	//조회수 증가
	public void updateHit(int board_no) {
		try {
			con=ds.getConnection();
			sql="update boardT8 set board_hit=board_hit+1 where board_no=?";
			pt=con.prepareStatement(sql);
			pt.setInt(1,board_no);//쿼리문의 첫번째 물음표에 정수 숫자로 번호값 저장
			pt.executeUpdate();//수정쿼리문 수행후 성공한 레코드 행의 개수 반환
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}//updateHit()

	//내용보기
	public BoardDTO getBoardCont(int board_no) {
		BoardDTO bc=null;
		
		try {
			con=ds.getConnection();
			sql="select * from boardT8 where board_no=?";
			pt=con.prepareStatement(sql);
			pt.setInt(1,board_no);
			rs=pt.executeQuery();//검색 쿼리문 수행후 결과 레코드를 rs에 저장
			if(rs.next()) {//다음 레코드 행이 존재 하면 참
				bc=new BoardDTO();
				bc.setBoard_no(rs.getInt("board_no"));
				bc.setBoard_name(rs.getString("board_name"));
				bc.setBoard_title(rs.getString("board_title"));
				bc.setBoard_cont(rs.getString("board_cont"));
				bc.setBoard_hit(rs.getInt("board_hit"));
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
           try {
        	   if(rs != null) rs.close();
        	   if(pt != null) pt.close();
        	   if(con != null) con.close();
           }catch(Exception e) {e.printStackTrace();}
		}
		return bc;
	}//getBoardCont()

	//서블릿 mvc게시판 수정
	public int boardEdit(BoardDTO eb) {
		int re=-1;//수정 실패시 반환값
		
		try {
			con=ds.getConnection();//커넥션 풀 관리 ds로 db연결 con생성
			sql="update boardT8 set board_name=?,board_title=?,board_cont=? "
				+" where board_no=?";//번호를 기준으로 글쓴이,글제목,글내용을 수정하는 쿼리문
			pt=con.prepareStatement(sql);
			pt.setString(1,eb.getBoard_name());//쿼리문의 첫번째 물음표에 수정할 글쓴이를 문자열로 저장
			pt.setString(2,eb.getBoard_title());
			pt.setString(3,eb.getBoard_cont());
			pt.setInt(4,eb.getBoard_no());
			
			re=pt.executeUpdate();//수정 쿼리문 수행후 성공한 레코드 행의 개수를 반환
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return re;
	}//boardEdit()

	//게시물 삭제
	public int delBoard(int board_no) {
		int re=-1;//삭제 실패시 반환값
		
		try {
			con=ds.getConnection();
			sql="delete from boardT8 where board_no=?";
			pt=con.prepareStatement(sql);
			pt.setInt(1,board_no);
			re=pt.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return re;
	}//delBoard()
}






