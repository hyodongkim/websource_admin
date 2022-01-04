package com.teachingcash.login.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	// 컨트롤러보다 먼저 수행되는 메소드
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			// 로그인 정보를 가지고 있는 세션을 가져옴
			HttpSession session = request.getSession();
			Object loginSession = session.getAttribute("adminLogin");
			
			if (loginSession == null) {
				// 로그인이 되어 있지 않은 상태이므로 로그인 폼으로  redirect 하고 더이상 컨트롤러 요청으로 가지 않도록 false 반환
				response.setCharacterEncoding("UTF-8"); 
		    	 response.setContentType("text/html; charset=UTF-8");

		         PrintWriter out = response.getWriter();
		         out.println("<script>alert('로그인 후 이용해주세요.'); location.href='"+request.getContextPath()+"/saadmin/'</script>");
		         out.flush();
		         out.close();
		         
				return false;
			} else {
				return true;
			}
		}
		
		// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메소드
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		     // TODO Auto-generated method stub
		     super.postHandle(request, response, handler, modelAndView);
		 }
}
