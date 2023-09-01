package kr.mit.c305;

import java.sql.*;
import java.sql.Date;
import java.util.*;


public class DBClass implements InterDBClass {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//DB����
	private void dbConn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "aaa", "bbb");
		} catch (Exception e) {
			dbClose();
			e.printStackTrace();
		}
		
	}

	//DB�ݱ�
	private void dbClose(){
		if(rs != null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(pstmt != null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(conn != null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
	}
	
	//��ü���� ���������� ��������
	@Override
	public List<ToDoVo> list() {
		dbConn();
		
		List<ToDoVo> list = new ArrayList<>();
		try {
			pstmt = conn.prepareCall("select * from todo order by todo_date");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ToDoVo vo = new ToDoVo();
				vo.no = rs.getInt("no");
				vo.date = rs.getDate("todo_date");
				vo.content = rs.getString("str");
				vo.isComplete = rs.getBoolean("isComplete");
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

	//���� �Է��ϱ�
	@Override
	public void input(ToDoVo vo) {
		int lastNum;
		dbConn();
		
		try {
			lastNum = getLastNum();
			dbConn();
			pstmt=conn.prepareStatement("insert into todo (no,str,todo_date) values(?,?,?)");
			pstmt.setInt(1, lastNum+1);
			pstmt.setString(2, vo.content);
			pstmt.setDate(3,  new java.sql.Date(vo.date.getTime()));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
	}

	//�̿Ϸ� ���� ��������
	@Override
	public List<ToDoVo> inCompleteList() {
		dbConn();
		List<ToDoVo> list = new ArrayList<>();
		try {
			pstmt = conn.prepareCall("select * from todo where isComplete = '0' order by no");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ToDoVo vo = new ToDoVo();
				vo.no = rs.getInt("no");
				vo.date = rs.getDate("todo_date");
				vo.content = rs.getString("str");
				vo.isComplete = rs.getBoolean("isComplete");
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

	//���� �Ϸ��ϱ�
	@Override
	public void complete(int no) {
		dbConn();
		try {
			pstmt = conn.prepareStatement("update todo set iscomplete = 1 where no = ?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		//	System.out.println("�̰� ���;� �ߵȰ���"+ pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbClose();
	}

	//���� �����ϱ�
	@Override
	public void delete(int no) {
		dbConn();
		
		try {
			pstmt = conn.prepareStatement("delete from todo where no = ?");
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if(i != 0) {
				System.out.println(no+"�� ������ �����Ǿ����ϴ�.");
			}else {
				System.out.println("\n�������� �ʴ� �����Դϴ�.\n");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbClose();

	}
	
	//���� �������� ��������
	public List<ToDoVo> getClosest() {
		dbConn();
		List<ToDoVo> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from todo where todo_date = (select min(todo_date) from todo where isComplete = 0) order by no");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ToDoVo vo = new ToDoVo();
				vo.no = rs.getInt(1);
				vo.date = rs.getDate(2);
				vo.content = rs.getString(3);
				vo.isComplete = rs.getBoolean(4);
				list.add(vo);
			}
			
	
		} catch (SQLException e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		
		}
		dbClose();
		return list;
	}
	
	//���ϴ� ���� ��������
	public ToDoVo getSchedule(int no) {
		ToDoVo vo = new ToDoVo();
		dbConn();
		try {
			pstmt = conn.prepareStatement("select * from todo where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			vo.no = rs.getInt(1);
			vo.date = rs.getDate(2);
			vo.content = rs.getString(3);
			vo.isComplete = rs.getBoolean(4);
			
		} catch (Exception e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}
		dbClose();
		return vo;
	}
	
	//�̿Ϸ� ������ �������
	public int inCompleteCount() {
		int count = 0;
		dbConn();
		try {
			pstmt = conn.prepareStatement("select count(*) from todo where isComplete = 0");
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}
		dbClose();
		return count;
	}
	
	//���� ��¥���
	public int getDDay(int no) {
		int dDay = 0;
		dbConn();
		
		try {
			pstmt = conn.prepareStatement("select round(todo_date - sysdate,0) from todo where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			dDay = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}
		return dDay;
	}
	
	
	//���� ū no��������
	private int getLastNum() {
		int lastNum = 0;
	
		try {
			pstmt=conn.prepareStatement("select max(no) from todo");
			rs = pstmt.executeQuery();
			rs.next();
			lastNum = rs.getInt(1);
		//	System.out.println("����ȣ �߻����� �׽�Ʈ"+lastNum);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		dbClose();
		
		return lastNum;
	}
	
	//��������1
//	public java.util.Date lastDate(){
//		dbConn();
//		Date date = null;
//		try {
//			pstmt = conn.prepareStatement("select max(todo_date) from todo where iscomplete = 0");
//			rs = pstmt.executeQuery();
//			rs.next();
//			date = rs.getDate(1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dbClose();
//		return date;
//	}
	
	//��������2
//	public ToDoVo lastStr() {
//		dbConn();
//		ToDoVo vo = new ToDoVo();
//		try {
//			pstmt = conn.prepareStatement("select no, str from todo where todo_date = (select max(todo_date) from todo where iscomplete = 0)");
//			rs = pstmt.executeQuery();
//			rs.next();
//			vo.no = rs.getInt(1);
//			vo.content = rs.getString(2);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dbClose();
//		return vo;
//	}
	
	//��������3
	//Ư�� �ܾ �����ϴ� ����
	public List<ToDoVo> search(String word){
		dbConn();
		List<ToDoVo> list = new ArrayList<>();
		ToDoVo vo = new ToDoVo();
		word ="%"+word+"%";
		try {
			pstmt = conn.prepareStatement("select * from todo where str like ?"); //'%'||?||'%'
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.no = rs.getInt(1);
				vo.date = rs.getDate(2);
				vo.content = rs.getString(3);
				vo.isComplete = rs.getBoolean(4);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
		return list;
	}

}
