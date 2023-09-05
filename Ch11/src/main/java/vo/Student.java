package vo;

public class Student {
	private String name; //이름
	private String no;	 //학번
	private String tel;	 //전화번호
	
	public Student() {}
	
	public Student(String name, String no, String tel) {
		this.name = name;
		this.no = no;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
}
