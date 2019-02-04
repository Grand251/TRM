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
	<h3>Requests</h3>
	<hr size="4" color="red"/>
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Trainer Name</th>
				<th scope="col">Trainer Email</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requests}" var="request">
				<tr>
					<th scope="row">
						<button type="button" class="btn btn-info btn-expand">Expand</button>
						<span style="margin-left: 15px">
							${request.id}
						</span>
						<div style="margin-top: 15px; display: none;" >
							<table class="table" style="background-color: transparent;">
								<thead>
									<tr>
										<th scope="col">Type</th>
										<th scope="col">Value</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Status</td>
										<td>${request.status}</td>
									</tr>
									<tr>
										<td>SPOC Name</td>
										<td>${request.spocName}</td>
									</tr>
									<tr>
										<td>SPOC Email</td>
										<td>${request.spocEmail}</td>
									</tr>
									<tr>
										<td>Trainer Name</td>
										<td>${request.trainerName}</td>
									</tr>
									<tr>
										<td>Trainer Email</td>
										<td>${request.trainerEmail}</td>
									</tr>
									<tr>
										<td>Mode</td>
										<td>${request.mode}</td>
									</tr>
									<tr>
										<td>Training Type</td>
										<td>${request.type}</td>
									</tr>
									<tr>
										<td>Training Subject</td>
										<td>${request.scope}</td>
									</tr>
									<tr>
										<td># of Participants</td>
										<td>${request.participants}</td>
									</tr>
									<tr>
										<td>Requested Start Time</td>
										<td>${request.requestedTimeZone} ${request.requestedStartTime}</td>
									</tr>
									<tr>
										<td>Requested End Time</td>
										<td>${request.requestedTimeZone} ${request.requestedEndTime}</td>
									</tr>
									<c:if test="${request.isItr}">
											<tr>
												<td>Start Time</td>
												<td>${request.timeZone} ${request.startTime}</td>
											</tr>
											<tr>
												<td>End Time</td>
												<td>${request.timeZone} ${endTime}</td>
											</tr>
									</c:if>
									<tr>
										<td>Location</td>
										<td>${request.location}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</th>
					<td>${request.trainerName}</td>
					<td>${request.trainerEmail}</td>		
					<td>
						<div class="container">
							<a href='requests/${request.id}/delete'>Delete</a>
							|
							<a href='editrequest/${request.id}'>Edit</a>
							<c:if test="${request.status == 4}">
								|
								<a href='approve/${request.id}'>Approve</a>
							</c:if>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>