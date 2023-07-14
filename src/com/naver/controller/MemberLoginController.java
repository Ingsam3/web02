package com.naver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLoginController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("./views/member/member_Login.jsp");//뷰페이지 경로 설정
		forward.setRedirect(false);
		return forward;
	}
}
