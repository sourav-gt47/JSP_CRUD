<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Trainee</title>
</head>
<body>
	<a href="menu.html"></a>
	<h3 align=center>Trainee Details Updation</h3>
	<!--<%=request.getAttribute("status")!=null?request.getAttribute("status"):"" %>-->
	<form action="<%=request.getContextPath()%>/MainController?actionVal=updateConfirm" method="post">
		<table align=center>
			<tr>
				<td>Employee Id</td>
				<td><input name="empId" type="text" value="<%=(String) request.getAttribute("empId")%>" readonly></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input name="empName" type="text" value="<%=(String) request.getAttribute("empName")%>"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<% String gender = (String) request.getAttribute("gender"); %>
					Male <input type="radio" name="gender" value="male" <%=gender.equals("male")?"checked":""%>>
					Female <input type="radio" name="gender" value="female" <%=gender.equals("female")?"checked":""%>>
				</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input name="dob" type="date" value="<%=(String) request.getAttribute("dob")%>"></td>
			</tr>
			<tr>
				<% String citizenshipStatus = (String) request.getAttribute("status");%>
				<td>Citizenship Status</td>
				<td>
					<select name="status">
						<option value="Citizen" <%=citizenshipStatus.equals("Citizen")?"selected":""%>>Citizen</option>
						<option value="PR" <%=citizenshipStatus.equals("PR")?"selected":""%>>PR</option>
					</select>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan=2 align=center><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>