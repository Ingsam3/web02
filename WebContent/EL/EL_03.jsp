<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	request.setAttribute("name", "이순신");
	//문자열 속성 키이름인 name에 Object 타입으로 업캐스팅한 값 이순신 저장
%>

<h3>닷 (.) 연산자로 접근 </h3>
${requestScope.name}<br>
${param.id}<br><hr>
<!--  파라미터 id 값을 가져온다 주소창에 노출되는 get 방식으로 *.jsp?id=아이디 가  전달되어야 한다 -->


<h3>브라켓 연산자([])로 접근</h3>
${requestScope["name"]}<br> 
${param["id"]} <br><hr>

<h3>jsp 스크립트 요소인 표현식으로 접근</h3>
<%=request.getAttribute("name") %><br>
<%=request.getParameter("id") %> <br><hr>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>9. 다양한 접근</title>
</head>
<body>

</body>
</html>