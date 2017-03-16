'use strict'

myApp.factory('HomeServices', ['$http', '$q', function($http, $q) {
	
	var REST_URI = 'Artefact/home-services';
	
	var factory = {
			getHomeInfo : getHomeInfo
	};
	
	return factory;
	
	function getHomeInfo() {
		
		var deferred = $q.defer;
		$http.get(REST_URI).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while fetching Home page Info');
			deferred.reject(errResponse)
		});
		return deferred.promise;
		
	}
}]);