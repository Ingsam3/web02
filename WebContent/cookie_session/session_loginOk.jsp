<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	//post로 전달되는 한글 깨짐 X
	String id = request.getParameter("login_id");
	String pwd = request.getParameter("login_pwd");
	
	if(id.equals(pwd)){
		///아이디와 비번이 같을 경우 로그인 인증 된 것으로 판단 (객체 주소는 판단 안 함)
		session.setAttribute("id", id);
		//문자열 세션 id 속성 키이름에 object 타입으로 업캐스팅 한 아이디 값 저장
%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2. 세션 로그인 성공</title>
	</head>
	<body>
			<h3 style="color: red;">로그인에 성공함!</h3>
	</body>
</html>

<%
	}else{
		out.print("<script>");
		out.print("alert('로그인 실패');");
		out.print("history.go(-1);");//뒤로 1만큼 가기
		out.print("</script>");
	}


%>