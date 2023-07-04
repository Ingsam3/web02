<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<c:if test="true">
<%-- 무조건 참 --%>
true<hr>
</c:if>

<c:if test="${param.name == 'hong' }">
	name 파라미터 값이 <strong style="font-size: 36px;">${param.name}</strong>입니다
</c:if>

<%-- 웹 주소창에 노출되는 get 방식을 & 기호로 구분하여 name, age 파라미터 값을 동시에 각각 전달한다  --%>
<c:if test="${param.age >= 20}">
	<hr>name 파라미터 값이 <strong>당신의 나이는 20세 이상</strong>입니다
</c:if>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11. jstl get parameter</title>
</head>
<body>

</body>
</html>