<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html ng-app="myApp">
  <head>  
    <title>Art-e-fact lights</title>  
     <link rel="stylesheet" href="static/css/bootstrap.css">
  </head>
  
  <body class="ng-cloak" id="main" ng-controller="HomeController as home">
  	<nav class="navbar navbar-default">
  		<div class="navbar-header">
  			<a class="navbar-brand">Art-e-fact Lights</a>
  		</div>
  	</nav>
  	
  	<nav class="navbar navbar-inverse .navbar-btn .navbar-static-top">
  		<div class="container-fluid">
  			<ul class="nav navbar-nav navbar-left">
  				<li><a href="#/"> Home</a></li>
  				<li><a href="#ceiling"> Ceiling Lights</a></li>
  				<li><a href="#wall"> Wall Lights</a></li>
  				<li><a href="#table"> Table and Floor</a></li>
  			</ul>
  		</div>
  	</nav>
  	<div>
  	<div ng-view></div>
  	</div>
  	
  	<script src="static/js/angular.js"></script>
  	<script src="static/js/angular-route.js"></script>
  	<script src="static/js/bootstrap.js"></script>
  	<script src="static/js/app.js"></script>
  	<script src="static/js/service/homeServices.js"></script>
  	<script src="static/js/controller/mainController.js"></script>
  	<script src="static/js/controller/homeController.js"></script>
  
  </body>