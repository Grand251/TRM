<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SPOC Dashboard</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
    crossorigin="anonymous">
    
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
        
    
      <link rel="stylesheet" href="resources/customcss/spoc-dashboard.css">


<script src="resources/spocJquery.js"></script>
<script>
  	function submitTR(){
  		$("#submitTR").submit();
  	}
  	
  	function submitITR(){
  		
    	$(".toInternal").click(function(){
      		var trainingRequestId = $(this).find('#internalId').val();
      		$("#selectITR").get(0).setAttribute('action', "edititr/"+trainingRequestId);
      		$("#selectITR").submit();
    	})	
  	}

  	$(function(){
  		
		  $(".toProgress").find("#trType").click(function(){
			  var id = $(this).parent().find("#ongoingId").val();
			  console.log(id)
			  $("#setType").get(0).setAttribute('value', id);

		  })
		  $("[data-toggle=popover]").popover({
			  	html: true,
			  	content: function() {
			  		return $("#popover-content").html();
			  	}
		  })
		  
		  $(document).on('click', "#closeType", function() {
			   console.log("closing");
			   $("[data-toggle=popover]").popover('hide');
			});

  	})
  	
  	
</script>
    <%@ include file="headerfile.jsp"%>
</head>

<body>
  <!-- Top navigation -->
  <%@include file="headerbody.jsp"%>
  <%@include file="navbar.jsp"%>
  
  <!--Some space between navigation bar and actual content-->
  <div class="row" style="height: 65vh;">
    <!--New Request Box-->
    <div id="newRequestBox" class="border">
    <form action="selectNewRequest">
      <!--Start Button Send selected new requests to be ongoing requests-->
      <button id="startButton" class="row* sticky-top" onclick="submitTR()" >
        Start
        <span id="right_arrow" class="glyphicon glyphicon-arrow-right"></span>
      </button>
	
      <!--New Requests would be added here-->
      <div class="col">
		<c:forEach items="${ntrList}" var="ntr">
      	<c:if test="${ntr.status == 0}">

        <div class="portfolio-item cardSpacing" style="float:left" >
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
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestStartTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestEndTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-time"> </span>${ntr.requestTimeZone }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-globe"></span>${ntr.requestLocation }</a></li>
                    <!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->

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
            <div class="blueCard card-body pointer" style="margin-top:-15px;">
              <table id="Info">
                <tr>
                  <td><input type="hidden" id="ntRId" name="trainingRequestId" value="${ntr.trainingRequestId}"></td>
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil" ></span>
                   ${ntr.requestTrainingModuleScope} </td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-calendar"></span>
                  <fmt:formatDate value="${ntr.requestStartTime }" pattern="MM/dd/yyyy"/>
                    </td>
                </tr>
                <tr>
                  <td><span class="glyphicon glyphicon-home"></span>
                    ${ntr.requestTrainingType }</td>
                </tr>
                <tr></tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-asterisk"></span>
                   New Request</td>
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
     </form>
    </div>
    <!--End of New Request Box-->

    <!--Ongoing Request Box-->
    <div id="ongoingRequestBox" class="border">
      <!-- Insert orange requests here-->

      <div style="margin-left: 7vw;">
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
                    <li><a href="#"> <span class="glyphicon glyphicon-modal-window"></span>${tr.requestTrainingMode }</a></li>
                    <!--"mode" of training -->
                    <li><a href="#"><span>&#35;</span>${tr.approxNumberOfParticipants } </a></li>
                    <!--Edit button 1 popover-->
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${tr.requestStartTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${tr.requestEndTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-time"> </span>${tr.requestTimeZone }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-globe"></span> ${tr.requestLocation }</a></li>
                    <!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                    <!--Edit button 1 popover-->
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
            <div class="card-body pointer toModal">
              <div class="card-body pointer toProgress" style="margin-top:-30px;">
              <input type="hidden" id="ongoingId" value="${tr.trainingRequestId}">
              <table id="Info">
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil"></span>
                    New Training Request </td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil"></span>
                   <fmt:formatDate value="${tr.requestStartTime}" pattern="MM/dd/yyyy"/>
				 </td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil"></span>
                    ${tr.requestTrainingModule } </td>
                </tr>
              </table>
				<a data-placement="right" data-toggle="popover"  
                        data-container="body" style="color: Blue; width: 500px; height: 500px;"
                         data-html="true" id="trType">
                        <span  class="glyphicon glyphicon-check"></span>Select Type</a>
              		 <!--Type popover form End --> 
			</div>
            </div>
            <!--card body end -->
            
          </div>
        </div>
        <!--end card -->   
        
        </c:if>
		</c:forEach>
		
       <c:forEach items="${itrList}" var="itr">
        <!-- 1 card -->
        <div class="portfolio-item cardSpacing" style="float:left">
          <div class="card h-100" id="card">
            <table>
              <td>
                <h3 align="left" style="margin-top: 0px">${itr.itrTrainingRequest.trainingRequestId} </h3>
              </td>
              <td>
                <!--card Drop down -->
                <div class="dropdown" align="right" style="margin-top: 0px" id="moreInfo">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true"><span class="glyphicon glyphicon-th-list"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>${itr.itrTrainingRequest.requestTrainingModuleScope }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span>${itr.itrTrainingRequest.requestTrainingType }</a></li>
                    <!--internal or vender -->
                    <li><a href="#"> <span class="glyphicon glyphicon-modal-window"></span>${itr.itrTrainingRequest.requestTrainingMode }</a></li>
                    <!--"mode" of training -->
                    <li><a href="#"><span>&#35;</span>${itr.itrTrainingRequest.approxNumberOfParticipants }</a></li>
                    <!--Edit button 1 popover-->
                    </li>

                    <li role="separator" class="divider"></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${itr.itrTrainingRequest.requestStartTime }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${itr.itrTrainingRequest.requestEndTime } </a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-time"> </span>${itr.itrTrainingRequest.requestTimeZone }</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-globe"></span> ${itr.itrTrainingRequest.requestLocation } </a></li>
                    <!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                    <!--Edit button 1 popover-->
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
          	<f:form id="selectITR" action="edititrform/${itr.itrId}">
            <div class="card-body pointer toInternal">
                <div class="card-body pointer toInternal" onclick="submitITR()" style="margin-top:-30px;">
                <input type="hidden" id="internalId" value="${itr.itrId}">
              <table id="Info">
                <tr>
                  <td> <span class="glyphicon glyphicon-pencil"></span>
                    Internal Training Request </td>
                </tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-calendar"></span>
                   <fmt:formatDate value="${itr.itrTrainingRequest.requestStartTime  }" pattern="MM/dd/yyyy"/>
                    </td>
                </tr>
                <tr>
                  <td><span class="glyphicon glyphicon-home"></span>
                    ${itr.itrTrainingRequest.requestTrainingModule }
                    </td>
                </tr>
                <tr></tr>
                <tr>
                  <td> <span class="glyphicon glyphicon-asterisk"></span>
                  	
                     ${itr.itrStatusDescription}</td>
                  <!--Where the training is in development -->
                </tr>
              </table>              
			</div>
            </div>
            </f:form>
            <!--card body end -->
          </div>
        </div>
        <!--end card -->
		</c:forEach>
		
		     <div id="popover-content" class="popover" style="display: none;"> 
            	<form id = "selectTT" action="selectTrainingType">
			<!--text box for the ID i believe--> 
			 		<div class="row">
                		<div>
                    		<input id="setType" name="trainingRequestId"  class="form-control" style="background-color: #D3D3D3;" readonly="true"/>
                    	</div>
              		</div>

			<!--this is the dropdown for the type -->
               	<div class="row">
                	<div class="col-xs-2">
                    	<label class="control-label">
                       		Training Type 
                     	</label>
                 	</div>
           		<div class="col-xs-10">
                	<select name="trainingRequestType" class="form-control">
                   		<option value="IT">Internal</option>
                        <option value="DT">Development</option>
                        <option value="VT">Vendor</option>
                   	</select>
             	</div>
          	</div>
                       <!--footer for the save and close buttons in the Type popover -->
            <div class="popover-footer">
            	<div class="row">
                	<div class="col">
                    	<div class="center-block">
                        	<button id="saveType" onclick="submitTT()" type="submit" class="btn btn-default" style="background-color: #31708F; color: white;">
                            	Save
                            	<i class="fa fa-save" aria-hidden="true"></i>
                         	</button><!-- Save changes button needs to close the popup-->
                          	<button id="closeType" type="button" class="btn btn-danger" data-dismiss="modal">Close</button><!-- Close buttomn -->
                     	</div>
               		</div>
             	</div>
       		</div>
     	</form>
  	</div> 
   
    <!--Type popup form End -->
		
      </div>
    </div>
  </div>
    <div class="row* space" style="margin-top:90px;"></div>
  
    <%@include file="footer.jsp" %>
  
</body>
</html>	