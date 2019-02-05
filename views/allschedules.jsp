<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> All Training Schedules</h1>
<br>
	<table border="2">
		<tr>
	    	<th id="training_schedule_id">ID</th>
	    	<th id="training_city">City</th>
	    	<th id="training_state">State</th>
	    	<th id="training_country">Country</th>
	    	<th id="training_zipcode">Zip Code</th>
	    	<th id="training_time_zone">Time Zone</th>
	    	<th id="training_location">Training Location</th>
	    	<th id="training_room_number">Room Number</th>
	    	<th id="training_start_date">Start Date</th>
	    	<th id="training_end_date">End Date</th>
	    </tr>
		<c:forEach items="${trainingSchedules}" var="trainingSchedule">
			<tr>
				<td>${trainingSchedule.training_schedule_id}</td>
				<td>${trainingSchedule.training_city}</td>
				<td>${trainingSchedule.training_state}</td>
				<td>${trainingSchedule.training_country}</td>
				<td>${trainingSchedule.training_zipcode}</td>
				<td>${trainingSchedule.training_time_zone}</td>
				<td>${trainingSchedule.training_location}</td>
				<td>${trainingSchedule.training_room_number}</td>
				<td>${trainingSchedule.training_start_date}</td>
				<td>${trainingSchedule.training_end_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>