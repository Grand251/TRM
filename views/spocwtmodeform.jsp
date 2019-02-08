<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Training Mode</title>
</head>
<body>
	<h1>Web Training Mode</h1>
	<hr size="4" color="black" />
	<br>
	<f:form action="confirmwtmode">
		<f:input path="training_schedule_id"
			cssStyle="background-color: #D3D3D3" readonly="true" />
		<f:input path="training_location" />
		<f:button>Submit</f:button>
	</f:form>
</body>
</html>