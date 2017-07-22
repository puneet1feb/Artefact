'use strict'

adminApp.factory('RemoveprodServices', [ '$http', '$q', function($http, $q) {

	var REST_URI = '/admin/product';
	var REST_URI_PROD = '/category';

	var factory = {
		getProductDetails : getProductDetails,
		removeProducts : removeProducts
	};

	return factory;
	
	function getProductDetails(category) {

		var deferred = $q.defer();
		$http.get(REST_URI_PROD + '/' + category + '/0').then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while product details');
			deferred.reject(errResponse)
		});
		return deferred.promise;

	}
	
	function removeProducts(products) {
		var deferred = $q.defer();
		$http.put(REST_URI, products).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while removing product');
			deferred.reject(errResponse)
		});
		return deferred.promise;
	}


} ]);