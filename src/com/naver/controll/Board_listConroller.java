package com.naver.controll;

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
*/
@WebServlet("/board_list")
public class Board_listConroller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		List<BoardDTO> blist = bdao.getBoardList();
		//게시판 목록 가져오기
		/*문제 
		 게시판 목록 가져오는 getBoardList()메서드 작성 
		 */
		
		request.setAttribute("blist", blist);
		//blist 문자열 속성 키 이름에 blist 목록을 저장
		
		RequestDispatcher blistForward = request.getRequestDispatcher("./view/board/board_list.jsp");
		blistForward.forward(request, response); //경로지정 
		
		/*
		 포워딩 특징)
		 1. request.setAttribute()에 의해서 저장된 blist 키이름 목록을 유지한다
		 2. 기존 url-pattern매핑 주소도 유지한다
		 */
	}

}
