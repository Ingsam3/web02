<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="util.Cookies" %>    
    
<%
	Cookies cookies = new Cookies(request);
	//쿠키 객체 생성 

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크</title>
</head>
<body>
<h2>쿠키 로그인 여부 판단</h2>
<%
	if(cookies.exists("AUTH")){
		out.println("아이디 : '"+cookies.getValue("AUTH")+"'로그인 상태");
		
		//AUTH 쿠키 이름에 대한 쿠키 값 구함
		
	}else{
		out.println("<strong style='color:red;'>로그인 되지 않은 상태</strong>");
	}


%>
</body>
</html>