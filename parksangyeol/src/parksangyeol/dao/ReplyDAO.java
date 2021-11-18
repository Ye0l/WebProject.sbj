package parksangyeol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;

public class ReplyDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ReplyDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/YEOL");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(con != null) { con.close(); con=null; }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public JSONArray rlist(String id) {
		String sql = "select id, num, reply from reply2 where id = ? order by num desc";
		JSONArray list = new JSONArray();
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
}
