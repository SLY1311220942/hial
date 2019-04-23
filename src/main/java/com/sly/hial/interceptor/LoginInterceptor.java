package com.sly.hial.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sly.hial.business.system.model.User;
import com.sly.hial.common.constant.CommonConstant;
import com.sly.hial.common.constant.ResultStatus;
import com.sly.hial.common.message.Message;
import com.sly.hial.common.result.BaseResult;


/**
 * 登录拦截器
 * 
 * @author sly
 * @time 2018年11月25日
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	/**
	 * 访问前拦截
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2018年11月25日
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		User user = (User) request.getSession().getAttribute(CommonConstant.SESSION_USER);
		
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		
		if(true) {
			return true;
		}
		//未登录
		String header = request.getHeader("X-Requested-With");  
		boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
		if(user == null){
			if(isAjax) {
				//ajax请求
				String evalStr="top.location='"+basePath+"/system/login/toLogin'";
			    BaseResult result = new BaseResult(ResultStatus.SESSION_OUT, Message.LOGIN_OUTTIME, "evalStr", evalStr);
				response.getWriter().write(JSON.toJSONString(result));
				return false;
			}else {
				//非ajax请求
				String str="<html><meta charset=\"utf-8\"><script  type=\"text/javascript\">top.location='"+basePath+"/system/login/toLogin'</script></html>";
				response.getWriter().print(str);
				return false;
			}
			
		}
		return true;
	}
	
	/**
	 * 拦截后操作
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @author sly
	 * @time 2018年11月25日
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * 完成后操作
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @author sly
	 * @time 2018年11月25日
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
