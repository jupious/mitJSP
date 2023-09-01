package kr.mit.c305;

import java.util.List;

public interface InterDBClass {
	//1. 목록 가져오기
	List<ToDoVo> list();
	
	//2.일정 입력
	void input(ToDoVo vo);
	
	//3-1. 미완료 목록 가져오기
	List<ToDoVo> inCompleteList();
	
	//3-2. 미완료 일정 완료하기
	void complete(int no);
	
	//4. 일정 삭제하기
	void delete(int no);
}
