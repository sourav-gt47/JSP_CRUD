<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.beans.*,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trainee Details</title>
</head>
<body>
	<%=request.getAttribute("updateStatus")!=null?request.getAttribute("updateStatus"):"" %>
	<%=request.getAttribute("deletestatus")!=null?request.getAttribute("deletestatus"):"" %>
	<%SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY"); %>
	<%ArrayList<TraineeDetails> traineeList = (ArrayList<TraineeDetails>)request.getAttribute("traineeList");%>
	<table border=1 align=center style="border-collapse:collapse">
	<tr>
		<th>Emp Id</th>
		<th>Emp Name</th>
		<th>Gender</th>
		<th>DOB</th>
		<th>Citizenship Status</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%
	for(TraineeDetails trainee:traineeList)
	{
	%>
	<tr>
		<td><%= trainee.getEmpid() %></td>
		<td><%= trainee.getName() %></td>
		<td><%= trainee.getGender() %></td>
		<td><%=formatter.format(trainee.getDob()) %></td>
		<td><%= trainee.getCitizenshipstatus() %></td>
		<td><a href="MainController?actionVal=updateFetch&empid=<%=trainee.getEmpid()%>&empName=<%=trainee.getName()%>&gender=<%=trainee.getGender()%>&dob=<%=trainee.getDob()%>&status=<%=trainee.getCitizenshipstatus()%>">Edit</a></td>
		<td><a href="MainController?actionVal=delete&empid=<%=trainee.getEmpid()%>">Delete</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>