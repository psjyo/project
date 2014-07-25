package com.biz;

import com.dao.ProjectDAO;

public class ProjectBiz {
	
	public int insert(int pro_no,String leader_no,String member1,String member2,String member3,String member4, String pro_title){
		ProjectDAO dao = new ProjectDAO();
		return dao.insert(pro_no, leader_no, member1, member2, member3, member4, pro_title);
	}
	
	public int delete(int pro_no){
		ProjectDAO dao = new ProjectDAO();
		return dao.delete(pro_no);
	}

}
