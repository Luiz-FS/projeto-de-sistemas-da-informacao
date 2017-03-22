/**
 * 
 */
app.controller("controllerCadastro", function($scope, $http, $location, $routeParams) {
	
	
	
	$scope.cadastrarUsuario = function() {
		var usuario = {
			nome: $scope.nomeUsuario,
			email: $scope.emailUsuario,
			senha: $scope.senhaUsuario,
			permissao: $scope.opcaoPessoa
		}
		
		console.log(usuario);
		
		$http.post("http://" + location.host + "/usuarios/cadastro", usuario).success(function (data, status) {
			console.log(data);
			console.log(status);
		});
		
	}
});
