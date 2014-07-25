package com.dto;

import java.sql.Date;

public class DocumentDTO {
	
	int doc_no;
	String title;
	String contents;
	Date date;
	String data;
	int m_no;
	public DocumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DocumentDTO(int doc_no, String title, String contents, Date date,
			String data, int m_no) {
		super();
		this.doc_no = doc_no;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.data = data;
		this.m_no = m_no;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	

}
