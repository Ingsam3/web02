<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 MVC 회원가입폼</title>
<script src="./js/jquery.js"></script>
<script src="./js/member.js"></script>
</head>
<body>
<h2>회원가입과 프로필 사진 업로드</h2>
<form method="post" action="mem_join_ok.naver" onsubmit="return join_check();"
enctype="multipart/form-data">
<%--
   파일을 첨부해서 서버에 업로드 할려는 자료실 기능을 만들기 위해서 해야하는 규칙)
    1.method="post"방식으로 해야한다. get방식으로는 파일 첨부기능을 만들 수 없다. form태그에서 method속성을 생략하면
    get방식이다. 그러므로 생략하면 안된다.
    
    2.자료실 기능을 만들기 위해서는 form태그내에 enctype="multipart/form-data"속성을 지정해야 한다.
    3.자료실 기능을 만들기 위해서는 파일 첨부해서 서버에서 받을 수 있는 외부 라이브러리가 필요하다.
    여기서는 cos.jar를 활용한다. 이 라이브러리를 WEB-INF/lib폴더 안에 넣어 준다.
 --%>
  <table border="1">
    <tr>
     <th>아이디</th>
     <td><input name="mem_id" id="mem_id" size="14" ><input type="button" 
     value="아이디중복검색" onclick="id_check();"><br>
     <span id="idcheck"></span> <%-- idcheck  영역이 비동기식 jQuery 아작스 프로그램으로 아이디 중복검색해서
     중복아이디 인지 사용가능한 아이디 인지 메시지를 띄우는 부분 --%>
     </td>
    </tr> 
    
    <tr>
     <th>비밀번호</th>
     <td><input type="password" name="mem_pwd" id="mem_pwd" size="14" ></td>
    </tr> 
    
    <tr>
     <th>비밀번호 확인</th>
     <td>
      <input type="password" name="pwd_chk" id="pwd_chk" size="14" >
     </td>
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
         <option value="${p}">${p}</option>
       </c:forEach>       
      </select>-<input name="mem_phone02" id="mem_phone02" size="4" maxlength="4" >-
                <%--maxlength="4"로 지정하면 두번째 자리 폰번호를 4자까지만 입력가능 --%>
                <input name="mem_phone03" id="mem_phone03" size="4" maxlength="4" >
     </td>
    </tr>
    
    <tr>
     <th>E-Mail</th>
     <td>
      <input name="mail_id" id="mail_id" size="16" >@<input name="mail_domain" 
      id="mail_domain" size="20" readonly > <%-- readonly속성은 읽기만 가능 --%>
      <select name="mail_list" onchange="mail_list();">
       <c:forEach var="mail" items="${email}">
         <option value="mail">${mail}</option>
       </c:forEach>
      </select>
     </td>
    </tr>
    
    <tr>
     <th>회원 프로필 사진</th>
     <td><input type="file" name="mem_file" ></td>
    </tr>
    
    <tr>
     <th colspan="2">
     <input type="submit" value="가입" > <input type="reset" value="취소"
     onclick="$('#mem_id').focus();" >
     </th>
    </tr>    
  </table>
</form>
</body>
</html>



