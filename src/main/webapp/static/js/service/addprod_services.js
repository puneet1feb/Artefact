'use strict'

adminApp.factory('AddprodServices', [ '$http', '$q', function($http, $q) {

	var REST_URI = '/admin/product';

	var factory = {
		addProd : addProd,
		uploadFileToUrl : uploadFileToUrl
	};

	return factory;

	function addProd() {

	}

	function uploadFileToUrl(file, product) {
		var deferred = $q.defer();
		var fd = new FormData();
		fd.append('file', file);
		fd.append('text', product.text);
		fd.append('name', product.name);
		fd.append('category', product.category);
		fd.append('priority', product.priority);
		fd.append('ebayLink', product.ebayLink);
		fd.append('amazonLink', product.amazonLink);
		
		
		$http.post(REST_URI, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while adding product');
			deferred.reject(errResponse)
		});
		return deferred.promise;

	}

} ]);