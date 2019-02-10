<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classroom Training Mode</title>
</head>
<body>
	<h1>Classroom Training Mode</h1>
	<h3>${spoc.getFirst_name()}&nbsp${spoc.getFirst_name()}&nbsp &nbsp
		&nbsp &nbsp${currentTimestamp}</h3>
	<hr size="4" color="black" />
	<br>
	<f:form action="confirmcrtmode">


	</f:form>

	<br>
	<br>
</body>
</html>
