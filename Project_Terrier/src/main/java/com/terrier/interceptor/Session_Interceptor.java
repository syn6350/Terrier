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



	@Override//��
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		// �̷��ϱ� �α��ξ��� ������ �� �����ؾ���
		if(request.getRemoteAddr().toString().equals("192.168.0.1"))
			return true;
		
		if(session.getAttribute("user_info")==null)
		{
	
			System.out.println("�ΰ��������� ����� ���ӽõ�");
			response.sendRedirect("/user/login");
			return false;
		}
		return true;
	}
}
