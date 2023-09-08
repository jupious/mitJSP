package model;

import java.util.Date;

public class ChatVO {
	private String name;
	private String pw;
	private String text;
	private Date chattime;
	private Integer chatcount;
	
	public ChatVO() {}
	
	public ChatVO(String name, String pw, String text, Date chattime) {
		this.name = name;
		this.pw = pw;
		this.text = text;
		this.chattime = chattime;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getChattime() {
		return chattime;
	}
	
	public void setChattime(Date chattime) {
		this.chattime = chattime;
	}

	public Integer getChatcount() {
		return chatcount;
	}

	public void setChatcount(Integer chatcount) {
		this.chatcount = chatcount;
	}

	@Override
	public String toString() {
		return "ChatVO [name=" + name + ", pw=" + pw + ", text=" + text + ", chattime=" + chattime + ", chatcount="
				+ chatcount + "]";
	}
	
	
}
