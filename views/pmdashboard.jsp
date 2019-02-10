<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
<<<<<<< HEAD
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
<script>
	$(document).ready(function (){
		$(".btn-expand").click(function(){
			var table = $(this).eq(0).parent().find("div").eq(0);
			
			if (table.css("display") == "block")
			{
				table.css("display", "none");
			}
			else
			{
				table.css("display", "block");
			}
		});
	});
</script>
</head>
<body>
	<h1>${name}'sDashboard</h1>
	<br>
	<br>
	<a href="createrequest">Create Request</a>
	<h3>Requests</h3>
	<hr size="4" color="red" />
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Trainer Name</th>
				<th scope="col">Trainer Email</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requests}" var="request">
				<tr>
					<th scope="row">
						<button type="button" class="btn btn-info btn-expand">Expand</button>
						<span style="margin-left: 15px"> ${request.id} </span>
						<div style="margin-top: 15px; display: none;">
							<table class="table" style="background-color: transparent;">
								<thead>
									<tr>
										<th scope="col">Type</th>
										<th scope="col">Value</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Status</td>
										<td>${request.status}</td>
									</tr>
									<tr>
										<td>SPOC Name</td>
										<td>${request.spocName}</td>
									</tr>
									<tr>
										<td>SPOC Email</td>
										<td>${request.spocEmail}</td>
									</tr>
									<tr>
										<td>Trainer Name</td>
										<td>${request.trainerName}</td>
									</tr>
									<tr>
										<td>Trainer Email</td>
										<td>${request.trainerEmail}</td>
									</tr>
									<tr>
										<td>Mode</td>
										<td>${request.mode}</td>
									</tr>
									<tr>
										<td>Training Type</td>
										<td>${request.type}</td>
									</tr>
									<tr>
										<td>Training Subject</td>
										<td>${request.scope}</td>
									</tr>
									<tr>
										<td># of Participants</td>
										<td>${request.participants}</td>
									</tr>
									<tr>
										<td>Requested Start Time</td>
										<td>${request.requestedTimeZone}
											${request.requestedStartTime}</td>
									</tr>
									<tr>
										<td>Requested End Time</td>
										<td>${request.requestedTimeZone}
											${request.requestedEndTime}</td>
									</tr>
									<c:if test="${request.isItr}">
										<tr>
											<td>Start Time</td>
											<td>${request.timeZone}${request.startTime}</td>
										</tr>
										<tr>
											<td>End Time</td>
											<td>${request.timeZone}${endTime}</td>
										</tr>
									</c:if>
									<tr>
										<td>Location</td>
										<td>${request.location}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</th>
					<td>${request.trainerName}</td>
					<td>${request.trainerEmail}</td>
					<td>
						<div class="container">
							<a href='requests/${request.id}/delete'>Delete</a> | <a
								href='editrequest/${request.id}'>Edit</a>
							<c:if test="${request.status == 4}">
								|
								<a href='approve/${request.id}'>Approve</a>
							</c:if>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
=======
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>ProjectManagerView</title>

<!-- Custom styles for this template -->
<link rel="stylesheet" href="resources/custom.css">

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="resources/bootstrap.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> <!--needed for the glyphs  -->

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



</head>

<body style="margin-top: 100px;">

  <!-- Navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="resources/as-logo.png" alt="Home">
        </a>
      </div>
    </div>
  </div>
  <!--End NAV-->

  <div><!-- Top table with search and create-->
    <table>
      <tr>
        <td >
             <!--search bar-->
          <input name="Search Training" id="searchBar" font-size="20" placeholder="Search">
          <!--search bar-->
          <!-- search  button-->
          <a href="#" id="searchButton" class="btn btn-info btn-sm" style="background-color: #31708F;">
            <span class="glyphicon glyphicon-search"></span> Search
          </a>
        </td>
        <td >
             <!-- create training button-->
          <!--  <a href="createrequest" id="CreateButton" data-toggle="modal" data-target="#create" style="background-color: #31708F;" class="btn btn-info btn-lg">
            <span class="glyphicon glyphicon-list-alt"></span> New Training Request
          </a>-->
          <form action="createrequest">
          <button type="submit" class = "btn btn-info" style="background-color: #31708F;">
			New Training Request
			<i class = "fa fa-list" aria-hidden = "true"></i>
			</button>
			</form>
        </td>
      </tr>
    </table>
  </div>

  <!-- Page Content -->
  <div class="container-fluid" style="margin-left:25px; ">
