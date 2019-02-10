<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

=======
<!DOCTYPE html>
>>>>>>> 8d44bc5427638387c1591b6b76552c725d2dbbfd
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<<<<<<< HEAD
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet"
	href="resources/Bootstrap/bootstrap-4.2.1-dist\css\bootstrap.min.css">
<link rel="stylesheet" href="resources/customcss/spoc.css">
<link rel="stylesheet" href="resources/CSS/custom.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="resources/spocJquery.js"></script>

=======

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <meta charset="utf-8"> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/stylesheets/spoc.css">
  <link  rel="stylesheet" href="resources/stylesheets/custom.css" >
  <link  rel="stylesheet" href="resources/stylesheets/trm.css" >
  <script src="resources/js/spocJquery.js"></script>
  <script>
  	function submitTT(){
    	$(".toProgress").click(function(){
    	    var trainingRequestId =$(this).find('#ongoingId').val();
    	    var status =$(this).find('#ongoingStatus').val();
    	    console.log(trainingRequestId);
    	    console.log(status);
    		if(status == 1.0)
    		{
    			$("#selectTT").get(0).setAttribute('action', "selectTrainingType/"+trainingRequestId);
    			$( "#selectTT" ).submit();
    		}else
    		{
    			$("#selectTT").get(0).setAttribute('action', "viewspocdashboard");
    			$( "#selectTT" ).submit();
    		}
    	})	
	}
  	
  	function submitTR(){
  		$("#submiTR").submit();
  	}
  </script>
>>>>>>> 8d44bc5427638387c1591b6b76552c725d2dbbfd
</head>

<body>

