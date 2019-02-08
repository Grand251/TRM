<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="headerfile.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reports</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
    <title>Create Header</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
        integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</head>
<body>

<%@include file="headerbody.jsp" %>
<%@include file="navbar.jsp" %>
<div class="container" id="bodycont" style="margin-top:50px">
        <form class="form" action="chartspoclocation" style="margin-left:10px;width:80%">
            <div class="row" style="align-items:center;display:flex">
                <div class="col-xs-4" style="margin-right:5px">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </span>
                        </div>
                        <select name="spocChoice">
							<c:forEach items="${spocOptions}" var="spoc">
						        <option value="${spoc.key}">
						            ${spoc.value}
						        </option>
						    </c:forEach>
						</select>
                    </div>
                </div>
                <div class="col-xs-4" style="margin-right:5px">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </span>
                        </div>
                        <select name="period" class="form-control">
                            <option value="30">Monthly</option>
                            <option value="90">Quarterly</option>
                            <option value="180">Six months</option>
                            <option value="365">Yearly</option>
                        </select>
                    </div>
                </div>
                <br>
                <div class="col-xs-4">
                    <div class="text-right" id="send_button">
                        <button type="submit" class="btn btn-info">
                            Click
                            <i class="far fa-hand-pointer"></i>
                        </button>
                    </div>
                </div>
                <br>
                <br>
            </div>
        </form>
    </div>
    
<br>
<br>
      <canvas id="trainingModeLoc" width="800" height="400"></canvas>
  <br>
  <br>
<script>

	var numSets = 0;
	var backgroundColorChoice = ['rgba(25, 25, 112, 1)',
        'rgba(108, 117, 125, 1)',
        'rgba(23, 162, 184, 1)'];
	function getDataSet(label, data){
		var ret = {
			label : label,
			backgroundColor: backgroundColorChoice[numSets],
			data : data
		}
		
		numSets++;
		if(numSets==backgroundColorChoice.length)
			numSets= 0;
		
		return ret;
	}


	var labels = [];
	var datasets = new Map();
	var first = true;
	<c:forEach items="${requests}" var="location">
		var key = "${location.key}";
		labels.push(key);
		<c:forEach items="${location.value}" var="mode">
			var m = "${mode.key}";
			var data = "${mode.value}";
			if(first)
				datasets.set(m, [data]);
			else
				datasets.get(m).push(data);
		</c:forEach>
		first = false;
	</c:forEach>
	
	var datasetObjs = [];
	
	var mapIter = datasets.keys();
	
	let resultKey = mapIter.next();
	while (!resultKey.done) {
		 console.log(resultKey.value);
		 datasetObjs.push(getDataSet(resultKey.value, datasets.get(resultKey.value)));
		 resultKey = mapIter.next();
	}
	
	console.log(labels);
	console.log(datasetObjs);

	var ctxBarChart = document.getElementById("trainingModeLoc").getContext("2d");
	var priceBarChart = new Chart(ctxBarChart, {
	    type: 'bar',
	    data: {
	        labels: labels,
	        datasets: datasetObjs
	    },
	    options: {
	    	title: {
                display: true,
                text: "Training Modes by Location",
                        fontSize: 24
              },
	    	scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true,
                        stepSize: 1
                    },
                    stacked: true,
                    gridLines: {
                        display: true,
                        color: "transparent",
                        lineWidth: 1,
                        zeroLineColor: "black",
                        zeroLineWidth: 1
                    },
                    scaleLabel: {
                        display: true,
                        labelString: 'Requests',
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
            		stacked: true,
            		scaleLabel: {
 	                    display: true,
 	                    labelString: "Location",
 	                    fontSize: 20
 	                }	
        		}],    
            },
	        tooltips: {
	            enabled: false
	        },
	        responsive: false
	    }
	});
</script>
<%@include file="footer.jsp" %>
</body>
</html>