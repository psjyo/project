package com.dto;

public class ProjectDTO {
	int pro_no;
	String leader_no;
	String member1;
	String member2;
	String member3;
	String member4;
	String pro_title;
	
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectDTO(int pro_no, String leader_no, String member1,
			String member2, String member3, String member4, String pro_title) {
		super();
		this.pro_no = pro_no;
		this.leader_no = leader_no;
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
		this.member4 = member4;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public String getLeader_no() {
		return leader_no;
	}
	public void setLeader_no(String leader_no) {
		this.leader_no = leader_no;
	}
	public String getMember1() {
		return member1;
	}
	public void setMember1(String member1) {
		this.member1 = member1;
	}
	public String getMember2() {
		return member2;
	}
	public void setMember2(String member2) {
		this.member2 = member2;
	}
	public String getMember3() {
		return member3;
	}
	public void setMember3(String member3) {
		this.member3 = member3;
	}
	public String getMember4() {
		return member4;
	}
	public void setMember4(String member4) {
		this.member4 = member4;
	}
	public String getPro_title() {
		return pro_title;
	}
	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}
	
	
}
