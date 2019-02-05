<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW REQUEST</title>
</head>
<body>
	<h1>ADD NEW REQUEST</h1>
	<hr size="4" color="red" />
	<br>
	<form action="addnewrequest">
		Type:
		<input type = "text" name="requestTrainingType"/>
		<br>
		Module:
		<input type = "text" name="requestTrainingModule"/>
		<br>
		Scope:
		<input type = "text" name="requestTrainingModuleScope"/>
		<br>
		Mode:
		<input type = "text" name="requestTrainingMode"/>
		<br>
		Location:
		<input type = "text" name="requestLocation"/>
		<br>
		Start Date:
		<input type = "date" name="requestStartDate"/>
		<br>
		End Date:
		<input type = "date" name="requestEndDate"/>
		<br>
		Start Time:
		<input type = "time" name="requestStartTime"/>
		<br>
		End Time:
		<input type = "time" name="requestEndTime"/>
		<br>
		Time Zone:
		<input type = "text" name="requestTimeZone"/>
		<br>
		Number of Participants:
		<input type = "number" name="approxNumberOfParticipants"/>
		<br>
		<input type="submit" value = "ADD REQUEST"/>
	</form>
</body>
</html>