package com.naver.controller;

public class ActionForward {

	private boolean isRedirect; // 어떻게 이동할 것인가를 판단하는 분기변수
	private String path; // 이동할 매핑주소 또는 뷰페이지 경로 저장
	
	public boolean isRedirect() {//getter() 메서드 => 값 반환 메서드
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) { //setter() 메서드 => 값 저장 메서드
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}	
}
