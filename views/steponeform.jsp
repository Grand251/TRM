<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="../submitstepone/${itrId}">
		<select>
			<option>TN</option>
			
		</select>
		<input type="date" name="startDate">
		<input type="date" name="endDate">
		<input type="radio" name="mode" value="web base">
		Web Training
		<input type="radio" name="mode" value="class room">
		Classroom Training
		
		<input type="submit" value="Submit" />
	
	</form>
</body>
</html>