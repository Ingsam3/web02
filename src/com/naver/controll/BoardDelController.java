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

import java.io.PrintWriter;


@WebServlet("/board_del")
public class BoardDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		 int board_no =Integer.parseInt(request.getParameter("board_no")) ;
		 BoardDAOImpl bdao = new BoardDAOImpl();
	       int re = bdao.delBoard(board_no);//서블릿 MVC 게시판 저장
	        /* 문제) 게시판 저장되게 하는 boardEdit()메서드를 작성한다. 그리고 개발자 테스트까지 해보자. 
	         */
	       
	        if(re == 1) {
	        	/*메세지*/
	        	//out.println("<script>");
	        	//out.println("alert('서블릿 MVC 게시판 저장에 성공했습니다!');");
	        	//out.println("location='board_list';");
	        	//out.println("</script>");
	        	
	        	RequestDispatcher bwForward = 
	   				 request.getRequestDispatcher("./views/board/board_list.jsp");
	   		
		   		//화면에 보여지는 뷰페이지(view)경로 설정
		   		bwForward.forward(request, response);
	        }
	
	
	}

}
