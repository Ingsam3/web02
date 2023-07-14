package com.naver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//member_Join.jsp 회원가입 폼 뷰페이지로 이동하게 하기 위한 컨트롤러 클래스
public class MemberJoinController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String[] phone = {"010","011","017","019"};
		String[] email = {"naver.com","daum.net","gmail.com","nate.com","직접입력"};
		
		request.setAttribute("phone",phone);//phone키이름에 phone배열 저장
		request.setAttribute("email", email);;
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./views/member/member_Join.jsp");
		return forward;
	}
}
