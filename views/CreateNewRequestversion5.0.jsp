<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Create Request</title>
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
  <link rel="stylesheet" href="resources/createrequest.css">
</head>

<body>
  <!-- Navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top sticky-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="resources/as-logo.png" alt="Home">
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
        <div id = "userbutton" class="dropdown" style="float:right; margin-left:20px;margin-top: -5px;">
          <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-lg fa-user" aria-hidden="true" style="color:crimson"></i>
          </button>
          <div class="dropdown-menu dropdown-position" style="background-color:darkslategray" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="about.html">Account</a>
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Log Out</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color:midnightblue;">
    <button style="background-color:firebrick" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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

  <div class="container" id="bodycont" style="margin-top:50px">
    <form action = "addnewrequest" class="form" style="margin-left:20px;">
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Training module
          </label>
        </div>
        <div class="col-xs-10">
          <input id="trainingmodule" type="text" class="form-control" name="request_training_module" placeholder="Language(Java,Sql)"
            required>
        </div>
      </div>
      <br>

      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Module Scope
          </label>
        </div>
        <div class="col-xs-10">
          <textarea class="form-control" rows="5" id="comment" cols="52" name="textarea" placeholder="JDBC" required></textarea>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Training Mode
          </label>
        </div>
        <div class="col-xs-10">
          <input class="radio-inline" type="radio" id="mfm" name="online" value="Online" checked>
          <label class="form-check-label" for="mfm" name="online">Online</label>
          <input class="radio-inline" type="radio" id="mff" name="online" value="Vendor">
          <label class="form-check-label" for="mff" name="classrm">Classroom</label>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Preferred Training Type
          </label>
        </div>
        <div class="col-xs-10">
          <input class="radio-inline" type="radio" id="abc" name="type" value="Internal" checked>
          <label class="form-check-label" for="abc">Internal</label>
          <input class="radio-inline" type="radio" id="def" name="type" value="Vendor">
          <label class="form-check-label" for="def">Vendor</label>
          <input class="radio-inline" type="radio" id="bcd" name="type" value="Dev Team">
          <label class="form-check-label" for="bcd">Development</label>

        </div>
      </div>
      <br>
      <div class="row" style="align-items:center;display:flex">
        <div class="col-xs-2">
          <label class="control-label">
            Location
          </label>
        </div>
        <div class="col-xs-10">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fas fa-map-marker-alt"></i>
              </span>
            </div>
            <select name = "location" class="form-control">
              <option value="Phoenix">Phoenix</option>
              <option value="Memphis">Memphis</option>
              <option value="San Diego">San Diego</option>
            </select>
          </div>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Proposed Start Date/Time
          </label>
        </div>
        <div class="col-xs-5">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                  <i class="fas fa-calendar-alt"></i>
              </span>
            </div>
            <input id="training_start" type="date" class="form-control" name="training_start" placeholder="Start date">
          </div>
        </div>
        <div class="col-xs-5">
          <input id="training_startTime" type="time" class="form-control" name="training_startTime" placeholder="Start time"
            required>
        </div>
      </div>

      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Proposed End Date/Time
          </label>
        </div>
        <div class="col-xs-5">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                  <i class="fas fa-calendar-alt"></i>
              </span>
            </div>
            <input id="training_end" type="date" class="form-control" name="training_end" placeholder="End date">
          </div>
        </div>
        <div class="col-xs-5">
          <input id="training_endTime" type="time" class="form-control" name="training_endTime" placeholder="Start time"
            required>
        </div>

      </div>
      <br>
      <div class="row" style="align-items:center;display:flex">
        <div class="col-xs-2">
          <label class="control-label">
            Enter Time Zone
          </label>
        </div>
        <div class="col-xs-10">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fas fa-globe"></i>
              </span>
            </div>
            <select name = "timezone" class="form-control">
              <option value="UTC">ArizonaT</option>
              <option value="MST">MST</option>
              <option value="PT">PT</option>
            </select>
          </div>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Project SPOC
          </label>
        </div>
        <div class="col-xs-10">
          <input id="spoc" type="number" class="form-control" name="spoc" placeholder="SPOC ID" required>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            #Participants
          </label>
        </div>
        <div class="col-xs-10">
          <input id="participants" type="number" class="form-control" name="participants" placeholder="Participants number"
            required>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Justification
          </label>
        </div>
        <div class="col-xs-10">
          <textarea class="form-control" rows="5" id="comment" cols="52" name="justification" placeholder="Write text here...."
            required></textarea>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col">
          <div class="text-right" id="send_button">
            <button type="submit" class="btn btn-info">
              Send Request
              <i class="fa fa-save" aria-hidden="true"></i>
            </button>
          </div>
        </div>
      </div>
      <br>
      <br>
    </form>
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