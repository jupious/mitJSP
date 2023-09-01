package vo;
//JavaBean 
public class ToDoVO {
	private String todo;
	private String todoDate;
	private String name;
	
	public ToDoVO(String todo, String todoDate, String name) {
		this.todo = todo;
		this.todoDate = todoDate;
		this.name = name;
	}
	
	public String getTodo() {
		return todo;
	}
	
	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	public String getTodoDate() {
		return todoDate;
	}
	
	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
