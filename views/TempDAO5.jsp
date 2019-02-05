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
<form action="daotest5">
	<select name="period">
		<option value ="30">Month</option>
		<option value="90">Quarter</option>
		<option value="180">Six Month</option>
		<option value="365">Year</option>
	</select>
	<input type="submit" value="Click"/>
</form>

<canvas id="myChart" width="900px" height="300px" ></canvas>
	
	<script>
		var labels = [];
		var data = [];
		<c:forEach items="${performance}" var="entry">
			var key = "${entry.key}"; var value = "${entry.value}";
			labels.push(key);
			data.push(value);
		</c:forEach>
		
		var period = "${period}";
		
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
	
		var label = getLabel();
		var ctx = document.getElementById("myChart").getContext('2d');
		var myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            labels: labels,
	            datasets: [{
	                data: data,
	                backgroundColor: [
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)',
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	            }]
	        },
	        options: {
	        	title: {
	                display: true,
	                text: 'SPOC Performance in ' + label,
	                        fontSize: 24
	              },
	            scales: {
	                yAxes: [{
	                    ticks: {
	                        beginAtZero:true,
	                    },
	                    gridLines: {
	                        display: true,
	                        color: "transparent",
	                        lineWidth: 1,
	                        zeroLineColor: "black",
	                        zeroLineWidth: 1
	                    },
	                    scaleLabel: {
	                        display: true,
	                        labelString: 'Points',
 	                        fontSize: 20
	                      }	                    
	                }],
	        
	        		xAxes: [{
	            		gridLines: {
	                		display: true,
	                		color: "transparent",
	                		zeroLineColor: "black",
	                        zeroLineWidth: 1
	            		},
	            		scaleLabel: {
	 	                    display: true,
	 	                    labelString: "SPOC",
	 	                    fontSize: 20
	 	                }	
	        		}],    
	            },
	            legend: {
	            	display:false,
	            },
	            responsive: false
	        }
	    });
	    </script>
</body>
</html>