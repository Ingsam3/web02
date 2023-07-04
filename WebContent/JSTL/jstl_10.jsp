<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--sql 태그립 추가 --%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10. jstl sql</title>
</head>
<body>
<sql:setDataSource var="con" driver="oracle.jdbc.driver.OracleDriver"
							 url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
							 user="day"
							 password="day"/>
</body>
</html>