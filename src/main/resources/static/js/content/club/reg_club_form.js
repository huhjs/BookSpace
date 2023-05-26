
//클럽명 중복확인 클릭 시 실행
function isDuplicateClubName(){
	const club_name_tag = document.querySelector('#clubName');
	const club_name = club_name_tag.value.trim();
	
	if(club_name == ''){
		alert('클럽명을 입력하세요.');
		return ;
	}
	
	//ajax start
	$.ajax({
	   url: '/club/isDuplicateClubNameAjax', //요청경로
	   type: 'post',
	   async : false, // 동기 방식
	   contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   data: {'clubName':club_name}, //필요한 데이터
	   success: function(result) {
	      if(result){
		 	alert('클럽명이 중복입니다.');
		  }
		  else{
			alert('사용가능한 클럽명입니다.');
			
			document.querySelector('#regClubBtn').disabled = false;
		  }
	      
	   },
	   error: function() {
	      alert('실패');
	   }
	});
	//ajax end
}


//중복확인 후 클럽명 수정시 클럽생성버튼 비활성화
function setDisabled(){
	document.querySelector('#regClubBtn').disabled = true;
}

//클럽 만들기
function regClub(){
	//유효성 검사진행
	const isVaild = regClubValidate();
	
	if(!isVaild){
		return ;
	}
	
	//클럽생성
	document.querySelector('#regClubForm').submit();
}

//에러메세지 제거
function deleteErrorDiv(){
	//기존의 오류메세지 삭제
	const errorDivs = document.querySelectorAll('div[class="message-is-invalid"]');
	
	for(const errorDiv of errorDivs){
		errorDiv.remove();
	}
}

//클럽 만들때 유효성 검사 진행
//잘됐으면 true, 아니면 false
function regClubValidate(){
	
	deleteErrorDiv();
	
	//함수의 리턴결과를 저장하는 변수
	let result_clubName = true;
	let result_clubIntro = true;
	let result_clubImg = true;
	let result_clubShortInfo = true;
	
	//오류메세지
	let str_clubName = '';
	let str_clubIntro = '';
	let str_clubImg = '';
	let str_clubShortInfo = '';
	
	//클럽 생성 form태그의 자식 div 전체 선택
	const divs = document.querySelectorAll('#regClubForm > div');
	
	//validation 처리
	//클럽명
	const club_name = document.querySelector('#clubName').value;
	if(club_name == ''){
		str_clubName = '클럽명은 필수입력입니다.';
		result_clubName = false;
	}
	else if(club_name.length > 20){
		str_clubName = '클럽명은 20글자 이내로 작성해주세요.';
		result_clubName = false;
	}
	
	//클럽 소개
	const club_intro = document.querySelector('#clubIntro').value;
	if(club_intro == ''){
		str_clubIntro = '클럽소개는 필수입력입니다.';
		result_clubIntro = false;
	}
	else if(club_intro.length < 10){
		str_clubIntro = '클럽소개는 10글자 이상 작성해주세요.';
		result_clubIntro = false;
	}
	
	//클럽 한줄소개
	const club_short_info = document.querySelector('#clubShortInfo').value;
	if(club_short_info == ''){
		str_clubShortInfo = '클럽소개는 필수입력입니다.';
		result_clubShortInfo = false;
	}
	else if(club_intro.length > 100){
		str_clubShortInfo = '클럽소개는 30글자 이내로 작성해주세요.';
		result_clubShortInfo = false;
	}
	
	
	//클럽이미지
	const club_image = document.querySelector('#clubImg').value;
	if(club_image == ''){
		str_clubImg = '클럽이미지는 필수입니다.';
		result_clubImg = false;
	}
	
	
	//유효성 검사 실패시 오류메세지 출력
	if(!result_clubName){
		const errorHTML = `<div class="message-is-invalid">${str_clubName}</div>`;
		divs[1].insertAdjacentHTML('afterend', errorHTML);
	}
	
	if(!result_clubIntro){
		const errorHTML = `<div class="message-is-invalid">${str_clubIntro}</div>`;
		divs[4].insertAdjacentHTML('afterend', errorHTML);
	}
	
	if(!result_clubImg){
		const errorHTML = `<div class="message-is-invalid">${str_clubImg}</div>`;
		divs[3].insertAdjacentHTML('afterend', errorHTML);
	}
	
	if(!result_clubShortInfo){
		const errorHTML = `<div class="message-is-invalid">${str_clubShortInfo}</div>`;
		divs[2].insertAdjacentHTML('afterend', errorHTML);
	}
	
	//
	return result_clubName && result_clubIntro && result_clubImg && result_clubShortInfo;
	
	
	
	
}






