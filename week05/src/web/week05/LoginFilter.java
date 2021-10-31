package web.week05;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		1. 형변환
		HttpServletRequest h_request = (HttpServletRequest)request;
		HttpServletResponse h_response = (HttpServletResponse)response;
		
		String uri = h_request.getRequestURI();
		System.out.println(uri);
		HttpSession session = h_request.getSession();
		String id = (String)session.getAttribute("id");
		
//		2. uri(/week05/login.do) 체크
//		login.do를 거치지 않았을 경우 login.html로 이동
		if(uri.indexOf("login.do")<0) {
			if(id == null || id.trim().length() == 0)
			h_response.sendRedirect("login.html");
		}
		
		chain.doFilter(request, response);
	}
}
