package com.sly.hial.business.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 索引controller
 * @author sly
 * @time 2019年4月30日
 */
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
	@RequestMapping("/systemHome")
	public String systemHome(HttpServletRequest request, HttpServletResponse response) {
		return "pages/system/systemHome.html";
	}
}
