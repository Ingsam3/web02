package com.naver.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.MemberDAOImpl;
import com.naver.vo.MemberTVO;
import com.oreilly.servlet.MultipartRequest;

public class MemberJoinOkController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String saveFolder = request.getRealPath("upload");
		//첨부된 프로필 사진 업로드되는 실제 서버경로
		int fileSize = 5*1024*1024; // 파일 첨부 된 사진을 이진파일이라고 한다  최대크기(5mb)
		MultipartRequest multi =null; // WEB-INF/lib폴더에 추가한 이진파일 업로드 라이브러리인 cos.jar에 있는 api로 참조 변수 선언
		
		multi = new MultipartRequest(request, saveFolder, fileSize,"UTF-8");
		MemberTVO m = new MemberTVO();
		
		String mem_id = multi.getParameter("mem_id"); 
		String mem_pwd = multi.getParameter("mem_pwd");
		String mem_name = multi.getParameter("mem_name");
		String mem_phone01 = multi.getParameter("mem_phone01");
		String mem_phone02 = multi.getParameter("mem_phone02");
		String mem_phone03 = multi.getParameter("mem_phone03");
		String mail_id = multi.getParameter("mail_id");
		String mail_domain = multi.getParameter("mail_domain");
		
		File upFile = multi.getFile("mem_file"); //첨부된 프로피 사진을 받는다
		
		if(upFile != null){
			//첨부 된 파일이 있는 경우
			String fileName = upFile.getName();
			//c첨부된 파일 명을 구함
			Calendar c =Calendar.getInstance();//캘린더 추상 클래스로 new 객체생성 못한다
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1; //1월이 0으로 반환됨 
			int date = c.get(Calendar.DATE);
			
			String homedir  = saveFolder +"/" +year+"-"+month+"-"+date;
			//오늘 날짜 폴더 경로 저장
			File todayPath01=new File(homedir);
			
			if(!(todayPath01.exists())) {
				todayPath01.mkdir();
				
			}
			Random r = new Random();
			int ramdom = r.nextInt(1000000000);
			//0 이상 1억 이하 난수
			/*첨부파일 확장자를 구함*/
			int index=fileName.lastIndexOf(".");
			//첨부파일 명에서 . 를 맨 오른쪽부터 찾아서 가장 먼저 나오는 해당 문자 위치 번호 맨 왼쪽부터 카운트해서 구함
			//첫 문자는 0부터 카운트함
			String fileExtendsion = fileName.substring(index+1);
			//첨부된 파일명에서 마침표 이후부터 마지막문자까지 확장자를 구함
			
			String refileName = "member"+year+month+date+ramdom+"."+fileExtendsion;
			//새로운 첨부 파일 명을 구함 
			String fileDBName ="/"+year+"-"+month+"-"+date+"/"+refileName;
			//DB에 저장될 레코드 값
			
			upFile.renameTo(new File(homedir+"/"+refileName));
			//실제 업로드
			m.setMem_file(fileDBName);
		}
		m.setMem_id(mem_id); m.setMem_pwd(mem_pwd);
		m.setMem_name(mem_name); m.setMem_phone01(mem_phone01);
		m.setMail_domain(mail_domain);m.setMail_domain(mail_domain);
		m.setMem_phone02(mem_phone02); m.setMem_phone03(mem_phone03);
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		int re = mdao.insertMember(m);
		/*문제-해당 회원테이블에 레코드가 저장도되게 public int insertMember(MemberDTO m)
		 메서드 작성
		 --개발자 테스트 시 
		 	1. 실제 upload 폴더에 오늘날짜 폴더가 생성되고 변경된 첨부 파일로 업로드 하는지 확인해봐야한다
		 	2. DB에저장된 레코드값 첨부파일 경로와 실제 upload 경로와 변경된 첨부파일 실제 파일 명이 일치하는지 꼭 확인해야 한다
		 	3. DB에 저장된 실제 파일명과 개수와 실제 upload 경로의 파일명과 개수 모두 일치해야한다
		 	
		 */
		
		if(re ==1) {
			ActionForward forward = new ActionForward();
			forward.setRedirect(true);
			//새로운 매핑 주소
			forward.setPath("mem_login.naver");
			//이동할 매핑 주소 저장
			return forward;
		}
		return null;
	}

}
