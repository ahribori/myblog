package com.aribori.common.interceptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestCheckInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String referer = request.getHeader("Referer");
		if(referer != null) {
				referer = referer.replace("http://", "");
				referer = referer.substring(0, referer.indexOf("/"));
				if (!referer.contains("aribori.com") && !referer.contains("localhost")) {
					// 로그에 기록
					
					String path = new HttpServletRequestWrapper(request).getRealPath("/") + "resources"
							+ File.separator + "log";
					String fileName = "referer.txt";
					BufferedWriter writer = null;
					BufferedReader reader = null;
					List<String> list = null;
					try {
						
						File dir = new File(path);
						if (!dir.exists()) dir.mkdirs();
						
						File file = new File(path + fileName);
						if(file.exists()) {
							
							list = new ArrayList<String>();
							reader = new BufferedReader(new FileReader(new File(path + fileName)));
						
							while(true) {
								String line = reader.readLine();
								if(line == null)
									break;
								list.add(line);
							}
						}
						
						writer = new BufferedWriter(new FileWriter(new File(path + fileName)));
						
						if (list != null && list.size() != 0) {
							for (String string : list) {
								writer.write(string);
								writer.newLine();
							}
						}
						
						// 추가될 내용
						writer.write("referer = " + referer + "   //   ip = " + request.getRemoteAddr());
						writer.newLine();
					
					} finally {
						if (writer != null) 
							writer.close();
						if (reader != null)
							reader.close();
					}
					
				}
		}
		
		return true;
	}

}
