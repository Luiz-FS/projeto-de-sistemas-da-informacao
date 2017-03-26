
app.controller("controllerMenu", function($scope, $location, loginService) {
	$scope.caminhos = function() {
		return loginService.getCaminhos();
	};
	
	$scope.usuarioEstaLogado = function() {
		return loginService.usuarioEstaLogado;
	};
	
	$scope.deslogar = function() {
		 $location.path("/login");
		 loginService.usuarioEstaLogado = false;
	};
});