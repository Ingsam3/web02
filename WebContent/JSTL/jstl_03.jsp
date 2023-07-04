<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="msg" value="${'안녕하세요'}" />
<%-- jstl 변수 msg 선언 --%>

<c:set var ="age" scope="page"> <%-- 쌍태그 --%>
${30} <%-- Sscope 속성은 jstl 변수가 적용될 범위 지정 --%>
</c:set>

<c:out value="${msg }"/>
<%-- jstl문으로 변수 값 출력 --%>
<br>
나이 : ${age } <%--EL --%>
<br>

<c:remove var="age" scope="page"/> <%--변수 제거 --%>
나이 : <c:out value="${age }"/>

<hr>
<c:catch var="errorMsg">
예외 발생 전
<%=10/0 %> <%--정수 숫자를 0으로 나누면 예외 발생 --%>
예외 발생 후
</c:catch>
<c:out value="${errorMsg}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3. jstl -set,변수 </title>
</head>
<body>

</body>
</html>