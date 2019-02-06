<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="resources/bootstrap-4.2.1-dist/css/bootstrap.min.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="resources/spoc.css">
  <link rel="stylesheet" href="resources/CSS/trm.css">
  <link rel="stylesheet" href="resources/customcss/custom.css">

  <script src="resources/executiveJquery.js"></script>
</head>

<body>
  <!--Top navigation -->
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

  <!--Space between navigation and ongoing requests-->
  <div style="height:10vh;"></div>

  <!--Container that holds ongoing requests-->
  <div class="border center-block" style="width: 95%; height:81vh; overflow: auto;">	
  	<c:forEach items="${trainings}" var="training">
  		<!-- 1 card -->
    <div class="portfolio-item cardSpacing" style="float:left">
      <div class="card h-100" id="card">
        <table>
          <td>
            <h3 align="left" style="margin-top: 0px">${training.workflow.executiveWorkflowStatusId}</h3>
          </td>
          <td>
            <!--card Drop down -->
            <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
              <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                aria-haspopup="true"><span class="glyphicon glyphicon-th-list"></span>
              </button>
              <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="#"><span class="glyphicon glyphicon-pencil"></span> ${training.workflow.trainingRequest.requestTrainingModuleScope} </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-home"></span> ${training.workflow.trainingRequest.requestTrainingType}</a></li>
                <!--internal or vender -->
                <li><a href="#"> <span class="glyphicon glyphicon-modal-window"></span> ${training.workflow.trainingRequest.requestTrainingMode}</a></li>
                <!--"mode" of training -->
                <li><a href="#"><span>&#35;</span> ${training.workflow.trainingRequest.approxNumberOfParticipants} Participants </a></li>
                <!--Edit button 1 popover-->
                <li> <button type="button" class="center-block" data-toggle="modal" data-target="#myModal">Edit</button></li>
                </li>

                <li role="separator" class="divider"></li>
                <li><a href="#"><span class="glyphicon glyphicon-calendar"></span> ${training.schedule.training_start_date} </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-calendar"></span> ${training.schedule.training_end_date} </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-time"> </span>${training.schedule.training_time_zone} </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-globe"></span> ${training.schedule.training_location} </a></li>
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
        <div class="card-body pointer toExecutiveProgress">
          <table id="Info">
            <tr>
              <td> <span class="glyphicon glyphicon-pencil"></span>
                ${training.workflow.trainingRequest.requestTrainingModule} </td>
            </tr>
            <tr>
              <td> <span class="glyphicon glyphicon-calendar"></span>
                ${training.schedule.training_start_date} </td>
            </tr>
            <tr>
              <td><span class="glyphicon glyphicon-home"></span>
                ${training.workflow.trainingRequest.requestTrainingType} </td>
            </tr>
            <tr></tr>
            <tr>
              <td> <span class="glyphicon glyphicon-asterisk"></span>
                ${training.workflow.trainingRequest.status} </td>
              <!--Where the training is in development -->
            </tr>
          </table>

        </div>
        <!--card body end -->
      </div>
    </div>
    <!--end card -->
  	</c:forEach>
  	
  </div>
  <!--End of fluid-->

  <!--Footer-->
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
  <!--End of footer-->
</body>

</html>