<<<<<<< HEAD
	<!--Navigation Bar-->
	<nav class="navbar navbar-expand-sm bg-light">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
	</ul>
	</nav>
	<!--End of navigation bar-->

	<!--Some space between navigation bar and actual content-->
	<div class="row space"></div>

	<form action="">
		<div class="row" style="height: 70vh;">
			<!--New Request Box-->
			<div id="newRequestBox" class="border">
				<!--Start Button Send selected new requests to be ongoing requests-->
				<button id="startButton" class="row* sticky-top">
					Start <span id="right_arrow"
						class="glyphicon glyphicon-arrow-right"></span>
				</button>

				<!--New Requests would be added here-->
				<div class="col" style="height: 63vh; overflow: auto">

					<c:forEach items="${ntrList}" var="ntr">
						<c:if test="${ntr.status==0}">
							<!-- 1 card -->
							<div class="newRequest">
								<div class="card" id="card">
									<table>
										<th>
										<td>
											<h4>${ntr.trainingRequestId}</h4>
										</td>
										<td>
											<div class="dropdown" align="right">
												<button class="btn btn-default dropdown-toggle"
													type="button" id="dropdownMenu1" data-toggle="dropdown"
													aria-haspopup="true"></button>
												<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
													<li><a href="#">Manager name </a></li>
													<!--Spoc in charge of training -->
													<li><a href="#">Manager Email </a></li>
													<!--Spoc's email-->
													<li><a href="#"> Trainer </a></li>
													<li><a href="#">Trainer Email </a></li>
													<!--Spoc's email-->
													<li><a href="#">${ntr.requestTrainingMode}</a></li>
													<!--"mode" of training -->
													<li><a href="#">${ntr.requestTrainingType}</a></li>
													<!--internal or vender -->
													<li><a href="#">${ntr.requestTrainingModule}</a></li>
													<!--type of trainig -module- (java,sql ect)-->
													<li><a href="#">${ntr.approxNumberOfParticipants}</a></li>
													<li><a href="#"><span
															class="glyphicon glyphicon-calendar"></span>${ntr.requestStartTime}</a></li>
													<li><a href="#"><span
															class="glyphicon glyphicon-calendar"></span>${ntr.requestEndTime}</a></li>
													<li><a href="#">${ntr.requestLocation}</a></li>
													<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
												</ul>
											</div>
										</td>
										</th>
									</table>
									<div class="card-body blueCard pointer">
										<table>
											<tr>
												<td><span class="glyphicon glyphicon-briefcase"></span>
													Vertical</td>
												<!--What Vertical -->
											</tr>
											<tr>
												<td><span class="glyphicon glyphicon-user"></span>
													Trainer</td>
											</tr>
											<tr>
												<td><span class="glyphicon glyphicon-asterisk"></span>${ntr.status}
												</td>
												<!--Where the training is in development -->
											</tr>
										</table>
										<input id="select" type="checkbox" class="selectBox" />
									</div>
								</div>
							</div>
							<!--end card -->
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!--End of New Request Box-->
			<form>

				<!--Ongoing Request Box-->
				<div id="ongoingRequestBox" class="border">
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>

									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->
					<!-- 1 card -->
					<div class="ongoingRequest">
						<div class="card orangeCard" id="card">
							<table>
								<th>
								<td>
									<h4 class="orangeCardTitle">Training name</h4>
								</td>
								<td>
									<div class="dropdown" align="right">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true"></button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a href="#">Manager Name </a></li>
											<!--Spoc in charge of training -->
											<li><a href="#">Manager Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> Trainer </a></li>
											<li><a href="#">Trainer Email </a></li>
											<!--Spoc's email-->
											<li><a href="#"> online or class</a></li>
											<!--"mode" of training -->
											<li><a href="#"> Training type </a></li>
											<!--internal or vender -->
											<li><a href="#">Training subject </a></li>
											<!--type of trainig -module- (java,sql ect)-->
											<li><a href="#"> Number of participants </a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
											<li><a href="#"><span
													class="glyphicon glyphicon-calendar"></span>End Time </a></li>
											<li><a href="#"> location </a></li>
											<!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
										</ul>


									</div>
								</td>
								</th>
							</table>
							<div class="card-body pointer toModal">
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-briefcase"></span>
											Vertical</td>
										<!--What Vertical -->
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span>
											Trainer</td>
									</tr>
									<tr>
										<td><span class="glyphicon glyphicon-asterisk"></span>
											Status</td>
										<!--Where the training is in development -->
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!--end card -->

					<!-- Modal -->
					<div class="modal fade" id="exampleModalLong" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLongTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-xl" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title text-center w-100"
										id="exampleModalLongTitle" style="font-weight: bold">Training
										Name</h3>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body" style="height: 77vh; overflow: auto">
									<div class="progress" style="height: 30px;">
										<div
											class="progress-bar progress-bar-striped progress-bar-animated"
											role="progressbar" aria-valuenow="75" aria-valuemin="0"
											aria-valuemax="100"
											style="background-color: dodgerblue; width: 75%"></div>
									</div>
									<div class="requestDetailsBox border">

										<div id="accordion">
											<!--Detail with collapse-->
											<div class="detail-container border">
												<div class="detail-header" id="headingOne">
													<button class="detailBtn" data-toggle="collapse"
														data-target="#collapseOne" aria-expanded="true"
														aria-controls="collapseOne">
														Status 1 <span class="glyphicon glyphicon-arrow-right"></span>
													</button>
												</div>

												<div id="collapseOne" class="collapse"
													aria-labelledby="headingOne" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry
														richardson ad squid. 3 wolf moon officia aute, non
														cupidatat skateboard dolor brunch. Food truck quinoa
														nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
														aliqua put a bird on it squid single-origin coffee nulla
														assumenda shoreditch et. Nihil anim keffiyeh helvetica,
														craft beer labore wes anderson cred nesciunt sapiente ea
														proident. Ad vegan excepteur butcher vice lomo. Leggings
														occaecat craft beer farm-to-table, raw denim aesthetic
														synth nesciunt you probably haven't heard of them
														accusamus labore sustainable VHS.</div>
												</div>

											</div>
											<!--End of detail-->

											<!--Detail with collapse-->
											<div class="detail-container border">
												<div class="detail-header" id="headingTwo">
													<button class="detailBtn" data-toggle="collapse"
														data-target="#collapseTwo" aria-expanded="true"
														aria-controls="collapseTwo">
														Status 2 <span class="glyphicon glyphicon-arrow-right"></span>
													</button>
												</div>

												<div id="collapseTwo" class="collapse"
													aria-labelledby="headingTwo" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry
														richardson ad squid. 3 wolf moon officia aute, non
														cupidatat skateboard dolor brunch. Food truck quinoa
														nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
														aliqua put a bird on it squid single-origin coffee nulla
														assumenda shoreditch et. Nihil anim keffiyeh helvetica,
														craft beer labore wes anderson cred nesciunt sapiente ea
														proident. Ad vegan excepteur butcher vice lomo. Leggings
														occaecat craft beer farm-to-table, raw denim aesthetic
														synth nesciunt you probably haven't heard of them
														accusamus labore sustainable VHS.</div>
												</div>

											</div>
											<!--End of detail-->

											<!--Detail with collapse-->
											<div class="detail-container border">
												<div class="detail-header" id="headingThree">
													<button class="detailBtn" data-toggle="collapse"
														data-target="#collapseThree" aria-expanded="true"
														aria-controls="collapseThree">
														Status 3 <span class="glyphicon glyphicon-arrow-right"></span>
													</button>
												</div>

												<div id="collapseThree" class="collapse"
													aria-labelledby="headingThree" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry
														richardson ad squid. 3 wolf moon officia aute, non
														cupidatat skateboard dolor brunch. Food truck quinoa
														nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
														aliqua put a bird on it squid single-origin coffee nulla
														assumenda shoreditch et. Nihil anim keffiyeh helvetica,
														craft beer labore wes anderson cred nesciunt sapiente ea
														proident. Ad vegan excepteur butcher vice lomo. Leggings
														occaecat craft beer farm-to-table, raw denim aesthetic
														synth nesciunt you probably haven't heard of them
														accusamus labore sustainable VHS.</div>
												</div>

											</div>
											<!--End of detail-->

											<!--Detail with collapse-->
											<div class="detail-container border">
												<div class="detail-header" id="headingFour">
													<button class="detailBtn" data-toggle="collapse"
														data-target="#collapseFour" aria-expanded="true"
														aria-controls="collapseFour">
														Status 4 <span class="glyphicon glyphicon-arrow-right"></span>
													</button>
												</div>

												<div id="collapseFour" class="collapse"
													aria-labelledby="headingFour" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry
														richardson ad squid. 3 wolf moon officia aute, non
														cupidatat skateboard dolor brunch. Food truck quinoa
														nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
														aliqua put a bird on it squid single-origin coffee nulla
														assumenda shoreditch et. Nihil anim keffiyeh helvetica,
														craft beer labore wes anderson cred nesciunt sapiente ea
														proident. Ad vegan excepteur butcher vice lomo. Leggings
														occaecat craft beer farm-to-table, raw denim aesthetic
														synth nesciunt you probably haven't heard of them
														accusamus labore sustainable VHS.</div>
												</div>

											</div>
											<!--End of detail-->

											<!--Detail with collapse-->
											<div class="detail-container border">
												<div class="detail-header" id="headingFive">
													<button class="detailBtn" data-toggle="collapse"
														data-target="#collapseFive" aria-expanded="true"
														aria-controls="collapseFive">
														Status 5 <span class="glyphicon glyphicon-arrow-right"></span>
													</button>
												</div>

												<div id="collapseFive" class="collapse"
													aria-labelledby="headingFive" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry
														richardson ad squid. 3 wolf moon officia aute, non
														cupidatat skateboard dolor brunch. Food truck quinoa
														nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
														aliqua put a bird on it squid single-origin coffee nulla
														assumenda shoreditch et. Nihil anim keffiyeh helvetica,
														craft beer labore wes anderson cred nesciunt sapiente ea
														proident. Ad vegan excepteur butcher vice lomo. Leggings
														occaecat craft beer farm-to-table, raw denim aesthetic
														synth nesciunt you probably haven't heard of them
														accusamus labore sustainable VHS.</div>
												</div>

											</div>
											<!--End of detail-->
										</div>
									</div>
									<!--End of detailRequestBox-->

									<!-- Space between details and summary-->
									<div class="spaceBetweenModal">&nbsp;</div>

									<div class="requestSummaryBox border">Summary</div>
									<!--End of Summary Box-->
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
									<button type="button" class="btn btn-success">Submit</button>
								</div>
							</div>
						</div>
					</div>
					<!-- End of Modal-->
				</div>
		</div>
		<!--End of ongoing request box-->
		</div>
		<!--End of whole request secion-->
