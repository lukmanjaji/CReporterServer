<%@page import="com.labafrique.creporter.model.ReportModel" %>
<%
    String code = request.getParameter("t");
    ReportModel model = (ReportModel) session.getAttribute(code);
    String m[] =  model.getCaseLocation().split(",");
    
%>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title> </title>

	<link href="img/favicon.144x144.png" rel="apple-touch-icon" type="image/png" sizes="144x144">
	<link href="img/favicon.114x114.png" rel="apple-touch-icon" type="image/png" sizes="114x114">
	<link href="img/favicon.72x72.png" rel="apple-touch-icon" type="image/png" sizes="72x72">
	<link href="img/favicon.57x57.png" rel="apple-touch-icon" type="image/png">
	<link href="img/favicon.png" rel="icon" type="image/png">
	<link href="img/favicon.ico" rel="shortcut icon">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
    <link rel="stylesheet" href="css/lib/font-awesome/font-awesome.min.css">
    <link rel="stylesheet" href="css/lib/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
<style>
* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.x1 {
  float: left;
  width: 25%;
  padding: 0px;
 /* Should be removed. Only for demonstration */
}

/* Create three equal columns that floats next to each other */
.x2 {
  float: left;
  width: 25%;
  padding: 0px;
 /* Should be removed. Only for demonstration */
}

/* Create three equal columns that floats next to each other */
.x3 {
  float: left;
  width: 50%;
  padding: 0px;
  height: 100%
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
   
    
    
    
</head>
<body style="height: 100%">

  <div class="column x1">
    <section class="card">
				<header class="card-header">
					Case Details
					
					
				</header>
				<div class="card-block">
                                    <b>Category</b><br>
                                    <%=model.getCategory()%><br>
                                    <b>Date</b><br>
                                    <%=model.getCreatedAt()%><br>
                                    <b>Address</b><br>
                                    <%=model.getAddress()%><br>
                                    <b>Details</b><br>
                                    <%=model.getDetails()%><br>
                                            
					
				</div>
				
			</section>
  </div>
  <div class="column x2">
    <section class="card">
				<header class="card-header">
					Media
					
					
				</header>
				<div class="card-block">
					<p class="card-text">
					<audio controls preload="metadata" style=" width:300px;">
                                            <source src="http://localhost:9494/creporter/listener/getFile/<%=code%>_audioFile" type="audio/mpeg" style="height: 50%;">
	Your browser does not support the audio element.
</audio>
					</p>
				</div>
			
				<div class="card-block">
					<p class="card-text">
					<video id="vplay" width="320" height="220" controls>
  <source src="http://localhost:9494/creporter/listener/getFile/<%=code%>_videoFile" type="video/mp4">
  <source src="movie.ogg" type="video/ogg">
Your browser does not support the video tag.
</video>
					</p>
				</div>
				
							<div class="card-block">
					<p class="card-text">
                                            <img id="myImg" src="http://localhost:9494/creporter/listener/getFile/<%=code%>_photoFile" onclick="ImageViewer('http://localhost:9494/creporter/listener/getFile/<%=code%>_photoFile')" alt="Snow" style="width:100%;max-width:350px; height: 180px">
					</p>
				</div>
				
			</section>
        
        
  </div>
  <div class="column x3" style="height: 100%">
   <div  id="map-container-google-1" class="z-depth-1-half map-container" style="height: 100%; width: 100%">
  <iframe src="/map?lat=<%=m[0]%>&lon=<%=m[1]%>" frameborder="0"
     allowfullscreen style="width: 100%; height: 100%"></iframe>
  </div>
</div>


	<script src="js/lib/jquery/jquery.min.js"></script>
	<script src="js/lib/tether/tether.min.js"></script>
	<script src="js/lib/bootstrap/bootstrap.min.js"></script>
	<script src="js/plugins.js"></script>

<script src="js/app.js"></script>




</body>
</html>