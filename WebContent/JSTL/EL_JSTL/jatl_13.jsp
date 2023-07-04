<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<h2>1부터 100까지의 자연수 중에서 홀수들의 누적합</h2>



<c:forEach var="s" begin="1" end="100" step="2">
	<c:set var="sum" value="${sum+s}"/>
</c:forEach>

<c:forEach var="n" begin="0" end="100" step="2">
	<c:set var="nsum" value="${nsum+n}"/>
</c:forEach>


홀수들의 누적합 : <strong style="color: red; font-size: 38px;"><c:out value="${sum }"/></strong>
<hr>
짝수들의 누적합 : <strong style="color: red; font-size: 38px;"><c:out value="${nsum }"/></strong>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>13. jstl</title>
</head>
<body>

</body>
</html>