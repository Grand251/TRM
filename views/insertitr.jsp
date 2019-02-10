<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert New Internal Training Request</h1>

	<f:form action="newitr">

	
	Status: <f:input path="itrStatus" />
		<br>
	  
	Trainer Employee ID: <f:select path="itrTrainer">
			<f:options items="${employees}" itemValue="employee_id"
				itemLabel="employee_id" />
		</f:select>
		<a href="showallemployees">Employee List</a>
		<br>
	  
	SPOC Employee ID: <f:select path="itrSpoc">
			<f:options items="${employees}" itemValue="employee_id"
				itemLabel="employee_id" />
		</f:select>
		<br>

		<a href="showallemployees">Employee List</a>
		<br>
	
	Training Request ID: <f:select path="itrTrainingRequest">
			<f:options items="${trainingRequests}" itemValue="trainingRequestId"
				itemLabel="trainingRequestId" />
		</f:select>
		<br>
		<a href="showalltr">Training Request List</a>
		<br>
	
	Training Mode: <f:select path="itrMode">
			<f:option value="CRT" label="CRT" />
			<f:option value="WT" label="WT" />
		</f:select>
		<br>
	
	Schedule ID: <f:select path="itrSchedule">
			<f:options items="${schedules}" itemValue="training_schedule_id"
				itemLabel="training_schedule_id" />
		</f:select>
		<br>

		<a href="showallschedules">Schedule List</a>
		<br>

		<f:button>Submit</f:button>
	</f:form>

</body>
</html>