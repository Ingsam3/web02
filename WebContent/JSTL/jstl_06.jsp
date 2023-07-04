<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String[] cityname ={"서울","부산","인천"};
	request.setAttribute("nameList", cityname);
	//nameList 문자열 속성 키 이름에 object 타입으로 업캐스팅한 cityname 저장
%>

<%-- <c:forTokens var="cityName" items="${nameList }" delims=",">--%>
<c:forTokens var="cityName" items="서울, 부산, 인천" delims=",">
 	<%--쉼표 ,  구분자를 기준으로 문자를 분리 --%>
	<c:out value="${cityName }"/><br> 
</c:forTokens>
<hr>Each Token 차이있음<br><hr>
<c:forEach var="cityName" items="${nameList }" >
<c:out value="${cityName }"/><br> 
</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6. jstl forTokens </title>
</head>
<body>

</body>
</html>