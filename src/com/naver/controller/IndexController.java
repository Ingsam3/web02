package com.naver.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.dao.MemberDAOImpl;
import com.naver.vo.MemberTVO;
//로구인 인증 후 메인화면으로 이동하게 하는 컨트롤러
public class IndexController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/hrml;charset=UTF-8");
		//웹브라우저에 출력되는 문자와 태그, 언어코딩 타입을 설정
		PrintWriter out = response.getWriter();
		//출력스트림 생성
		
		HttpSession session = request.getSession();
		//세션 객체 생성
		String id =(String)session.getAttribute("id");
		//세션 아이디
		if(id == null) {
			out.print("<script>");
			out.println("alert('다시로그인하세요');");
			out.println("location='mem_login.naver';");
			out.print("</script>");
			
		}else {
			//로그인 된 상태
			MemberDAOImpl mdao = new MemberDAOImpl();
			MemberTVO m = mdao.loginCheck(id);
			request.setAttribute("member_profile", m.getMem_file());
			//프로필 파일 경로와 파일명 저장
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./views/member/member_Login.jsp");
			return forward;
			
		}
		return null;
	}

}
