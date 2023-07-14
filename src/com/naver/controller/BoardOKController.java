package com.naver.controller;

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
@WebServlet("/board_write_ok") // board_write_ok 매핑주소 등록
public class BoardOKController extends HttpServlet {
	
	/**
	 * post 방식으로 접근할 때는 doPost() 메서드를 오버라이딩을 해서 호출
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//웹브라우저에서 출력되는 문자와 태그,
		//언어코딩 타입 설정
		PrintWriter out=response.getWriter();//출력스트림 객체 생성
		request.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글을 안 깨지게 한다.
		
		String name = request.getParameter("board_name");//board_name 피라미터 이름에 저장되어 져서
		//전달된 글쓴이를 받아서 좌측 변수 name에 저장
		String title = request.getParameter("board_title");
		String content = request.getParameter("board_cont");
		
		out.println("글쓴이 :"+ name +"<hr>");
		out.println("글제목 : "+ title + "<hr>");
		out.println("글내용 : " + content + "<hr>");
		
        BoardDTO b=new BoardDTO();
        b.setBoard_name(name); b.setBoard_title(title); b.setBoard_cont(content);
        
        BoardDAOImpl bdao = new BoardDAOImpl();
        int result = bdao.insertBoard(b);//서블릿 MVC 게시판 저장
        /* 문제) 게시판 저장되게 하는 insertBoard()메서드를 작성한다. 그리고 개발자 테스트까지 해보자. 
         */
        
        if(result == 1) {
        	//out.println("서블릿 MVC 게시판 저장 성공!");
        	out.println("<script>");
        	out.println("alert('서블릿 MVC 게시판 저장에 성공했습니다!');");
        	out.println("location='board_list';");
        	out.println("</script>");
        }
	}
}






