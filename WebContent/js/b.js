/**
 * b.js
 */
 
 function bw_check(){
 
    $board_name = $.trim($('#board_name').val());
    if($board_name.length == 0){
      alert('글쓴이를 입력하세요!');
      $('#board_name').val('').focus();
      return false;
     }
     
   if($.trim($('#board_title').val()) == ''){
     alert('글제목을 입력하세요!');
     $('#board_title').val('').focus();
     return false;
    }
    
   if($.trim($('#board_cont').val()) == ''){
     alert('글내용을 입력하세요!');
     $('#board_cont').val('').focus();
     return false;
    }     
 }