package parksangyeol.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parksangyeol.command.MCommand;
import parksangyeol.command.MInsertCommand;
import parksangyeol.command.MListCommand;

@WebServlet("*.do")
public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller arrived.");
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		MCommand command = null;
		
		String url = request.getRequestURL().toString();
		String com = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".do"));
		if(com != null && com.trim().equals("list")) {
			command = new MListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/mList.jsp";
		}
		if(com != null && com.trim().equals("board")) {
			viewPage = "/WEB-INF/view/mBoard.jsp";
		}
		if(com != null && com.trim().equals("insertForm")) {
			viewPage = "/WEB-INF/view/mInsertForm.jsp";
		}
		if(com != null && com.trim().equals("insert")) {
			command = new MInsertCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/mList.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
}
