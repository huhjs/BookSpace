

//전부 퇴실 버튼 클릭 시
function allCheckOut() {
  Swal.fire({
    text: '전부 퇴실시키겠습니까?',
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: "확인",
    cancelButtonText: "취소"
  }).then((result) => {
    if (result.isConfirmed) {
      location.href = `/aLibrary/allCheckOut`;
    }
  });
}

//초기화 버튼 클릭 시
function allClear(){
	
}