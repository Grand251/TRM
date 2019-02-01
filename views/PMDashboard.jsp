<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Dashboard</h1>
	<br>
	<br>
	<h3>New Requests</h3>
	<hr size="4" color="red"/>
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Type</th>
				<th scope="col">Start</th>
				<th scope="col">End</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${newReq}" var="request">
				<tr>
					<th scope="row">${request.trainingRequestId}</th>
					<td>${request.requestTrainingType}</td>
					<td>${request.requestStartTime}</td>
					<td>${request.requestEndTime}</td>
					
					<td>
						<div class="container">
							<a href='requests/${request.trainingRequestId}/delete'>Delete</a>
							<a href='editrequest/${request.trainingRequestId}'>Edit</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>