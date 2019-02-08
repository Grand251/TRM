<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Employees</h1>
	<br>
	<table border="2">
		<tr>
			<th id="employee_id">ID</th>
			<th id="last_name">Last Name</th>
			<th id="first_name">First Name</th>
			<th id="user_name">Username</th>
			<th id="phone_number">Phone Number</th>
			<th id="email">E-mail Address</th>
			<th id="street">Street</th>
			<th id="city">City</th>
			<th id="state">State</th>
			<th id="country">Country</th>
			<th id="job_title">Job Title</th>
			<th id="vertical">Vertical</th>
			<th id="project">Project</th>
			<th id="pid">Project ID</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.employee_id}</td>
				<td>${employee.last_name}</td>
				<td>${employee.first_name}</td>
				<td>${employee.user_name}</td>
				<td>${employee.phone_number}</td>
				<td>${employee.email}</td>
				<td>${employee.street}</td>
				<td>${employee.city}</td>
				<td>${employee.state}</td>
				<td>${employee.country}</td>
				<td>${employee.job_title}</td>
				<td>${employee.vertical}</td>
				<td>${employee.project}</td>
				<td>${employee.pid}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>