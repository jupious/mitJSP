package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatConnecter {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	
	//DB연결
		protected void dbConn() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "aaa", "1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		//DB닫기
		protected void dbClose(){
			if(rs != null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn != null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
		}
}
