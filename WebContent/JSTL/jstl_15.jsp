<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<c:set var="str01" value="Abc"/>

lenght(ste01) = ${fn:length(str01) }<br>
영문대문자출력 : ${fn:toUpperCase(str01) }<br>    
영문소문자출력 : ${fn:toLowerCase(str01) }<br>    
0이상 2미만 사이의 문자 추출 : ${fn:substring(str01, 0, 2) }<br>    
B문자를 d문자로 변경 : ${fn:replace(str01,"b","d") }<br>    
<hr>
<c:set var="token" value="1,2,3,4,5"/><%--배열 --%>
<c:set var="arr" value="${fn:split(token,',') }"/>
<%-- , 구분자를기준으로 문자를 분리해서 배열로 만든다 --%>
<c:forEach var="i" items="${arr }">
${i }<br>
</c:forEach>
<hr>
-로 배열 원소결합 : ${fn:join(arr,"-") }<hr>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3. 여러 출력 예제 </title>
</head>
<body>

</body>
</html>