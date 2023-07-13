/*member.js*/

function join_check(){
	if($.trim($("#mem_id").val()) ==""){
		alert("회원아이디를 입력하세요!");
		$("#mem_id").val("").focus();
		return false;
	}
	
	$mem_pwd = $.trim($('#mem_pwd').val());
	$pwd_chk = $.trim($('#pwd_chk').val());
	
	if($mem_pwd.length == 0){
		alert("비밀번호를 입력하세요!");
		$("#mem_pwd").val("").focus();
		return false;
	}
	if($pwd_chk.length == 0){
		alert("비밀번호 확인을 입력하세요!");
		$("#pwd_chk").val("").focus();
		return false;
	}
	
	if($mem_pwd != #pwd_chk){
		alert("비밀번호가 다릅니다!");
		$("#mem_pwd").val("");
		$("#pwd_chk").val("");
		$("#mem_pwd").focus();
		//비번 입력 필드 초기화 
		return false;
	}

	if($.trim($("#mem_name").val()) ==""){
		alert("회원이름을 입력하세요!");
		$("#mem_name").val("").focus();
		return false;
	}
	if($.trim($("#mem_phone03").val()) ==""){
		alert("폰번호를 입력하세요!");
		$("#mem_phone").val("").focus();
		return false;
	}
	if($.trim($("#email_id").val()) ==""){
		alert("이메일을 입력하세요!");
		$("#email_id").val("").focus();
		return false;
	}
	if($.trim($("#email_domain").val()) ==""){
		alert("이메일을 입력하세요!");
		$("#email_domain").val("").focus();
		return false;
	}
	
}
	//아이디 중복 검색
	
function id_check(){

$('#id_check').hide(); // 아이디 영역을 숨긴다
$mem_id = $.trim($('#mem_id').val());
//문자영역 보이게 하는 

if(!(validate_mem_id($mem_id))){
	#newtext="<font color='red' size='1'><b>아이디는 영문소문자,숫자, _조합만 가능합니다</b></font>"
	$('#idcheck').text('');
	$('#idcheck').show();
	$('#idcheck').append($newtext);
	$('#idcheck').val('').focus();
	return false;
}
//비동기식 jquery Ajax
$.ajax({
	type:'POST', // 자료를 서버로 보내는 법
	url : 'mem_idcheck.naver', // 서버 매핑 주소
	date :{ 'id' : $mem_id} , //id 파라미터 이름에 $mem_id 변수값을 담아서 전달
	datatype : 'int', //받아오는 자료 형식
	success : function(result){
		//비동기식 아작스로 받아오는 성공시 호출되는 변수
		if($result == 1){
			//중복 아이디인 경우
			$newtext = "<font color='red' size='1'>중복아이디입니다.</font>"
			
		}else{
			//중복 아이디가 아닌 경우
			$newtext = "<font color='blue' size='2'>사용가능한 아이디입니다</font>"
			$('#idcheck').text('');
			$('#idcheck').show();
			$('#idcheck').append($newtext);
			$('#mem_pwd').focus();
		}
	},
	error:function(){
	//에러가 발생했을 때 실행
	alert('data Error!');
	}
});


//아이디 정규 표현식 유효성 검사
function validate_memid($mem_id){
	var pattern = new ReExp(/^[a-z0-9]+$/);
	//아이디는 영문 소문자 , 숫자, _조합만 가능
	return pattern.test($mem_id);
}

}

}	