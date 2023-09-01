package kr.mit.c305;

public class MainSchedule {

	public static void main(String[] args) {
		Display display = new Display();
		ToDoClass toDoClass = new ToDoClass();
		int menunum;
		String isYes;
		
		display.title();
		do {
			menunum = display.menu();
			System.out.println();
			if(menunum == 1) {
				toDoClass.toDo();
				
			}else if(menunum == 2) {
				toDoClass.closestdSchedule();
				
			}else if(menunum == 3) {
				do {
					isYes = toDoClass.toDoManager();
					System.out.println("\n");
					}while(isYes.equals("y"));
			}else if(menunum == 4) {
				toDoClass.searchSchedule();
			}else if(menunum == 5) {
				//원하는 일정 남은날짜보기
				toDoClass.getDDay();
			}else if(menunum == 6) {
				int flag;
				do {
				flag = toDoClass.incompleteList();
				}while(flag == 1);
			}else if(menunum == 7) {
				toDoClass.scheduleDelete();
			}
			
		}while(menunum != 7);
		
		display.end();
	}

}
