package com.study.bookspace.myBuy.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.bookspace.myBuy.vo.GoodsBuyVO;
import com.study.bookspace.myCart.vo.GoodsCartVO;

@Service("buyService")
public class BuyServiceImpl implements BuyService {
	@Autowired
	 private SqlSessionTemplate sqlSession;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void buyFromCart(GoodsBuyVO goodsBuyVO, GoodsCartVO goodsCartVO) {
		sqlSession.insert("buyMapper.buyFromCart", goodsBuyVO);
		sqlSession.insert("buyMapper.getNextBuyCode");
		sqlSession.insert("buyMapper.buyDetails", goodsBuyVO);
		sqlSession.insert("orderMapper.insertOrder", goodsBuyVO);
		sqlSession.delete("cartMapper.deleteCarts", goodsCartVO);
	}

	@Override
	public String getNextBuyCode() {
		return sqlSession.selectOne("buyMapper.getNextBuyCode");
	}

	@Override
	public List<GoodsBuyVO> getBuyList(GoodsBuyVO goodsBuyVO) {
		return sqlSession.selectList("buyMapper.getBuyList", goodsBuyVO);
	}

	@Override
	public int updateBuyOrder(String buyCode) {
		return sqlSession.update("buyMapper.updateBuyOrder",buyCode);
	}

	
	
	
}
