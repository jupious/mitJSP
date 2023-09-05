package model;

public class NameVO {
	private String name1;
	private String name2;
	private int percent;
	
	public NameVO(String name1, String name2, int percent) {
		this.name1 = name1;
		this.name2 = name2;
		this.percent = percent;
	}
	
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
}
