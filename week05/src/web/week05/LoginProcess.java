package web.week05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 세션을 얻어오기
		HttpSession session = request.getSession();
		
//		2. 폼의 내용을 session에 입력한다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		
//		3. main.do로 이동
		response.sendRedirect("main.do");
	}

}
