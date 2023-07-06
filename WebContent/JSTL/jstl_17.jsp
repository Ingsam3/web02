<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/><%--한글 안 깨지게 함 --%>

<h3>jstl 태그 예제</h3>

파라미터 name 값 : <c:out value="${param.name }"/>

<form method="post  " action="jstl_17.jsp">
	<label for="name">이름</label>
	<input name="name" id="name" size="">
	<%-- label for 속성명  name과 입력박스 id 속성명 name이 같으면 labe for만 입력해도 선택효과  --%>
	<input type="submit" value="확인">
</form>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5. jstl 태그 예제</title>
</head>
<body>

</body>
</html>