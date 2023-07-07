package com.naver.vo;

public class BoardDTO {
//데이터 저장빈 클래스 - > 되도록이면 테이블 컬럼명과 빈클래스 변수명을 같게 한다
	private int board_no;//게시판 번호 
	private String board_name; //글쓴이
	private String board_title; //글제목
	private String board_cont; //글내용
	private int board_hit; // 조회수
	private String board_date; // 등록날짜
	
	//getter &setter 생성
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_cont() {
		return board_cont;
	}
	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date.substring(0,10);
		//0이상 10 미만 사이의 년월일 반환
	}
	
}
