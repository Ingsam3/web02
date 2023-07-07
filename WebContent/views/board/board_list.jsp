<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="5">서블릿 MVC 게시판 목록보기</th>
		</tr>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
		
		<c:if test=${empty blist }>
			<c:forEach var="b" items="${blist }">
				<tr>
					<th>${b.board_no }</th>
					<td style="padding-left:10px;">${b.board_title }</td>
					<th>${b.board_name}</th>
					<th>${b.board_hit}</th>
					<th>${b.board_date}</th>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test ="${empty blist }">
			<tr>
				<th colspan="5">게시판 목록이 없습니다</th>
			</tr>
			<tr>
				<th colspan="5">
					<input type="button" value="input"
					onclick="location='board_write';">
				</th>
			</tr>
		
		</c:if>
	</table>
</body>
</html>