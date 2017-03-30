'use strict'

myApp.factory('OutdoorlightServices', [ '$http', '$q', function($http, $q) {

	var REST_URI = '/category/5';

	var factory = {
		getProductDetails : getProductDetails
	};

	return factory;

	function getProductDetails(pageNumber) {

		var deferred = $q.defer();
		$http.get(REST_URI + '/' + pageNumber).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while fetching Led spots product details Info');
			deferred.reject(errResponse)
		});
		return deferred.promise;

	}
} ]);