=======
  <!-- Top navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="resources/img/as-logo.png" alt="Home">
        </a>
      </div>
      <!-- Right-aligned links -->
      <div id="right-header">
        <a href="about.html" class="about">About</a>
        <a href="#" class="logolink" title="Home">
          <img class="logoimage2" src="resources/img/as-logo.png" alt="Home">
        </a>
      </div>
    </div>
  </div>
  <!--End of navigation bar-->

  <!--Some space between navigation bar and actual content-->
  <div class="row* space"></div>


  <div class="row" style="height: 65vh;">
    <!--New Request Box-->
    <div id="newRequestBox" class="border">
    <form action="selectNewRequest">
      <!--Start Button Send selected new requests to be ongoing requests-->
      <button id="startButton" class="row* sticky-top" onclick="submitTR()">
        Start
        <span id="right_arrow" class="glyphicon glyphicon-arrow-right"></span>
      </button>

      <!--New Requests would be added here-->
      <div class="col">
	<c:forEach items="${ntrList}" var="ntr">
      	<c:if test="${ntr.status == 0}">

        <div class="portfolio-item cardSpacing" style="float:left">
          <div class="card h-100" id="card">
            <table>
              <td>
                <h3 align="left" style="margin-top: 0px">${ntr.trainingRequestId}</h3>
              </td>
              <td>
                <!--card Drop down -->
                <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true"><span class="glyphicon glyphicon-th-list"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>${ntr.requestTrainingModuleScope }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span>${ntr.requestTrainingType }</a></li>
                    <!--internal or vender -->
                    <li><a href="#"> <span class="glyphicon glyphicon-modal-window"></span>${ntr.requestTrainingMode }</a></li>
                    <!--"mode" of training -->
                    <li><a href="#"><span>&#35;</span> ${ntr.approxNumberOfParticipants }</a></li>
                    <!--Edit button 1 popover-->
                    <li> <button type="button" class="center-block" data-toggle="modal" data-target="#myModal">Edit</button></li>
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestStartTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestEndTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-time"> </span>${ntr.requestTimeZone }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-globe"></span>${ntr.requestLocation }</a></li>
                    <!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                    <!--Edit button 1 popover-->
                    <li> <button type="button" class="center-block" data-toggle="modal" data-target="#myModal1">Edit</button></li>
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#" data-toggle="modal" data-target="#Log" style="color: blue;"><span class="glyphicon glyphicon-list-alt"></span>
                        Log</a></li>

                  </ul>
                </div>
                <!--card Drop down end  -->
              </td>
            </table>
            <!--card body -->
            <div class="blueCard card-body pointer">
              <table id="Info">
                <tr>
                  <td><input type="hidden" id="ntRId" name="trainingRequestId" value="${ntr.trainingRequestId}"></td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil"></span>
                   ${ntr.requestTrainingModuleScope} </td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-calendar"></span>
                    ${ntr.requestStartTime }</td>
                </tr>
                <tr>
                  <td><span class="glyphicon glyphicon-home"></span>
                    ${ntr.requestTrainingType }</td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-check"></span>
                    Approvals</td>
                </tr>
                <tr></tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-asterisk"></span>
                   ${ntr.status}</td>
                  <!--Where the training is in development -->
                </tr>
              </table>
                <input id="select" name = "trainingRequestId" type="checkbox" class="selectBox" />

            </div>
            <!--card body end -->
          </div>
        </div>
        <!--end card -->
        </c:if>
