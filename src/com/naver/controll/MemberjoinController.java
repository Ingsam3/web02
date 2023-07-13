package com.naver.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member_join")
public class MemberjoinController extends HttpServlet {
	
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		public ActionForward execute(HttpServletRequest repuest, 
		HttpServletResponse response) throw Exception{
			String[]phone = {"010","011"};
			String[]eamil = {"naver.com"};
			
			repuest.setAttribute("phone", phone);
			repuest.setAttribute("eamil", eamil);
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath(",/views/member/member_join.jsp");
			return forward;
			
		}
		
	}

}
