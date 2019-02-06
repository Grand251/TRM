<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"
 %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Vendor</h1>

<hr size = "4" color = "blue"/>
<br>
	<a href = "insertVendorDetailsForm">Insert new vendor</a>
	<table border = "2">
		<c:forEach items = "${allVendors}" var = "vendorDetails">
			<tr>
				<td>${vendorDetails.getVendor_id()}</td>
				<td>${vendorDetails.getVendor_name()}</td>
				<td>${vendorDetails.getVendor_phone()}</td>
				<td>${vendorDetails.getVendor_email()}</td>
				<td>${vendorDetails.getVendor_city()}</td>
				<td>${vendorDetails.getVendor_state()}</td>
				<td>${vendorDetails.getVendor_country()}</td>
				<td>${vendorDetails.getVendor_zipcode()}</td>
				<td>${vendorDetails.getVendor_time_zone()}</td>
	
				<td><a href = "deleteVendorDetails/${vendorDetails.getVendor_id()}">Delete</a></td>
				<td><a href = "editVendorDetails/${vendorDetails.getVendor_id()}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>