</c:forEach>

      </div>
    </div>
    <!--End of New Request Box-->

    <!--Ongoing Request Box-->
    <div id="ongoingRequestBox" class="border">
      <!-- Insert orange requests here-->

      <div class="" style="margin-left: 7vw;">
       <c:forEach items="${trList}" var="tr">
        <c:if test="${tr.status > 0 && tr.status < 4}">
        <!-- 1 card -->
        <div class="portfolio-item cardSpacing" style="float:left">
          <div class="card h-100" id="card">
            <table>
              <td>
                <h3 align="left" style="margin-top: 0px">${tr.trainingRequestId} </h3>
              </td>
              <td>
                <!--card Drop down -->
                <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true"><span class="glyphicon glyphicon-th-list"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>${tr.requestTrainingModuleScope }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span>${tr.requestTrainingType }</a></li>
                    <!--internal or vender -->
                    <li><a href="#"> <span class="glyphicon glyphicon-modal-window"></span> Training Mode</a></li>
                    <!--"mode" of training -->
                    <li><a href="#"><span>&#35;</span> Number of participants </a></li>
                    <!--Edit button 1 popover-->
                    <li> <button type="button" class="center-block" data-toggle="modal" data-target="#myModal">Edit</button></li>
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span> Start Date and Time</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span> End Date and Time </a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-time"> </span>Time Zone</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-globe"></span> location </a></li>
                    <!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                    <!--Edit button 1 popover-->
                    <li> <button type="button" class="center-block" data-toggle="modal" data-target="#myModal1">Edit</button></li>
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#" data-toggle="modal" data-target="#Log" style="color: blue;"><span class="glyphicon glyphicon-list-alt"></span>
                        Log</a></li>

                  </ul>
                </div>
                <!--card Drop down end  -->
              </td>
            </table>

            <!--card body -->
            <div class="card-body pointer toProgress">
              <f:form id="selectTT" action="">
                <div class="card-body pointer toModal" onclick="submitTT()">
                <input type="hidden" id="ongoingId" value="${tr.trainingRequestId}">
               	<input type="hidden" id="ongoingStatus" value="${tr.status}"> 
              <table id="Info">
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil"></span>
                    Training Module </td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-calendar"></span>
                    Start Date</td>
                </tr>
                <tr>
                  <td><span class="glyphicon glyphicon-home"></span>
                    Training Type</td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-check"></span>
                    Approvals</td>
                </tr>
                <tr></tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-asterisk"></span>
                     ${tr.status}</td>
                  <!--Where the training is in development -->
                </tr>
              </table>
              </f:form>
			</div>
            </div>
            <!--card body end -->
          </div>
        </div>
        <!--end card -->
        </c:if>
		</c:forEach>

      </div>
    </div>
  </div>
  <!--End of ongoing request box-->
  <div style="padding-top: 7vh"></div>
  <footer id="footer">
    <div class="row*">
      <div class="col-xs-12">
        <p class="m-0" style="text-align:center;margin-top:15px;">&copy;Copyright 2017 Syntel INC. All
          rights
          reserved.
        </p>
      </div>
    </div>
  </footer>
  <!--End of whole request secion-->

>>>>>>> 8d44bc5427638387c1591b6b76552c725d2dbbfd
</body>

</html>