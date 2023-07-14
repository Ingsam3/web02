<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="./js/jquery.js"></script>
<script src="./js/b.js"></script>
</head>
<body>
 <h2>서블릿 MVC 게시판 수정폼</h2>
 <form method="post" action="board_Edit_ok" onsubmit="return bw_check();">
 <input type="hidden" name="board_no" value="${b.board_no}" >
 
   글쓴이:<input type="text" name="board_name" id="board_name" size="14" 
   value="${b.board_name}"><br><br>
   글제목:<input type="text" name="board_title" id="board_title" size="36" 
   value="${b.board_title}"><br><br>
   글내용:<textarea name="board_cont" id="board_cont" rows="10" 
   cols="34">${b.board_cont}</textarea>
   <hr>
   <input type="submit" value="수정" > 
   <input type="reset" value="취소" onclick="$('#board_name').focus();" >
 </form>
</body>
</html>