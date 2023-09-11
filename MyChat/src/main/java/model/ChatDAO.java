package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
					pstmt = conn.prepareStatement("insert into chatlog (name, text) values (?, ?)");
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
		
		//채팅기록 반환
		public List<ChatVO> list(){
			List<ChatVO> list = new ArrayList<>();
			SimpleDateFormat df = new SimpleDateFormat("aa hh:mm:ss");
			dbConn();
			try {
				pstmt = conn.prepareStatement("select * from chatlog order by chattime");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ChatVO vo = new ChatVO();
					vo.setName(rs.getString("name"));
					vo.setText(rs.getString("text"));
					vo.setChattime(df.format(rs.getTimestamp("chattime")));
					System.out.println(df.format(rs.getTimestamp("chattime")));
					java.util.Date aa= new java.util.Date();
					System.out.println("aa"+aa);
					
					System.out.println(df.format(aa));
					aa = rs.getDate("chattime");
					System.out.println("get aa"+ df.format(aa));
					list.add(vo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbClose();
			return list;
		}
}
