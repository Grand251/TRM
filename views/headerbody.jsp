<div id="topnav" class="navbar navbar-default navbar-fixed-top sticky-top">
    <div class="header-container">
        <!-- Left-aligned link -->
        <div class="left-header">
            <a class="logo-content" href="backtodashboard" 
            title="Home">
                <img class="logoimage1" src="resources/images/as-logo.png" alt="Home">
            </a>
        </div>
        <div id="right-header">
            <div style="float:left; margin-left: 20%;">
                <div class="abouticon" style="float:left">
                    <a class="active" href="#">
                        <i class="fas fa-2x fa-user" style="margin-top:-4px"></i>&nbsp;&nbsp;
                    </a>
                </div>
                <div class="welcome" style="float:right">
                    <h5 class="user">Welcome, <%=session.getAttribute("username").toString() %></h5>
                </div>
            </div>
            <form action="/SpringMVCApp/loginform">
            	<input type="submit" class="btn btn-primary" value="Logout">
            </form>
        </div>
    </div>
</div>