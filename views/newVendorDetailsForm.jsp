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
.error{
	border: 5px solid #ffdddd;
}

</style>

</head>
<body>
<h1>Create New Vendor</h1>
<hr size = "4" color = "blue"/>
<br>
<f:form action = "insertVendorDetails">
	<f:input cssErrorClass="form-field-error" path = "vendor_id"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_name"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_phone"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_email"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_city"/>
	
	<f:input cssErrorClass="form-field-error" path = "vendor_state"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_country"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_zipcode"/>
	<f:input cssErrorClass="form-field-error" path = "vendor_time_zone"/>
	<f:button>create</f:button>
</f:form>
<br>
<hr size = "4" color = "blue"/>

<c:forEach items="${errorReport}" var="error">
		<p>
		<c:forEach items="${error}" var="errval">
			<span style="color:red">${errval.key}&nbsp;&nbsp;${errval.value}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</c:forEach>
		</p>
</c:forEach>

</body>
</html>