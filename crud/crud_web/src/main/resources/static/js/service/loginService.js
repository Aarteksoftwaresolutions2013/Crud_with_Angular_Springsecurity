(function(){
	'use strict'
	 
	angular.module("crudApp").factory('loginService' , function($http,$q,$window, $location,$sessionStorage){
		
		var obj={};
		
		
		obj.loginUser = function(user) {
			console.log("$sessionStorage",$sessionStorage.users);
			console.log("login user service in service angular ");
			 var deferred = $q.defer();
			   var config = {
			     headers : {
			      'Content-Type' : 'application/json'
			     }
			   };
			   var data = angular.toJson(user);
			   console.log(data);
			    $http.post('http://localhost:8082/crud-controller/rest/user', data, config).success(
			    function(data, status, headers, config) {
			    	deferred.resolve(data);
			    	if(status == '200'){
			    		console.log("valid user");
			    		$location.path('/welcome'); 
			    	}else if(status == '204'){
			    		console.log("not valid user");
			    	}
			        
			    }).error(function(data, status, headers, config) {
			    	if(status == '500'){
			    		console.log("throwing exception");
			    	} 
			      deferred.reject();
			    
			    });
			     return deferred.promise;
			   }
		
		return obj;
	});
})();