package kr.mit.c305.gdg;

import java.sql.*;
import java.util.*;

public class BoardDBM {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	static final int PAGECOUNT = 3; //페이지당 게시글숫자
	
	
	//db연결
	private void dbConn() {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "aaa", "1234");
		} catch (Exception e) {
			dbClose();
			e.printStackTrace();
		}
		
	}
	
	//db닫기
	private void dbClose(){
		if(rs != null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(pstmt != null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(conn != null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
	}
	
	//로그인
	public boolean loginCheck(String id, String password) {
		boolean flag = false;
		dbConn();
		try {
			pstmt = conn.prepareStatement("select mname from member where id = ? and password = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;		
				System.out.println("로그인 성공!\n" + rs.getString(1) + "님 환영합니다!");
			}else
				flag = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbClose();
		return flag;
	}
	
	//게시판 로딩
	public List<BoardVO> boardLoader(int page) {
		dbConn();
		int start;
		List<BoardVO> list = new ArrayList<>();
		start = (page-1)*PAGECOUNT;	
		try {
			pstmt = conn.prepareStatement("Select post_no, post_date, title from post order by post_no desc limit ?, ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, PAGECOUNT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.post_no = rs.getInt(1);
				vo.date = rs.getDate(2);
				vo.title = rs.getString(3);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	//아이디 중복확인
	public boolean dupCheck(String id) {
		dbConn();
		boolean isExist = false;
		try {
			pstmt = conn.prepareStatement("select id from post where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			System.out.println("에러발생!");
			e.printStackTrace();
		}
		return isExist;
	}
	
	//가입
	public int sign(String name, String id, String password) {
		dbConn();
		int check = 0;
		try {
			pstmt = conn.prepareStatement("insert into member (mname, id, password) values(?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			check = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	//게시글 읽기
	public List<BoardVO> read(int num) {
		List<BoardVO> list = new ArrayList<>();
		
		dbConn();
		try {
			pstmt = conn.prepareStatement("select id, title, content, post_date from post where post_no = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.id = rs.getString(1);
				vo.title = rs.getString(2);
				vo.post_content = rs.getString(3);
				vo.date = rs.getDate(4);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	//댓글 표시
	public List<BoardVO> readComm(int num){
		List<BoardVO> list = new ArrayList<>();
		
		dbConn();
		try {
			pstmt = conn.prepareStatement("select id, comm_contents, comm_date from comments where post_no = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.id = rs.getString(1);
				vo.comm_content = rs.getString(2);
				vo.date = rs.getDate(3);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
}
