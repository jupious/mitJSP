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
	
	@Override
	public String toString() {
		return "BoardVO [post_no=" + post_no + ", post_count=" + post_count + ", comm_count=" + comm_count + ", id="
				+ id + ", comm_id=" + comm_id + ", password=" + password + ", name=" + name + ", title=" + title
				+ ", post_content=" + post_content + ", comm_content=" + comm_content + ", date=" + date + "]";
	}
	
}
