package com.naver.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MFrontController extends HttpServlet {

	/* 서블릿 클래스 특징)
	 *  1.서블릿 클래스는 온라인 상에서 누구나 다 접근 가능하게 public 접근 권한 제어자로 선언한다.
	 *  2.서블릿 클래스는 HttpServlet 클래스로 부터 상속받는다.
	 *  3.get으로 접근할 때는 doGet메서드를 오버라이딩을 해서 호출하고,post로 접근할 때는 doPost메서드를 오버라이딩을
	 *  해서 호출한다. get or post에 상관없이 service()메서드를 오버라이딩을 해서 호출한다.
	 *  4.HttpServletRequest 서블릿은 사용자 폼에서 입력한 정보를 서버로 가져올 때 사용한다.
	 *  5.HttpServletResponse 서블릿은 서버의 가공된 정보를 사용자 웹브라우저에 응답할 때 사용한다.
	 */
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
      
		String requestURI = request.getRequestURI(); // /web02/*.naver 경로를 구함
		String contextPath = request.getContextPath(); // /web02 컨텍스트 패스 경로를 구함
		String command = requestURI.substring(contextPath.length()); // /web02 이후 경로를 구함.
		//즉 /*.naver url-pattern 매핑주소 경로를 구함.
		
		ActionForward forward = null;
		Action action = null;
		
		Properties prop = new Properties(); //키 ,값 쌍으로 저장되는 사전적인 컬렉션 자료구조
		FileInputStream fis =
			new FileInputStream(request.getRealPath("WEB-INF/classes/naver.properties"));
		/* getRealPath()메서드는 톰켓 WAS서버에 의해서 변경된 실제 톰켓 프로젝트 경로를 반환한다.
		 * E:\20230406_자바취업반\Web_WorkSpace\.metadata\.plugins\
		 * org.eclipse.wst.server.core\tmp0\wtpwebapps\web02\WEB-INF\classes
		 */
		prop.load(fis);//프로퍼티 컬렉션에 로드
		fis.close();
		
		String value = prop.getProperty(command);//키이름 매핑주소에 해당하는 값을 구함.
		
		if(value.substring(0,7).equals("execute")) {//0이상 7미만 사이의 문자 내용이 execute와 같다면
			
			try {
				StringTokenizer st = new StringTokenizer(value,"|");//| 기준으로 문자 분리 즉 문자 파
				//싱
				String url_01 = st.nextToken();//첫번째 분리된 문자 execute저장
				String url_02 = st.nextToken();//두번째 분리된 문자 com.naver.controller.컨트롤러
				//클래스명 저장
				Class url = Class.forName(url_02);//실제 작동하는 컨트롤러 로드 실행
				
				action = (Action)url.newInstance();
				
				try {
				   forward = action.execute(request, response);//자손에서 오버라이딩 된 execute()
				   //메서드를 호출해서 ActionForward객체를 생성함
				}catch(Exception e) {e.printStackTrace();}
				
			}catch(ClassNotFoundException ce) {//해당 클래스명을 찾지 못했을 때 발생되는 예외 오류
				ce.printStackTrace();
			}catch(InstantiationException ie) {//추상클래스나 인터페이스를 객체화 하고자 할 때 
				ie.printStackTrace();
			}catch(IllegalAccessException ex) {//클래스 접근을 못했을 때
				ex.printStackTrace();
			}
		}//if 
		
		if(forward != null) {
			if(forward.isRedirect() == true) {//==true는 생략 가능함
				response.sendRedirect(forward.getPath());
				/* sendRedirect() 메서드로 이동하는 경우 특징)
				 *  1.새로운 매핑주소로 이동하기 때문에 request.setAttribute(키이름,값)을 유지 하지 못한다.
				 *  하지만 session.setAttribute(세션키이름,값)은 유지한다.
				 *  2.레코드 저장,수정 ,삭제 이후 변화된 새로운 값을 확인할 때 사용한다.
				 */
			}else {
				RequestDispatcher forward2=request.getRequestDispatcher(forward.getPath());
				forward2.forward(request, response);
				
				/* forward()메서드로 이동하는 경우 특징)
				 *  1.기존 url-pattern 매핑주소를 유지한다. 그러므로 request.setAttribute() 나 session
				 *  .setAttribute()에 의해서 저장된 키이름값도 유지한다.
				 */
			}
		}//if
	}	
}












