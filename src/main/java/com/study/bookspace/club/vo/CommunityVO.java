package com.study.bookspace.club.vo;

import com.study.bookspace.member.vo.MemberVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommunityVO extends CommunityListSearchVO{
	private String boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String regDate;
	private int readCnt;
	private int replyCnt;
	private String clubCode;
	private String clubNotice;
	private int rowNum;
	private int rowNumber;
	private CommunityImageVO communityImageVO;
	private MemberVO memberVO;
}
