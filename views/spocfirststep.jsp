<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>SPOC Input Data</h1>
	<form action="spocinputdata">
		Training Type: <select name="type">
			<option>IT</option>
			<option>DTT</option>
			<option>VT</option>

		</select><br> Training Medium: <select name="medium">
			<option>CRT</option>
			<option>WT</option>
		</select><br> Trainer Name: <input type="text" id="trainer" /><br>
		Schedule Start Date: <input type="date" id="start_date"><br>
		Schedule End Date: <input type="date" id="end_date" /><br> <input
			type="submit" value="Submit" /><br>
		<!-- change to input of submit type -->
	</form>
</body>
</html>