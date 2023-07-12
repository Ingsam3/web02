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
		PrintWriter out=response.getWriter();//출력스트림 있어야 javascript 사용할 수 있음
		 int board_no =Integer.parseInt(request.getParameter("no")) ;
		 BoardDAOImpl bdao = new BoardDAOImpl();
	       int re = bdao.delBoard(board_no);//서블릿 MVC 게시판 삭제
	      
	        if(re == 1) {
	        	/*메세지*/
	        	out.println("<script>");
	        	out.println("alert('서블릿 MVC 게시판 삭제에 성공했습니다!');");
	        	//response로 이동하면 안 됨
	        	out.println("location='board_list';");
	        		out.println("</script>");
	        	
	        }
	
	
	}

}
