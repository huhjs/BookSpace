package com.study.bookspace.myCart.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.study.bookspace.menu.vo.SubMenuVO;
import com.study.bookspace.myCart.service.CartService;
import com.study.bookspace.myCart.vo.GoodsCartVO;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/mCart")
public class MyCartController {
	@Resource(name="cartService")
	private CartService cartService;
	
	//장바구니 생성
	@ResponseBody
	@PostMapping("/regCartAjax")
	public void regCartAjax(GoodsCartVO goodsCartVO, Authentication authentication, SubMenuVO subMenuVO) {
		User user = (User)authentication.getPrincipal();
		goodsCartVO.setMemId(user.getUsername());
		cartService.regGoodsCart(goodsCartVO);
	}
	
	//장바구니로 이동
	//마이페이지니까 마이 사이드 추가 필요
	@GetMapping("/cartList")
	public String cartList(Model model, Authentication authentication, GoodsCartVO cartVO,SubMenuVO subMenuVO) {
		User user = (User)authentication.getPrincipal();
		List<GoodsCartVO> cartList = cartService.cartList(user.getUsername());
		model.addAttribute("cartList", cartList);
		int finalPrice = 0;
		for(GoodsCartVO cart : cartList ) {
			finalPrice += cart.getTotalPrice();
		}
		model.addAttribute("finalPrice", finalPrice);
		return "content/cart/cart_list";
	}
	
	//상품 수량 변경
	@PostMapping("/updateCartRegCnt")
	public String updateCartRegCnt(GoodsCartVO goodsCartVO,SubMenuVO subMenuVO) {
		cartService.updateCartRegCnt(goodsCartVO);
		return "redirect:/mCart/cartList?mainMenuCode=" + subMenuVO.getMainMenuCode() + "&subMenuCode=" + subMenuVO.getSubMenuCode();
	}
	
	//상품 삭제
	@GetMapping("/deleteCart")
	public String deleteCart(String cartCode, SubMenuVO subMenuVO) {
		cartService.deleteCart(cartCode);
		return "redirect:/mCart/cartList?mainMenuCode=" + subMenuVO.getMainMenuCode() + "&subMenuCode=" + subMenuVO.getSubMenuCode();
	}
	
	//선택 삭제 
	@GetMapping("/deleteCarts")
	public String deleteCarts(String[] cartCodes, GoodsCartVO goodsCartVO, SubMenuVO subMenuVO) {
		List<String> cartCodeList = Arrays.asList(cartCodes); 
		goodsCartVO.setCartCodeList(cartCodeList);
		cartService.deleteCarts(goodsCartVO);
		return "redirect:/mCart/cartList?mainMenuCode=" + subMenuVO.getMainMenuCode() + "&subMenuCode=" + subMenuVO.getSubMenuCode();
	}
	
}
