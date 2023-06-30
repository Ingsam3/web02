<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="util.Cookies" %>    

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("login_id");
	String pass = request.getParameter("login_pwd");
	
	if(id.equals(pass)){
		///아이디와 비번이 같을 경우 로그인 인증 된 것으로 판단
		response.addCookie(Cookies.createCookie("AUTH", id,"/",-1));
		//쿠키 이름, 값, 경로, 유효기간을 가진 쿠키 주가
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>로그인 성공</h2>
	<h3 style="color: red;">로그인에 성공함!</h3>
</body>
</html>
<%
	}else{
		out.print("<script>");
		out.print("alert('로그인 실패');");
		out.print("history.go(-1);");
		out.print("</script>");
	}


%>


