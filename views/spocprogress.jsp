<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="bootstrap-4.2.1-dist\css\bootstrap.min.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="spoc.css">
  <link rel="stylesheet" href="CSS/trm.css">
  <link rel="stylesheet" href="customcss/custom.css">
  <link rel="stylesheet" href="customcss/createrequest.css">

  <script src="spocJquery.js"></script>
</head>

<body>
  <!-- Top navigation -->
  <div id="topnav" class="navbar navbar-default navbar-fixed-top">
    <div class="header-container">
      <!-- Left-aligned link -->
      <div class="left-header">
        <a class="logo-content" href="#" title="Home">
          <img class="logoimage1" src="../Version0.4/img/as-logo.png" alt="Home">
        </a>
      </div>
      <!-- Right-aligned links -->
      <div id="right-header">
        <a href="about.html" class="about">About</a>
        <a href="#" class="logolink" title="Home">
          <img class="logoimage2" src="../Version0.4/img/as-logo.png" alt="Home">
        </a>
      </div>
    </div>
  </div>
  <!--End of navigation bar-->

  <!--Some space between navigation bar and actual content-->
  <div style="margin-top:9vh;"></div>

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
              <form class="form" style="margin-left:20px;">
                <br>
                <div class="row">
                  <div class="col-xs-2">
                    <label class="control-label">
                      Trainer Name
                    </label>
                  </div>
                  <div class="col-xs-8">
                    <input id="trainername" type="text" class="form-control" name="trainer_name" required>
                  </div>
                  <div class="col-xs-2">
                    <input class="checkbox-inline" type="checkbox" id="cc" name="check" value="cc">
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
                    <input id="training_start" type="date" class="form-control" name="training_start" placeholder="Start date">
                  </div>
                  <div>
                    <input id="training_startTime" type="time" class="form-control" name="training_startTime"
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
                      Mode
                    </label>
                  </div>
                  <div class="col-xs-10">
                    <input class="radio-inline" type="radio" id="ra" name="wt" value="wt">
                    <label class="form-check-label" for="ra" name="webtr">WT</label>
                    <input class="radio-inline" type="radio" id="rad" name="wt" value="Vendor">
                    <label class="form-check-label" for="rad" name="onlinetr">OCR</label>
                  </div>
                </div>
                <br>


                <br>
                <div class="row">
                  <div class="col">
                    <div class="text-right">
                      <button type="submit" class="btn btn-info">
                        Save
                        <i class="fa fa-save" aria-hidden="true"></i>
                      </button>
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
                <form class="form" style="margin-left:20px;">
                  <br>
                  <div class="row">
                    <div class="col-xs-2">
                      <label class="control-label">
                        Participants
                      </label>
                    </div>
                    <div class="col-xs-10">
                      <textarea class="form-control" rows="5" cols="52" id="comment" name="textarea" placeholder="Write here....."
                        required></textarea>
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
                      <select name="exec">
                        <option value="name1">Mike</option>
                        <option value="name2">Sabin</option>
                        <option value="name3">Nick</option>
                      </select>
                    </div>
                  </div>
                  <br>
                  <div class="row">
                    <div class="col">
                      <div class="text-center">
                        <button type="submit" class="btn btn-info">
                          Save
                          <i class="fa fa-save" aria-hidden="true"></i>
                        </button>
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

          </div>
          <!--End of detail-->

          <!--Detail with collapse-->
          <div class="detail-container border">
            <div class="detail-header" id="headingThree">
              <button class="detailBtn" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true"
                aria-controls="collapseThree">
                Status 3
                <span class="glyphicon glyphicon-arrow-right"></span>
              </button>
            </div>

            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
        <form class="form" style="margin-left:20px;">
            <br>
            <div class="row">
                <div class="col-xs-2">
                    <label class="control-label">
                        Trainer Name
                    </label>
                </div>
                <div class="col-xs-8">
                    <input id="trainername" type="text" class="form-control" name="trainer_name" required>
                </div>
                <div class="col-xs-2">
                    <input class="checkbox-inline" type="checkbox" id="cc" name="check" value="cc">
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
                    <input id="training_start" type="date" class="form-control" name="training_start" placeholder="Start date">
                </div>
                <div>
                    <input id="training_startTime" type="time" class="form-control" name="training_startTime"
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
                        Mode
                    </label>
                </div>
                <div class="col-xs-10">
                    <input class="radio-inline" type="radio" id="ra" name="wt" value="wt">
                    <label class="form-check-label" for="ra" name="webtr">WT</label>
                    <input class="radio-inline" type="radio" id="rad" name="wt" value="Vendor">
                    <label class="form-check-label" for="rad" name="onlinetr">OCR</label>
                </div>
            </div>
            <br>


            <br>
            <div class="row">
                <div class="col">
                    <div class="text-right">
                        <button type="submit" class="btn btn-info">
                            Save
                            <i class="fa fa-save" aria-hidden="true"></i>
                        </button>
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
            <p class="alignright">____________________</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Mode:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">____________________</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Training Start Date:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">____________________</p>
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
            <p class="alignright">____________________</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Location:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">____________________</p>
          </div>
        </div>

        <!--Field and output row-->
        <div class="row summary-text">
          <div class="col-sm-6">
            <p class="alignleft">Apporved Status:</p>
          </div>
          <div class="col-sm-6">
            <p class="alignright">____________________</p>
          </div>
        </div>

        <!--After the field and output rows are buttons to submit, save, or cancel-->
        <div class="flex-container downCenter">
          <div>
            <button type="button" class="btn btn-lg btn-success toSpocDashboard">Submit</button>
          </div>
          <div>
            <button type="button" class="btn btn-lg btn-primary toSpocDashboard">Save changes</button>
          </div>
          <div>
            <button type="button" class="btn btn-lg btn-secondary toSpocDashboard" data-dismiss="modal">Close</button>
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