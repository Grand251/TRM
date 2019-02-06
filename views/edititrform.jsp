<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label for="partList">Participants List</label>
<textarea rows="10" cols="50" readonly="true" id="partList">
Joe
John
<!-- Put Participant List From the Database -->
</textarea>

<f:form action="../saveUpdatedData">
	Select Executive: 	<select id="">
	 	<c:forEach items="${execList}" var="exec">
	 		<option value="${exec}" label="${exec.first_name} ${exec.last_name}"/>
	 	</c:forEach>
	</select><br>
	<!-- 
	Select Executive: 	<f:select path="internalTraining">
	 		<f:options items="${execList}" itemValue="employee_id" itemLabel="first_name"/>
	</f:select><br>
	 -->
	<input type="submit" value="submit"/>
</f:form>
</body>
</html>