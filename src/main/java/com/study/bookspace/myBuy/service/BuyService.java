package com.study.bookspace.myBuy.service;

import java.util.List;

import com.study.bookspace.myBuy.vo.GoodsBuyVO;

public interface BuyService {
	
	//상품 구매
	void buyFromCart(GoodsBuyVO goodsBuyVO);
	
	//다음 buyCode 조회
	String getNextBuyCode();
	
	//구매 목록 조회
	List<GoodsBuyVO> getBuyList(GoodsBuyVO goodsBuyVO);
	

}