package vo;

import java.util.Date;

public class MyFileDTO {
	//자바빈규칙
	//1. 기본생성자를 가지고 있어야한다.
	//2. 빈이 패키지화 되어있어야한다.(패키지 안에 있어야한다)
	//3. 멤버 변수의 접근자는 private으로 선언한다.
	//4. 멤버 변수의 접근하기 위해 public의 getter/setter 메소드가 존재해야 한다.
	
	private Long idx;
	private String title;
	private String cate;
	private String ofile;
	private String sfile;
	private Date postdate;

	
	public MyFileDTO() {}
	
	public MyFileDTO(Long idx, String title, String cate, String ofile, String sfile, Date postdate) {
		this.idx = idx;
		this.title = title;
		this.cate = cate;
		this.ofile = ofile;
		this.sfile = sfile;
		this.postdate = postdate;
	
	}
	
	public Long getIdx() {
		return idx;
	}
	
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCate() {
		return cate;
	}
	
	public void setCate(String cate) {
		this.cate = cate;
	}
	
	public String getOfile() {
		return ofile;
	}
	
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	
	public String getSfile() {
		return sfile;
	}
	
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	
	public Date getPostdate() {
		return postdate;
	}
	
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}



	@Override
	public String toString() {
		return "MyFileDTO [idx=" + idx + ", title=" + title + ", cate=" + cate + ", ofile=" + ofile + ", sfile=" + sfile
				+ ", postdate=" + postdate + "]";
	}

	
	
	
	
}
