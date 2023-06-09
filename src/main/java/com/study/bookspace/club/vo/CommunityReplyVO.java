package com.study.bookspace.club.vo;

import com.study.bookspace.member.vo.MemberVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommunityReplyVO {
	private String replyNum;
	private String replyContent;
	private String replyWriter;
	private String regDate;
	private String boardNum;
	private String clubCode;
	private MemberVO memberVO;
}
