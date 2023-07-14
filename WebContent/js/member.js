/**
 * member.js
 */
 
 function join_check(){
  
   if($.trim($('#mem_id').val())== ''){
     alert('회원아이디를 입력하세요!');
     $('#mem_id').val('').focus();
     return false;
    }
    
    $mem_pwd = $.trim($('#mem_pwd').val());
    $pwd_chk = $.trim($('#pwd_chk').val());
    
    if($mem_pwd.length == 0) {
      alert('비밀번호를 입력하세요!');
      $('#mem_pwd').val('').focus();
      return false;
     }
     
    if($pwd_chk == ''){
      alert('비번확인을 입력하세요!');
      $('#pwd_chk').val('').focus();
      return false;
    }
    
    if($mem_pwd != $pwd_chk){
      alert('비번이 다릅니다!');
      $('#mem_pwd').val("");//비번 입력필드 초기화
      $('#pwd_chk').val('');
      $('#mem_pwd').focus();//비번 입력필드로 포커스 이동
      return false;
     }
     
    if($.trim($('#mem_name').val())== ''){
     alert('회원이름를 입력하세요!');
     $('#mem_name').val('').focus();
     return false;
    }
    
    if($.trim($('#mem_phone02').val())== ''){
     alert('폰번호를 입력하세요!');
     $('#mem_phone02').val('').focus();
     return false;
    }
    
    if($.trim($('#mem_phone03').val())== ''){
     alert('폰번호를 입력하세요!');
     $('#mem_phone03').val('').focus();
     return false;
    }
    
    if($.trim($('#mail_id').val())== ''){
     alert('E-Mail 아이디를 입력하세요!');
     $('#mail_id').val('').focus();
     return false;
    }
    
    if($.trim($('#mail_domain').val())== ''){
     alert('E-Mail 주소를 입력하세요!');
     return false;
    }
    //문제)유효성 검증 메시지가 잘 띄워지는지 확인해 보자.
 }//join_check()
 
 //아이디 중복 검색
 function id_check(){
   $('#idcheck').hide(); //idcheck영역을 숨긴다.
   $mem_id = $.trim($('#mem_id').val());
   if($mem_id.length < 4){
     $newtext="<font color='red' size='1'><strong>아이디는 4자 이상이어야 합니다.</strong></font>";
     $('#idcheck').text('');//idcheck 영역 문자 초기화
     $('#idcheck').show();//idcheck영역을 보이게 함
     $('#idcheck').append($newtext);//idcheck영역에 유효성 검증 메시지 추가
     $('#mem_id').val('').focus();
     return false;
   }    
   
   if($mem_id.length > 12){
     $newtext="<font color='red' size='1'><strong>아이디는 12자 이하이어야 합니다.</strong></font>";
     $('#idcheck').text('');//idcheck 영역 문자 초기화
     $('#idcheck').show();//idcheck영역을 보이게 함
     $('#idcheck').append($newtext);//idcheck영역에 유효성 검증 메시지 추가
     $('#mem_id').val('').focus();
     return false;
   }    
   
   if(!(validate_memid($mem_id))){
     $newtext="<font color='red' size='1'><b>아이디는 영문소문자,숫자,_조합만 가능합니다.</b></font>";
     $('#idcheck').text('');//idcheck 영역 문자 초기화
     $('#idcheck').show();//idcheck영역을 보이게 함
     $('#idcheck').append($newtext);//idcheck영역에 유효성 검증 메시지 추가
     $('#mem_id').val('').focus();
     return false;
   }
   
   //비동기식 jQuery Ajax
   $.ajax({
      type:'POST', //자료를 서버로 보내는 법
      url:'mem_idcheck.naver', //서버 매핑 주소
      data : {'id':$mem_id}, //id피라미터 이름에 $mem_id변수값을 담아서 전달
      datatype:'int', //받아오는 자료형식
      success:function($result){//비동기식 아작스로 받아오는 성공시 호출되는 함수.받아온 데이터는 $result변수에
      //저장
         if($result == 1){//중복아이디 인 경우
           $newtext = "<font color='red' size='1'><b>중복 아이디 입니다.</b></font>";
           $('#idcheck').text('');//idcheck 영역 문자 초기화
           $('#idcheck').show();//idcheck영역을 보이게 함
           $('#idcheck').append($newtext);//idcheck영역에 유효성 검증 메시지 추가
           $('#mem_id').val('').focus();
           return false;
         }else{//중복아이디가 아닌 경우
           $newtext = "<font color='blue' size='2'><b>사용가능한 아이디 입니다.</b></font>";
           $('#idcheck').text('');
           $('#idcheck').show();
           $('#idcheck').append($newtext);
           $('#mem_pwd').focus();//비번 입력필드로 포커스 이동
         }//if else
      },
      error:function(){//에러가 발생했을 때 실행
        alert('data Error!');
      }
   });//$.ajax()
 }//id_check()
 
 //아이디 정규 표현식 유효성 검사
 function validate_memid($mem_id){
   var pattern=new RegExp(/^[a-z0-9_]+$/);//이 정규표현식 의미는 아이디는 영문소문자,숫자,_조합만 가능하게 함
   return pattern.test($mem_id);//아이디 정규표현식 검사
 }
 
 //메일 주소 선택과 직접 입력
 function mail_list(){
   var num = m.mail_list.selectedIndex; //선택한 목록 항목 번호를 반환=>첫번째 목록 항목 번호는 0
   if(num  == -1){//목록이 선택되지 않았다면
     return true;
   }
   
   if(m.mail_list.value == "직접입력"){
      m.mail_domain.value = "";//메일 주소 입력필드 초기화
      m.mail_domain.readOnly = false;//입력 필드 쓰기 가능하게 함.
      m.mail_domain.focus();//메일주소 입력필드로 포커스 이동
   }else{//직접 입력이 아닌 멜주소 목록을 선택한 경우
      m.mail_domain.value = m.mail_list.options[num].value;
      //목록 옵션 value속성값이 메일주소 도메인 입력필드값으로 대입
      m.mail_domain.readOnly = true;//읽기만 가능
   }
   /* 문제)m이 정의 되어 있지 않아서 오류가 발생한다. 이 오류를 디버깅 해보자.
   */
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 