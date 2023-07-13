<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 MVC 회원가입 폼</title>
<script src="./js/member.js"></script>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="mem_join_ok.naver" 
onsubmit="return join_check();" enctype="multipart/form-data">
<%--파일을 첨부해서 서버에 업로드 하려는 자료실 기능을 만들기 위해 해야하는 규칙 
	1. method = "post"방식으로 해야함get으로는 파일 첨부기능 못 만든다
	form 태그에서 mrthod 속성을 생략하면 get 방식이다 생략X
	2.자료실 기능을 만들기 위해서는 form 태그내에 enctype="multipart/form-data"속성을 지정해야한다
	3.파일 첨부해서 서버에 받을 수 있는 외부 라이브러리가 필요. 여기서는 cos.jar 활용한다
	
--%>
<table border="1">
   <tr>
    <th>아이디</th>
    <td><input name="mem_id" id="mem_id" size="14" >
    <input type="button" value="아이디 중복 검색" onclick="id_check();">
    <br>
    <span id="idcheck"></span>
    <%--비동기식 아작스 프로그램으로 아이디 중복 검색해서 메세지 띄우는 부분 --%>
    </td>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td><input type="password" name="mem_pwd" id="mem_pwd" size="14" ></td>
   </tr>
   <tr>
    <th>비밀번호 확인</th>
    <td><input type="password" name="pwd_ck" id="pwd_ck" size="14" ></td>
   </tr>
   <tr>
    <th>회원이름</th>
    <td><input name="mem_name" id="mem_name" size="14" ></td>
   </tr>
   <tr>
    <th>폰번호</th>
    <td>
    	<select name="mem_phone01" id="mem_phone01">
    		<c:forEach var="p" items="${phone}">
    			<option value="${p}">${p }</option>
    		</c:forEach>
    	</select><input name="mem_phone02" id="mem_phone02" size="14"
    	maxlength="4" ><%--두번 째 폰자리 까지만 입력가능 --%>
    	<input name="mem_phone02" id="mem_phone02" size="14" maxlength="4" >
    </td>
   </tr>
   <tr>
    <th>이메일</th>
    <td><input name="mail_id" id="mail_id" size="16" >@
    	<input name="mail_domain" id="mail_domain" size="20"
    	readonly="readonly" ><%--읽기만 가능 --%>
    	<select name="mail_list" onchange="mail_list();">
    		<c:forEach var="mail" items="${email }">
    			<option value="mail">${mail}</option>
    		</c:forEach>
    	</select>
    </td>
   </tr>
   <tr>
   	<th>회원 프로필 사진</th>
   	<td><input type="text"></td>
   </tr> 
   <tr>
    <th colspan="2">
    <input type="submit" value="가입" >
    <input type="reset" value="취소" onclick="$('#mem_id').focus();">
    </th>
   </tr>
  </table>


</form>

</body>
</html>