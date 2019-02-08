<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
</head>
<body>
	<canvas id="myChart" width="600px" height="300px" ></canvas>
	
	<script>
		var labels = [];
		var data = [];
		<c:forEach items="${requests}" var="entry">
			var key = "${entry.key}"; var value = "${entry.value}";
			labels.push(key);
			data.push(value);
		</c:forEach>
	
	
		var ctx = document.getElementById("myChart").getContext('2d');
		var myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            labels: labels,
	            datasets: [{
	                label: 'Number of Training Requests',
	                data: data,
	                backgroundColor: [
	                    'rgba(255, 99, 132, 1)',
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
	                text: 'Training Requests by Month' + 'Quarterly',
	                        fontSize: 24
	              },
	            scales: {
	                yAxes: [{
	                    ticks: {
	                        beginAtZero:true,
	                    },
	                    gridLines: {
	                        display: false,
	                        color: "black",
	                        lineWidth: 1
	                    },
	                    scaleLabel: {
	                        display: true,
	                        labelString: 'Requests',
 	                        fontSize: 20
	                      }	                    
	                }],
	        
	        		xAxes: [{
	            		gridLines: {
	                		display: false,
	                		color: "black"
	            		},
	            		scaleLabel: {
	 	                        display: true,
	 	                        labelString: 'Month',
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