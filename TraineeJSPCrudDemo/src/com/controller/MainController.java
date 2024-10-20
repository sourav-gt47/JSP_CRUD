package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.TraineeDetails;
import com.service.TraineeService;
import com.utility.Utility;

@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("actionVal");
		TraineeService traineeService = new TraineeService();
		if(action.equals("insert"))
		{
			int empId = Integer.parseInt(request.getParameter("empId"));
			String empName = request.getParameter("empName");
			String gender = request.getParameter("gender");
			java.sql.Date dob = Utility.convertStringToSQLDate(request.getParameter("dob"));
			String status = request.getParameter("status");
			
			TraineeDetails trainee = new TraineeDetails(empId, empName, gender, dob, status);
			int rowsAffected = traineeService.registerTrainee(trainee);
			if(rowsAffected!=0)
			{
				request.setAttribute("status", "<font color=blue>Insert Successful</font>");
			}
			else
			{
				request.setAttribute("status", "<font color=red>Insert Unsuccessful</font>");
			}
			RequestDispatcher rd = request.getRequestDispatcher("RegisterDetails.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("fetchAll"))
		{
			ArrayList<TraineeDetails> traineeList = traineeService.fetchAllTrainees();
			request.setAttribute("traineeList", traineeList);
			RequestDispatcher rd = request.getRequestDispatcher("FetchDetails.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("updateFetch"))
		{
			request.setAttribute("empId", request.getParameter("empid"));
			request.setAttribute("empName", request.getParameter("empName"));
			request.setAttribute("gender", request.getParameter("gender"));
			request.setAttribute("dob", request.getParameter("dob"));
			request.setAttribute("status", request.getParameter("status"));
			
			RequestDispatcher rd = request.getRequestDispatcher("UpdateDetails.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("updateConfirm"))
		{
			int empId = Integer.parseInt(request.getParameter("empId"));
			String empName = request.getParameter("empName");
			String gender = request.getParameter("gender");
			java.sql.Date dob = Utility.convertStringToSQLDate(request.getParameter("dob"));
			String status = request.getParameter("status");
			
			TraineeDetails trainee = new TraineeDetails(empId, empName, gender, dob, status);
			int rowsAffected = traineeService.updateTraineeByEmpId(trainee);
			if(rowsAffected!=0)
			{
				request.setAttribute("updateStatus", "<font color=blue>Update Successful</font>");
			}
			else
			{
				request.setAttribute("updateStatus", "<font color=red>Update Unsuccessful</font>");
			}
			
			ArrayList<TraineeDetails> traineeList = traineeService.fetchAllTrainees();
			request.setAttribute("traineeList", traineeList);
			RequestDispatcher rd = request.getRequestDispatcher("FetchDetails.jsp");
			rd.forward(request, response);
			
		}
		else if(action.equals("delete"))
		{
			int empId = Integer.parseInt(request.getParameter("empid"));
			int rowsAffected = traineeService.deleteTraineeByEmpId(empId);
			if(rowsAffected!=0)
			{
				request.setAttribute("deletestatus", "<font color=blue>Delete Successful</font>");
			}
			else
			{
				request.setAttribute("deletestatus", "<font color=red>Delete Unsuccessful</font>");
			}
			ArrayList<TraineeDetails> traineeList = traineeService.fetchAllTrainees();
			request.setAttribute("traineeList", traineeList);
			RequestDispatcher rd = request.getRequestDispatcher("FetchDetails.jsp");
			rd.forward(request, response);
		}
	}

}
