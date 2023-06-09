function updateNotice(selectedTag, noticeNo, mainMenuCode, subMenuCode){
		

		//수정 버튼 클릭 시
	if(selectedTag.value == '수정'){
		//클릭한 수정 버튼에서 댓글 내용이 있는 태그 찾아가기
		noticeContentDiv = document.querySelector('#noticeContent');
		console.log(noticeContentDiv);
		
		noticeContent = document.querySelector('#noticeContent').textContent;
		noticeTitleDiv = document.querySelector('.qnaDetail .aTitle');
		noticeTitle = noticeTitleDiv.textContent;
		formDiv = document.querySelector('.updateForm');
		
		//댓글 내용 저장(지우기 위해 백업)
		const content = noticeContent;
		
		//선택한 태그 안의 내용 비우기
		console.log(noticeContentDiv);
		formDiv.innerHTML = '';

		console.log(noticeContentDiv);
		//태그에 input 추가 구문 문자열로 저장
		let str = ``;
		str += `<form id="updateNoticeForm" action="/info/updateNotice" method="post" >`;
		str += `<input type="hidden" value="${noticeNo}" name="noticeNo">`;
		str += `<input type="hidden" value="${mainMenuCode}" name="mainMenuCode">`;
		str += `<input type="hidden" value="${subMenuCode}" name="subMenuCode">`;
		str += `<input type="text" class="form-control" name="noticeTitle" value="${noticeTitle}" style="padding: 0;">`;
		//str += `<textarea class="form-control" required rows="2" cols="50" name="noticeTitle" style="resize: none;">${noticeTitle}</textarea>`;
		str += `<textarea class="form-control" required rows="10" cols="50" name="noticeContent" style="resize: none; margin-top:1rem;">${noticeContent}</textarea>`;
		str += `</form>`;
		
		
		//선택한 태그의 자식태그로 추가
		formDiv.insertAdjacentHTML('afterbegin', str);
		//수정 버튼의 글자 변경
		selectedTag.value = '확인';		
	}else{
		//form태그 submint 시키기
		document.querySelector('#updateNoticeForm').submit();
	}
	
}

//공지사항 삭제 버튼 클릭 시
function deleteNotice(noticeNo, mainMenuCode, subMenuCode){
	Swal.fire({
  title: '공지를 삭제하시겠습니까?',
  icon: 'question',
  showCancelButton: true,
  confirmButtonText: '삭제',
  cancelButtonText: '취소',
}).then((result) => {
  if (result.isConfirmed) {
    Swal.fire({
      title: '공지가 삭제되었습니다.',
      icon: 'success',
    }).then(() => {
      location.href = `/info/deleteNotice?noticeNo=${noticeNo}&mainMenuCode=${mainMenuCode}&subMenuCode=${subMenuCode}`;
    });
  }
});

	
}







