package kr.mit.c305;


import java.text.SimpleDateFormat;
import java.util.*;


public class ToDoClass implements InterToDoClass {
	Scanner scan = new Scanner(System.in);
	DBClass db;
	
	//전체일정 출력메소드
	@Override
	public void toDo() {	
		//DB연결해서 목록을 가져오기
		db = new DBClass();
		List<ToDoVo> list = new ArrayList<>();
		list=db.list();
		if(list != null) {
			listLoader(list);
			System.out.println("현재 " + db.inCompleteCount()+"개의 미완료 일정이 있습니다.\n");
		}else
			System.out.println("등록된 일정이 없습니다.\n");
	}

	//일정 입력메소드
	@Override
	public String toDoManager() {
		ToDoVo vo = new ToDoVo();
		db = new DBClass();
		String tempStr;
		System.out.print("날짜 입력(yyyy-MM-dd): ");
		tempStr=scan.nextLine();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date datenow = new Date();
		try {
			date = df.parse(tempStr);
			long diff = date.getTime() - datenow.getTime();
			long diffDays = diff/(1000*60*60*24);
			if(diffDays<0) {
				System.out.println("과거의 일정은 등록할 수 없습니다.");
				return "y";
			}
		}catch(Exception e) {
			System.out.println("오늘날짜로 입력되었습니다.");
		}
		vo.date = date;
		System.out.print("내용 입력: ");
		vo.content=scan.nextLine();
		vo.no = 1;
		db.input(vo);

		System.out.print("계속 입력하시겠습니까?(y/n): ");
		
		return scan.nextLine();
	}
	
	//일정 완료하기 메소드
	@Override
	public int incompleteList() {
		int user;
		List<ToDoVo> list = new ArrayList<>();
		db = new DBClass();
		
		
		do {
			list = db.inCompleteList();
			if(list == null) {
				System.out.println("모든 일정이 완료되었습니다.\n");
				user = 0;
				
			}else {
				listLoader(list);
				System.out.print("몇번 일정을 완료하시겠습니까? or 종료하기(0)");
				user = scan.nextInt();
				scan.nextLine();
				if(user != 0) {	
					db.complete(user);			
				}
			}			
			System.out.println();
		}while(user != 0);
		return user;
	}

	
	//일정 삭제 메소드
	@Override
	public void scheduleDelete() {
		int user = 0;
		db = new DBClass();
		List<ToDoVo> list = new ArrayList<>();
		
		
		do {
			if(list != null) {
				list = db.list();
				listLoader(list);
				System.out.print("삭제할 일정의 번호를 입력해주세요 or 종료(0): ");
				user = scan.nextInt();
				scan.nextLine();
				if(user!=0) {
					db.delete(user);
				}
			}else {
				System.out.println("삭제할 일정이 없습니다.");
			}
		}while(user != 0);
	
	}
	
	//근접일정 + 남은날짜 메소드
	@Override
	public void closestdSchedule() {
		db = new DBClass();
		List<ToDoVo> list = new ArrayList<>();
		Date date = new Date();
		int no, dateRemain;
		list = db.getClosest();
		
		
		if(list != null) {
			System.out.println("가장 근접한 일정");
			listLoader(list);
			no = list.get(0).no;
			dateRemain = db.getDDay(no);
			if(dateRemain == 0) {
				System.out.println("해당 일정 당일입니다.");
			}else if(dateRemain > 0) {
				System.out.println("남은 날짜는 "+ dateRemain+"일 입니다.");
			}else
				System.out.println("해당 일정으로부터 "+ (dateRemain*-1)+"일 지났습니다.");
			
		}else
			System.out.println("일정이 없습니다.");
		
	}
	
	//원하는 날짜의 남은날짜 메소드
	public void getDDay() {
		db = new DBClass();
		Date date = new Date();
		ToDoVo vo = new ToDoVo();
		int num = 0, dateRemain;
		toDo();
	
		System.out.print("확인하고싶은 일정의 번호를 입력해주세요.: ");
		num = scan.nextInt();
		scan.nextLine();
		
		dateRemain = db.getDDay(num);
		if(dateRemain == 0) {
			System.out.println("해당 일정 당일입니다.");
		}else if(dateRemain > 0) {
			System.out.println("남은 날짜는 "+ dateRemain+"일 입니다.");
		}else
			System.out.println("해당 일정으로부터 "+ (dateRemain*-1)+"일 지났습니다.");

		
	}
	
	//일정 내용으로 검색
	public void searchSchedule() {
		List<ToDoVo> list = new ArrayList<>();
		db = new DBClass();
		System.out.print("검색할 단어를 입력해주세요: ");
		list = db.search(scan.nextLine());
		if(list != null) {
			listLoader(list);
		}else
			System.out.println("검색 결과가 없습니다.\n");
	}
	
	
	//리스트 출력용 메소드
	private void listLoader(List<ToDoVo> list) {
		String str = null;
		System.out.println("-----------------------------------");
		for (ToDoVo vo : list) {
			if(vo.isComplete)
				str = "완료";
			else
				str = "미완료";
			
			System.out.println(vo.no+" "+vo.date+" "+ vo.content + " " + str);
		}
		System.out.println("-----------------------------------\n");
	}
}
