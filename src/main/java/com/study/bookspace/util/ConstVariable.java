package com.study.bookspace.util;

public class ConstVariable {
	
	// 도서 이미지 첨부 파일 경로
    public static final String BOOK_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\book\\";

    
    // 클럽 이미지 첨부 파일 경로(집)
    public static final String HCLUB_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\club\\";

    //클럽 이미지 첨부 파일 경로(학원)
    public static final String CLUB_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\club\\";
    
    // info(QNA 이미지)
    public static final String QNA_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\info\\";
 
    //상품 이미지
    public static final String GOODS_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\goods\\";
    
    // 커뮤니티 게시글 이미지 첨부 파일 경로(학원)
    public static final String COMMUNITY_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\community\\";
    
    // 커뮤니티 게시글 이미지 첨부 파일 경로(집)
    public static final String HCOMMUNITY_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\community\\";
    
    // 회원 사진 경로
    public static final String MEMBER_UPLOAD_PATH = PathVariable.LOCAL_PATH + "\\BookSpace\\src\\main\\resources\\static\\image\\member\\";

	// ASCII 범위 – 영숫자(0-9, a-z, A-Z)
	public static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
}
