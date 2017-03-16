'use strict'

myApp.controller('HomeController', ['$scope', 'HomeServices', function($scope, HomeServices) {
        // create a message to display in our view
        var self =  this;
        
        self.getHomeInfo = getHomeInfo;
        
        getHomeInfo();
        
        function getHomeInfo() {
        	HomeServices.getHomeInfo().then(function(data) {
        		self.homeInfo = data;
        	})
        }
    }]);