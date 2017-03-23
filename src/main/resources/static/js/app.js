/*
 * Modulo geral da aplicacao e configuracao das routes.
 * 
 */
var app = angular.module("menuPrincipal", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider) {

	$routeProvider
		.when("/cadastrar-se", {
			templateUrl : "/view/cadastro.html",
			controller: "controllerCadastro"
		})
		.when("/login", {
			templateUrl: "/view/login.html",
			controller: "controllerLogin"
		})
		.when("/sobre", {
	    	templateUrl : "/view/sobre.html"
		});

	$locationProvider.html5Mode(true);
});

app.config(function ($httpProvider) {
	$httpProvider.interceptors.push("tokenInterceptador");
});
