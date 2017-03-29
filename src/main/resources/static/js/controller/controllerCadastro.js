
app.controller("controllerCadastro", function($scope, $http, $location, $routeParams,
		CONFIGURACAO, ROTA, SUB_ROTA) {
	
	
	
	$scope.cadastrarUsuario = function() {
		var usuario = {
			nome: $scope.nomeUsuario,
			email: $scope.emailUsuario,
			senha: $scope.senhaUsuario,
			permissao: $scope.opcaoPessoa
		}

		
		$http.post(CONFIGURACAO.URL + ROTA.USUARIO + SUB_ROTA.CADASTRO, usuario).success(function (data, status) {
		});

        delete $scope.nomeUsuario;
        delete $scope.emailUsuario;
        delete $scope.senhaUsuario;
        delete $scope.opcaoPessoa;
	}
});
