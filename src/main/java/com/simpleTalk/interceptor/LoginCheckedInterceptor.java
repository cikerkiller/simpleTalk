package com.simpleTalk.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simpleTalk.common.TalkConstant;
import com.simpleTalk.pojo.User;


public class LoginCheckedInterceptor implements HandlerInterceptor{
	private List<String> sendRedirect;
	
	
	public List<String> getSendRedirect() {
		return sendRedirect;
	}

	public void setSendRedirect(List<String> sendRedirect) {
		this.sendRedirect = sendRedirect;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		String requestUrl=req.getRequestURI();
		if(!StringUtils.contains(requestUrl, "/login_status.do")){
			User user=(User) req.getSession().getAttribute(TalkConstant.CURRENT_USER);
			if(user==null){
				req.getRequestDispatcher("/user/login_status.do").forward(req, res);
				return false;
			}
		}
		return true;
	}

}
