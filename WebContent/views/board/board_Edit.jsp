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

<form method="post" action="board_edit_ok" onsubmit="return bw_check();">

		<table border="1">
			<tr>
				<th colspan="2">게시판 수정폼</th>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input name="board_name" id="board_name" size="14"value="${b.board_name}"></td>

			</tr>
			<tr>
				<th>글제목</th>
				<td><input name="board_title" id="board_title" size="14"value="${b.board_title}"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea name="board_cont" id="board_cont" rows="10" cols="38">
				${bc}
				</textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="게시판 수정 " onclick="">
					<input type="reset" value="취소" onclick="$('#board_name').focus();">
				</th>
			</tr>
		</table>
	</form>

</body>
</html>