<!--  status as 3 is enabled. everything else disabled -->
<!--  -1 status is denied by project requester -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	
	<%@include file="headerfile.jsp" %>
	<!-- Custom styles for this template -->
	<link rel="stylesheet" href="resources/stylesheets/PM/PMcustom.css">
</head>

<body style="background-color: #87cefa;">

  <%@include file="headerbody.jsp" %>
  <%@include file="navbar.jsp" %>

	<div style="margin-left:15%; margin-top:100px;"><!-- Top table with search and create-->
       <!-- create training button-->
          <a href="createrequest" id="CreateButton" class="btn btn-danger btn-lg">
            <span class="glyphicon glyphicon-list-alt"></span> New Training Request
          </a>
  </div>

  <!-- Page Content -->
  <div class="container-fluid" style="margin-left:15%; margin-top:50px; padding:0px; max-width:1300px;">
<!--row start-->
	<div class="row" style="margin-right: 10px;">
      	<c:forEach items="${requests}" var="request">
      	
      
         <!-- 1 card -->
      <div class="portfolio-item">
        <div class="card h-100" id="card">
          <table>
            <td>
              <h3 align="left" style="margin-top: 0px">ID: ${request.id}</h3>
            </td>
            <td>
              <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                  aria-haspopup="true" style="background-color:#007bff; color:white;"><span class="fas fa-list"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width: 250%;">
                  <li><span class="fas fa-pencil-alt"></span><strong>Scope:</strong> ${request.scope}</li>
                  <li><span class="fas fa-home"></span><strong>Type:</strong> ${request.type}</li>
                  <!--internal or vender -->
                  <li><span class="fas fa-calendar"></span><strong>Mode:</strong> ${request.mode}</li>
                  <!--"mode" of training -->
                  <li><i class="fas fa-hashtag"></i><strong>Participants:</strong> ${request.participants}</li>
 
                      <li align="center"> <button type="button" class="btn btn-primary editBtn" data-toggle="modal" data-target="#myModal${request.id}">Edit</button></li>
                  
                  
                  
                  <li role="separator" class="divider"></li>
                  <li><span class="fas fa-calendar"></span><strong>S Date:</strong> ${request.requestedStartDate}</li>
                  <li><span	 class="fas fa-calendar"></span><strong>E Date:</strong> ${request.requestedEndDate}</li>
                  <li><span class="fas fa-clock"> </span><strong>Time Zone:</strong> ${request.timeZone}</li>
                  <li><span class="fas fa-globe-americas"></span><strong>Location:</strong> ${request.location}</li>
                  <!--Where it is taking place if not online (IF ONLINE DONT SHOW)
					WORKING BUTTON                  
                  <li> <button type="button" id="editbuttontwo" class="center-block" data-toggle="modal" data-target="#myModal1">Edit</button></li>
                  
                  <li> <button type="button" 
                 	 class="center-block"
                 	 data-toggle="modal"
                 	 data-target="#myModal1"
                  	 onclick="location.href=''">Edit</button></li>
                  -->
                  
                  
                  <li align="center"> <button type="button" 
                 	 data-toggle="modal"
                 	 data-target="#myModal1${request.id}"
                 	 class="btn btn-primary editBtn"
                  	 >Edit</button></li>
                
                
                  <li role="separator" class="divider"></li>  
                  
<li style="
    text-align: -webkit-right;
    margin-right: 10px;
