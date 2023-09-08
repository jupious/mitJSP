package model;

import java.sql.*;

public class ChatDAO extends ChatConnecter{
	
		//유저확인
		//로그인할떄 세션 체크해서 이미 있는유저인지 확인 필요
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
		
		//이름 중복확인
		public boolean isUserExist(String name) {
			boolean isExist = false;
			dbConn();
			try {
				pstmt = conn.prepareStatement("select * from members where name = ?");
				pstmt.setString(1, name);
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
			int check = 0;
			if(isUserExist(name)) {
				//이미 가입자가 있음
				return false;
			}else {
				dbConn();
				try {
					pstmt = conn.prepareStatement("insert into members (name, pw) values ( ?, ?)");
					pstmt.setString(1, name);
					pstmt.setString(2, pw);
					check = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dbClose();
				if(check == 1) {
					return true;
				}else {
					return false;
				}
				
			}
		}
		//채팅내용 db저장
		public int saveChat(ChatVO vo) {
			int check = -1;
			String name = vo.getName();
			int count = chatCount(name);
			if(countUp(name,count) != 1) {
				return -2;
			}else {
				dbConn();
				try {
					pstmt = conn.prepareStatement("insert into chatlog values (?, ?)");
					pstmt.setString(1, name);
					pstmt.setString(2, vo.getText());
					check = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				dbClose();
				return check;
			}
			
		}
		
		//채팅개수+1
		private int countUp(String name, int count) {
			int check = -1;
			dbConn();
			try {
				pstmt = conn.prepareStatement("update members set chatcount = ? where name = ?");
				pstmt.setInt(1, count+1);
				pstmt.setString(2, name);
				check = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbClose();
			return check;
		}
		
		
		//현재 채팅갯수반환
		public int chatCount(String name) {
			int count = -1;
			dbConn();
			try {
				pstmt = conn.prepareStatement("select chatcount from members where name = ?");
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			dbClose();
			return count;
		}
		
		
}
