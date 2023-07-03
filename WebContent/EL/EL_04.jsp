<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>


<form method="post" action="EL_04.jsp">
	<label for="name">이름</label>
	<!--  label for ="변수" : label for 이름인name과 
	id 속성명 name 이 같으면 마우스 조작이 어려운 사용자들이 
	입력 필드 뿐만아니라 라벨 for 이름을 선택해도 입력 필드 선택 효과가 난다. 
	즉 라벨 글씨나 요소를 클릭해도 입력 필드 선택됨-->
	<input name="name" id="name" value="${param.name}" />
	
	<input type="submit" value="전송">
	<hr>
	입력하신 이름은  <strong>${param.name}</strong>입니다.

</form>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10. label for & 출력</title>
</head>
<body>

</body>
</html>