<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Internal Training Request</title>
</head>
<body>
<h1>Internal Training Request</h1>
<h3>${spoc.getFirst_name()}&nbsp ${spoc.getLast_name()}&nbsp &nbsp &nbsp &nbsp${currentTimestamp}</h3>
<hr size="4" color="black"/>
<br>
<br>
<f:form>
	Internal Training ID: &nbsp
	<f:input path="itrId" id="itrId" cssStyle="background-color: #D3D3D3" readonly="true"/>
	<br>
	Internal Training Status: &nbsp
	<f:input path="itrStatusDescription" cssStyle="background-color: #D3D3D3" readonly="true"/>
	<br>
</f:form>
<f:form action="newitr/selectitrtrainer">
	Select an Internal Trainer: &nbsp
	<f:select path="itrTrainer">
		<c:forEach items="${trainers}" var="trainer">
			<f:option value="${trainer}" label="${trainer.employee_id} ${trainer.first_name} ${trainer.last_name }"/>
		</c:forEach>
	</f:select>
	<f:button>Select</f:button>
	<br>
</f:form>
	<f:form action="newitr/selectitrmode">
		Internal Training Mode: &nbsp
		<f:select path="itrMode">
			<f:option value="CRT" label="Classroom Training" />
			<f:option value="WT" label="Web Training" />
		</f:select>
		<f:button>Select</f:button>
	</f:form>
		<a href="newitr/itrschedule">Input Training Schedule</a>
	
	<br>

</body>
</html>

