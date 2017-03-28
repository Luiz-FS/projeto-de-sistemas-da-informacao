
app.controller("controllerNotificacoes", function($scope, $http, $location, $routeParams) {
	
	$scope.notificacoes = [];
	
	(function(){
		$http.get("http://" + location.host + "/usuarios/notificacoes").success(function (data, status) {
    		console.log(status);
    		console.log('aki eu');
    		$scope.notificacoes = data;    	  	
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
	})();
});