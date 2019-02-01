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
<script>
	$(document).ready(function (){
		$(".btn-expand").click(function(){
			var table = $(this).eq(0).parent().find("div").eq(0);
			
			if (table.css("display") == "block")
			{
				table.css("display", "none");
			}
			else
			{
				table.css("display", "block");
			}
		});
	});
</script>
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
					<th scope="row">
						<button type="button" class="btn btn-info btn-expand">Expand</button>
						<span style="margin-left: 15px">
							${request.trainingRequestId}
						</span>
						<div style="margin-top: 15px; display: none;" >
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Type</th>
										<th scope="col">Value</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Executive Name</td>
										<td></td>
									</tr>
									<tr>
										<td>SPOC Name</td>
										<td></td>
									</tr>
									<tr>
										<td>Training Type</td>
										<td>${request.requestTrainingType}</td>
									</tr>
									<tr>
										<td>Module</td>
										<td>${request.requestTrainingModule}</td>
									</tr>
									<tr>
										<td>Module Scope</td>
										<td>${request.requestTrainingModuleScope}</td>
									</tr>
									<tr>
										<td>Mode</td>
										<td>${request.requestTrainingMode}</td>
									</tr>
									<tr>
										<td>Start</td>
										<td>${request.requestStartTime}</td>
									</tr>
									<tr>
										<td>End</td>
										<td>${request.requestEndTime}</td>
									</tr>
									<tr>
										<td>Location</td>
										<td>${request.requestLocation}</td>
									</tr>
									<tr>
										<td>Time Zone</td>
										<td>${request.requestTimeZone}</td>
									</tr>
									<tr>
										<td># of Participants</td>
										<td>${request.approxNumberOfParticipants}</td>
									</tr>
									<tr>
										<td>Time Requested</td>
										<td>${request.timeRequested}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</th>
					<td>${request.requestTrainingType}</td>
					<td>${request.requestStartTime}</td>
					<td>${request.requestEndTime}</td>
					
					<td>
						<div class="container">
							<a href='requests/${request.trainingRequestId}/delete'>Delete</a>
							|
							<a href='editrequest/${request.trainingRequestId}'>Edit</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>