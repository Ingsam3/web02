package com.naver.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.BoardDAOImpl;
import com.naver.vo.BoardDTO;

/**
 * Servlet class BoardEditOkController : 서블릿 MVC게시판 수정완료 컨트롤러
 */
@WebServlet("/board_Edit_ok")
public class BoardEditOkController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); //POST방식으로 전송되는 한글을 안깨지게 한다.
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));//히든으로 전달된 글번호
		//를 받아서 정수 숫자로 변경해서 저장
		String board_name = request.getParameter("board_name");//수정할 글쓴이,글제목,글내용를 저장
		String board_title = request.getParameter("board_title");
		String board_cont = request.getParameter("board_cont");
		
		BoardDTO eb = new BoardDTO();
		eb.setBoard_no(board_no); eb.setBoard_name(board_name);
		eb.setBoard_title(board_title); eb.setBoard_cont(board_cont);
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		
		int re = bdao.boardEdit(eb);//번호를 기준으로 글쓴이,글제목,글내용을 수정한다.
		
		if(re == 1) {
			response.sendRedirect("board_cont?no="+board_no);
		}
	}
}
