//중간 자료 저장하는 데이터 저장빈 클래스
package com.naver.vo;

public class UserVO {
	private String firstName; // 성
	private String lastName; // 이름
	public String getFirstName() { //값 반환
		return firstName;
	}
	public void setFirstName(String firstName) { //값 저장
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
