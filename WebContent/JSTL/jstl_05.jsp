<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="<%=new int[]{80,100,80,85,95,75} %>"/>
<c:set var="total" value="${0}"/> <%-- 0으로 초기화 --%>
** 점수 출력 ** <br>
<c:forEach var="s" items="${score }" begin="0" end="5" step="1">
${s}&nbsp;
	<c:set var="total" value="${total+s }"/>
	<%-- 배열 원소 누적합 --%>
	
</c:forEach>
<hr>
배열 점수의 총합 = <c:out value="${total }"/>
<hr/>

<%-- 문제 : forEach문 활용해서 1부터 10까지 자연수의 짝수 값 구하기,
짝수값의 누적 합 구해서 출력 --%>

<c:set var="sum" value="<%=new int[]{1,2,3,4,5,6,7,8,9,10} %>"/>
<c:set var="total" value="${0}"/> <%-- 0으로 초기화 --%>
** 짝수 출력 ** <br>
<c:forEach var="s" items="${sum }" begin="1" end="10" step="2">
${s}&nbsp;
	<c:set var="total" value="${total+s }"/>
	<%-- 배열 원소 누적합 --%>
	
</c:forEach>
<hr>
짝수의 총합 = <c:out value="${total }"/>
<hr/>
강사답안
<c:forEach var="n"  begin="2" end="10" step="2">
${n}&nbsp;
	<c:set var="total" value="${total+n }"/>
	<%-- 배열 원소 누적합 --%>
	
</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5. jstl 배열,forEach </title>
</head>
<body>

</body>
</html>