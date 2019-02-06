<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="resources/Bootstrap/bootstrap-4.2.1-dist\css\bootstrap.min.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="resources/customcss/spoc.css">
  <link rel="stylesheet" href="resources/CSS/trm.css">
  <link rel="stylesheet" href="resources/CSS/custom.css">

  <script src="resources/spocJquery.js"></script>
  <script>
  	function submitTT(){
    	$(".toModal").click(function(){
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
  </script>
  
</head>

<body>

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
    <f:form action="followupSelection" >
      <!--Start Button Send selected new requests to be ongoing requests-->
      <button id="startButton" class="row* sticky-top" onclick="submitTR()">
        Start
        <span id="right_arrow" class="glyphicon glyphicon-arrow-right"></span>
      </button>
      
	 </f:form>
      <!--New Requests would be added here-->
      <div class="col">
	<c:forEach items="${ntrList}" var="ntr">
      	<c:if test="${ntr.status == 0}">
        <!-- 1 card -->
        <div class="center-block newRequest">
          <div class="card" id="card">
            <table>
              <td>
                <h3 align="left" style="margin-top: 0px">${ntr.requestTrainingModule}</h3>
              </td>
              <td>
                <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true"><span class="glyphicon glyphicon-th-list"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">${ntr.trainingRequestId }</a></li>
                    <li><a href="#">${ntr.requestTrainingModuleScope }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span>${ntr.requestTrainingType }</a></li>
                    <!--internal or vender -->
                    <li><a href="#">${ntr.requestTrainingMode }</a></li>
                    <!--"mode" of training -->
                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestStartTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestEndTime }</a></li>
                    <li><a href="#">${ntr.requestTimeZone }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-globe"></span>${ntr.requestLocation }</a></li>
                    <!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span>&#35;</span>${ntr.approxNumberOfParticipants }</a></li>
                    <li><a href="#">Log</a></li>

                  </ul>
                </div>
              </td>
            </table>
            <div class="card-body blueCard pointer">
              <table id="Info">
                <tr></tr>
                <tr>
                  <td><input type="hidden" id="ntRId" name="trainingRequestId" value="${ntr.trainingRequestId}"></td>
                </tr>
                <tr>
                  <td>
                    ${ntr.trainingRequestId }</td>
                </tr>
                <tr>
                  <td>
                    Start Date</td>
                </tr>
                <tr>
                  <td>
                    ${ntr.requestTrainingType }</td>
                </tr>
                <tr>
                  <td>
                    approvals</td>
                </tr>
                <tr></tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-asterisk"></span>
                    ${ntr.status}</td>
                  <!--Where the training is in development -->
                </tr>
              </table>
              <input id="select" type="checkbox" class="selectBox" />
            </div>
          </div>
        </div>
        </c:if>
        <!--end card -->
		</c:forEach>
      </div>
    </div>
    <!--End of New Request Box-->
    
    <!--Ongoing Request Box-->
    <div id="ongoingRequestBox" class="border">
      <!-- Insert orange requests here-->
                   <!-- 1 card -->
           <c:forEach items="${trList}" var="trainingRequest">
           	<c:if test="${trainingRequest.status > 0 && trainingRequest.status < 4}">
           <div class="ongoingRequest">
              <div class="card orangeCard" id="card"> 
                <table>
                  <th>
                    <td>
                <h4 class="orangeCardTitle">Trainer ID: ${trainingRequest.trainingRequestId} </h4> 
              </td>
              <td>
                 <div class="dropdown" align="right">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true">
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Manager Name </a></li><!--Spoc in charge of training --> 
                    <li><a href="#">Manager Email </a></li><!--Spoc's email--> 
                    <li><a href="#"> Trainer </a></li>
                    <li><a href="#">Trainer Email </a></li><!--Spoc's email-->  
                    <li><a href="#"> online or class</a></li><!--"mode" of training --> 
                    <li><a href="#"> Training type </a></li><!--internal or vender --> 
                    <li><a href="#">Training subject </a></li> <!--type of trainig -module- (java,sql ect)-->
                    <li><a href="#"> Number of participants </a></li>                     
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>Start Time</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>End Time </a></li>
                    <li><a href="#"> location  </a></li><!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                  </ul>
              </div> 
            </td>
            </th> 
            </table>
            <f:form id="selectTT" action="">
                <div class="card-body pointer toModal" onclick="submitTT()">
                <input type="hidden" id="ongoingId" value="${trainingRequest.trainingRequestId}">
               	<input type="hidden" id="ongoingStatus" value="${trainingRequest.status}"> 
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   ${trainingRequest.status}                   
                          </td> <!--Where the training is in development -->
                      </tr>
                  </table>
                </div>
          </f:form>
              </div>
            </div>
            <!--end card -->
             <!-- 1 card -->
           </c:if>
            <!--end card -->
        </c:forEach>
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

</body>

</html>