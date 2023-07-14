package com.naver.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board_write") // board_write 매핑주소 등록
public class BoardWriteController extends HttpServlet {	

	/**
	 *  get or post에 상관없이 service()메서드를 오버라이딩을 해서 호출한다.
	 *  이 서블릿 컨트롤러 클래스의 역할은 해당 컨트롤러를 통해서 게시판 입력폼 뷰페이지 boardWrite.jsp로 이동하게 하는
	 *  것이다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		RequestDispatcher bwForward = 
				request.getRequestDispatcher("./views/board/boardWrite.jsp");
		        //화면에 보여지는 뷰페이지(view) 경로 설정
		bwForward.forward(request, response);
		
		/* 여기서 보이는 RequestDispatcher.forward() 메서드의 특징)
		 *  1.기존 url-pattern 매핑주소값을 유지한채 해당 뷰페이지로 이동한다. 
		 */
	}
}




