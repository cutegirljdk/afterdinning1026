package org.kosta.myproject.model;

import java.sql.Connection;
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
	
}
