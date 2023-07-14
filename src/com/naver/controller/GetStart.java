package com.naver.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 웹브라우저에서 실행되는 주소값을 URL 매핑주소라고 한다.
 * URL 매핑주소 /getbegin 등록
 */
@WebServlet("/getbegin")
public class GetStart extends HttpServlet {
	/** 서블릿 자바 특징)
	 *   1. 서블릿 자바는 HttpServlet 서블릿 클래스로 부터 상속을 받는다.
	 *   2. 온라인 웹상에서 누구나 다 접근 가능하게 하기 위해서 public접근 제어자로 선언한다.
	 *   3. HttpServletRequest 서블릿은 사용자 폼에서 입력한 정보를 서버로 가져오는 역할을 한다.
	 *   4. HttpServletResponse 서블릿은 서버의 가공된 정보를 사용자 웹브라우저에 응답할 때 사용한다.
	 *   5. get으로 접근할 때는 doGet()메서드를 오버라이딩을 해서 호출한다.
	 *   6. get방식인 예)
	 *      가. 웹브라우저 주소창에서 직접 실행하는 경우나 직접 입력해서 실행할 때
	 *      나. 하이퍼링크 get방식으로 이동하는 경우
	 *      다. 자바 스크립트의 location객체에 의해서 이동하는 경우
	 *      라. jsp의 내장객체인 response.sendRedirect()메서드에 의해서 이동하는 경우
	 *      마. JSTL c:redirect에 의해서 이동하는 경우
	 *      바. form태그에서 method=get방식이거나 생략하는 경우
	 *      사. 비동기식 아작스 get으로 이동하는 경우
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {//브라우저 창에서 직접 실행하는 경우라서 get으로 접근
		response.setContentType("text/html;charset=UTF-8");//브라우저에 응답하는 문자와 태그,언어코딩
		//타입을 설정
        PrintWriter out = response.getWriter();//출력 스트림 객체 생성
        out.println("최초 get방식 서블릿 실행~");
        out.close();//출력 스트림 닫는다.
	}
}



