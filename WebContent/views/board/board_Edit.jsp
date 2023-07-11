<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/b.js"></script>
</head>
<body>

<h2>서블릿 MVC 게시판 입력폼 </h2>
		<form method="post"action="board_Edit_ok" onsubmit="return bw_check();">
			<input type="hidden" name="board_no" value="${b.board_no }">
			
			글쓴이 : <input type="text" name="board_name" id="board_name" size="14"
			value="${b.baord_name }">
			<br><br>
			글제목 : <input type="text" name="board_title" id="board_title" size="36"
			value="${b.baord_title }">
			<br><br>
			글내용 : 
			<textarea rows="10" cols="34" id="board_cont" name="board_cont">
			${b.board_cont}
			</textarea>
			<hr>
			<input type="submit" value="수정">
			<input type="reset" value="취소" onclick="$('#board_name').focus();">
	</form>

</body>
</html>