<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h2>${training.reqId}</h2>
				<form action="exec/status/{id}">
					<p>
						1) Send Email
						<input type="checkbox" name="email"> 
					</p>
					<p>
						2) Skill Enrollment
						<input type="checkbox" name="enrollment">
					</p>
					<p>
						3) Assessment Recorded
						<input type="checkbox" name="assessment">
					</p>
					<p>
						4) Vendor Training Security Clearance
						<input type="checkbox" name="vendor">
					</p>
					<p>
						5) Send Training Completion
						<input type="checkbox" name="completion">
					</p>
					<input type="submit" value="Submit">
				</form>
			</article>
		</c:forEach>
		
	</section>
</body>
</html>