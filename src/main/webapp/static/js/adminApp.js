'use strict';

var adminApp = angular.module('adminApp', [ 'ngRoute' ]);

adminApp.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider.when('/', {
		templateUrl : 'static/pages/addProd.html'
	}).when('/addProd', {
		templateUrl : 'static/pages/addProd.html'
	}).when('/removeProd', {
		templateUrl : 'static/pages/removeProd.html'
	}).when('/updateProd', {
		templateUrl : 'static/pages/updateProd.html'
	}).otherwise({
		redirectTo : '/'
	});
});