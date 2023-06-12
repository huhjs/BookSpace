package com.study.bookspace.club.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookClubVO {
	private String clubCode;
	private String clubName;
	private String clubIntro;
	private String clubCreateDate;
	private int clubMemCnt;
	private int clubStatusNo;
	private String memId;
	private String clubShortInfo;
	private BookClubImageVO bookClubImageVO;
	private BookClubMemberVO bookClubMemberVO;
}
