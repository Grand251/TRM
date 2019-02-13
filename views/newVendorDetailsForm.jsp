<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://www.springframework.org/tags/form"

 %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.input-validation-error
{
    background: #FEF1EC;
    border: 1px solid #CD0A0A;
}

</style>

</head>
<body>
<h1>Create New Vendor</h1>
<hr size = "4" color = "blue"/>
<br>
<f:form action = "insertVendorDetails">
	<f:input cssErrorClass="form-field-error" path = "vendor_id"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_name"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_phone"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_email"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_city"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	
	<f:input cssErrorClass="form-field-error" path = "vendor_state"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_country"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_zipcode"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_time_zone"/>
	<f:errors path="vendor_id" cssClass="form-field-error"/>
	<f:button>create</f:button>
</f:form>
<br>
<hr size = "4" color = "blue"/>
<script>

var errorReport = [];

<c:forEach items="${errorReport}" var="error">
		var errorValues = [];
		<c:forEach items="${error}" var="errval">
		var errorValue = "${errval}";	
		errorValues.push(errorValue);
		</c:forEach>
		errorReport.push(errorValues);
</c:forEach>

console.log(errorReport);



errorReport.forEach(function(error){
	console.log(error);
	console.log(error[0]);
	var errorElement = document.getElementsByName(error[0])[0];
	console.log(errorElement);
	errorElement.classList.add("input-validation-error");
});




</script>

</body>
</html>