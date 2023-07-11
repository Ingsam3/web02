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


@WebServlet("/board_Edit_ok")
public class BoardEditOkController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글을 안 깨지게 한다.
		
		int board_no =Integer.parseInt(request.getParameter("board_no")) ;
		String board_name = request.getParameter("board_name");//board_name 피라미터 이름에 저장되어 져서
		//전달된 글쓴이를 받아서 좌측 변수 name에 저장
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_cont");
		
        BoardDTO eb=new BoardDTO();
        eb.setBoard_name(board_name); eb.setBoard_title(board_title); eb.setBoard_cont(board_content);
        eb.setBoard_no(board_no);
        
        BoardDAOImpl bdao = new BoardDAOImpl();
        int re = bdao.boardEdit(eb);//서블릿 MVC 게시판 저장
        /* 문제) 게시판 저장되게 하는 boardEdit()메서드를 작성한다. 그리고 개발자 테스트까지 해보자. 
         */
        
        if(re == 1) {
        	response.sendRedirect("board_cont?no="+board_no);
        }
	}

}
