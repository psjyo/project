package com.biz;

import java.awt.Image;

import com.dao.MemberDAO;

public class MemberBiz {
	public int CreateMember(int m_no, String id, String passwd, String std_no,
			Image img, String name) {
		MemberDAO dao = new MemberDAO();
		return dao.CreateMember(id, passwd, std_no,name);
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
