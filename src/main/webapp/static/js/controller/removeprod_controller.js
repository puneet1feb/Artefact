'use strict'

adminApp.controller('RemoveprodController', [ '$scope', 'RemoveprodServices',
		function($scope, RemoveprodServices) {

			var self = this;
			
			self.category='1';

			self.loader = false;
			
			self.showMsg = false;
			
			self.selectProds = [];
			self.message = "";

			self.getProducts = getProductDetails;
			self.removeProds = removeProds;
			self.resetProducts = resetProducts;

			function removeProds() {
				RemoveprodServices.removeProducts(self.selectProds).then(function(data) {
					self.loader = false;
					self.showMsg = true;
					self.message = data.desc;
					getProductDetails();
					resetProducts();
					

					
				}, function(errResponse) {
					console.error('Failed to remove products');
					self.loader = false;
				});
			}
			
			function resetProducts() {
				self.selectProds = [];
			}
			
			function getProductDetails() {
				self.loader = true;
				RemoveprodServices.getProductDetails(self.category).then(function(data) {
					self.products = data;
					self.loader = false;
				}, function(errResponse) {
					console.error('Error while getting product details');
					self.loader = false;
				});
			}

			function reset() {
				self.product = {
					id : null,
					text : '',
					names : '',
					category : '',
					ebayLink : '',
					amazonLink : '',
					priority : 10,
					image : ''
				};
				elf.loader = false;
				self.showMsg = true;
			}

			function submit() {
				self.loader = true;
				console.log('Saving New Prod : ', self.product);
				uploadFile(self.product);

			}

		} ]);