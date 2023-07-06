<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var ="price" value="10000"/>

통화형 : <fmt:formatNumber value="${price }" type="currency" currencySymbol="원"/>
<%--fmt:formatNumber : 숫자 양식에 맞춰서 출력 --%>
<hr>

<c:set var="now" value="<%=new java.util.Date() %>"/>
<fmt:formatDate value="${now }" type="date" dateStyle="full"/>
<%--fmt:formatDate는 날짜 정보를 담고있다 date 날짜를 풀 스타일로 표현 --%>

<hr>
<fmt:formatDate value="${now }" type="time"/>
<%-- time은 시간형태 --%>
<%-- 오타나면 아예 실행도 안 됨 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2. jstl 여러 표현식 (통화, 날짜)</title>
</head>
<body>

</body>
</html>