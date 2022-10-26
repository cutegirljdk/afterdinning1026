package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
=======
import java.sql.ResultSet;
>>>>>>> branch 'main' of https://github.com/cutegirljdk/afterdinning1026.git
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	private DataSource dataSource; 
	private MemberDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource(); 
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	public  Connection getConnection() throws SQLException{
		return dataSource.getConnection(); 
	}
	
<<<<<<< HEAD
	public void register(MemberVO memberVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="INSERT INTO member(id,password,name) VALUES(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.executeUpdate();
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}		
	}
	
=======
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
>>>>>>> branch 'main' of https://github.com/cutegirljdk/afterdinning1026.git
}
