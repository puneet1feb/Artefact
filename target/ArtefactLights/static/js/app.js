'use strict';

var myApp = angular.module('myApp', [ 'ngRoute' ]);

myApp.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider.when('/', {
		templateUrl : 'static/pages/home.html'
	}).when('/ledspots', {
		templateUrl : 'static/pages/ledspots.html'
	}).when('/ledbulbs', {
		templateUrl : 'static/pages/ledbulbs.html'
	}).when('/ledstrip', {
		templateUrl : 'static/pages/ledstrip.html'
	}).when('/indoorlight', {
		templateUrl : 'static/pages/indoorlight.html'
	}).when('/outdoorlight', {
		templateUrl : 'static/pages/outdoorlight.html'
	}).when('/leddownlight', {
		templateUrl : 'static/pages/leddownlight.html'
	}).when('/commlighting', {
		templateUrl : 'static/pages/commlight.html'
	}).otherwise({
		redirectTo : '/'
	});
});