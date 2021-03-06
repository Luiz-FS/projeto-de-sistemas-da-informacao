
app.controller("controllerNotificacoes", function($scope, $http, CONFIGURACAO, ROTA, SUB_ROTA) {
	
	$scope.notificacoes = [];
	$scope.notificaoAvaliada;
	
	(function(){
		$http.get(CONFIGURACAO.URL + ROTA.USUARIO + SUB_ROTA.NOTIFICACOES).success(function (data, status) {
			$scope.notificacoes = data;    	  	
    	
    	}).error(function (data, status){
    	});
	})();
	
	$scope.setNotificacaoAvaliada = function(notificacao) {
		$scope.notificaoAvaliada = notificacao;
	};
	
	$scope.addAvaliacaoUsuario = function() {
		var avaliacao = {nota: $scope.notaAvaliacao,
				comentarios: $scope.novaAvalicao}
	
		$http.post(CONFIGURACAO.URL + ROTA.USUARIO + SUB_ROTA.ANUNCIO_CADASTRO_AVALIACAO + "/" + $scope.notificaoAvaliada.id, avaliacao).success(function (data, status) {
			
    		$("#modalAdicionarAvalicao").modal("hide");
    	
    		$scope.notaAvalicao = "";
    		$scope.novaAvalicao = "";
    	
    	}).error(function (data, status){
    	});	
	};
});