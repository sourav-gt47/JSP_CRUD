package com.service;

import java.util.ArrayList;

import com.beans.TraineeDetails;
import com.dao.TraineeDAO;

public class TraineeService {
	
	TraineeDAO traineeDAO = new TraineeDAO();
	public int registerTrainee(TraineeDetails trainee)
	{
		return traineeDAO.registerTrainee(trainee);
	}
	public ArrayList<TraineeDetails> fetchAllTrainees()
	{
		return traineeDAO.fetchAllTrainee();
	}
	public int updateTraineeByEmpId(TraineeDetails trainee)
	{
		return traineeDAO.updateTraineeByEmpId(trainee);
	}
	public int deleteTraineeByEmpId(int empid)
	{
		return traineeDAO.deleteTraineeByEmpId(empid);
	}
}
