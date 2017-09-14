(function(){
	'use strict'
	var app = angular.module("crudApp");
	app.config(function($routeProvider, $locationProvider){
		$routeProvider
		
		.when('/login' , {
			templateUrl : 'view/login.html',
			controller : 'loginCtrl'
		})
		.when("/registration" , {
			templateUrl : 'view/registration.html',
		})
		.when('/welcome', {
			templateUrl : 'view/welcome.html'
		})
		.otherwise({
			templateUrl : 'home.html'
		});
		//$locationProvider.html5Mode(true);
		$locationProvider.hashPrefix("");
	})
})();