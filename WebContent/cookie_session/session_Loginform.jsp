<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1. 세션 로그인 폼</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	//type 속성은 생략해도 웹브라우저가 기본 값으로 자바스크립트로 인식한다
	
	function login_check(){
	
	if($.trim($("#login_id").val()) == ''){
		  alert('로그인 아이디를 입력하세요!');
		  $('#login_id').val('').focus(); //.val() : 초기화
		  return false;
	  }
	
	$login_pwd=$.trim($("#login_pwd").val());//변수에 담아서 사용
	  
	  if($login_pwd.length == 0){
		  alert('비번을 입력하세요!');
		  $('#login_pwd').val('').focus(); 
		  return false;
	  }
}

</script>
</head>
<body>
	<h2>세션 로그인 폼</h2>
	<form method="post" action="session_loginOk.jsp" onsubmit="return login_check();">
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="login_id" id="login_id" size="14" tabindex="1"></td>
			<!-- tabindex: 탭키 눌렀을 때 첫번째 포커스를 가진다 -->
			<th rowspan="2">
				<!-- 2개 행 합침 -->
				<input type="submit" value="로그인">
			</th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="login_pwd" id="login_pwd" size="14" tabindex="2"></td>
			<!-- tabindex="2" :두번째로 포커스 가짐 -->
		</tr>
	
	</table>
	</form>
</body>
</html>

