package model;

public class MstVO {
	private String code;
	private String pname;
	private Integer cost;
	private Integer pnum;
	private Integer jnum;
	private Integer sale;
	private String gcode;
	private String gname;
	private String ogCode;
	
	public MstVO() {}
	
	public MstVO(String code, String pname, int cost, int pnum, int jnum, int sale, String gcode, String gname) {
		this.code = code;
		this.pname = pname;
		this.cost = cost;
		this.pnum = pnum;
		this.jnum = jnum;
		this.sale = sale;
		this.gcode = gcode;
		this.gname = gname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getJnum() {
		return jnum;
	}
	public void setJnum(int jnum) {
		this.jnum = jnum;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	public String getOgCode() {
		return ogCode;
	}

	public void setOgCode(String ogCode) {
		this.ogCode = ogCode;
	}

	@Override
	public String toString() {
		return "MstVO [code=" + code + ", pname=" + pname + ", cost=" + cost + ", pnum=" + pnum + ", jnum=" + jnum
				+ ", sale=" + sale + ", gcode=" + gcode + ", gname=" + gname + "]";
	}
	
	
}
