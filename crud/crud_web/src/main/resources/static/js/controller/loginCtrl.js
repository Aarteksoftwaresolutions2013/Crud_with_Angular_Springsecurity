(function(){
	'use strict'
	
	var app = angular.module("crudApp");
	app.controller("loginCtrl" , ["$scope","$window","$location","loginService","$sessionStorage","$timeout",function($scope,$window,$location,loginService,$sessionStorage,$timeout){
		$scope.user={
	               
				                userId:"",
				                email:"",
		                        password:""
				    };
	
		$scope.loginUser = function(){
			console.log($scope.user.email);
			loginService.loginUser($scope.user).then(function(data){
				if(!data){
					$scope.statusMessage = 'false';
				}else{
					$sessionStorage.users = {
					         useremail : data.email,
					         userpassword : data.password
				       };	
				}
				 $timeout(function () {
					 $scope.statusMessage ="";
					 console.log("in time",$scope.statusMessage);
					 }, 3000);
		
			});	
		}
		
		$scope.logout = function () {
	        delete $sessionStorage.users;
	        $window.location.href = '#/home.html';
	        };
		
	}]);
})();