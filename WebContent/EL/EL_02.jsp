<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<h3>8. 유즈빈 액션 태그</h3>    
<jsp:useBean id="user" class="com.naver.vo.UserVO" scope="page">
	<jsp:setProperty name="user" property="firstName" value="홍"/>
	<%-- 값 저장 액션태그이다. uservo 빈 클래스의 홍을 저장한다.
		자바코드로 표현하면 user.setFristName()과 같은 기능
	 --%>
	<jsp:setProperty name="user" property="lastName" value="길동"/>
</jsp:useBean>    
    
<jsp:getProperty name="user" property="firstName"/> 
<%-- 값 반환 액션 태그 --%>    
<%= user.getLastName() %>
<hr>

<h3>표현언어 EL로 출력</h3>
${user.firstName}    
${user.lastName}    
<%-- 자바 코드로 표현하면 user.getLastAnme();과 같은 기능이다 --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유즈빈 액션 태그</title>
</head>
<body>

</body>
</html>