
app.controller("controllerAddAnuncio", function($scope, $http, CONFIGURACAO, ROTA, SUB_ROTA) {

	$scope.cadastrarAnuncio = function() {

		$http.post(CONFIGURACAO.URL + ROTA.ANUNCIO + SUB_ROTA.CADASTRO, $scope.anuncio)
		    .success(function (data, status) {
                console.log(data);
                console.log(status);
		    });
	}
});
