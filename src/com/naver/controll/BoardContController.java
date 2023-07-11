package com.naver.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.BoardDAOImpl;
import com.naver.vo.BoardDTO;

/* 서블릿 MVC 게시판 내용보기와 조회수 증가 */
public class BoardContController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
       int board_no = Integer.parseInt(request.getParameter("no"));//no피라미터 이름에 저장되어 져서
       //get으로 전달된 번호값을 받아서 정수 숫자로 바꿔서 저장
       
       BoardDAOImpl bdao=new BoardDAOImpl();
       bdao.updateHit(board_no);//조회수 증가
       /* 문제 1)번호를 기준으로 조회수를 증가 시켜보자. 개발자 테스트까지 해본다. 
        */
       
       BoardDTO bc = bdao.getBoardCont(board_no);
       /* 문제 2)번호를 기준으로 오라클 DB boardT8테이블로 부터 레코드를 가져오게 만들어 보자. 
        */
       String bcont = bc.getBoard_cont().replace("\n","<br>");//textarea입력박스에서 엔터키를 친부
       //분을 웹브라우저에서 줄바꿈해서 글내용을 본다.
       
       request.setAttribute("b",bc);//b키이름에 bc객체를 Object타입으로 업캐스팅 해서 저장
       request.setAttribute("bc",bcont);
       
       RequestDispatcher bcForward =
    		   request.getRequestDispatcher("./views/board/board_cont.jsp");
       bcForward.forward(request, response);       
       /* 문제 3) JSTL 또는 EL을 사용해서 뷰페이지인 board_cont.jsp를 작성해서 제목,내용,조회수를 나오게 해보자. 
        * 특히 내용은 textarea에서 엔터키를 친부분을 줄바꿈해서 나오게 해 보자. 제일 밑에 수정,삭제,목록 버튼을 추가하면 
        * 된다.
        */
       
       
       
       
	}	
}
