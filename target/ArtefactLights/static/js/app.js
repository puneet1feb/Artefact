'use strict';
 
var myApp = angular.module('myApp',['ngRoute']);

myApp.config(function($routeProvider){
	$routeProvider
	
	.when('/', {
		templateUrl: 'static/pages/home.html'
	});	
});