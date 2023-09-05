package model;

import java.sql.*;

public class ChatDB {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ChatDB() {}
	
	//DB연결
		private void dbConn() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "aaa", "1234");
			} catch (Exception e) {
				dbClose();
				e.printStackTrace();
			}
			
		}

		//DB닫기
		private void dbClose(){
			if(rs != null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn != null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
		}
		
		//유저확인
		public boolean userCheck(String name, String pw) {
			boolean isExist = false;
			dbConn();
			try {
				pstmt = conn.prepareStatement("select * from members where name = ? and pw = ?");
				pstmt.setString(1, name);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					isExist = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbClose();
			return isExist;
		}
		
		//가입
		public boolean signUp(String name, String pw) {
			if(userCheck(name, pw)) {
				//이미 가입자가 있음
				return false;
			}else {
				dbConn();
				try {
					pstmt = conn.prepareStatement("insert into members values ( ?, ?)");
					pstmt.setString(1, name);
					pstmt.setString(2, pw);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dbClose();
				return true;
			}
		}
}
