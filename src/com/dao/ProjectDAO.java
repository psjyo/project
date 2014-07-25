package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.ProjectDTO;

public class ProjectDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "project";
	String passwd = "project";
	
	public ProjectDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(int pro_no,String leader_no,String member1,String member2,String member3,String member4, String pro_title){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "insert into info(pro_no,leader_no,member1,member2,member3,member4, pro_title) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pro_no);
			pstmt.setString(2, leader_no);
			pstmt.setString(3, member1);
			pstmt.setString(4, member2);
			pstmt.setString(5, member3);
			pstmt.setString(6, member4);
			pstmt.setString(7, pro_title);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
	
	public int delete(int pro_no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "delete from info where pro_no = ?";
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)
				pstmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public ArrayList<ProjectDTO> select(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProjectDTO> list = new ArrayList<ProjectDTO>();
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "select * from info";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int pro_no = rs.getInt(1);
				String leader_no = rs.getString(2);
				String member1 = rs.getString(3);
				String member2 = rs.getString(4);
				String member3 = rs.getString(5);
				String member4 = rs.getString(6);
				String pro_title = rs.getString(7);
				
				//System.out.println(name + "\t" + age + "\t" + weight + "\t" + height + "\t" + gender);
				// DeptDTO ¿˙¿Â
				ProjectDTO dto = new ProjectDTO(pro_no,leader_no,member1,member2,member3,member4, pro_title);
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
				rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	

}
