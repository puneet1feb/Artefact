adminApp.factory('AuthInterceptor', [ function() {
	return {
		// Send the Authorization header with each request
		'request' : function(config) {
			config.headers = config.headers || {};
			var encodedString = btoa("artefact_admin:Wer#g6@#1");
			config.headers.Authorization = 'Basic ' + encodedString;
			return config;
		}
	};
} ]);