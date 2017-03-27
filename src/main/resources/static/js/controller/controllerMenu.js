
app.controller("controllerMenu", function($scope, loginService) {
	
	$scope.usuarioEstaLogado = function() {
		return loginService.usuarioEstaLogado();
	};
	
	$scope.caminhos = function() {
		if($scope.usuarioEstaLogado()) {
			return loginService.caminhosUsuarioLogado;
		} else {
			return loginService.caminhosUsuarioDeslogado;
		}
	};
	
	$scope.deslogar = function() {
		loginService.deslogar();
	};
});