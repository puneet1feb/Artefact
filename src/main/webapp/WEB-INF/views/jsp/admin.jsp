<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache">
<title>Artefact lights - Admin Page</title>
<link rel="stylesheet" href="static/css/main.css">
<link rel="stylesheet" href="static/css/bootstrap.css">
</head>

<body ng-app="adminApp" class="ng-cloak" id="main">
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand">Artefact Lights - Admin Home page</a>
		</div>
	</nav>

	<nav class="navbar navbar-inverse navbar-btn navbar-static-top">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#home"> Admin Home</a></li>
				<li><a href="#addProd"> Add Product</a></li>
				<li><a href="#removeProd"> Remove Product</a></li>
				<li><a href="#updateProd"> Update Product</a></li>
			</ul>
		</div>
	</nav>
	<div>
		<div ng-view></div>
	</div>

	<script src="static/js/angular.js"></script>
	<script src="static/js/angular-route.js"></script>
	<script src="static/js/adminApp.js"></script>
	<script src="static/js/jquery-3.2.0.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<!-- <script src="static/js/service/admin_services.js"></script>
	<script src="static/js/controller/admin_controller.js"></script> -->
	<script src="static/js/service/addprod_services.js"></script>
	<script src="static/js/controller/addprod_controller.js"></script>
	<!-- <script src="static/js/service/removeprod_services.js"></script>
	<script src="static/js/controller/removeprod_controller.js"></script>
	<script src="static/js/service/updateprod_services.js"></script>
	<script src="static/js/controller/updateprod_controller.js"></script> -->
</body>
</html>