package com.aribori.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestCheckInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String referer = request.getHeader("Referer");
		if(referer != null) {
			try {
				referer = referer.replace("http://", "");
				referer = referer.substring(0, referer.indexOf("/"));
				if (!referer.contains("aribori.com") && !referer.contains("localhost")) {
					// 로그에 기록
				}
			} catch (IndexOutOfBoundsException e) {
				
			}
		}
		
		return true;
	}

}
