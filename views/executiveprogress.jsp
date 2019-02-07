<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">

  	<link rel="stylesheet" href="/SpringMVCApp/resources/stylesheets/bootstrap.min.css">

  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

	<link rel="stylesheet" href="/SpringMVCApp/resources/stylesheets/exec.css">
 	<link rel="stylesheet" href="/SpringMVCApp/resources/stylesheets/trm.css">
 	<link rel="stylesheet" href="/SpringMVCApp/resources/stylesheets/custom.css">
 	<link rel="stylesheet" href="/SpringMVCApp/resources/stylesheets/execworkflowform.css">

  	<script src="/SpringMVCApp/resources/js/executiveJquery.js"></script>
<body>
	<!-- Top navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="/SpringMVCApp/resources/images/as-logo.png" alt="Home">
        </a>
      </div>
      <!-- Right-aligned links -->
      <div id="right-header">
        <a href="about.html" class="about">About</a>
        <a href="#" class="logolink" title="Home">
          <img class="logoimage2" src="/SpringMVCApp/resources/images/as-logo.png" alt="Home">
        </a>
      </div>
    </div>
  </div>
  <!--End of navigation bar-->
  
  <!--Some space between navigation bar and actual content-->
  <div style="margin-top:9vh;"></div>

  <!--Title of the trainer request progress-->
  <h2 class="text-center border-bottom">${dto.workflow.executiveWorkflowStatusId} Progress</h2>
  
  <!--Main content-->
  <div class="center-block" style="width:95%;">
    <div class="row">
      <!--Left side: Accordians that drop down forms-->
      <div class="col-sm-8 border" style="height: 77vh; overflow: auto;">
        <div id="accordion">
          <!--Detail with collapse-->

          <!--Training Section-->
          <div class="detail-container border">
            <div class="detail-header" id="headingOne">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
                aria-controls="collapseOne">
                About Training
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
              <form class="form" style="margin-left:0px;">

                <!--Row 1: Module & Name-->
                <div class="row">

                  <div class="col-sm-2">
                    <label>Module: </label>
                  </div>
                  <div class="col-sm-2">
                    <label>${dto.workflow.trainingRequest.requestTrainingModule}</label>
                  </div>

                  <div class="col-sm-2 offset-sm-2">
                    <label>Trainer Name: </label>
                  </div>
                  <div class="col-sm-2">
                    <label>${dto.trainerName}</label>
                  </div>
                </div>
                <br>

                <!--Row 2: Type and Mode-->
                <div class="row">

                  <div class="col-sm-2">
                    <label>Type: </label>
                  </div>
                  <div class="col-sm-2">
                    <label>${dto.workflow.trainingRequest.requestTrainingType}</label>
                  </div>

                  <div class="col-sm-2 offset-sm-2">
                    <label>Mode: </label>
                  </div>
                  <div class="col-sm-2">
                    <label>${dto.workflow.trainingRequest.requestTrainingMode}</label>
                  </div>
                </div>
                <br>

                <!--Row 3: Training Scope-->
                <div class="row" style="max-height: 300px; overflow:auto;">
                  <div class="col-sm-2">
                    <label>Scope: </label>
                  </div>
                  <div class="col-sm-8">
                    ${dto.workflow.trainingRequest.requestTrainingModuleScope}
                  </div>
                </div>
                <br>
              </form>
            </div>
          </div>

          <!--Time & Date Section-->
          <div class="detail-container border">
            <div class="detail-header" id="headingTwo">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
                aria-controls="collapseTwo">
                Time & Date
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
              <form class="form" style="margin-left:0px;">

                <!--Row 1: Start date and time-->
                <div class="row" style="max-height: 300px; overflow:auto;">

                  <div class="col-sm-2">
                    <label>Start Date:</label>
                  </div>
                  <div class="col-sm-3">
                    <label>${dto.schedule.training_start_date}</label>
                  </div>

                  <div class="col-sm-2">
                    <label>Start Time: </label>
                  </div>
                  <div class="col-sm-3">
                    <label>Some time</label>
                  </div>

                </div>
                <br>

                <!--Row 2: End date and time-->
                <div class="row" style="max-height: 300px; overflow:auto;">

                  <div class="col-sm-2">
                    <label>End Date: </label>
                  </div>
                  <div class="col-sm-3">
                    <label>${dto.schedule.training_end_date}</label>
                  </div>

                  <div class="col-sm-2">
                    <label>End Time: </label>
                  </div>
                  <div class="col-sm-3">
                    <label>Some time</label>
                  </div>

                </div>
                <br>

                <!--Row 3: Timezone-->
                <div class="row" style="max-height: 300px; overflow:auto;">

                  <div class="col-sm-2">
                    <label>Time Zone: </label>
                  </div>
                  <div class="col-sm-8">
                    <label>${dto.schedule.training_time_zone}</label>
                  </div>

                </div>
                <br>
              </form>
            </div>
          </div>

          <!--Participants Section-->
          <div class="detail-container border">
            <div class="detail-header" id="headingThree">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true"
                aria-controls="collapseThree">
                Participants
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
              <div class="card-body">
                <form class="form" style="max-height: 20vh; overflow: auto;">

                  <!--All participants here-->
                  <table style="width:100%;">
                    <tr style="font-size: 12pt;">
                      <th>First name</th>
                      <th>Last name</th>
                      <th>Email</th>
                    </tr>
                    <c:forEach items="${dto.participants}" var="participant">
                    	<tr>
                      		<td>${participant.participantEmployee.first_name}</td>
                      		<td>${participant.participantEmployee.last_name}</td>
                      		<td>${participant.participantEmployee.email}</td>
                    	</tr>
                    </c:forEach>
                  </table>
                </form>
              </div>
            </div>

          </div>

          <!--Options.-->
          <div class="detail-container border">
            <div class="detail-header" id="headingFive">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true"
                aria-controls="collapseFive">
                Options
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordion">
              <form class="form" style="margin-left:0px;" action="${dto.workflow.executiveWorkflowStatusId}" method="POST">

                <div>
                <table style="width:100%">
                  <tr style="font-size: 12pt;">
                    <th><label>Options</label></th>
                    <th><label>Status</label></th>
                  </tr>
                  <tr>
                    <td><label>Send Email</label></td>
                    <td><label><input type="checkbox" name="email"
							<c:if 
								test="${dto.workflow.invitationsSent == '1'}">checked="checked"
							</c:if> 
						/></label></td>
                  </tr>
                  <tr>
                    <td><label>Skill Enrollment</label></td>
                    <td><label><input type="checkbox" name="enrollment"
							<c:if test="${dto.workflow.skillportEnrollmentsCompleted == '1'}">checked="checked"</c:if> 
						/></label></td>
                  </tr>
                  <tr>
                    <td><label>Assessment Recorded</label></td>
                    <td><label><input type="checkbox" name="assessment"
							<c:if test="${dto.workflow.assessmentsRecorded == '1'}">checked="checked"</c:if> 
						/></label></td>
                  </tr>
                  <tr>
                    <td><label>Vendor Training Security Clearance</label></td>
                    <td><label><input type="checkbox" name="vendor"
							<c:if test="${dto.workflow.vendorTrainingClearance == '1'}">checked="checked"</c:if> 
						/></label></td>
                  </tr>
                  <tr>
                    <td><label>Feedback Completed</label></td>
                    <td><label><input type="checkbox" name="feedback"
							<c:if test="${dto.workflow.feedbackCompleted == '1'}">checked="checked"</c:if> 
						/></label></td>
                  </tr>
                  <tr>
                    <td><label>Send Training Completion</label></td>
                    <td><label><input type="checkbox" name="completion"
							<c:if test="${dto.workflow.trainingCompleted == '1'}">checked="checked"</c:if> 
						/></label></td>
                  </tr>
                </table>
                </div>
                <br>
                <div class="row">
                  <div class="col">
                    <div class="text-right">
                      <input type="submit" value="Submit">
                    </div>
                  </div>
                </div>
              </form>

            </div>

          </div>
          <!--End of detail-->
        </div>

      </div>
      <!--End of left side-->

      <!--Right side: Summary-->
      <div class="col-sm-4 border" style="height: 77vh;">
        <h3 class="text-center" style="font-weight: bold">Summary</h3>

        <!--Left side summary: field text-->
        <!--Right side summary: output text-->

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Mode:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${dto.workflow.trainingRequest.requestTrainingMode}</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Module:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${dto.workflow.trainingRequest.requestTrainingModule}</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Start Date:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${dto.schedule.training_start_date}</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Start Time:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">____________________</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Trainer:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${dto.trainerName}</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Location:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${dto.schedule.training_location}</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Approved Status:</p>
          </div>
          <div class="col-sm-6">
          	<c:if test="${dto.workflow.trainingRequest.status >= 5}">
            	<p class="alignright">Approved</p>
            </c:if>
            <c:if test="${dto.workflow.trainingRequest.status < 5}">
            	<p class="alignright">Not Approved</p>
            </c:if>
          </div>
        </div>
      </div>
      <!--End of Summary-->

    </div>
  </div>
  <!--End of main content-->

  <!--Footer of webpage-->
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
  <!--End of footer webpage-->
</body>
</html>