package com.naver.controller;

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
 * 서블릿 MVC 게시판 수정폼에 관한 Servlet 컨트롤러 
 */
@WebServlet("/board_edit")
public class BoardEditController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("no"));
		//get으로 전달된 번호값을 정수 숫자로 변경해서 좌측변수에 저장
		
		BoardDAOImpl bdao=new BoardDAOImpl();		
		BoardDTO bc = bdao.getBoardCont(board_no);
		
		request.setAttribute("b",bc);
		
		RequestDispatcher editForward=
				request.getRequestDispatcher("./views/board/board_Edit.jsp");
		editForward.forward(request, response);
		
		/* 문제1)기존 뷰페이지 파일명 boardWrite.jsp를 활용해서 기존 레코드값 글쓴이,글제목,글내용이 서블릿 mvc
		 * 게시판 수정폼에 출력되고 유효성 검증 메시지도 띄워지는 board_Edit.jsp를 만들어 보고 개발자 테스트까지
		 * 해보자.
		 * 
		 * 문제2)번호를 기준으로 글쓴이,글제목,글내용까지 수정되게 하는 board_Edit_ok 수정완료 매핑주소가 실행되는
		 * BoardEditOkController.java 도 만들고, BoardDAOImpl.java에 수정되게 하는 
		 * public int boardEdit(BoardDTO eb){}메서드도 작성하자.그리고 개발자 테스트 즉 디버깅까지 해보자.
		 */
	}
}
