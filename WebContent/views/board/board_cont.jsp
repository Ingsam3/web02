<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table border="1">
 <tr>
  <th colspan="2">서블릿 MVC 게시판 내용보기</th>
 </tr>
 <TR>
  <th>제목</th>
  <td>${b.board_title}</td>
 </TR>
 <tr>
  <th>내용</th>
  <td>${bc}</td>
 </tr>
 <tr>
  <th>조회수</th>
  <td>${b.board_hit}</td>
 </tr>
 <tr>
  <th colspan="2">
   <input type="button" value="수정" onclick="location='board_edit?no=${b.board_no}';" >
   <%-- board_edit?no=번호값이 get방식으로 전달됨. --%>
   <input type="button" value="삭제" onclick=
"if(confirm('정말로 삭제할까요?') == true){ location='board_del?no=${b.board_no}';}else{ 
	    return;}" >
<%--자바스크립트에서 confirm()내장함수는 확인/취소 버튼을 가진 경고창을 만들어 준다. 확인 클릭하면 true를 반환해서
삭제되게 하고,취소를 클릭하면 삭제 안되게 현재창에 그대로 있게 한다.주로 중요 자료 다시 한번더 삭제 유/무를 물어볼 때 많이
사용한다. --%>

  <%--
     문제) 확인 버튼을 클릭하면 번호를 기준으로 삭제되게 board_del매핑주소가 실행 될때 해당 컨트롤러 클래스 
     BoardDelController.java를 만들고, BoardDAOImpl.java에 삭제되는 메서드 public int delBoard(
     int board_no){}를 작성해 본다. 삭제 이후 반환값 1을 리턴받아서 컨트롤러 에서 자바스크립트 경고창 메시지
     '서블릿 MVC 게시판 삭제에 성공했습니다!'라는 것을 띄우고 자바스크립트 location객체에 의해서 board_list매핑
     주소로 이동되게 하자. 개발자 테스트까지 해본다.
  --%>
  
  <input type="button" value="목록" onclick="location='board_list';" >	    
  </th>
 </tr>
</table>
</body>
</html>