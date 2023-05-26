
//승인 버튼 클릭 시
function acceptMember(acceptCode){
	
	//ajax start
	$.ajax({
	   url: '/club/acceptMemberAjax', //요청경로
	   type: 'post',
	   async : true,
	   contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   data: {'acceptCode':acceptCode}, //필요한 데이터
	   success: function(result) {
		  const accpet = confirm('승인하시겠습니까?');
		  if(accpet){
	      alert('승인이 완료되었습니다.');
     	  }
	   },
	   error: function() {
	      alert('실패');
	   }
	});
	//ajax end
}

//거절 버튼 클릭 시
function refuse(acceptCode){
	
	//ajax start
	$.ajax({
	   url: '/club/refuseMemberAjax', //요청경로
	   type: 'post',
	   async : true,
	   contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   data: {'acceptCode':acceptCode}, //필요한 데이터
	   success: function(result) {
	      const refusal = confirm('거절하시겠습니까?');
	      if(refusal){
			  alert('거절이 완료되었습니다.');
		  }
	   },
	   error: function() {
	      alert('실패');
	   }
	});
	//ajax end
}

//강퇴 버튼 클릭 시
function kickOut(acceptCode){
	
	//ajax start
	$.ajax({
	   url: '/club/refuseMemberAjax', //요청경로
	   type: 'post',
	   async : true,
	   contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   data: {'acceptCode':acceptCode}, //필요한 데이터
	   success: function(result) {
	      const kickOutMsg = confirm('강퇴하시겠습니까?');
	      if(kickOutMsg){
			  alert('강퇴가 완료되었습니다.');
		  }
	   },
	   error: function() {
	      alert('실패');
	   }
	});
	//ajax end
}