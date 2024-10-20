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
	<h3 align=center>Trainee Registration</h3>
	<%=request.getAttribute("status")!=null?request.getAttribute("status"):"" %>
	<form action="<%= request.getContextPath() %>/MainController?actionVal=insert" method="post">
		<table align=center>
			<tr>
				<td>Employee Id</td>
				<td><input name="empId" type="text"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input name="empName" type="text"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					Male <input type="radio" name="gender" value="male">
					Female <input type="radio" name="gender" value="female">
				</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input name="dob" type="date"></td>
			</tr>
			<tr>
				<td>Citizenship Status</td>
				<td>
					<select name="status">
						<option value="Citizen">Citizen</option>
						<option value="PR">PR</option>
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