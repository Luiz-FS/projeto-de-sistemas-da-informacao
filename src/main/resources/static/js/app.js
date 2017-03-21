/*
 * Modulo geral da aplicacao e configuracao das routes.
 */
var app = angular.module("menuPrincipal", ["ngRoute"]);

app.config(function($routeProvider) {

	$routeProvider
	.when("/cadastrar-se", {
		templateUrl : "/templates/cadastro.html",
		controller : ""
	})
	.otherwise({
		redirectTo: '/'
	});
	
});
