package com.naver.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.BoardDAOImpl;
import com.naver.vo.BoardDTO;

/**
 *게시판 수정폼 
 */
@WebServlet("/board_edit")
public class BoardEditController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("no"));
		//get으로 전달된 번호 값 정수로 받기
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		
		BoardDTO bc = bdao.getBoardCont(board_no); //오라클로부터 가져옴
		
		request.setAttribute("b", bc); //b키이름 저장
		
		RequestDispatcher editFoward = 
				request.getRequestDispatcher("./views/board/board_Edit.jsp");
		editFoward.forward(request, response); //이동함
		/*
		 문제 1-기본 뷰페이지 파일명 boardWrite.jsp를 활용해서 기존 레코드 값 글쓴이, 글제목, 글내용이 서블릿MVC게시판 
		 수정폼에 출력되고 유효성 검증 메시지도 띄워지는 board_Edite.jsp만들기 
		
		문제2-번호를 기준으로 글쓴이, 글제목, 글내용을 수정할 수 있는 Board_Edit_ok 수정완료 매핑 주소가 실행되는 
		BoardEditOkController.java 만들고
		BoardDAOImpl.java에 수정 메서드 
		public int boardEdit(BoardDTO ed){}메서드도 작성 
		
		 */
	}

}
