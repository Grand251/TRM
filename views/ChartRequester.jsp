<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
</head>
<body>
<form action="chartRequester">
	<select name="reqChoice">
		<c:forEach items="${reqOptions}" var="req">
	        <option value="${req.key}">
	            ${req.value}
	        </option>
	    </c:forEach>
	</select>
	
	<select name="period">
		<option value ="30">Monthly</option>
		<option value="90">Quarterly</option>
		<option value="180">Six Months</option>
		<option value="365">Yearly</option>
	</select>
	<input type="submit" value="Click"/>
</form>

<canvas id="myStatusChart" width="400px" height="300px" ></canvas>
<br>
<br>
<canvas id="myPartChart" width="400px" height="300px" ></canvas>
	
	<script>
	console.log("HELLO");
		var data = [];
		<c:forEach items="${status}" var="request">
			var value = "${request}";
			data.push(value);
		</c:forEach>
		
		console.log(data);
		var period = "${period}";
		
		function getLabel(){
			if (period==90)
				return "Quarter";
			else if (period==180)
				return "6 Month Period"
			else if(period==365)
				return "Year";
			else
				return "Month"
			
		}
	
		var label = getLabel();
		
		var ctx = document.getElementById("myStatusChart").getContext('2d');
	    var myChart = new Chart(ctx, {
	        type: 'pie',
	        data: {
	            labels: ['Canceled', 'In Progress', 'Completed'],
	            datasets: [{
	                label: 'Training Request Status in ' + label,
	                data: data,
	                backgroundColor: [
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderColor: [
	                    'rgba(255,99,132,1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderWidth: 1
	            }]
	        },
	        options: {
	        	title: {
	                display: true,
	                text: 'Training Request Status in ' + label,
	                        fontSize: 24
	              },
	            responsive: false
	        }
	    });

		var partLabels = [];
		var partData = [];
		<c:forEach items="${participants}" var="entry">
			var key = "${entry.key}"; var value = "${entry.value}";
			partLabels.push(key);
			partData.push(value);
		</c:forEach>
		
		console.log(partLabels);
		console.log(partData);
		/*var period = "${period}";
		
		function getLabel(){
			if (period==90)
				return "Quarter";
			else if (period==180)
				return "6 Months"
			else if(period==365)
				return "Year";
			else
				return "Month"
			
		}
	
		var label = getLabel();*/
		
		var partCtx = document.getElementById("myPartChart").getContext('2d');
	    var partMyChart = new Chart(partCtx, {
	        type: 'pie',
	        data: {
	            labels: partLabels,
	            datasets: [{
	                label: 'Training Participants in ' + label,
	                data: partData,
	                backgroundColor: [
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderColor: [
	                    'rgba(255,99,132,1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderWidth: 1
	            }]
	        },
	        options: {
	        	title: {
	                display: true,
	                text: 'Training Participants in ' + label,
	                        fontSize: 24
	              },
	            responsive: false
	        }
	    });
	    </script>

</body>
</html>