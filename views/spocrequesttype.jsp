<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Request Type</title>
</head>
<body>
<h1>Select Training Type</h1>
<hr size="4" color="blue"/>
<br>

<f:form action="../saveTrainingType">
	<f:input path="trainingRequestId" cssStyle="background-color: #D3D3D3;" readonly="true"/>
	<br>
	<f:select path="requestTrainingType">
		<f:option value="IT">Internal Training</f:option>
		<f:option value="DT">Development Training</f:option>
		<f:option value="VT">Vendor Training</f:option>
	</f:select>
	<br>
	<br>
	<f:button>Submit</f:button>
</f:form>
<br>
<a href="../viewspocdashboard">Go Back</a>
<br>
</body>
</html>