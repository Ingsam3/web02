<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 로그인 폼</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
function login_check(){
	
	if($.trim($("#login_id").val()) == ''){
		  alert('로그인 아이디를 입력하세요!');
		  $('#login_id').val('').focus();
		  return false;
	  }
	  
	  if($.trim($('#login_pwd').val()) == ''){
		  alert('비번을 입력하세요!');
		  $('#login_pwd').val('').focus(); 
		  return false;
	  }
}

</script>
</head>
<body>
	<h2>쿠키 로그인 폼</h2>
	<form method="post" action="cookie_loginOk.jsp" onsubmit="return login_check();">
	아이디 : <input type="text" name="login_id" id="login_id" size="14" tabindex="1">
	<!-- tabindex: 탭키 눌렀을 때 첫번째 포커스를 가진다 -->
	비밀번호 : <input type="password" name="login_pwd" id="login_pwd" size="14" tabindex="2">
	<!-- tabindex="2" :두번째로 포커스 가짐 -->
	<input type="submit" value="로그인">
	
	
	</form>
</body>
</html>