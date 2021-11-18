package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/list")
public class LController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LController arrived.");
		Context initCtx = null;
		Context envCtx = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray list = null;
		
		try {
			req.setCharacterEncoding("utf-8");
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/YEOL");
			con = ds.getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			resp.setContentType("text/html; charset=utf-8");
			
			list = new JSONArray();
			
			while(rs.next()) {
				JSONObject json = new JSONObject();
				json.put("id",  rs.getString("id"));
				json.put("name", rs.getString("name"));
				json.put("pwd", rs.getString("pwd"));
				list.add(json);
			}
			resp.getWriter().print(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt!=null)
				try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(con!=null)
				try {con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}
}
