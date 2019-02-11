<!DOCTYPE html>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="../resources/Bootstrap/bootstrap-4.2.1-dist\css\bootstrap.min.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="../resources/customcss/spoc-progress.css">

  <script src="../resources/spocJquery.js"></script>
  <script>

	
	$(document).on('click', "#closeSteps", function() {
		console.log("closing");
  		$("#submitForm").get(0).setAttribute('action', "../viewspocdashboard");
  		$("#submitForm").submit();
	});

  </script>
  
</head>

<body>
  <!-- Top navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="../resources/img/as-logo.png" alt="Home">
        </a>
      </div>
      <!-- Right-aligned links -->
      <div id="right-header">
        <a href="about.html" class="about">About</a>
        <a href="#" class="logolink" title="Home">
          <img class="logoimage2" src="../resources/img/as-logo.png" alt="Home">
        </a>
      </div>
    </div>
  </div>
  <!--End of navigation bar-->

  <!--Some space between navigation bar and actual content-->
  <div style="margin-top:17vh;"></div>

  <!--Title of the trainer request progress-->
  <h2 class="text-center border-bottom">Trainer Request Progress</h2>

  <!--Main content-->
  <div class="center-block" style="width:95%;">
    <div class="row">
      <!--Left side: Accordians that drop down forms-->
      <div class="col-sm-8 border" style="height: 77vh; overflow: auto;">
        <div id="accordion">
          <!--Detail with collapse-->
          <div class="detail-container border">
            <div class="detail-header" id="headingOne">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
                aria-controls="collapseOne">
                Status 1
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
              <form  action="../submitstepone/${itrId}" class="form" style="margin-left:20px;">
                <br>
                <div class="row">
                  <div class="col-xs-2">
                    <label class="control-label">
                      Trainer Name
                    </label>
                  </div>
                  <div class="col-xs-8">
                  	<select name="trainerId">
						<c:forEach items="${trainers}" var="trainer">
							<option label="${trainer.first_name} ${trainer.last_name}" value="${trainer.employee_id }"></option>
			
						</c:forEach>
			
					</select>
					</div>
                </div>
                <br>
                <div class="row">
                  <div class="col-xs-2">
                    <label class="control-label">
                      Training Start Date/Time
                    </label>
                  </div>
                  <div class="col-xs-5">
                    <input id="training_start" type="date" class="form-control" name="startDate" placeholder="Start date">
                  </div>
                  <div>
                    <input id="training_startTime" type="time" class="form-control" name="startTime"
                      placeholder="Start time" required>
                  </div>
                </div>
                <br>
                <div class="row">
                  <div class="col-xs-2">
                    <label class="control-label">
                      Training End Date/Time
                    </label>
                  </div>
                  <div class="col-xs-5">
                    <input id="training_end" type="date" class="form-control" name="endDate" placeholder="End date"/>
                  </div>
                  <div>
                    <input id="training_endTime" type="time" class="form-control" name="endTime" placeholder="Start time"
                      required>
                  </div>
                </div>
                <br>
                <div id="location" class="row">
                 <div class="col-xs-2">
                    <label class="control-label">
                      Training Location
                    </label>
                  </div>
                    	<div class="col-xs-4" >
                    		<input type="text" class="form-control" name="trainingCity" placeholder="City" required/>
                    	</div>
                    	<div class="col-xs-2" >
                    	
                    		<input type="text" class="form-control" name="trainingState" placeholder="State" required/>
                    	</div>
                    	<div class="col-xs-2" >
                    	
                    		<input type="text" class="form-control" name="trainingZipcode" placeholder="Zipcode" required/>
                    	</div>
                    	
                  </div>
                  <br>
                <div class="row">
                  <div class="col-xs-2">
                    <label class="control-label">
                      Mode
                    </label>
                    <script>
                    
                    $(document).on('click', "#classTraining", function(){
                    	$("#webTraining").prop('checked', false);
                    	$("#classroom").show();
                    	$("#web").hide();
                    	$("#trainingLocation").prop('required',true);
                    	$("#trainingRoom").prop('required',true);
                    })
                    $(document).on('click', "#webTraining", function(){
                    	$("#classTraining").prop('checked', false);
                    	$("#classroom").hide();
                    	$("#web").show();
                    	$("#trainingUrl").prop('required',true);
                    	$("#trainingAudio").prop('required',true);
                    })
                    
                    </script> 
                    
                  </div>
                  <div class="col-xs-10">
                    <input class="radio-inline" type="radio" id="webTraining" name="trainingMode" value="Web Based">
                    <label class="form-check-label" for="ra" name="wmode">Web Training</label>
                    <input class="radio-inline" type="radio" id="classTraining" name="trainingMode" value="Classroom Based">
                    <label class="form-check-label" for="rad" name="clmode">Classroom Training</label>
                 	<br>
                 	<br>
                 	
    				<div id="classroom" class="row" style="display:none">
                 		<div class="col-xs-2">
                    	<label class="control-label">
                      	Classroom
                    	</label>
                  		</div>
                    	<div class="col-xs-2" >
                    		<input type="text" class="form-control" name="trainingLocation" placeholder="Location"/>
                    	</div>
                    	<div class="col-xs-2" >
                    		<input type="text" class="form-control" name="trainingRoom" placeholder="Room #"/>
                    	</div>
                  </div>
                  
                   <div id="web" class="row" style="display:none">
                 		<div class="col-xs-2">
                    	<label class="control-label">
                      	Web
                    	</label>
                  		</div>
                    	<div class="col-xs-2" >
                    		<input type="text" class="form-control" name="trainingUrl" placeholder="URL" />
                    	</div>
                    	<div class="col-xs-2" >
                    		<input type="text" class="form-control" name="trainingAudio" placeholder="Audio" />
                    	</div>
                  </div>
                  
                  </div>
                  <br>
                
                </div>
                <br>


                <br>
                <div class="row">
                  <div class="col">
                    <div class="text-right">
                      <button type="submit" class="btn btn-info">
                        Submit
                        <i class="fa fa-save" aria-hidden="true"></i>
                      </button>
                    </div>
                  </div>
                </div>
              </form>
            </div>

          </div>
          <!--End of detail-->

          <!--Detail with collapse-->
          <div class="detail-container border">
            <div class="detail-header" id="headingTwo">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
                aria-controls="collapseTwo">
                Status 2
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
              <div class="card-body">
                <f:form action="../submitsteptwo/${itrId}" class ="form" style="margin-left:20px;">
                  <br>
                  <div class="row">
                    <div class="col-xs-2">
                      <label class="control-label">
                        Participants
                      </label>
                    </div>
                    <div class="col-xs-10">
                     <textarea class="form-control" rows="5" cols="52" id="comment" name="textarea" readonly="true" id="partList">
						<c:forEach items="${partNameList}" var="partName">${partName}&#13;&#10;</c:forEach>
						</textarea>
                    </div>
                  </div>
                  <br>
                  <div class="row" style="align-items:center;display:flex">
                    <div class="col-xs-2">
                      <label class="control-label">
                        Executive
                      </label>
                    </div>
                    <div class="col-xs-10">
						<f:select path="executiveWorkflowStatusExecutive"> 
							 <c:forEach items="${execList}" var="exec">
							 	<f:option value="${exec.employee_id}" label="${exec.first_name} ${exec.last_name}"/>
							 </c:forEach>
						</f:select><br>
                    </div>
                  </div>
                  <br>
                  <div class="row">
                    <div class="col">
                      <div class="text-center">
                        <button type="submit" class="btn btn-info">
                          Submit
                          <i class="fa fa-save" aria-hidden="true"></i>
                        </button>
                      </div>
                    </div>
                  </div>
                  </f:form>
              </div>
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
            <p class="alignleft">Mode:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${itr.itrTrainingRequest.requestTrainingMode }</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Start Date:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright"><fmt:formatDate value="${itr.itrSchedule.training_start_date  }" pattern="MM/dd/yyyy"/></p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training End Date:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright"><fmt:formatDate value="${itr.itrSchedule.training_end_date  }" pattern="MM/dd/yyyy"/></p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Trainer:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${itr.itrTrainer.first_name } ${itr.itrTrainer.last_name }</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Location:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${itr.itrSchedule.training_city } ${itr.itrSchedule.training_state}</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Approved Status:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">${approvalStatus}</p>
          </div>
        </div>
		
		<form id="submitForm" >
        <!--After the field and output rows are buttons to submit, save, or cancel-->
        <div class="flex-container downCenter">
          <div>
            <button type="button" id="closeSteps"  class="btn btn-lg btn-secondary toSpocDashboard" data-dismiss="modal" >Close</button>
          </div>
        </div>
        </form>
      </div>
      <!--End of Summary-->
    </div>
  </div>
  <!--End of main content-->

  <!--Footer of webpage-->
  <footer id="footer">
      <div class="col-xs-12">
        <p class="m-0" style="text-align:center;margin-top:15px;">&copy;Copyright 2017 Syntel INC. All
          rights
          reserved.
        </p>
      </div>
  </footer>
  <!--End of footer webpage-->
</body>

</html>