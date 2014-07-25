package com.biz;

import java.sql.Date;

import com.dao.DocumentDAO;

public class DocumentBiz {
	
	public int insert(int doc_no, String title, String contents, Date date,
			String data, int m_no){
		DocumentDAO dao = new DocumentDAO();
		return dao.insert(doc_no, title, contents, date, data, m_no);
	}
	
	public int delete(int doc_no){
		DocumentDAO dao = new DocumentDAO();
		return dao.delete(doc_no);
	}
	
	

}
