package com.biz;

import java.util.ArrayList;

import com.dao.ProjectInfoDAO;
import com.dto.ProjectInfoDTO;

public class ProjectInfoBiz {
	
	public ArrayList<ProjectInfoDTO> select(){
		ProjectInfoDAO dao = new ProjectInfoDAO();
		return  dao.select();
	}

}
