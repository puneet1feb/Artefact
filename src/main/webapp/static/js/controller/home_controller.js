'use strict'
myApp.controller('HomeController', [ '$scope', 'HomeServices',
		function($scope, HomeServices) {
			// create a message to display in our view
			var self = this;
			self.loader = false;

			self.getHomeInfo = getHomeInfo;

			getHomeInfo();

			function getHomeInfo() {
				self.loader = true;
				HomeServices.getHomeInfo().then(function(data) {
					self.carousel = data;
					self.loader = false;
				}, function(errResponse) {
					console.error('Error while getting carousel');
					self.loader = false;
				});
			}
		} ]);