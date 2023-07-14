package com.naver.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.dao.MemberDAOImpl;
import com.naver.vo.MemberTVO;
//로그인 인증 컨트롤러
public class MemberLoginOkController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/hrml;charset=UTF-8");
		//웹브라우저에 출력되는 문자와 태그, 언어코딩 타입을 설정
		PrintWriter out = response.getWriter();
		//출력스트림 생성
		request.setCharacterEncoding("UTF-8");
		
		String login_id=request.getParameter("login_id");
		String login_pwd=request.getParameter("login_pwd");
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		MemberTVO dm =mdao.loginCheck(login_id);///로그인 인증
		
		if(dm == null) {
			out.print("<script>");
			out.println("alert('가입 안 된 회원입니다');");
			out.println("history.back();");
			out.print("</script>");
		}else {
			if(!dm.getMem_pwd().equals(login_id)) {
				//비번 내용이 다르면
				out.print("<script>");
				out.println("alert('비번이 다릅니다');");
				out.println("history.go(-1);");
				out.print("</script>");
			}else {
				//비번이  같은경우
				HttpSession session = request.getSession();
				//세션 객체 생성
				session.setAttribute("id", login_id);
				//세션 아이디 저장
				
				//새로운 매핑주소로 이동
				ActionForward forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("index.naver");//로그인 이후 메인화면으로 이동
				return forward;
			}
		}
		
		return null;
	}

}
