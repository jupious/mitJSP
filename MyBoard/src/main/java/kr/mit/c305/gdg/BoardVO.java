package kr.mit.c305.gdg;

import java.util.*;

public class BoardVO {
	int post_no;
	int post_count;
	int comm_count;
	
	String id;
	String comm_id;
	String password;
	String name;
	String title;
	String post_content;
	String comm_content;
	
	Date date;
	
	

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public int getPost_count() {
		return post_count;
	}

	public void setPost_count(int post_count) {
		this.post_count = post_count;
	}

	public int getComm_count() {
		return comm_count;
	}

	public void setComm_count(int comm_count) {
		this.comm_count = comm_count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComm_id() {
		return comm_id;
	}

	public void setComm_id(String comm_id) {
		this.comm_id = comm_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "BoardVO [post_no=" + post_no + ", post_count=" + post_count + ", comm_count=" + comm_count + ", id="
				+ id + ", comm_id=" + comm_id + ", password=" + password + ", name=" + name + ", title=" + title
				+ ", post_content=" + post_content + ", comm_content=" + comm_content + ", date=" + date + "]";
	}
}
