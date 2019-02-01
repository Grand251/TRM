<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Dashboard</h1>
	<br>
	<br>
	<h3>New Requests</h3>
	<hr size="4" color="red"/>
	<table border="2">
	<c:forEach items="${newReq}" var="request">
		<tr>
			<td>${request.trainingRequestId}</td>
			<td>${request.requestTrainingType}</td>
			<td>${request.requestStartTime}</td>
			<td>${request.requestEndTime}</td>
			
			<td><a href='requests/${request.trainingRequestId}'>Delete</a></td>
			<td><a href='editrequest/${request.trainingRequestId}'>Edit</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>