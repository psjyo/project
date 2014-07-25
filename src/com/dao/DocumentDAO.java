package com.dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.DocumentDTO;
import com.dto.MemberDTO;

public class DocumentDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "project";
	String passwd = "project";
	public DocumentDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int insert(int doc_no, String title, String contents, Date date,
			String data, int m_no){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "insert into docu(doc_no, title, contents, date,data, m_no) values(?,?,?,?,?,?)";
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
	
	public int delete(int doc_no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "delete from doc where doc_no = ?";
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public ArrayList<DocumentDTO> select(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DocumentDTO> list = new ArrayList<DocumentDTO>();
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String sql = "select * from customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int doc_no = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				Date date = rs.getDate(4);
				String data = rs.getString(5);
				int m_no = rs.getInt(6);
				
				//System.out.println(name + "\t" + age + "\t" + weight + "\t" + height + "\t" + gender);
				// DeptDTO 저장
				DocumentDTO dto = new DocumentDTO(doc_no,title, contents, date,data, m_no);
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
	
	
	public ArrayList<DocumentDTO> search(){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		ArrayList<DocumentDTO> list = new ArrayList<DocumentDTO>();
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "select title, contents, date, data from docu where doc_no like '_%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int doc_no = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				Date date = rs.getDate(4);
				String data = rs.getString(5);
				int m_no = rs.getInt(6);
				
				//System.out.println(name + "\t" + age + "\t" + weight + "\t" + height + "\t" + gender);
				// DeptDTO 저장
				DocumentDTO dto = new DocumentDTO(doc_no, title, contents, date, data, m_no);
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
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
		
	}
	
	
	
	
	
	
	

}
