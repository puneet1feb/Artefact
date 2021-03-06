<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html ng-app="myApp">
<head>
<meta http-equiv="Cache-Control" content="no-cache">
<title>Luminix LED</title>
<link rel="stylesheet" href="static/css/main.css">
<link rel="stylesheet" href="static/css/bootstrap.css">
</head>

<body class="ng-cloak" id="main">
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="#home">Luminix LED</a>
		</div>
		<div class="navbar-nav navbar-right">
			<a class="navbar-brand" target="_blank"
				href="http://stores.ebay.co.uk/luminixled/">Visit our Ebay
				store</a>
		</div>
	</nav>

	<nav class="navbar navbar-inverse navbar-btn navbar-static-top">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#ledspots"> LED Spotlights</a></li>
				<li><a href="#ledbulbs"> LED Lightbulbs</a></li>
				<li><a href="#ledstrip"> LED Strip Lights</a></li>
				<li><a href="#indoorlight"> Indoor Light Fittings</a></li>
				<li><a href="#outdoorlight"> Outdoor Lighting</a></li>
				<li><a href="#leddownlight"> LED Downlights</a></li>
				<li><a href="#commlighting"> Commercial Lighting</a></li>
			</ul>
		</div>
	</nav>
	<div>
		<div ng-view></div>
	</div>

	<script src="static/js/angular.js"></script>
	<script src="static/js/angular-route.js"></script>
	<script src="static/js/app.js"></script>
	<script src="static/js/jquery-3.2.0.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/service/home_services.js"></script>
	<script src="static/js/controller/home_controller.js"></script>
	<script src="static/js/service/ledspots_services.js"></script>
	<script src="static/js/controller/ledspots_controller.js"></script>
	<script src="static/js/service/ledbulbs_services.js"></script>
	<script src="static/js/controller/ledbulbs_controller.js"></script>
	<script src="static/js/service/ledstrip_services.js"></script>
	<script src="static/js/controller/ledstrip_controller.js"></script>
	<script src="static/js/service/leddownlight_services.js"></script>
	<script src="static/js/controller/leddownlight_controller.js"></script>
	<script src="static/js/service/indoorlight_services.js"></script>
	<script src="static/js/controller/indoorlight_controller.js"></script>
	<script src="static/js/service/outdoorlight_services.js"></script>
	<script src="static/js/controller/outdoorlight_controller.js"></script>
	<script src="static/js/service/commlight_services.js"></script>
	<script src="static/js/controller/commlight_controller.js"></script>
</body>
</html>