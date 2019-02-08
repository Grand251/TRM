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
	<h1>All Internal Training Requests</h1>
	<br>
	<table border="2">
		<tr>
			<th id="itrStatus">Status</th>
			<th id="itrTrainerID">Trainer Employee ID</th>
			<th id="itrSpocID">SPOC Employee ID</th>
			<th id="itrTrainingRequestID">Training Request ID</th>
			<th id="itrMode">Mode</th>
			<th id="itrScheduleID">Training Schedule ID</th>
			<th id="itrStatusDescription">Status Description</th>
		</tr>
		<c:forEach items="${internalTrainingRequests}"
			var="internalTrainingRequest">
			<tr>
				<td>${internalTrainingRequest.itrStatus}</td>
				<td><a href="showallemployees">${internalTrainingRequest.itrTrainer.employee_id}</a></td>
				<td><a href="showallemployees">${internalTrainingRequest.itrSpoc.employee_id}</a></td>
				<td><a href="showalltr">${internalTrainingRequest.itrTrainingRequest.trainingRequestId}</a></td>
				<td>${internalTrainingRequest.itrMode}</td>
				<td><a href="showallschedules">${internalTrainingRequest.itrSchedule.training_schedule_id}</a></td>
				<td>${internalTrainingRequest.itrStatusDescription}</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>