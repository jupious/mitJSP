package kr.mit.c305;


import java.text.SimpleDateFormat;
import java.util.*;


public class ToDoClass implements InterToDoClass {
	Scanner scan = new Scanner(System.in);
	DBClass db;
	
	//��ü���� ��¸޼ҵ�
	@Override
	public void toDo() {	
		//DB�����ؼ� ����� ��������
		db = new DBClass();
		List<ToDoVo> list = new ArrayList<>();
		list=db.list();
		if(list != null) {
			listLoader(list);
			System.out.println("���� " + db.inCompleteCount()+"���� �̿Ϸ� ������ �ֽ��ϴ�.\n");
		}else
			System.out.println("��ϵ� ������ �����ϴ�.\n");
	}

	//���� �Է¸޼ҵ�
	@Override
	public String toDoManager() {
		ToDoVo vo = new ToDoVo();
		db = new DBClass();
		String tempStr;
		System.out.print("��¥ �Է�(yyyy-MM-dd): ");
		tempStr=scan.nextLine();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date datenow = new Date();
		try {
			date = df.parse(tempStr);
			long diff = date.getTime() - datenow.getTime();
			long diffDays = diff/(1000*60*60*24);
			if(diffDays<0) {
				System.out.println("������ ������ ����� �� �����ϴ�.");
				return "y";
			}
		}catch(Exception e) {
			System.out.println("���ó�¥�� �ԷµǾ����ϴ�.");
		}
		vo.date = date;
		System.out.print("���� �Է�: ");
		vo.content=scan.nextLine();
		vo.no = 1;
		db.input(vo);

		System.out.print("��� �Է��Ͻðڽ��ϱ�?(y/n): ");
		
		return scan.nextLine();
	}
	
	//���� �Ϸ��ϱ� �޼ҵ�
	@Override
	public int incompleteList() {
		int user;
		List<ToDoVo> list = new ArrayList<>();
		db = new DBClass();
		
		
		do {
			list = db.inCompleteList();
			if(list == null) {
				System.out.println("��� ������ �Ϸ�Ǿ����ϴ�.\n");
				user = 0;
				
			}else {
				listLoader(list);
				System.out.print("��� ������ �Ϸ��Ͻðڽ��ϱ�? or �����ϱ�(0)");
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

	
	//���� ���� �޼ҵ�
	@Override
	public void scheduleDelete() {
		int user = 0;
		db = new DBClass();
		List<ToDoVo> list = new ArrayList<>();
		
		
		do {
			if(list != null) {
				list = db.list();
				listLoader(list);
				System.out.print("������ ������ ��ȣ�� �Է����ּ��� or ����(0): ");
				user = scan.nextInt();
				scan.nextLine();
				if(user!=0) {
					db.delete(user);
				}
			}else {
				System.out.println("������ ������ �����ϴ�.");
			}
		}while(user != 0);
	
	}
	
	//�������� + ������¥ �޼ҵ�
	@Override
	public void closestdSchedule() {
		db = new DBClass();
		List<ToDoVo> list = new ArrayList<>();
		Date date = new Date();
		int no, dateRemain;
		list = db.getClosest();
		
		
		if(list != null) {
			System.out.println("���� ������ ����");
			listLoader(list);
			no = list.get(0).no;
			dateRemain = db.getDDay(no);
			if(dateRemain == 0) {
				System.out.println("�ش� ���� �����Դϴ�.");
			}else if(dateRemain > 0) {
				System.out.println("���� ��¥�� "+ dateRemain+"�� �Դϴ�.");
			}else
				System.out.println("�ش� �������κ��� "+ (dateRemain*-1)+"�� �������ϴ�.");
			
		}else
			System.out.println("������ �����ϴ�.");
		
	}
	
	//���ϴ� ��¥�� ������¥ �޼ҵ�
	public void getDDay() {
		db = new DBClass();
		Date date = new Date();
		ToDoVo vo = new ToDoVo();
		int num = 0, dateRemain;
		toDo();
	
		System.out.print("Ȯ���ϰ���� ������ ��ȣ�� �Է����ּ���.: ");
		num = scan.nextInt();
		scan.nextLine();
		
		dateRemain = db.getDDay(num);
		if(dateRemain == 0) {
			System.out.println("�ش� ���� �����Դϴ�.");
		}else if(dateRemain > 0) {
			System.out.println("���� ��¥�� "+ dateRemain+"�� �Դϴ�.");
		}else
			System.out.println("�ش� �������κ��� "+ (dateRemain*-1)+"�� �������ϴ�.");

		
	}
	
	//���� �������� �˻�
	public void searchSchedule() {
		List<ToDoVo> list = new ArrayList<>();
		db = new DBClass();
		System.out.print("�˻��� �ܾ �Է����ּ���: ");
		list = db.search(scan.nextLine());
		if(list != null) {
			listLoader(list);
		}else
			System.out.println("�˻� ����� �����ϴ�.\n");
	}
	
	
	//����Ʈ ��¿� �޼ҵ�
	private void listLoader(List<ToDoVo> list) {
		String str = null;
		System.out.println("-----------------------------------");
		for (ToDoVo vo : list) {
			if(vo.isComplete)
				str = "�Ϸ�";
			else
				str = "�̿Ϸ�";
			
			System.out.println(vo.no+" "+vo.date+" "+ vo.content + " " + str);
		}
		System.out.println("-----------------------------------\n");
	}
}
