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
<h1>All Vendor Trainers List</h1>

<hr size = "4" color = "blue"/>
<br>
	<a href = "insertVendorTrainerForm">Insert new vendor trainer</a>
	<table border = "2">
		<c:forEach items = "${vendorTrainers}" var = "vendorTrainer">
			<tr>
				<td>${vendorTrainer.getVendor_trainer_id()}</td>
				<td>${vendorTrainer.getVendor_trainer_name()}</td>
				<td>${vendorTrainer.getPhone()}</td>
				<td>${vendorTrainer.getEmail()}</td>
				<td>${vendorTrainer.getProfile()}</td>
				<td>${vendorTrainer.getEvaulation_status()}</td>
				<td>${vendorTrainer.getVendor_trainer_log()}</td>
	
				<td><a href = "deleteVendorTrainer/${vendorTrainer.getVendor_trainer_id()}">Delete</a></td>
				<td><a href = "editVendorTrainer/${vendorTrainer.getVendor_trainer_id()}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>