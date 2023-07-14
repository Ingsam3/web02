package com.naver.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.MemberDAOImpl;
import com.naver.vo.MemberTVO;

//아이디 중복 검색 컨트롤러
public class MemberIdCheckController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		MemberDAOImpl mdao = new MemberDAOImpl();
		MemberTVO db_id = mdao.idCheck(id);
		/* 문제)아이디를 기준으로 회원 테이블로 부터 아이디를 검색해서 해당 아이디를 MemberTVO에 
		 * 저장한 다음 반환해서 아이디중복 검색를 만들어 본다.개발자 테스트 까지 마무리 한다.
		 */
		
		int re=-1;//중복 아이디가 없는 경우 반환값
		if(db_id != null) {//데이터 베이스 해당 컬럼에 중복 아이디가 있는 경우
			re=1;
		}
		out.println(re);//값 반환
		return null;
	}
}
