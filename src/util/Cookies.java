package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.IIOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {
//사용자 정의 쿠키 클래스

	private Map<String,Cookie> cookieMap = new HashMap<>();
	/*
	 1. java.util 패키지의 컬렉션 인터체이스 Map은 key, value 으로 저장되는 사전적인 자료구조이다
	 2. 문자열 키 이릉에 쿠키 개게 타입만 저장 가능한 제네릭 설정
	 */
	
	public Cookies(HttpServletRequest request) {
		/*HttpServletRequest : 서블릿 사용자 입력폼에서 입력한 정보를 서버로 가져올 때 사용*/
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				cookieMap.put(cookies[i].getName(),cookies[i]);
				//컬렉션에 쿠키 이름과 값 즉 쿠키 객체를 각각 키, 값 쌍으로 저장
			}
		}
	}//생성자 오버로딩
	
	public Cookie getCookie( String name) {
		return cookieMap.get(name);
	}//쿠키 이름에 대한 쿠키 객체 반환
	
	public String getValue(String name) throws IOException{
		Cookie cookie = cookieMap.get(name);
		if(cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "UTF-8");
		//인코딩 후 저장하기 때문에 한글 설정 필요
	}//쿠키 이름에 대한 값 반환
	
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}//쿠키이름에 대한 값이 존재하면 참
	
	public static Cookie createCookie(String name, String value) throws IOException {
		return new Cookie(name, URLEncoder.encode(value, "UTF-8"));
	}//쿠키 이름, 값을 가진 쿠키 생성

	public static Cookie createCookie(String name, String value, String path, int maxAge)
	throws IOException{
		Cookie cookie = new Cookie(name, URLEncoder.encode(value,"UTF-8"));
		cookie.setPath(path);// 쿠키 경로저장
		cookie.setMaxAge(maxAge);// 쿠키 유효시간 저장
		return cookie;
	}//쿠키 이룸, 값, 경로, 쿠키 유효시간을 가진 쿠키 생성
	
	public static Cookie createCookie(String name, String value, String path, int maxAge, String domain)
			throws IOException{
		Cookie cookie =  new Cookie(name, URLEncoder.encode(value,"UTF-8"));
		cookie.setDomain(domain);//도메인 저장
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}//전달인자 개수가 다른 메서드 오버로딩 => 쿠키이름, 값, 쿠키값, 도메인, 경로, 유효시간을 가진 쿠키 생성
	
}
