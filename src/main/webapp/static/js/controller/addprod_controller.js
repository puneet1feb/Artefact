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
				category : null,
				ebayLink : '',
				amazonLink : '',
				priority : 10,
				image : ''
			};

			self.submit = submit;
			self.reset = reset;
			self.uploadFile = uploadFile;

			function uploadFile(product) {
				var file = $scope.myFile;

				console.log('file is ');
				console.dir(file);

				AddprodServices.uploadFileToUrl(file, product);
			}
			;

			function reset() {
				self.product = {
					id : null,
					text : '',
					category : '',
					ebayLink : '',
					amazonLink : '',
					priority : 10,
					image : ''
				};
			}

			function submit() {
				console.log('Saving New Prod : ', self.product);
				uploadFile(self.product);

			}

		} ]);