'use strict'

adminApp.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);

adminApp.controller('AddprodController', [ '$scope', 'AddprodServices',
		function($scope, AddprodServices) {

			var self = this;

			self.product = {
				id : null,
				text : '',
				name : '',
				category : null,
				ebayLink : '',
				amazonLink : '',
				priority : 10,
				image : ''
			};
			
			self.loader = false;
			
			self.showMsg = false;

			self.submit = submit;
			self.reset = reset;
			self.uploadFile = uploadFile;

			function uploadFile(product) {
				var file = $scope.myFile;

				console.log('file is ');
				console.dir(file);
				
				AddprodServices.uploadFileToUrl(file, product).then(function(data) {
					self.loader = false;
					self.showMsg = true;
					reset();
				}, function(errResponse) {
					console.error('Error while getting carousel');
					self.loader = false;
				});

				
			};

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
			}

			function submit() {
				self.loader = true;
				console.log('Saving New Prod : ', self.product);
				uploadFile(self.product);

			}

		} ]);