<!--row start-->
	<div class="row" style="margin-right: 10px;">
      	<c:forEach items="${requests}" var="request">
      	
      
         <!-- 1 card -->
      <div class="portfolio-item">
        <div class="card h-100" id="card">
          <table>
            <td>
              <h3 align="left" style="margin-top: 0px">Training ID </h3>
            </td>
            <td>
              <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                  aria-haspopup="true"><span class="glyphicon glyphicon-th-list"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                  <li><a href="#"><span class="glyphicon glyphicon-pencil"></span> Training Scope ${request.scope} </a></li>
                  <li><a href="#"><span class="glyphicon glyphicon-home"></span> Training type ${request.type}</a></li>
                  <!--internal or vender -->
                  <li><a href="#"> <span class="glyphicon glyphicon-modal-window"></span> Training Mode ${request.mode}</a></li>
                  <!--"mode" of training -->
                  <li><a href="#"><span>&#35;</span> Number of participants ${request.participants} </a></li>
 
                      <li> <button type="button" class="center-block" data-toggle="modal" data-target="#myModal${request.id}">Edit</button></li>
                  
                  
                  
                  <li role="separator" class="divider"></li>
                  <li><a href="#"><span class="glyphicon glyphicon-calendar"></span> Start Date and Time ${request.requestedStartTime}</a></li>
                  <li><a href="#"><span	 class="glyphicon glyphicon-calendar"></span> End Date and Time ${request.requestedEndTime}</a></li>
                  <li><a href="#"><span class="glyphicon glyphicon-time"> </span>Time Zone ${request.timeZone}</a></li>
                  <li><a href="#"><span class="glyphicon glyphicon-globe"></span> location ${request.location} </a></li>
                  <!--Where it is taking place if not online (IF ONLINE DONT SHOW)
					WORKING BUTTON                  
                  <li> <button type="button" id="editbuttontwo" class="center-block" data-toggle="modal" data-target="#myModal1">Edit</button></li>
                  
                  <li> <button type="button" 
                 	 class="center-block"
                 	 data-toggle="modal"
                 	 data-target="#myModal1"
                  	 onclick="location.href=''">Edit</button></li>
                  -->
                  
                  
                  <li> <button type="button" 
                 	 class="center-block"
                 	 data-toggle="modal"
                 	 data-target="#myModal1${request.id}"
                 	 onclick=
                  	 >Edit</button></li>
                
                
                  <li role="separator" class="divider"></li>  
                  