"><a href="#" class="center-block" id="log" title="Log of changes" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="all of the info here ">
                         <span class="fas fa-clipboard-list">  </span>Process Request Log</a>
                      </li>       
                      
                           
                  

                </ul>
              </div>
            </td>
          </table>
          <div class="card-body">
            <table id="Info">
              <tr></tr>
              <tr>
                <td> <span class="fas fa-pencil-alt"></span>
                  <strong>Module:</strong> ${request.module}</td>
              </tr>
              <tr>
                <td> <span class="fas fa-calendar"></span>
                  <strong>S Date:</strong> ${request.requestedStartDate}</td>
              </tr>
              <tr>
                <td><span class="fas fa-user-alt"></span>
                  <strong>Type:</strong> ${request.type}</td>
              </tr>
              <tr></tr>
              <tr>
                <td> 
                <table>
                	<tr>
                		<td style="width: 40%">
                			<span class="fas fa-asterisk"></span>
                			<strong>Status:</strong>
                		</td>
                		<td style="width: 60%">
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
										</c:choose>	
                		</td>
                	</tr>
                </table>
                
                <!--Where the training is in development -->
              </tr>
              <tr> <td> 
              <c:choose>     
              <c:when test="${request.status == 3}">               
                        <a data-placement="right" data-toggle="popover"  
                        data-container="body" style="color:red"
                         data-html="true" href="#" id="login" class="approval">
                        <span class="fas fa-check-square"></span>Approvals</a>
              </c:when>
                        
              </c:choose>
                    </td>
              </tr>
              
            </table>
            	<!--hovern button status start-->
					 <div>
						<button type="button" id="Changes" data-container="body" class="btn btn-danger" data-toggle="popover" 
                    data-placement="right" data-original-title=""  data-html="true" data-trigger="hover"
                    data-content="
							Spoc Name: ${request.spocName} <br>
							Spoc Email: ${request.spocEmail }
							Trainer Name: ${request.trainerName}
							Trainer Email: ${request.trainerEmail}
							Training Module: ${request.module}
							Training Time Zone: ${request.timeZone}
							Start Time: ${request.actualStartDate} 
							End Time: ${request.actualEndDate}					
						"> SPOC </button>
					  </div>
						<!-- hovern button status end -->

          </div>
        </div>
      </div>
      <!--end card -->
      
            
        


 <!-- Training Edit popover script --> 
 <div class="modal fade" id="myModal${request.id}" role="dialog">
        <div class="modal-dialog modal-md" style="height: 100%; margin-top: 10%;">
          <div class="modal-content" style="width: 220%">
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
											<label class="control-label" style="padding: 0px 5px;">Participants </label>
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
            <div class="modal-dialog modal-md" style="height: 100%; margin-top: 10%;">
              <div class="modal-content" style="width: 300%">
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
										value="${request.requestedStartDate}" required>
								</div>
								<div>
									<input id="training_startTime" type="time" class="form-control"
										name="startTime" placeholder="Start time"
										value="${request.requestedStartTime}" required>
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
										value="${request.requestedEndDate}" required>
								</div>
								<div>
									<input id="training_endTime" type="time" class="form-control"
										name="endTime" placeholder="End time"
										value="${request.requestedEndTime}" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-xs-2">
									<label class="control-label"> Time Zone: </label>
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
    <!--Training Time Edit popup script  end-->
        <!--Aproval popover form End --> 
       <div id="popover-content" style="display:none"> 
        <div>
                    <form action="approve/${request.id}">
                    <div class="row">
                            <div class="col-xs-2">
                                    <label class="control-label">
                                    </label>
                            </div>
                          
                            <div class="container">
                                <input class="radio-inline" type="radio" id="DD" name="approvalRB" value="Deny" style="width: 30px; height: 30px;" checked>
                                <label class="form-check-label" for="data-dismiss" name="Deny" style="font-size: x-large; vertical-align: super;">Deny</label>
                                <input class="radio-inline" type="radio" id="AA" name="approvalRB" value="Accept" style="width: 30px; height: 30px; margin-left: 10px;">
                                <label class="form-check-label" for="AA" name="Accept" style="font-size: x-large; vertical-align: super;">Accept</label>
                                <br>
                            </div>
                        </div>
                        <div class="row" style="padding: 10px;">
                                <div class="col-2">
                                </div>
                                <div>
                                    <textarea class="form-control" cols="32" id="comment" name="textarea" placeholder="Comments" required></textarea>
                                </div>
                            </div>
                        <div class="popover-footer">
                                <div class="row" style="margin-top: 10px; float: right;">
                                        <div class="col">
                                            <div class="center-block">
                                              <button type="submit" class="btn btn-default" style="background-color: #31708F; color: white;">
                                                    Save
                                                    <i class="fa fa-save" aria-hidden="true"></i>
                                                </button><!-- Save changes button needs to close the popup-->
                                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button><!-- Close buttomn -->
                                            </div>
                                        </div>
                                    </div>
                        </div>
                            </form>
                            </div>
            </div>
      
</c:forEach>
      <!--row div end-->
    </div>

    <!-- /.container -->
  </div>

  <!-- Footer -->
<%--   <%@include file="trmfooterfile.jsp" %> --%>

<!--Script for the popover -->
<script>
$(function () {
	  $('#Changes').popover({
	    container: 'body'
	  });
	  $('.approval').popover({
		  container: 'body',
		  content: function() {
			  return $('#popover-content').html();
		  }
	  });
	});
</script> 
</body>

</html>