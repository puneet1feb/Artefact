'use strict'
myApp.controller('CommlightController', [ '$scope', 'CommlightServices',
		function($scope, CommlightServices) {
			var self = this;
			self.loader = false;
			self.pageNumber = 1;
			self.size =0;

			self.getProductDetails = getProductDetails;
			self.previousPage = previousPage;
			self.nextPage = nextPage;

			getProductDetails();
			

			function getProductDetails() {
				self.loader = true;
				CommlightServices.getProductDetails(self.pageNumber).then(function(data) {
					self.product = data;
					self.size = data.length;
					self.loader = false;
				}, function(errResponse) {
					console.error('Error while getting carousel');
					self.loader = false;
				});
			}
			
			function previousPage() {
				self.pageNumber = self.pageNumber - 1;
				getProductDetails();
			}
			
			function nextPage() {
				self.pageNumber = self.pageNumber + 1;
				getProductDetails();
			}
		} ]);