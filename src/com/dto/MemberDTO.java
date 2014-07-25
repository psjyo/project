package com.dto;

import java.awt.Image;

public class MemberDTO {
	
	int m_no;
	String id;
	String passwd;
	String std_no;
	//Image img;
	String name;
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(int m_no, String name, String id, String passwd, String std_no) {
		super();
		this.m_no = m_no;
		this.id = id;
		this.passwd = passwd;
		this.std_no = std_no;
		//this.img = img;
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStd_no() {
		return std_no;
	}
	public void setStd_no(String std_no) {
		this.std_no = std_no;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
