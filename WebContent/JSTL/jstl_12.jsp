<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<ul>
	<c:choose>
		<%-- <c:when test="${param.name =='Lee' }">--%>
		<c:when test="${param.name eq'Lee' }">
		<%-- 표현언어 에서 같다 연산은 eq & == --%>
			<li>당신의 이름은<strong style="font-size: 34;">${param.name }</strong>입니다.</li>
		</c:when>
		
		<c:otherwise>해당사항 없습니다</c:otherwise>
	</c:choose>
</ul>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12. jstl 다중조건문 2</title>
</head>
<body>

</body>
</html>