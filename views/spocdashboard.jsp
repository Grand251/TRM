<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<html lang="en">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    
    <link rel="stylesheet" href="resources/stylesheets/bootstrap.min.css">
    <link rel="stylesheet" href="resources/stylesheets/spoc.css">
    <link  rel="stylesheet" href="resources/stylesheets/custom.css" >

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <script src="resources/js/spocJquery.js"></script>    
        
</head>
<body>

    <!--Navigation Bar-->
    <nav class="navbar navbar-expand-sm bg-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Profile</a>
            </li>
        </ul>
    </nav> <!--End of navigation bar-->

    <!--Some space between navigation bar and actual content-->
    <div class="row space"></div>
	
	<form action="">
	    <div class="row" style="height: 70vh;">
        <!--New Request Box-->
        <div id="newRequestBox" class="border">
            <!--Start Button Send selected new requests to be ongoing requests-->
            <button id="startButton" class="row* sticky-top">
                Start
                <span id="right_arrow" class="glyphicon glyphicon-arrow-right"></span>
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
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true">
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Manager name </a></li><!--Spoc in charge of training --> 
                    <li><a href="#">Manager Email </a></li><!--Spoc's email--> 
                    <li><a href="#"> Trainer </a></li>
                    <li><a href="#">Trainer Email </a></li><!--Spoc's email-->  
                    <li><a href="#">${ntr.requestTrainingMode}</a></li><!--"mode" of training --> 
                    <li><a href="#">${ntr.requestTrainingType}</a></li><!--internal or vender --> 
                    <li><a href="#">${ntr.requestTrainingModule}</a></li> <!--type of trainig -module- (java,sql ect)-->
                    <li><a href="#">${ntr.approxNumberOfParticipants}</a></li>                     
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestStartTime}</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-calendar"></span>${ntr.requestEndTime}</a></li>
                    <li><a href="#">${ntr.requestLocation}</a></li><!--Where it is taking place if not online (IF ONLINE DONT SHOW)-->
                  </ul>
              </div> 
            </td>
            </th> 
            </table>
                <div class="card-body blueCard pointer">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>${ntr.status}                   
                          </td> <!--Where the training is in development -->
                      </tr>
                  </table>
                    <input id="select" type="checkbox" class="selectBox"/>
                </div>
              </div>
            </div>
            <!--end card -->
				</c:if>
            </c:forEach>
            </div>
                    </div> <!--End of New Request Box-->
	<form>

        <!--Ongoing Request Box-->
        <div id="ongoingRequestBox" class="border">
             <!-- 1 card -->
           <div class="ongoingRequest">
              <div class="card orangeCard" id="card">  
                <table>
                  <th>
                    <td>
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
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
                <h4 class="orangeCardTitle">Training name </h4> 
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
                <div class="card-body pointer toModal">
                  <table> 
                      <tr>
                        <td> <span class="glyphicon glyphicon-briefcase"></span>   Vertical </td> <!--What Vertical -->
                      </tr>
                      <tr>
                         <td><span class="glyphicon glyphicon-user"></span>   Trainer</td>
                      </tr>
                      <tr>
                          <td> <span class="glyphicon glyphicon-asterisk"></span>   Status                   
                          </td> <!--Where the training is in development -->
                      </tr>
                  </table>
                </div>
              </div>
            </div>
            <!--end card -->
            
        <!-- Modal -->
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog modal-xl" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center w-100" id="exampleModalLongTitle" style="font-weight:bold">Training Name</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="height: 77vh; overflow: auto">
                <div class="progress" style=" height: 30px;">
                <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="background-color: dodgerblue; width: 75%"></div>
                </div>
                    <div class="requestDetailsBox border">
                        
                        <div id="accordion">
                            <!--Detail with collapse-->
                            <div class="detail-container border">
                                <div class="detail-header" id="headingOne">
                                    <button class="detailBtn" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        Status 1
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                    </button>
                                </div>

                                <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                                    <div class="card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>

                            </div> <!--End of detail-->

                            <!--Detail with collapse-->
                            <div class="detail-container border">
                                <div class="detail-header" id="headingTwo">
                                    <button class="detailBtn" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                        Status 2
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                    </button>
                                </div>

                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                                    <div class="card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>

                            </div> <!--End of detail-->

                            <!--Detail with collapse-->
                            <div class="detail-container border">
                                <div class="detail-header" id="headingThree">
                                    <button class="detailBtn" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
                                        Status 3
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                    </button>
                                </div>

                                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                                    <div class="card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>

                            </div> <!--End of detail-->

                            <!--Detail with collapse-->
                            <div class="detail-container border">
                                <div class="detail-header" id="headingFour">
                                    <button class="detailBtn" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
                                        Status 4
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                    </button>
                                </div>

                                <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordion">
                                    <div class="card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>

                            </div> <!--End of detail-->

                            <!--Detail with collapse-->
                            <div class="detail-container border">
                                <div class="detail-header" id="headingFive">
                                    <button class="detailBtn" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
                                        Status 5
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                    </button>
                                </div>

                                <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordion">
                                    <div class="card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>

                            </div> <!--End of detail-->
                        </div>
                    </div> <!--End of detailRequestBox-->

                    <!-- Space between details and summary-->
                    <div class="spaceBetweenModal">&nbsp;</div>

                    <div class="requestSummaryBox border">
                        Summary
                    </div> <!--End of Summary Box-->
                </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-success">Submit</button>
            </div>
            </div>
        </div>
        </div><!-- End of Modal-->
        </div> 
        </div><!--End of ongoing request box-->
    </div><!--End of whole request secion-->
</body>
</html>