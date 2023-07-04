<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="fruit" value="${param.name }"/>
<%-- get 으로 전달되는 name 파라미터 값을 받아서 jstl 변수에 저장  --%>

 
param name 애 실려온 값 : 
<c:if test="${!empty fruit}">
	<c:out value="${fruit}"/>

</c:if>

<hr>
<c:choose>
	<c:when test="${fruit == 'apple' }">
	${fruit} :사과
	</c:when>
	<c:when test="${fruit == 'banana' }">
	${fruit} :바나나
	</c:when>
	<c:otherwise>해당사항 없음</c:otherwise>
</c:choose>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4. jstl 다중 조건 문</title>
</head>
<body>

</body>
</html>