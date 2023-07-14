package com.naver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public abstract ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	/* 인터페이스에 오는 추상메서드 특징)
	 *  1. public abstract 키워드 생략가능하다.
	 *  2. {}가 없고, 실행문장이 없고,호출 불가능하다.
	 *  3. 인터페이스를 구현 상속받은 자손 클래스에서 부모 인터페이스의 모든 추상메서드를 강제 오버라이딩을 해야 자손 클래스
	 *  객체 생성이 가능하다.
	 */
}
