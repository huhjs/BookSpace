package com.study.bookspace.myBook.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.bookspace.book.vo.BookVO;
import com.study.bookspace.myBook.vo.BookRecordSearchVO;
import com.study.bookspace.myBook.vo.BookRecordVO;

@Service("myBookService")
public class MyBookServiceImpl implements MyBookService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 독서 기록 등록
	@Override
	public void regBookRecord(BookRecordVO bookRecordVO) {
		sqlSession.insert("recordMapper.regBookRecord", bookRecordVO);
	}

	// 독서 기록 목록
	@Override
	public List<BookRecordVO> getMyBookRecord(BookRecordSearchVO bookRecordSearchVO) {
		return sqlSession.selectList("recordMapper.getMyBookRecord", bookRecordSearchVO);
	}

	//독서 기록 삭제
	@Override
	public int deleteBookRecord(String recordCode) {
		return sqlSession.delete("recordMapper.deleteBookRecord", recordCode);
	}

	// 독서 기록 수정
	@Override
	public int updateBookRecord(BookRecordVO bookRecordVO) {
		return sqlSession.update("recordMapper.updateBookRecord", bookRecordVO);
	}

	// 독서 기록 개수 조회
	@Override
	public int getBookRecordDataCnt(BookRecordSearchVO bookRecordSearchVO) {
		return sqlSession.selectOne("recordMapper.getBookRecordDataCnt", bookRecordSearchVO);
	}

	// 도서 검색 모달
	@Override
	public List<BookVO> bookSearchForModal(Map<String, Object> mapData) {
		return sqlSession.selectList("recordMapper.bookSearchForModal", mapData);
	}

	@Override
	public List<BookRecordVO> getBookRecordList() {
		return sqlSession.selectList("recordMapper.getBookRecordList");
	}

}
