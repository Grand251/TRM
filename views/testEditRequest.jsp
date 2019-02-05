<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>EDIT REQUEST</h1>
	<hr size="4" color="red" />
	<br>
	<f:form action="../saveUpdateData">
	Request ID:
		<f:input path="trainingRequestId"/>
		<br>
		Training Type:
		<f:input path="requestTrainingType"/>
		<br>
		Training Module:
		<f:input path="requestTrainingModule"/>
		<br> 
		Module Scope:
		<f:input path="requestTrainingModuleScope" /> 
		<br>
		Training Mode:
		<f:input path="requestTrainingMode"/> 
		<br>
		Start Date:
		<input type = "date" name="requestStartDate" value = "${startdate}"/>
		<br>
		End Date:
		<input type = "date" name="requestEndDate" value = "${enddate}"/>
		<br>
		Start Time:
		<input type = "time" name="requestStartTime" value = "${starttime}"/>
		<br>
		End Time:
		<input type = "time" name="requestEndTime" value = "${endtime}"/>
		<br>
		Location:
		<f:input path="requestLocation" /> 
		<br>
		Time Zone:
		<f:input path="requestTimeZone" /> 
		<br>
		Number of Participants:
		<f:input path="approxNumberOfParticipants" />
		<br>
		<f:button>SAVE</f:button>
	</f:form>

</body>
</html>