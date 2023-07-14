package com.naver.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogOutController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/hrml;charset=UTF-8");
		//웹브라우저에 출력되는 문자와 태그, 언어코딩 타입을 설정
		PrintWriter out = response.getWriter();
		//출력스트림 생성
		request.setCharacterEncoding("UTF-8");	
		
		HttpSession session = request.getSession();
		
		session.invalidate();//세션 만료 = 로그아웃
		
		out.print("<script>");
		out.println("alert('로그아웃 되었습니다');");
		out.println("location='mem_login.naver';");
		out.print("</script>");
		
		return null;
	}

}
