package com.naver.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.BoardDAOImpl;
import com.naver.vo.BoardDTO;

/**
 * 서블릿 MVC 게시판 저장 컨트롤러
 */
@WebServlet("/board_wite_ok")
public class BoardOkController extends HttpServlet {

       
    /**
   	post 방식으로 접근할 때는 doPost() 메세드를 오버라이딩 해서 호출한다
     */
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html'charset=UTF-8");
		//웹브라우저에서 출력되는 문자와 태그 언어코딩타입설정
		
		PrintWriter out = response.getWriter();
		//출력 스트림 설정
		request.setCharacterEncoding("UTF-8");
		//한글 안깨지게
		String name = request.getParameter("board_name");
		//board_name  파라미터 이름에 저장되어 전달된 글쓴이를 받아서 좌측 변수에 저장
		String title = request.getParameter("board_title");
		String content = request.getParameter("board_cont");
		
		out.println("글쓴이 : " + name +"<hr>");
		out.println("글제목 : " + title +"<hr>");
		out.println("글내용 : " + content +"<hr>");
		
		
		// 6
		BoardDTO b = new BoardDTO();
		b.setBoard_name(name);
		b.setBoard_title(title);
		b.setBoard_cont(content);
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		int result = bdao.insertBoard(b);
		//서블릿 MVC 게시판 저장
		if(result == 1) {
			//out.println("서블릿 MVC 게시판 저장 성공");
			out.println("<script>");
			out.println("alert('서블릿 MVC 게시판 저장에 성공!')");
			out.println("location='board_list';");
			out.println("</script>");
		}
		
	}

}
