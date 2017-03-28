
app.controller("controllerNotificacoes", function($scope, $http, $location, $routeParams) {
	
	$scope.notificacoes = [];
	$scope.notificaoAvaliada;
	
	(function(){
		$http.get("http://" + location.host + "/usuarios/notificacoes").success(function (data, status) {
    		console.log(status);
    		console.log('aki eu');
    		$scope.notificacoes = data;    	  	
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
	})();
	
	$scope.setNotificacaoAvaliada = function(notificacao) {
		$scope.notificaoAvaliada = notificacao;
	};
	
	$scope.addAvaliacaoUsuario = function() {
		var avaliacao = {nota: $scope.notaAvaliacao,
				comentarios: $scope.novaAvalicao}
	
		$http.post("http://" + location.host + "/usuarios/avaliacao/" + $scope.notificaoAvaliada.id, avaliacao).success(function (data, status) {
			console.log(status);    		
			
    		$("#modalAdicionarAvalicao").modal("hide");
    	
    		$scope.notaAvalicao = "";
    		$scope.novaAvalicao = "";
    	
    	}).error(function (data, status){
    		console.log(status);
    	});	
	};
});