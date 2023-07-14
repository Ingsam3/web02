<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="./js/jquery.js"></script>
<script src="./js/b.js"></script>
<%--
  문제) 유효성 검증 메시지를 띄우는 b.js파일을 만드시고,서블릿 mvc(모델 1방식이 아닌 모델 2방식으로)
  게시판 입력폼 개발자 테스트 하세요.
 --%>
</head>
<body>
 <h2>서블릿 MVC 게시판 입력폼</h2>
 <form method="post" action="board_write_ok" onsubmit="return bw_check();">
   글쓴이:<input type="text" name="board_name" id="board_name" size="14" ><br><br>
   글제목:<input type="text" name="board_title" id="board_title" size="36" ><br><br>
   글내용:<textarea name="board_cont" id="board_cont" rows="10" cols="34"></textarea>
   <hr>
   <input type="submit" value="저장" > 
   <input type="reset" value="취소" onclick="$('#board_name').focus();" >
 </form>
</body>
</html>