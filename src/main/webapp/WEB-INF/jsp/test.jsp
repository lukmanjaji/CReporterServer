<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>CReporter Admin</title>
        <script src="/js/ws.js"></script>
        <script>
            startWS();
        </script>
	
        


	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
<link rel="stylesheet" href="css/lib/lobipanel/lobipanel.min.css">
<link rel="stylesheet" href="css/separate/vendor/lobipanel.min.css">
<link rel="stylesheet" href="css/lib/jqueryui/jquery-ui.min.css">
<link rel="stylesheet" href="css/separate/pages/widgets.min.css">
<link rel="stylesheet" href="css/lib/font-awesome/font-awesome.min.css">

<link href="css/lib/charts-c3js/c3.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="css/lib/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/lib/datatables-net/datatables.min.css">
<link rel="stylesheet" href="css/separate/vendor/datatables-net.min.css">

<link rel="stylesheet" href="css/alertify.css"/>
<link rel="stylesheet" href="css/themes/default.min.css"/>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

    


    
</head>
<body class="with-side-menu" style="height: 100%">
    

	<header class="site-header">
	    <div class="container-fluid">
	
	        <a href="#" class="site-logo">
	            <img class="hidden-md-down" src="/img/logo-2.png" alt="">
	            <img class="hidden-lg-up" src="/img/logo-2-mob.png" alt="">
	        </a>
	
	        <button id="show-hide-sidebar-toggle" class="show-hide-sidebar">
	            <span>toggle menu</span>
	        </button>
	
	        <button class="hamburger hamburger--htla">
	            <span>toggle menu</span>
	        </button>
	        <div class="site-header-content">
	            <div class="site-header-content-in">
	                <div class="site-header-shown">
	                   
	                    <div class="dropdown user-menu">
	                        <button class="dropdown-toggle" id="dd-user-menu" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            <img src="/img/avatar-2-64.png" alt="">
	                        </button>
	                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd-user-menu">
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-user"></span>Profile</a>
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-cog"></span>Settings</a>
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-question-sign"></span>Help</a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-log-out"></span>Logout</a>
	                        </div>
	                    </div>
	
	                    <button type="button" class="burger-right">
	                        <i class="font-icon-menu-addl"></i>
	                    </button>
	                </div><!--.site-header-shown-->
	
	                <div class="mobile-menu-right-overlay"></div>
	                <div class="site-header-collapsed">
	                    <div class="site-header-collapsed-in">
	                        
                           
	
	                        
	                       
	                        
	                        
	                        <div class="site-header-search-container">
	                            <a id="count" class="btn btn-nav btn-rounded btn-inline btn-danger-outline" href="http://themeforest.net/item/startui-premium-bootstrap-4-admin-dashboard-template/15228250">
                                       loading... 
	                        </a>
                                    <script>
            countAll();
            
        </script>
	                        </div>
                                
	                    </div><!--.site-header-collapsed-in-->
	                </div><!--.site-header-collapsed-->
	            </div><!--site-header-content-in-->
	        </div><!--.site-header-content-->
	    </div><!--.container-fluid-->
	</header><!--.site-header-->

	<div class="mobile-menu-left-overlay"></div>
	<nav class="side-menu">
	    <ul class="side-menu-list">
	        
                <li class="green with-sub" style="background: lightgray">
                    <a href="#" onclick="switchView('summary')">
	                <i class="font-icon font-icon-zigzag"></i>
	                <span class="lbl" >Summary</span>
	            </a>
	        </li>
                
                <li class="green with-sub">
	            <a href="#" onclick="switchView('gridframe')">
	                <i class="glyphicon glyphicon-list-alt"></i>
	                <span class="lbl">Case Manager</span>
	            </a>
	        </li>
                
                <li class="green with-sub">
	            <a href="#" onclick="switchView('mapframe')">
	                <i class="font-icon font-icon-help"></i>
	                <span class="lbl">Case Map</span>
	            </a>
	        </li>
                
                <li class="green with-sub">
	            <a href="#" onclick="switchView('analysis')">
	                <i class="font-icon font-icon-chart"></i>
	                <span class="lbl">Analysis</span>
	            </a>
	        </li>
                
	        
	    </ul>
	
	    <section>
	        <header class="side-menu-title">Tools</header>
	        <ul class="side-menu-list">
	           
	            <li>
	                <a href="#" onclick="switchView('notepad')">
	                    <i class="tag-color grey-blue"></i>
	                    <span class="lbl">Notepad</span>
	                </a>
	            </li>
	            <li>
	                <a href="#">
	                    <i class="tag-color red"></i>
	                    <span class="lbl">Logout</span>
	                </a>
	            </li>
	            
	        </ul>
	    </section>
	</nav><!--.side-menu-->
      
        <!--content area -->
        <div id="contentArea" class="page-content" style="height: 100%">
           
        </div>
        
        <div id="mapArea" style="overflow: hidden">
            
        </div>
        
        
       
        	<script src="js/lib/jquery/jquery.min.js"></script>
	<script src="js/lib/tether/tether.min.js"></script>
	<script src="js/lib/bootstrap/bootstrap.min.js"></script>
	<script src="js/plugins.js"></script>

	<script type="text/javascript" src="js/lib/jqueryui/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/lib/lobipanel/lobipanel.min.js"></script>
	<script type="text/javascript" src="js/lib/match-height/jquery.matchHeight.min.js"></script>
        <script src="js/lib/datatables-net/datatables.min.js"></script>
	
        
           
            <script>
                    layTable();
            </script>
        
        

<script src="js/lib/d3/d3.min.js"></script>
<script src="js/lib/charts-c3js/c3.min.js"></script>


        
<script src="/js/app.js"></script>
<script src="/js/alertify.js"></script>
<script src="js/lib/charts-c3js/c3js-init.js"></script>

         <script>
                switchView('summary');
                
         </script>
         
         
</body>


        
</html>