package kr.mit.c305.gdg;

import java.text.SimpleDateFormat;
import java.util.*;

public class BoardManager {
	Scanner scan = new Scanner(System.in);
	String currentID;
	BoardDBM db;
	
	public void loggingIn() {
		db = new BoardDBM();
		String id, password;
		System.out.print("아이디를 입력해주세요 : ");
		id = scan.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		password = scan.nextLine();
		if(db.loginCheck(id, password)) {
			//게시글 로딩
			mainList(1);
		}else {
			//아이디 비번확인해주세요
			loginFail();
		}
			
	}
	
	public void loginFail() {
		int num;
		System.out.println("존재하지 않는 회원입니다.\n아이디 또는 비밀번호를 확인해주세요\n");

		System.out.print("1. 다시입력\n2. 가입하기\n3. 종료\n선택해주세요: ");
		num = scan.nextInt();
		scan.nextLine();
		if(num!=3) {
			if(num == 1) {
				loggingIn();
			}else if(num == 2) {
				signUp();
			}
		}
		
		
	}
	
	public void signUp() {
		db = new BoardDBM();
		boolean dup;
		int check;
		String name, id, password;
		System.out.print("이름을 입력해주세요 : ");
		name = scan.nextLine();
		do {
			System.out.print("아이디를 입력해주세요 : ");
			id = scan.nextLine();
			dup = db.dupCheck(id);
			if(dup) {
				System.out.println("이미 존재하는 아이디입니다.");
			}
		}while(dup);
		System.out.print("비밀번호를 입력해주세요 : ");
		password = scan.nextLine();
		check = db.sign(name,id,password);
		if(check != 1) {
			System.out.println("오류발생!");
		}else {
			System.out.println("환영합니다! 로그인 화면으로 이동합니다.");
			loggingIn();
		}
		
	}
	
	public void mainList(int page) {
		boolean loadCheck;
		int user;
		db = new BoardDBM();
		List<BoardVO> list = new ArrayList<>();
		list = db.boardLoader(page);
		loadCheck = listLoader(list, "게시판");
		if(!(loadCheck)) {
			System.out.println("로딩오류발생!");
		}else {
			System.out.print("1. 게시글 보기\n2. 게시글 작성\n3. 페이지 이동\n4. 게시글 검색\n5. 종료\n선택해주세요 : ");
			user = scan.nextInt();
			scan.nextLine();
			if(user == 1) {
				readPost();	
			}else if(user == 2) {
				//게시글입력
			}else if(user == 3) {
				//페이지 받아서 처리하기(없으면 없다고 말해줌)
			}else if(user == 4) {
				//검색방법 선택 후 검색(없으면 없다고 말해줌)
			}else {
				//종료
			}
		}
	}
	
	public void readPost() {
		db = new BoardDBM();
		List<BoardVO> list = new ArrayList<>();
		int num;
		System.out.print("보고싶은 게시글의 번호을 입력해주세요 : ");
		num = scan.nextInt();
		scan.nextLine();
		list = db.read(num);
		if(listLoader(list, "게시글읽기")) {
			list.clear();
			list = db.readComm(num);
			if(!(listLoader(list, "댓글"))) {
				System.out.println("등록된 댓글이 없습니다.");
			}
		}else {
			System.out.println("존재하지 않는 게시글입니다.");
		}
		
	}
	
	
	private boolean listLoader(List<BoardVO> list, String type) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String content;
		if(list.size() == 0) {
			System.out.print("빈 리스트입니다 : ");
			return false;
		}else {
			System.out.println("-------------------------------------");
			for (BoardVO vo : list) {
				if(type.equals("게시판")) {
					System.out.println(vo.post_no+" | "+vo.date+" | "+vo.title);
					
				}else if(type.equals("게시글읽기")) {
					System.out.print("제목 "+ vo.title+"\n\n작성자 : "+vo.id+"\n작성일 "+df.format(vo.date)+"\n\n");
					content = vo.post_content;
					lineChanger(content);
					
				}else if(type.equals("댓글")) {
					System.out.print("작성자 : "+vo.id+"\t작성일 : "+vo.date+"\n");
					content = vo.comm_content;
					lineChanger(content);
					
				}else {
					System.out.println("공사중입니다");
					return false;
				}
				
			}
			System.out.println("-------------------------------------");
		}
		return true;
	}
	
	private void lineChanger(String str) {
		int pointer;
		for(int i = 0; i < str.length();i++) {
			pointer = 30*(i+1);
			if(pointer > str.length()) {
				System.out.println(str.substring(i*30));
				break;
			}else {
				System.out.println(str.substring(i*30, pointer)+"\n");
			}
			
		}
	}
}
