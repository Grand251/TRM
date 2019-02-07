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
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="resources/stylesheets/createrequest.css">

  <style>
    #icon
    { 
      line-height:40px;
      background:paleturquoise;
      color:blue;
            
    }
  </style>
</head>

<body>

  <!-- Navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top sticky-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="resources/images/as-logo.png" alt="Home">
        </a>
      </div>
      <!-- Right-aligned links -->
      <div id="right-header">
        <a href="about.html" class="about">About</a>
      </div>
    </div>
  </div>
  <!--End NAV-->

  <div class="container">
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
          <textarea class="form-control" rows="5" id="comment" name="textarea" placeholder="JDBC" required></textarea>
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
          <label class="form-check-label" for="mff" name="vendor">Vendor</label>    
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
      <div class="row">
        <div class="col-xs-2">
          <label class="control-label">
            Location
          </label>
        </div>
        <div class="col-xs-10">
              <select name = "location">
                  <option value="Phoenix">Phoenix</option>
                  <option value="Memphis">Memphis</option>
                  <option value="San Diego">San Diego</option>
              </select>
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
          <input id="training_start" type="date" class="form-control" name="training_start" placeholder="Start date">
        </div>
        <div>
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
      <input id="training_end" type="date" class="form-control" name="training_end" placeholder="End date">
    </div>
    <div>
      <input id="training_endTime" type="time" class="form-control" name="training_endTime" placeholder="Start time"
        required>
    </div>
  </div>
  <br>
  <div class="row">
      <div class="col-xs-2">
        <label class="control-label">
          Enter Time Zone
        </label>
      </div>
      <div class="col-xs-10">
          <select name = "timezone">
              <option value="UTC">UTC</option>
              <option value="MST">MST</option>
              <option value="PT">PT</option>
          </select>
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
          <input id="spoc" type="number" class="form-control" name="spoc" placeholder="SPOC ID"
            required>
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
            Justification of Request:
          </label>
        </div>
        <div class="col-xs-10">
          <textarea class="form-control" rows="5" id="justification" name="justification" placeholder="Reason for request" required></textarea>
        </div>
      </div>
      <br>
        <br>
        <div class="row">
            <div class="col">
              <div class="text-right">
                <button type="submit" class="btn btn-info">
                    Send Request
                   <i class="fa fa-save" aria-hidden="true"></i>
                   </button>
                </div>
            </div>
        </div>







  <!--  <div class="form-group mb-4">
        <label class="control-label" class="sr-only">
          Training module
          <input id="request_training_module" type="text" class="form-control" name="request_training_module" placeholder="Language(Java,Sql)"
          required>
        </label>
      </div> -->
  <!--  <div class="form-group">
        <label class="control-label" for="request_training_module_scope">Module Scope</label>
      
        <input id="request_training_module_scope" type="textarea" class="form-control" name="request_training_module_scope"
          placeholder="JDBC" required>

      </div>
      <div class="form-group mb-4">
          <label class="control-label" for="req">Training Mode</label>
          <label class="form-check-label" for="mfm">Online</label>
          <input class="radio-inline" type="radio" id="mfm" value="mfm">
          <label class="form-check-label" for="mff">Vendor</label>
          <input class="radio-inline" type="radio" id="mff" value="mff">
      </div>

      <div class="form-group">
        <label class="control-label" for="training_type">
          Preferred Training Type
        </label>
          <label class="form-check-label" for="abc">Internal</label>
          <input class="radio-inline" type="radio" id="abc" value="b">
          <label class="form-check-label" for="bcd">Development Team</label>
          <input class="radio-inline" type="radio" id="bcd" value="b">
          <label class="form-check-label" for="def">Vendor</label>
          <input class="radio-inline" type="radio" id="def" value="c">
      </div>
      <div class="form-group" style="margin-top:40px"> 
          <label class="control-label" for="request_time_zone">
            Enter Training Location
          </label>
          <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Training Location
              </button>
              <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
          </div>
      </div>

      <div class="form-group">
        <label class="control-label" for="request_training_start">
          Proposed Start Date/Time
        </label>
        <div class="input-group">
          <div class="input-group-addon">
            <i id="icon" class="fas fa-lg  fa-fw fa-calendar"></i>
          </div>
          <input id="request_training_start" type="date" class="form-control" name="request_training_start" placeholder="Start date">
        </div>
      </div>
      <div class="form-group">
        </label>
        <div class="input-group">
          <div class="input-group-addon">
            <i id="icon" class="fa fa-clock-o" aria-hidden="true"></i>
          </div>
          <input id="request_training_startTime" type="time" class="form-control" name="request_training_startTime"
            placeholder="Start time" required>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label" for="request_training_end">
          Proposed End Date/Time
        </label>
        <div class="input-group">
          <div class="input-group-addon">
            <i id="icon" class="fas fa-lg fa-fw fa-calendar"></i>
          </div>
          <input id="request_training_end" type='date' class="form-control" name="request_training_end">
        </div>
      </div>

      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">
            <i id="icon" class="fa fa-clock-o" aria-hidden="true"></i>
          </div>
          <input id="request_training_endTime" type="time" class="form-control" name="request_training_endTime"
            placeholder="End time">
        </div>
      </div>

      <div class="form-group">
        <label class="control-label" for="request_time_zone">
         Enter Time Zone
        </label>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Time Zone
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">UTC</a>
                <a class="dropdown-item" href="#">MST</a>
                <a class="dropdown-item" href="#">PST</a>
            </div>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label" for="request_project_spoc">
          Project Spoc
        </label>
        <input id="request_project_spoc" type="number" class="form-control" name="request_project_spoc" placeholder="SPOC ID"
          required>
      </div>
      <div class="form-group">
        <label class="control-label" for="request_approx_participant">
          #Participants
        </label>
        <input id="request_approx_participant" type="number" class="form-control" name="request_approx_participant"
          placeholder="Participants number" required>
      </div>
      <div class="form-group">
      <button type="submit" class="btn btn-info">
       Send Request
      <i class="fa fa-save" aria-hidden="true"></i>
      </button> -->
  <!-- </div> -->

  </form>
  </div>

  <!-- Footer -->
  <footer id="footer">
    <div style="margin:10px 0 0 0" class="row">
      <div class="col-xs-12">
        <p style="text-align:center;margin-top:10px;margin-right:0;margin-left:25px">&copy;Copyright 2017 Syntel INC.
          All
          rights
          reserved.
        </p>
      </div>
    </div>
  </footer>
</body>

</html>