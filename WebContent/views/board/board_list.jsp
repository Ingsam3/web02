<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
  <table border="1">
   <tr>
    <th colspan="5">서블릿 MVC 게시판 목록보기</th>
   </tr>
   <tr>
    <th>글번호</th> <th>글제목</th> <th>글쓴이</th> <th>조회수</th> <th>등록날짜</th>
   </tr>
   <c:if test="${!empty blist}">
    <c:forEach var="b" items="${blist}">
     <tr>
      <th>${b.board_no}</th>
      <td style="padding-left:10px; font-weight: bold;">
      <a href="board_cont?no=${b.board_no}">${b.board_title}</a>
      <%-- board_cont?no=번호값 형태의 get방식으로 번호값을 전달한다. --%>
      </td>
      <th>${b.board_name}</th>
      <th>${b.board_hit}</th>
      <th>${b.board_date}</th>
     </tr>
    </c:forEach>
   </c:if>
   <c:if test="${empty blist}">
    <tr><th colspan="5">게시판 목록이 없습니다.</th></tr>
   </c:if>
   <tr>
    <th colspan="5"><input type="button" value="입력" 
    onclick="location='board_write';" /></th>
   </tr>
  </table>
</body>
</html>