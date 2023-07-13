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
	
function join_check(){

$('#id_check').hide(); // 아이디 영역을 숨긴다
$mem_id = $.trim($('#mem_id').val());
//문자영역 보이게 하는 
}	