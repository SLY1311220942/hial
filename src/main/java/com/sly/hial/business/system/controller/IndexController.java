package com.sly.hial.business.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	/**
	 * 去系统管理主页
	 * @param request
	 * @param response
	 * @return
	 * @author sly
	 * @time 2019年4月20日
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		return "pages/system/home.html";
	}
}
