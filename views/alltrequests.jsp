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
	<h1>All Training Requests</h1>
	<br>
	<table border="2">
		<tr>
			<th id="trainingRequestId">ID</th>
			<th id="requesterId">Requester Employee ID</th>
			<th id="requestTrainingType">Training Type</th>
			<th id="requestTrainingModule">Training Module</th>
			<th id="requestTrainingModuleScope">Training Module Scope</th>
			<th id="requestTrainingMode">Training Mode</th>
			<th id="requestStartTime">Start Time</th>
			<th id="requestEndTime">End Time</th>
			<th id="requestLocation">Location</th>
			<th id="requestTimeZone">Time Zone</th>
			<th id="approxNumberOfParticipants">Approximate Number Of
				Participants</th>
			<th id="requestProjectSpoc">Project SPOC Employee ID</th>
			<th id="executiveId">Executive Employee ID</th>
			<th id="timeRequested">Time Requested</th>
		</tr>
		<c:forEach items="${trainingRequests}" var="trainingRequest">
			<tr>
				<td>${trainingRequest.trainingRequestId}</td>
				<td><a href="showallemployees">${trainingRequest.requesterId}</a></td>
				<td>${trainingRequest.requestTrainingType}</td>
				<td>${trainingRequest.requestTrainingModule}</td>
				<td>${trainingRequest.requestTrainingModuleScope}</td>
				<td>${trainingRequest.requestTrainingMode}</td>
				<td>${trainingRequest.requestStartTime}</td>
				<td>${trainingRequest.requestEndTime}</td>
				<td>${trainingRequest.requestLocation}</td>
				<td>${trainingRequest.requestTimeZone}</td>
				<td>${trainingRequest.approxNumberOfParticipants}</td>
				<td><a href="showallemployees">${trainingRequest.requestProjectSpoc}</a></td>
				<td><a href="showallemployees">${trainingRequest.executiveId}</a></td>
				<td>${trainingRequest.timeRequested}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>