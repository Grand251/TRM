<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Internal Training Schedule</title>
</head>
<body>
	<h1>Internal Training Request</h1>
	<h3>${spoc.getFirst_name()}&nbsp${spoc.getFirst_name()}&nbsp &nbsp
		&nbsp &nbsp${currentTimestamp}</h3>
	<hr size="4" color="black" />
	<br>
	<br>
	<f:form action="confirmschedule">
	City: &nbsp
	<f:input path="training_city" />
		<br>
	State: &nbsp
	<f:input path="training_state" />
		<br>
	Country: &nbsp
	<f:input path="training_country" />
		<br>
	Zipcode: &nbsp
	<f:input path="training_zipcode" />
		<br>
	Time Zone: &nbsp
	<f:input path="training_time_zone" />
		<br>
	Start Date: &nbsp
	<f:input path="training_start_date" />
		<br>
	End Date: &nbsp
	<f:input path="training_end_date" />
		<br>

		<f:button>Submit</f:button>
	</f:form>
	<br>
	<br>

</body>
</html>

