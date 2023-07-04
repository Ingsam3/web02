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
							 
	<%-- 오라클 연결 con --%>			
				 
<sql:update dataSource="${con }">
	insert into test values(1, '홍길동')
</sql:update>							
<%--  sql:update : insert, delete, update일때 사용 --%>
 				 
<sql:update dataSource="${con }">
	insert into test values(2, '이순신')
</sql:update>	

<sql:query var="rs" dataSource="${con }">
	select * from test <%-- 세미콜론 생략 --%>
</sql:query>
<%-- sql:query : select 검색문 수행 시 사용,
검색 결과는 rs에 저장 --%>

<c:forEach var="data" items="${rs.rows }">
${data['num'] } <%-- EL의 브라켓 연산자인 []를 사용해서 해당 컬럼으로부터 레코드를 가져온다 --%>
${data['name'] }<hr>
</c:forEach>

</body>
</html>