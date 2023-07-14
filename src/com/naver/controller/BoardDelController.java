package com.naver.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.BoardDAOImpl;

/**
 * Servlet Controller class BoardDelController은 서블릿 MVC 게시판 삭제 컨트롤러
 */
@WebServlet("/board_del")
public class BoardDelController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//웹브라우저에 출력되는 문자와 태그,언어코딩
		//타입을 설정
		PrintWriter out = response.getWriter();//출력스트림 객체 out를 생성
		
		int board_no = Integer.parseInt(request.getParameter("no"));//get으로 전달되는 번호값을 받아
		//서 정수 숫자로 변경해서 저장
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		int result = bdao.delBoard(board_no);//글번호를 기준으로 게시물 삭제
		
		if(result == 1) {
			out.println("<script>");
			out.println("alert('서블릿 MVC 게시판 삭제에 성공했습니다!');");
			out.println("location='board_list';");
			out.println("</script>");
		}
	}
}
