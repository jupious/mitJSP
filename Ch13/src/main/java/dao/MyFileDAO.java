package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.MyFileDTO;

//Data Access Object - db접근처리
public class MyFileDAO implements MyFileInter{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//DB연결
	private void dbConn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "aaa", "bbb");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//DB닫기
	private void dbClose(){
		if(rs != null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(pstmt != null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(conn != null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
	}

	@Override
	public List<MyFileDTO> list() {
		List<MyFileDTO> list = new ArrayList<>();
		 
		dbConn();
		try {
			pstmt = conn.prepareStatement("select * from myfile order by idx");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MyFileDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
		return list;
	}
	
	public long listCount() {
		long count = 0;
		dbConn();
		try {
			pstmt = conn.prepareStatement("select count(idx) from myfile order by idx");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
		return count;
	}

	@Override
	public void insert(MyFileDTO dto) {
		
		dbConn();
		try {
			pstmt = conn.prepareStatement("insert into myfile (idx, title, cate, ofile, sfile) values (seq_board_num.nextval, ?, ?, ?, ?)");
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getCate());
			pstmt.setString(3, dto.getOfile());
			pstmt.setString(4, dto.getSfile());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
	}
	
	public String getName(long idx) {
		String sfile = "noFile";
		System.out.println("idx : " + idx);
		dbConn();
		try {
			pstmt = conn.prepareStatement("select sfile from myfile where idx = ?");
			pstmt.setLong(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sfile = rs.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbClose();
		return sfile;
	}
	
	public int delete(long idx) {
		int complete = -1;
		dbConn();
		try {
			pstmt = conn.prepareStatement("delete from myfile where idx = ?");
			pstmt.setLong(1, idx);
			complete = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		dbClose();
		return complete;
	}
	
	
	
}
