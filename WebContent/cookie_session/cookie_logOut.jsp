<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.Cookies" %>    
    
<%
	response.addCookie(Cookies.createCookie("AUTH", "","/",0));
	//쿠키 이름, 값, 경로, 유효시간을 0으로 생성 : 쿠키 만료 즉 로그아웃 시킴
	Cookies cookies = new Cookies(request);
	//쿠키 객체 생성 

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 아웃</title>
</head>
<body>
<h2 style="color: red;">logout</h2>

</body>
</html>