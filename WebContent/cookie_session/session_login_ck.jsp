<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");
	//세션 아이디 값을  Obgect 타입으로 구해서 명시적 다운 캐스팅 후 변수에 저장
	//(String) : 캐스팅 연산자
	boolean result =(id == null)?false:true;
	//3항 조건 연산자



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3.세션 로그인 여부 검사</title>
</head>
<body>
<h2>세션 로그인 여부 검사</h2>
<%
	if(result){
		// == true
		out.println("아이디'"+id+"'로그인 된 상태");	
	}else{
		out.println("로그인 하지 않은 상태");	
	}

%>

</body>
</html>