package com.naver.vo;

public class MemberTVO {//memberT8 테이블 컬럼명과 일치하는 변수명을 가진 데이터 저장빈 클래스를 되도록이면 만든다.
	//그리고 네임피라미터 이름과 변수명을 반드시 같게 해서 빈클래스를 만든다.
	
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone01;
	private String mem_phone02;
	private String mem_phone03;
	private String mail_id;
	private String mail_domain;
	private String mem_file;
	private String mem_date;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone01() {
		return mem_phone01;
	}
	public void setMem_phone01(String mem_phone01) {
		this.mem_phone01 = mem_phone01;
	}
	public String getMem_phone02() {
		return mem_phone02;
	}
	public void setMem_phone02(String mem_phone02) {
		this.mem_phone02 = mem_phone02;
	}
	public String getMem_phone03() {
		return mem_phone03;
	}
	public void setMem_phone03(String mem_phone03) {
		this.mem_phone03 = mem_phone03;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getMail_domain() {
		return mail_domain;
	}
	public void setMail_domain(String mail_domain) {
		this.mail_domain = mail_domain;
	}
	public String getMem_file() {
		return mem_file;
	}
	public void setMem_file(String mem_file) {
		this.mem_file = mem_file;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}	
}
