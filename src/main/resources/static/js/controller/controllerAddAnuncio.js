
app.controller("controllerAddAnuncio", function($scope, $http, CONFIGURACAO, ROTA, SUB_ROTA) {

    $scope.anuncioNaoCriado = false;
    $scope.anuncioCriado = false;

	$scope.cadastrarAnuncio = function() {
		
		if($scope.anuncio.tipo != "PRODUTO") {
			$scope.anuncio.categoriaAnuncio = "DEFAULT";
		}
				
		$http.post(CONFIGURACAO.URL + ROTA.ANUNCIO + SUB_ROTA.CADASTRO, $scope.anuncio)
		    .success(function (data, status) {
                $scope.anuncioNaoCriado = false;
                $scope.anuncioCriado = true;
		    })
		    .error(function (response) {
                $scope.anuncioNaoCriado = true;
                $scope.anuncioCriado = false;
            });

            delete $scope.anuncio;
	}
});
