package model;

import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class NameDB {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/////////////
	final static String[] FIRST = {"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ",
			"ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	
	final static int[] FCOUNT = { 1, 2, 1, 2, 4, 3, 3, 3, 6,
			2, 4, 1, 2, 4, 3, 2, 3, 4, 3};
	
	final static String[] MID = {"ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ",
			"ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅢ","ㅣ"};		
	
	final static int[] MCOUNT = {2, 3, 3, 4, 2, 3, 3, 4, 2, 4, 
			5, 3, 3, 2, 4, 5, 3, 3, 1, 2, 1};
	
	final static String[] LAST = {"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ",
			"ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	
	final static int[] LCOUNT = {0, 1, 2, 3, 1, 3, 4, 2, 3, 4, 6, 6,
			5, 6, 7, 6, 3, 3, 5, 2, 4, 1, 2, 3, 2, 3, 4, 3};
	//////////////
	
	public NameDB() {
		
	}
	
	//DB연결
	private void dbConn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "aaa", "bbb");
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
	
	//db저장
	private void saveName(String name1, String name2, int percent) {
		dbConn();
		try {
			pstmt = conn.prepareStatement("insert into nameset values (?, ?, ?)");
			pstmt.setString(1, name1);
			pstmt.setString(2, name2);
			pstmt.setInt(3, percent);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	//이름확인하기
	private int loadName(String name1, String name2) {
		dbConn();
		int per = -1, per2 = -1;
		try {
			pstmt = conn.prepareStatement("select percent from nameset where name1 = ? and name2 = ?");
			pstmt.setString(1, name1);
			pstmt.setString(2, name2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				per = rs.getInt(1);
			}
			
			pstmt.setString(1, name2);
			pstmt.setString(2, name1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				per2 = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		dbClose();
		System.out.println("정순결과"+per+"역순결과"+per2);
		if(per != -1) {
			return per;
		}else if(per2 != -1) {
			return per2;
		}else {
			return -1;
		}
		
	}
	
	//이름 받아서 처리
	public int getPercent(String name1, String name2) {
		Random rand = new Random();
		int percent;		
		int res = loadName(name1,name2);
		
		System.out.println("가져온 숫자"+res);
		if(res == -1) {
			if(checkKor(name1, name2)) {
				percent = test(name1,name2);
			}else {
				percent = rand.nextInt(101);
			}
			saveName(name1, name2, percent);
		}else {
			percent = res;
		}
		return percent;
	}
	
	//전체 리스트 반환
	public List<NameVO> listLoad(){
		List<NameVO> list = new ArrayList<>();
		dbConn();
		try {
			pstmt = conn.prepareStatement("select * from nameset order by  TO_NUMBER(percent) desc");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NameVO vo = new NameVO(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	//한글체크
	private boolean checkKor(String name1, String name2) {
		boolean name1Check = Pattern.matches("^[가-힣]*$", name1);
		boolean name2Check = Pattern.matches("^[가-힣]*$", name2);
		return (name1Check&&name2Check);
	}
	
	//자모 획수 계산
	private static int test(String text, String text2) {
		int size = text.length() + text2.length();
		
	
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int j = 0, k = 0;
		for(int i = 0; i < size; i++) {
			if(i%2 == 0) {
				char c = text.charAt(j);
				System.out.println(c);
				list.add(test1(c));
				j++;
				
			}else {
				char c = text2.charAt(k);
				System.out.println(c);
				list.add(test1(c));
				k++;
			}

		}
		
		for (Integer num : list) {
			System.out.println(num);
		}
		

		while(true) {
			int lsize = list.size();
			int l2size = list2.size();
			System.out.println("반복들어옴 l1사이즈" + lsize+"l2사이즈 " +l2size);
			
			if(list2.size() == 0) {
				for(int i = 0; i < (lsize-1); i++) {
					int sum = list.get(i) + list.get(i+1);
					if(sum >= 10) {
						sum = sum%10;
					}
					list2.add(sum);
				}
				if(list.size() != 1) {
					list.clear();
				}
				
		
			}else if(list.size() == 0){
				for(int i = 0; i < (l2size-1); i++) {
					int sum = list2.get(i) + list2.get(i+1);
					if(sum >= 10) {
						sum = sum%10;
					}
					list.add(sum);
				}
				if(list2.size() != 1) {
					list2.clear();
				}
			
			}
			if(lsize ==1 || l2size == 1) {
				break;
			}
			
		}
		//System.out.println(list2.size());
		
		int per = -1;
		if(list.size() == 1) {
			per = list.get(0);
			System.out.println("결과"+per);
			
		}else if(list2.size() == 1) {
			per = list2.get(0);
			System.out.println("결과"+per);
		}
		return per;
		
	}
	
	//한글자 자모 쪼개서 획수 리턴
	private static int test1(char c) {
		int num = 0;
		if(c >= 0xAC00) {
			c = (char)(c - 0xAC00);
			
			int fIndex = (c/28/21);
			int mIndex = ((c)/28%21);
			int lIndex = (c % 28);
			num = FCOUNT[fIndex] + MCOUNT[mIndex] + LCOUNT[lIndex];
			System.out.println(FCOUNT[fIndex] + " " + MCOUNT[mIndex] + " " + LCOUNT[lIndex]);
		}
		return num;
	}
	
}