<li><a href="#" class="center-block" id ="log" title="Log of changes" 
                        data-toggle="popover" style="color:blue" data-trigger="hover"
                        data-placement="bottom" data-content="all of the info here ">
                         <span class="glyphicon glyphicon-list-alt" >  </span>Log</a>
                      </li>             
                      
                           
                  

                </ul>
              </div>
            </td>
          </table>
          <div class="card-body">
            <table id="Info">
              <tr></tr>
              <tr>
                <td> <span class="glyphicon glyphicon-pencil"></span>
                  Training Module: ${request.id}</td>
              </tr>
              <tr>
                <td> <span class="glyphicon glyphicon-calendar"></span>
                  Start Date: ${request.requestedStartTime}</td>
              </tr>
              <tr>
                <td><span class="glyphicon glyphicon-home"></span>
                  Training Type: ${request.type}</td>
              </tr>
              <tr>
                <td> <span class="glyphicon glyphicon-check"></span>
                  Approvals</td>
              </tr>
              <tr></tr>
              <tr>
                <td> <span class="glyphicon glyphicon-asterisk"></span>
                  Status:
																				
										    <c:choose>
										        <c:when test="${request.status == 0}">Not ready for SPOC to workon</c:when>
										        <c:when test="${request.status == 1}">Ready to be edited by SPOC</c:when>
										        <c:when test="${request.status == 2}">SPOC has begun to process request (Haven't selected whether it will be IT or Vendor)</c:when>
										        <c:when test="${request.status  == 3}">IT/VT/DT has been selected</c:when>
										        <c:when test="${request.status == 3.1}">Ready for project manager approval</c:when>
										        <c:when test="${request.status == 3.2}">Project manager has approved it</c:when>
										        <c:when test="${request.status  == 4}">Sent to executive</c:when>
										        <c:when test="${request.status  == 4}">Sent to executive</c:when>
										        <c:when test="${request.status  == 4}">Sent to executive</c:when>
										        <c:when test="${request.status  == 4}">Sent to executive</c:when>
										        <c:when test="${request.status  == 4}">Sent to executive</c:when>
										        <c:when test="${request.status  == 4}">Sent to executive</c:when>
										        
										        <c:otherwise>${request.status }</c:otherwise>
										    </c:choose></td>
                <!--Where the training is in development -->
              </tr>
            </table>
            	<!--hovern button status start-->
					 <div>
						<button type="button" id="Changes" data-trigger="hover" class="btn btn-danger" data-toggle="popover" 
                    data-placement="right"data-original-title="" 
                    data-content="
							Spoc Name: ${request.spocName}
							Spoc Email: ${request.spocEmail }
							Training Time Zone: ${request.timeZone}
							
							Training Participants: ${request.participants }
							Trainer Name: ${request.trainerName}
							Trainer Email: ${request.trainerEmail}
							Schedule ID: ${request.scheduleID}
							Training Module: ${request.module}
							Start Time: ${request.startTime}
							End Time: ${request.endTime}
							Requested Start Time: ${request.requestedStartTime}
							Requested End Time: ${request.requestedEndTime}
														
						
						<br>
														
						"> SPOC </button>
					  </div>
						<!-- hovern button status end -->

          </div>
        </div>
      </div>
      <!--end card -->
      
            
        


 <!-- Training Edit popover script --> 
 <div class="modal fade" id="myModal${request.id}" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
             <h4 class="modal-title"style="color:white;">Training Edit</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                    <form action="saveTrainingUpdateData" class="form"
									style="margin-left: 20px;">
									<br>
									<div class="row">
										<div>
											<input type="text" name="trainingRequestId"
												value="${request.id}" hidden = "true"/>
										</div>
										<div class="col-2">
											<label class="control-label"> Scope </label>
										</div>
										<div>
											<textarea class="form-control" rows="2" cols="32"
												id="comment" name="requestTrainingModuleScope"
												placeholder="JDBC" required>${request.scope}</textarea>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-xs-2">
											<label class="control-label"> Type </label>
										</div>
										<div>
										<c:choose>
										<c:when test ="${request.type == 'IT'}" >
											<input class="radio-inline" type="radio" id="DT"
												name="requestTrainingType" value="IT" checked> <label
												class="form-check-label" for="abc">Internal</label> <input
												class="radio-inline" type="radio" id="VT"
												name="requestTrainingType" value="VT"> <label
												class="form-check-label" for="def">Vendor</label> <input
												class="radio-inline" type="radio" id="DT"
												name="requestTrainingType" value="DT"> <label
												class="form-check-label" for="bcd">Development</label>
										</c:when>
										<c:when test ="${request.type == 'VT'}" >
											<input class="radio-inline" type="radio" id="IT"
												name="requestTrainingType" value="IT"> <label
												class="form-check-label" for="abc">Internal</label> <input
												class="radio-inline" type="radio" id="VT"
												name="requestTrainingType" value="VT" checked> <label
												class="form-check-label" for="def">Vendor</label> <input
												class="radio-inline" type="radio" id="DT"
												name="requestTrainingType" value="DT"> <label
												class="form-check-label" for="bcd">Development</label>
										</c:when>
										<c:when test ="${request.type == 'DT'}" >
											<input class="radio-inline" type="radio" id="IT"
												name="requestTrainingType" value="IT"> <label
												class="form-check-label" for="abc">Internal</label> <input
												class="radio-inline" type="radio" id="VT"
												name="requestTrainingType" value="VT" > <label
												class="form-check-label" for="def">Vendor</label> <input
												class="radio-inline" type="radio" id="DT"
												name="requestTrainingType" value="DT" checked> <label
												class="form-check-label" for="bcd">Development</label>
										</c:when>
										<c:otherwise>
										<input class="radio-inline" type="radio" id="IT"
												name="requestTrainingType" value="IT"> <label
												class="form-check-label" for="abc">Internal</label> <input
												class="radio-inline" type="radio" id="VT"
												name="requestTrainingType" value="VT" > <label
												class="form-check-label" for="def">Vendor</label> <input
												class="radio-inline" type="radio" id="DT"
												name="requestTrainingType" value="DT"> <label
												class="form-check-label" for="bcd">Development</label>
										</c:otherwise>
										</c:choose>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-2">
											<label class="control-label"> Mode </label>
										</div>
										<div>
										<c:choose>
										<c:when test ="${request.mode == 'WEB'}" >
											<input class="radio-inline" type="radio" id="web"
												name="requestTrainingMode" value="WEB" checked> <label
												class="form-check-label" for="mfm"
												name="requestTrainingMode">Web-Based</label> <input
												class="radio-inline" type="radio" id="classroom" name="requestTrainingMode"
												value="CLASS"> <label class="form-check-label"
												for="mff" name="requestTrainingMode">Classroom</label>
										</c:when>
										<c:when test ="${request.mode == 'CLASS'}" >
											<input class="radio-inline" type="radio" id="web"
												name="requestTrainingMode" value="WEB"> <label
												class="form-check-label" for="mfm"
												name="requestTrainingMode">Web-Based</label> <input
												class="radio-inline" type="radio" id="classroom" name="requestTrainingMode"
												value="CLASS" checked> <label class="form-check-label"
												for="mff" name="requestTrainingMode">Classroom</label>
										</c:when>
										<c:otherwise>
										<input class="radio-inline" type="radio" id="web"
												name="requestTrainingMode" value="WEB"> <label
												class="form-check-label" for="mfm"
												name="requestTrainingMode">Web-Based</label> <input
												class="radio-inline" type="radio" id="classroom" name="requestTrainingMode"
												value="CLASS"> <label class="form-check-label"
												for="mff" name="requestTrainingMode">Classroom</label>
										</c:otherwise>
										</c:choose>
										</div>
									</div>
									<br>
									<div class="row">
										<div>
											<label class="control-label"> Participants </label>
										</div>
										<div>
											<input id="participants" type="number" cols="32"
												class="form-control" name="approxNumberOfParticipants"
												placeholder="Participants number"
												value="${request.participants}" required>
										</div>
									</div>
									<br>
									<div class="modal-footer">
										<div class="row">
											<div class="col">
												<div class="text-left">
													<button type="submit" class="btn btn-default"
														style="background-color: #31708F; color: white;">
														Training Scope Edit <i class="fa fa-save"
															aria-hidden="true"></i>
													</button>
												</div>
											</div>
										</div>
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Close</button>
									</div>

								</form>

                </div>
                
              </div>
            </div>
          </div>
        
         <!-- Training Edit popover end  script -->

       <!-- Training Time Edit popover code -->
       <div class="modal fade" id="myModal1${request.id}" role="dialog">
            <div class="modal-dialog modal-md">
              <div class="modal-content">
                  <!--Header for Training Time Edit -->
                <div class="modal-header"> <h4 class="modal-title" style="color:white;">Training Time Edit </h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                 
                </div>
                <!--Header end-->
                <div class="modal-body">
                  <!--Training Time Edit Form/body  -->
                       <form action="saveScheduleUpdateData" class="form"
							style="margin-left: 20px;">
							<br>
							<div class="row">
								
								<div>
									<input type="text" name="trainingRequestId"
										value="${request.id}" hidden = "true"/>
								</div>
								<div class="col-xs-2">
									<label class="control-label"> Start Date/Time </label>
								</div>
								<div class="col-xs-5">
									<input id="training_start" type="date" class="form-control"
										name="startDate" placeholder="Start date"
										value="${request.startTime}" required>
								</div>
								<div>
									<input id="training_startTime" type="time" class="form-control"
										name="startTime" placeholder="Start time"
										value="${request.startHour}" required>
								</div>
							</div>

							<br>
							<div class="row">
								<div class="col-xs-2">
									<label class="control-label"> End Date/Time </label>
								</div>
								<div class="col-xs-5">
									<input id="training_end" type="date" class="form-control"
										name="endDate" placeholder="End date"
										value="${request.endTime}" required>
								</div>
								<div>
									<input id="training_endTime" type="time" class="form-control"
										name="endTime" placeholder="End time"
										value="${request.endHour}" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-xs-2">
									<label class="control-label"> Time Zone </label>
								</div>
								<div class="col-xs-10">
								<c:choose>
								<c:when test ="${request.timeZone == 'UTC'}" >
									<select name="requestTimeZone">
										<option name="a" value="UTC" selected = "selected">UTC</option>
										<option name="b" value="MST">MST</option>
										<option name="c" value="PT">PT</option>
									</select>
								</c:when>
								<c:when test ="${request.timeZone == 'MST'}" >
									<select name="requestTimeZone">
										<option name="a" value="UTC">UTC</option>
										<option name="b" value="MST" selected = "selected">MST</option>
										<option name="c" value="PT">PT</option>
									</select>
								</c:when>
								<c:when test ="${request.timeZone == 'PT'}" >
									<select name="requestTimeZone">
										<option name="a" value="UTC">UTC</option>
										<option name="b" value="MST">MST</option>
										<option name="c" value="PT" selected = "selected">PT</option>
									</select>
								</c:when>
								<c:otherwise>
								<select name="requestTimeZone">
										<option name="a" value="UTC">UTC</option>
										<option name="b" value="MST">MST</option>
										<option name="c" value="PT">PT</option>
									</select>
								</c:otherwise>
								</c:choose>
								</div>
							</div>
							<br>

							<div class="row">
								<div class="col-xs-2">
									<label class="control-label"> Location </label>
								</div>
								<div class="col-xs-10">
								<c:choose>
								<c:when test ="${request.location == 'Phoenix'}" >
									<select name="requestLocation">
										<option name="city" value="Phoenix" selected = "selected">Phoenix</option>
										<option name="city1" value="Memphis">Memphis</option>
										<option name="city2" value="San Diego">San Diego</option>
									</select>
								</c:when>
								<c:when test ="${request.location == 'Memphis'}" >
									<select name="requestLocation">
										<option name="city" value="Phoenix">Phoenix</option>
										<option name="city1" value="Memphis" selected = "selected">Memphis</option>
										<option name="city2" value="San Diego">San Diego</option>
									</select>
								</c:when>
								<c:when test ="${request.location == 'San Diego'}" >
									<select name="requestLocation">
										<option name="city" value="Phoenix">Phoenix</option>
										<option name="city1" value="Memphis">Memphis</option>
										<option name="city2" value="San Diego" selected = "selected">San Diego</option>
									</select>
								</c:when>
								<c:otherwise>
								<select name="requestLocation">
										<option name="city" value="Phoenix">Phoenix</option>
										<option name="city1" value="Memphis">Memphis</option>
										<option name="city2" value="San Diego">San Diego</option>
									</select>
								</c:otherwise>
								</c:choose>
								</div>
							</div>
							<br> <br>
							<div class="modal-footer">
								<div class="row">
									<div class="col">
										<div class="text-left">
											<button type="submit" class="btn btn-default"
												style="background-color: #31708F; color: white;">
												Training Time Edit <i class="fa fa-save" aria-hidden="true"></i>
											</button>
										</div>
									</div>
								</div>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>
						</form>
                            <!--Training Time Edit Form end -->
                </div>
                   <!--Training Time Edit body end -->'
                   <!-- training Time Edit Footer -->
                <!-- Training Time Edit Footer-->
              </div>
            </div>
          </div>
      <!--popover script  end-->
</c:forEach>
      <!--row div end-->
    </div>

    <!-- /.container -->
  </div>

  <!-- Footer -->
  <footer id="footer">
    <p class="para">&copy;Copyright 2017 Syntel INC. All
        rights
        reserved.
    </p>
</footer>

<!--Script for the popover    -->
<script>
	$(function () {
  $('#log').popover({
    container: "#card"
  })
  $('[data-toggle="popover"]').popover();
    $('#log').hover(function()
    {
    	$('.popover').eq(0).css({'margin-left': '-50%', 'top': '102%', 'border-color': 'red'});
    });

    $('#Approval').click(function()
    {
    	$('.popover').eq(0).css({'margin-left': '102%', 'top': '102%', 'border-color': 'red'});
    });  
});
</script> 
  <!--  Script for the popover end  -->

<!-- Bootstrap core JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

 <!--Font awesome social media icons links -->
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" />


>>>>>>> 8d44bc5427638387c1591b6b76552c725d2dbbfd
</body>

</html>