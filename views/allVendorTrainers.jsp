<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>All Vendors Trainers</title>
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

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <script src="tableJQuery.js"></script>
</head>

<body>
  <!-- Navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top sticky-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="../img/as-logo.png" alt="Home">
        </a>
      </div>
      <div id="right-header">
        <div style="float:left">
          <div class="abouticon" style="float:left">
            <a class="active" href="#">
              <i class="fas fa-2x fa-info-circle" style="margin-top:-4px"></i>&nbsp;&nbsp;
            </a>
          </div>
          <div class="welcome" style="float:right">
            <h5 class="user">Welcome User</h5>
          </div>
        </div>
        <div id="userbutton" class="dropdown" style="float:right; margin-left:20px;margin-top: -5px;">
          <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-lg fa-user" aria-hidden="true" style="color:crimson"></i>
          </button>
          <div class="dropdown-menu dropdown-position" style="background-color:darkslategray"
            aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="about.html">Account</a>
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Log Out</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color:midnightblue;">
    <button style="background-color:firebrick" class="navbar-toggler" type="button" data-toggle="collapse"
      data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <button type="submit" class="btn btn-secondary">
            Request
            <i class="fas fa-folder-plus"></i>
          </button> &nbsp;&nbsp;
        </li>
        <li class="nav-item">
          <button type="submit" class="btn btn-info">
            Reports&nbsp;
            <i class="far fa-chart-bar"></i>
          </button> &nbsp;&nbsp;
        </li>
        <li class="nav-item">
          <form action="#">
            <div class="input-group">
              <!-- puts group in a row -->
              <input type="text" class="form-control" id="searchinput" placeholder="Search..">
              <div class="input-group-append">
                <span class="input-group-text">
                  <i class="fa fa-search"></i>
                </span>
              </div>
            </div>
          </form>
        </li>

      </ul>
    </div>
  </nav>
  <!--End NAV-->

  <!--Main Content-->
  <div class="container-fluid" style="height: 77vh; overflow: auto;">

    <!--Title with insert link-->
    <div class="row">
      <div class="col-sm-4 offset-sm-4">
        <h1 class="text-center">All Vendor Traininers Table</h1>
      </div>
      <div class="col-sm-4" style="position: relative;">
        <a href="insertVendorTrainerForm" data-toggle="tooltip" title="Insert new employee" style="position:absolute; bottom:0; left:65%;">
          <span class="glyphicon glyphicon-plus" style="font-size: 30px; color:cornflowerblue; padding: 3px;"></span>
        </a>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-10 offset-sm-1">
        <table class="table border border-dark table-striped">
          <!--Table head-->
          <thead class="thead-dark">
            <tr>
              <th class="text-center" scope="col">ID</th>
              <th class="text-center" scope="col">Name</th>
              <th class="text-center" scope="col">Phone</th>
              <th class="text-center" scope="col">Email</th>
              <th class="text-center" scope="col">Profile</th>
              <th class="text-center" scope="col">Evaulation Status</th>
              <th class="text-center" scope="col">Log</th>
              <th class="text-center" scope="col">Edit</th>
              <th class="text-center" scope="col">Delete</th>
            </tr>
          </thead>

          <!--Insert vendor trainers here!!-->
          <tbody>

            <c:forEach items = "${vendorTrainers}" var = "vendorTrainer">
            <tr>
              <td class="text-center" scope="row" id="vendor_trainer_id">${vendorTrainer.getVendor_trainer_id()}</td>
              <td class="text-center" id="vendor_trainer_name">${vendorTrainer.getVendor_trainer_name()}</td>
              <td class="text-center" id="phone">${vendorTrainer.getPhone()}</td>
              <td class="text-center" id="email">${vendorTrainer.getEmail()}</td>

              <td class="text-center" id="profile">
                <a href="${vendorTrainer.getProfile()}">
                  <span data-toggle="tooltip" title="View profile" class="glyphicon glyphicon-user"
                    style="color:black;"></span>
                </a>
              </td>

              <td class="text-center" id="evaulation_status">
                <c:choose>	
					<c:when test = "${vendorTrainer.getEvaluation_status() == 'true'}">
						<span data-toggle="tooltip" title="Complete"
							class="glyphicon glyphicon-ok" style="color: green;"></span>
					</c:when>
					<c:otherwise>
						<span data-toggle="tooltip" title="Delete"
							class="glyphicon glyphicon-remove" style="color: red;"></span>
					</c:otherwise>
				</c:choose>
              </td>

              <td class="text-center" id="vendor_trainer_log">
                <a href="${vendorTrainer.getVendor_trainer_log()}">
                  <span data-toggle="tooltip" title=".pdf?" class="glyphicon glyphicon-file" style="color:black"></span>
                </a>
              </td>

              <td class="text-center" id="edit">
                <a href="editVendorTrainer/${vendorTrainer.getVendor_trainer_id()}">
                  <span data-toggle="tooltip" title="Edit" class="glyphicon glyphicon-pencil"
                    style="color:black;"></span>
                </a>
              </td>

              <td class="text-center" id="delete">
                <a href="deleteVendorTrainer/${vendorTrainer.getVendor_trainer_id()}">
                  <span data-toggle="tooltip" title="Delete" class="glyphicon glyphicon-remove"
                    style="color:red;"></span>
                </a>
              </td>
            </tr>

            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <!-- Footer -->
  <footer id="footer">
    <p class="para">&copy;Copyright 2017 Syntel INC. All
      rights
      reserved.
    </p>
  </footer>
</body>

</html>