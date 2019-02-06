<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style>

</style>
</head>
<body>
<br>
<hr size="4" color="red">
<br>
	<section>
		<c:forEach items="${trainings}" var="training">
			<article>
				<h2>${training.trainingRequest.trainingRequestId}</h2>
				<form 
					action="execdashboard/${training.executiveWorkflowStatusId}">
					<p>
						1) Send Email
						<input type="checkbox" name="email"
							<c:if 
								test="${training.invitationsSent == '1'}">checked="checked"
							</c:if> 
						/>
					</p>
					<p>
						2) Skill Enrollment
						<input type="checkbox" name="enrollment"
							<c:if test="${training.skillportEnrollmentsCompleted == '1'}">checked="checked"</c:if> 
						/>
					</p>
					<p>
						3) Assessment Recorded
						<input type="checkbox" name="assessment"
							<c:if test="${training.assessmentsRecorded == '1'}">checked="checked"</c:if> 
						/>
					</p>
					<p>
						4) Vendor Training Security Clearance
						<input type="checkbox" name="vendor"
							<c:if test="${training.vendorTrainingClearance == '1'}">checked="checked"</c:if> 
						/>
					</p>
					<p>
						5) Feedback Completed
						<input type="checkbox" name="feedback"
							<c:if test="${training.feedbackCompleted == '1'}">checked="checked"</c:if> 
						/>
					</p>
					<p>
						6) Send Training Completion
						<input type="checkbox" name="completion"
							<c:if test="${training.trainingCompleted == '1'}">checked="checked"</c:if> 
						/>
					</p>
					<input type="submit" value="Submit">
				</form>
			</article>
		</c:forEach>
		
	</section>
</body>
</html>