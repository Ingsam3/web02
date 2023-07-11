<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용보기</title>
</head>
<body>
<table border="1">
	<tr>
		<th colspan="2">서블릿 MVC 게시판 내용보기</th>
	</tr>
	<tr>
		<th>제목</th>
		<td>${b.board_title}</td><%-- --%>
	</tr>
	<tr>
		<th>내용</th>
		<td>${bc}</td> <%-- 줄바꿈--%>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${b.board_hit}</td> 
	</tr>
	<tr>
		<th colspan="2">
			<input type="button" value="수정" onclick="location='board_edit>no=${b.bpard_no}';">
			<%--board_edit>no=번호값이 get 방식으로 전달됨 --%>
			<input type="button" value="삭제" onclick=
				"if(confirm('정말삭제할까요?') == true){
				location = 'board_del?no=${b.board_no}';}else{
				return;}">
				<%--true 반환하면  삭제되게 한다.  --%>
			<input type="button" value="목록" onclick="location='board_list.jsp';">	
		</th>
	
	</tr>



</table>

</body>
</html>