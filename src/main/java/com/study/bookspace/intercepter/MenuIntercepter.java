package com.study.bookspace.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MenuIntercepter implements HandlerInterceptor {
	
//	@Resource(name = "adminService")
//	private AdminService adminService;
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		modelAndView.addObject("menuList", adminService.getAdminMenuList());
//		SubMenuVO subMenuVO = (SubMenuVO)modelAndView.getModel().get("subMenuVO");
//		modelAndView.addObject("subMenuList", adminService.getSubMenuList(subMenuVO.getMenuCode()));
//	}

}
