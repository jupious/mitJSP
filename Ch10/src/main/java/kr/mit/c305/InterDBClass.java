package kr.mit.c305;

import java.util.List;

public interface InterDBClass {
	//1. ��� ��������
	List<ToDoVo> list();
	
	//2.���� �Է�
	void input(ToDoVo vo);
	
	//3-1. �̿Ϸ� ��� ��������
	List<ToDoVo> inCompleteList();
	
	//3-2. �̿Ϸ� ���� �Ϸ��ϱ�
	void complete(int no);
	
	//4. ���� �����ϱ�
	void delete(int no);
}
