package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.constants.DbConstants;

public class DbUtility {
	
	public Connection connectDB()
	{
		Connection conn = null;
		try
		{
			Class.forName(DbConstants.DRIVER);
			conn = DriverManager.getConnection(DbConstants.DBURL);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConnection(Connection conn)
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void closeStatement(PreparedStatement stmt)
	{
		try 
		{
			stmt.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
