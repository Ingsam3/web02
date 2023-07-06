<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2>jstl 코어 태그 예제</h2>

<c:set var="nara" value="${'korea' }"/>


<c:if test="{$nara !=null}">
국가명 : <c:out value="${nara }"/><%--jstl --%>
</c:if>
<c:if test="{!empty nara}">
국가명 : ${nara }<%-- EL --%>
</c:if>

<c:choose>
	<c:when test="${nara =='korea' }">
		<c:out value="${nara }"/>겨울은 춥다
	</c:when>
	
	<c:when test="${nara == 'canada' }">
		${nara } 의 겨울은 춥다
	</c:when>
	
	<c:otherwise>그외 나라의 겨울은 알 수 없다</c:otherwise>
</c:choose>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4. jstl 코어 태그 예제</title>
</head>
<body>

</body>
</html>