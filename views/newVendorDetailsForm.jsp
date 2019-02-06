<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "f" uri = "http://www.springframework.org/tags/form"

 %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Create New Vendor</h1>
<hr size = "4" color = "blue"/>
<br>
<f:form action = "insertVendorDetails">
	<f:input path = "vendor_id"/>
	<f:input path = "vendor_name"/>
	<f:input path = "vendor_phone"/>
	<f:input path = "vendor_email"/>
	<f:input path = "vendor_city"/>
	
	<f:input path = "vendor_state"/>
	<f:input path = "vendor_country"/>
	<f:input path = "vendor_zipcode"/>
	<f:input path = "vendor_time_zone"/>
	<f:button>create</f:button>
</f:form>
<br>
<hr size = "4" color = "blue"/>

</body>
</html>