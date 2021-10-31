package web.week05;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		사전 필터
		System.out.println("filter activated.");
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
//		사후 필터
		System.out.println("after filter.");
	}

}
