<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:midnightblue; padding-top: 10px; padding-bottom: 10px;">
    <button style="background-color:firebrick" class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav" style="margin-left: 40px;">
        <ul class="navbar-nav">
            <li class="nav-item">
            	<a href="chartRequester">
            		<form action="getChart">
	            		<button type="submit" class="btn btn-info">
		                    Reports&nbsp;
		                    <i class="far fa-chart-bar"></i>
		                </button> &nbsp;&nbsp;
            		</form>
                </a>
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