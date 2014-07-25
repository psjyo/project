package com.biz;

import java.awt.Image;

import com.dao.MemberDAO;

public class MemberBiz {
	public int CreateMember(int m_no, String name, String id, String passwd, String std_no) {
		MemberDAO dao = new MemberDAO();
		return dao.CreateMember(m_no,name, id, passwd, std_no);
	}
	
	public int DeleteMember(String std_no) {
		MemberDAO dao = new MemberDAO();
		return dao.DeleteMember(std_no);
		
	}
	
	public int UpdateMember(String passwd, String std_no){
		MemberDAO dao = new MemberDAO();
		return dao.UpdateMember(passwd, std_no);
	}

}
