<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>


<h2>7단 구구단 연습</h2>

<ul>
	<c:forEach var="a" begin="1" end="9" step="1">
		<li>7 X <c:out value="${a }"/> = ${7 * a }</li>
	</c:forEach>
</ul>
<hr>

<%
	HashMap<String , Object> hm =new HashMap<>();
//키, 값 쌍으로 저장 되는 사전적인 자료구조인 컬렉션 HashMap
	hm.put("name","홍길동");
//문자열 속성 키이름 name에 값 저장
	hm.put("today" , new Date());
//날짜 객체 저장
%>
<h2> 키, 값 쌍으로 출력</h2>
<c:set var="map" value="<%=hm %>"/>
<c:forEach var="i" items="${map }">
	${i.key } : ${i.value} <br>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1. jstl 예제(구구단, HashMap)</title>
</head>
<body>

</body>
</html>