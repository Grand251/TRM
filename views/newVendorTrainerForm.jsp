<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Create Header</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="resources/createrequest.css">
</head>

<body>
	<!-- Navigation -->
	<div id="topnav"
		class="navbar navbar-default navbar-fixed-top sticky-top">
		<div class="header-container">
			<!-- Left-aligned link -->
			<div class="left-header">
				<a class="logo-content" href="#" title="Home"> <img
					class="logoimage1" src="../img/as-logo.png" alt="Home">
				</a>
			</div>
			<div id="right-header">
				<div style="float: left">
					<div class="abouticon" style="float: left">
						<a class="active" href="#"> <i
							class="fas fa-2x fa-info-circle" style="margin-top: -4px"></i>&nbsp;&nbsp;
						</a>
					</div>
					<div class="welcome" style="float: right">
						<h5 class="user">Welcome User</h5>
					</div>
				</div>
				<div class="dropdown"
					style="float: right; margin-left: 20px; margin-top: -5px;">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="fa fa-lg fa-user" aria-hidden="true"
							style="color: crimson"></i>
					</button>
					<div class="dropdown-menu dropdown-position"
						style="background-color: darkslategray"
						aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="about.html">Account</a> <a
							class="dropdown-item" href="#">Settings</a> <a
							class="dropdown-item" href="#">Log Out</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: midnightblue;">
		<button style="background-color: firebrick" class="navbar-toggler"
			type="button" data-toggle="collapse" data-target="#navbarNav"
			aria-controls="navbarNav" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<button type="submit" class="btn btn-secondary">
						Request <i class="fas fa-folder-plus"></i>
					</button> &nbsp;&nbsp;
				</li>
				<li class="nav-item">
					<button type="submit" class="btn btn-info">
						Reports&nbsp; <i class="far fa-chart-bar"></i>
					</button> &nbsp;&nbsp;
				</li>
				<li class="nav-item">
					<form action="#">
						<div class="input-group">
							<!-- puts group in a row -->
							<input type="text" class="form-control" id="searchinput"
								placeholder="Search..">
							<div class="input-group-append">
								<span class="input-group-text"> <i class="fa fa-search"></i>
								</span>
							</div>
						</div>
					</form>
				</li>
			</ul>
		</div>
	</nav>
	<!--End NAV-->
	<div class="container" id="bodycont" style="margin-top: 50px">
		<f:form class="form" action="insertVendorTrainer"
			style="margin-left:20px;width:80%">
			<h3>New Vendor Trainer Details</h3>
			<br>
			<br>

			<div class="row" style="align-items: center; display: flex">
				<div class="col-xs-2">
					<label class="control-label"> Vendor Trainer_Name </label>
				</div>
				<div class="col-xs-10">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i
								class="fas fa-address-card"></i>
							</span>
						</div>
						<f:input path="vendor_trainer_name" id="vendor_trainer_name"
							class="form-control" name="vendor_trainer_name" />

					</div>
				</div>
			</div>
			<br>
			<div class="row" style="align-items: center; display: flex">
				<div class="col-xs-2">
					<label class="control-label"> Phone </label>
				</div>
				<div class="col-xs-10">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-phone"></i>
							</span>
						</div>
						<f:input path="phone" id="phone" type="number"
							class="form-control" name="phone" />
					</div>
				</div>
			</div>
			<br>
			<div class="row" style="align-items: center; display: flex">
				<div class="col-xs-2">
					<label class="control-label"> Email </label>
				</div>
				<div class="col-xs-10">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-at"></i>
							</span>
						</div>
						<f:input path="email" id="email" class="form-control" name="email" />
					</div>
				</div>
			</div>
			<br>
			<div class="row" style="align-items: center; display: flex">
				<div class="col-xs-2">
					<label class="control-label"> Profile </label>
				</div>
				<div class="col-xs-10">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-user"></i>
							</span>
						</div>
						<f:input path="profile" id="profile" class="form-control"
							name="profile" />
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-xs-2">
					<label class="control-label"> Evaluation Status </label>
				</div>
				<div class="col-xs-10">
					<f:checkbox path="evaluation_status" class="checkbox-inline"
						id="evaluation_status" name="evaluation_status" value="true" />

				</div>
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-xs-2">
					<label class="control-label"> Vendor Trainer Log </label>
				</div>
				<div class="col-xs-10">
					<f:textarea path="vendor_trainer_log" rows="5" cols="52"
						id="vendor_trainer_log" name="vendor_trainer_log" />
				</div>
			</div>
			<br>

			<div class="row" style="align-items: center; display: flex">
				<div class="col">
					<div class="text-right" id="send_button">
						<f:button class="btn btn-info">
							Create <i class="fas fa-plus"></i>
						</f:button>


					</div>
				</div>
			</div>
			<br>
			<br>
		</f:form>
	</div>
	<!-- Footer -->
	<footer id="footer">
		<p class="para">&copy;Copyright 2017 Syntel INC. All rights
			reserved.</p>
	</footer>
</body>

</html>