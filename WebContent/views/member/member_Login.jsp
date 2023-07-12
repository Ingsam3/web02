<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 MVC 회원관리 로그인 폼</title>
<script src="./js/jquery.js"></script>
<script>
  function login_check(){
	  if($.trim($("#login_id").val()) == ""){
		  alert('로그인 아이디를 입력하세요!');
		  $('#login_id').val('').focus();
		  return false;
	  }
	  
	  if($.trim($('#login_pwd').val()) == ''){
		  alert('로그인 비번을 입력하세요!');
		  $('#login_pwd').val('').focus();
		  return false;
	  }
  }
</script>
</head>
<body>
 <c:if test="${empty id}"> <%--세션 아이디가 비어 있다면 =>로그인 전 화면 --%>
   <h2>로그인 폼</h2>
   <form method="post" action="mem_login_ok.naver" onsubmit="return login_check();">
    <table border="1">
     <tr>
      <th>아이디</th>
      <td><input name="login_id" id="login_id" size="14" tabindex="1" ></td>
      <%-- tabindex="1"로 지정하면 탭키를 눌렀을 때 첫번째로 포커스를 가진다. --%>
      <th rowspan="2">
       <input type="submit" value="로그인" >       
      </th>
     </tr>
     
     <tr>
      <th>비밀번호</th>
      <td><input type="password" name="login_pwd" id="login_pwd" size="14" 
      tabindex="2" ></td>
     </tr>
     
     <tr>
      <th colspan="3">
       <input type="button" value="아이디 찾기" >
       <input type="button" value="비번 찾기" >
       <input type="button" value="회원가입" onclick="location='mem_join.naver';" >
      </th>
     </tr>
    </table>
   </form>
 </c:if>
 
 <c:if test="${!empty id}"> <%--세션 아이디가 비어 있지 않다면 =>로그인 이후 화면 --%>
   <h2>로그인 이후 화면</h2>
   <form method="post" action="mem_logout.naver">
     <table border="1">
      <tr>
       <th>
        <input type="button" value="정보수정" >
        <input type="button" value="회원탈퇴" >
        <input type="submit" value="로그아웃" >
       </th> 
      </tr>
      
      <tr>
       <th><span style="font-size:28px;">${id}님</span> 로그인을 환영합니다.</th>
      </tr>
      
      <%--회원 프로필 사진이 있는 경우만 실행 --%>
      <c:if test="${!empty member_profile}">
       <tr>
        <th><img src="./upload${member_profile}" width="150" height="120" 
        alt="회원 프로필 사진" ></th>
       </tr>
      </c:if>
     </table>
     <%-- 문제) 서블릿 mvc패턴의 로그인 폼이 작동되게 해보자. --%>
   </form>
 </c:if>
</body>
</html>



