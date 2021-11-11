package parksangyeol.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parksangyeol.dao.MemberDAO;
import parksangyeol.dto.MemberDTO;

public class MViewCommand implements MCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MView arrived.");
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id);
		
		request.setAttribute("dto", dto);
	}

}
