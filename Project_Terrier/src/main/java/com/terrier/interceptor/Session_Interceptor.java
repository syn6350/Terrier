package com.terrier.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Session_Interceptor extends HandlerInterceptorAdapter
{

	/*@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}*/



	@Override//전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		// 이러니까 로그인없이 접속이 됨 수정해야함
		if(request.getRemoteAddr().toString().equals("192.168.0.1"))
			return true;
		
		if(session.getAttribute("user_info")==null)
		{
	
			System.out.println("인가되지않은 사용자 접속시도");
			response.sendRedirect("/user/login");
			return false;
		}
		return true;
	}
}
