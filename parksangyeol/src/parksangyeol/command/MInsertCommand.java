package parksangyeol.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parksangyeol.dao.MemberDAO;
import parksangyeol.dto.MemberDTO;

public class MInsertCommand implements MCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MInsertCommand arrived");
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
	}
	
}
