package kr.mit.c305;

import java.util.Date;

public class ToDoVo {
	int no;
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	Date date;
	String content;
	Boolean isComplete;
	
	public ToDoVo (int no,Date date, String content, Boolean isComplete){
		this.no = no;
		this.date = date;
		this.content = content;
		this.isComplete = isComplete;
	}
	
	public ToDoVo() {
		
	}

	@Override
	public String toString() {
		return "ToDoVo [no=" + no + ", date=" + date + ", content=" + content + ", isComplete=" + isComplete + "]";
	}
}
