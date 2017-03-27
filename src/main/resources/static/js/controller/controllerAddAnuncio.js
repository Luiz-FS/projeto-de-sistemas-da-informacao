
app.controller("controllerAddAnuncio", function($scope, $http, CONFIGURACAO, ROTA, SUB_ROTA) {

    $scope.anuncioNaoCriado = false;
    $scope.anuncioCriado = false;

	$scope.cadastrarAnuncio = function() {

		$http.post(CONFIGURACAO.URL + ROTA.ANUNCIO + SUB_ROTA.CADASTRO, $scope.anuncio)
		    .success(function (data, status) {
                $scope.anuncioNaoCriado = false;
                $scope.anuncioCriado = true;

                console.log("Sucesso: " + status);
		    })
		    .error(function (response) {
                $scope.anuncioNaoCriado = true;
                $scope.anuncioCriado = false;

                console.log("Falha: " + response);
            });

            delete $scope.anuncio;
	}
});
