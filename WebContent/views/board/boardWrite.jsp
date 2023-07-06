<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2. 서블릿 MVC 게시판 입력폼</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

		<script type="text/javascript" src="../../js/b.js"></script>
		<script type="text/javascript">
		
		
		</script>
	</head>
	<body>
		<h2>서블릿 MVC 게시판 입력폼 </h2>
		<form method="post"action="board_wite_ok.jsp" onsubmit="return bw_check();">
			글쓴이 : <input type="text" name="board_name" id="board_name" size="14">
			<br><br>
			글제목 : <input type="text" name="board_title" id="board_title" size="36">
			<br><br>
			글내용 : <input type="text" name="board_cont" id="board_cont" size="34">
			<br><br>
			<hr>
			<input type="submit" value="저장">
			<input type="reset" value="취소" onclick="$('#board_name').focus();">
	</form>
	
	</body>
</html>