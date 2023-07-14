package com.naver.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.BoardDAOImpl;
import com.naver.vo.BoardDTO;

/**
 * 서블릿 MVC 게시판 목록 컨트롤러
 */
@WebServlet("/board_list")
public class BoardListController extends HttpServlet {
	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		List<BoardDTO> blist = bdao.getBoardList();//게시판 목록 가져오기
		/* 문제) 서블릿 MVC게시판 목록을 가져오는 getBoardList()메서드를 작성해 보자. 개발자 테스트 까지 해보자. 
		 */
		
		request.setAttribute("blist",blist);//blist 문자열 속성 키이름에 blist목록을 저장
		
		RequestDispatcher blistForward = 
				request.getRequestDispatcher("./views/board/board_list.jsp");
		blistForward.forward(request, response);
		/* 포워딩 특징)
		 *  1.request.setAttribute("blist",blist)에 의해서 저장된 blist키이름 게시판 목록값을 유지한다.
		 *  2.기존 url-pattern매핑주소도 유지한다.
		 */
	}
}
