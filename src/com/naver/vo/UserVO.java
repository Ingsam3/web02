package com.naver.vo;

public class UserVO {//중간 자료 저장하는 데이터 저장빈 클래스

	private String firstName;//성
	private String lastName;//이름	
	
	public String getFirstName() {//값 반환 getter() 메서드
		return firstName;
	}
	public void setFirstName(String firstName) {//값 저장 setter() 메서드
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
