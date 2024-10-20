package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.TraineeDetails;
import com.utility.DbUtility;

public class TraineeDAO {
	
	public int registerTrainee(TraineeDetails trainee)
	{
		DbUtility db = new DbUtility();
		Connection conn = db.connectDB();
		PreparedStatement ps = null;
		String sql = "insert into Trainee(empId, name, gender, dob, citizenshipStatus) values(?,?,?,?,?)";
		int rowsAffected = 0;
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, trainee.getEmpid());
			ps.setString(2, trainee.getName());
			ps.setString(3, trainee.getGender());
			ps.setDate(4, trainee.getDob());
			ps.setString(5, trainee.getCitizenshipstatus());
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		
		return rowsAffected;
	}
	
	public ArrayList<TraineeDetails> fetchAllTrainee()
	{
		DbUtility db = new DbUtility();
		Connection conn = db.connectDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TraineeDetails> traineeList = new ArrayList<TraineeDetails>();
		String sql = "select * from Trainee";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				traineeList.add(new TraineeDetails(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return traineeList;
	}
	
	public int updateTraineeByEmpId(TraineeDetails trainee)
	{

		DbUtility db = new DbUtility();
		Connection conn = db.connectDB();
		PreparedStatement ps = null;
		int rowsAffected = 0;
		String sql = "update Trainee set name=?,gender=?,dob=?,citizenshipStatus=? where empId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, trainee.getName());
			ps.setString(2, trainee.getGender());
			ps.setDate(3, trainee.getDob());
			ps.setString(4, trainee.getCitizenshipstatus());
			ps.setInt(5, trainee.getEmpid());
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return rowsAffected;
	}
	
	public int deleteTraineeByEmpId(int empid)
	{
		DbUtility db = new DbUtility();
		Connection conn = db.connectDB();
		PreparedStatement ps = null;
		int rowsAffected = 0;
		String sql = "delete from Trainee where empId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empid);
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return rowsAffected;
	}
}
