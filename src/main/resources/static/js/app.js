/*
 * Modulo geral da aplicacao e configuracao das routes.
 * 
 */
var app = angular.module("menuPrincipal", ["ngRoute"]);

app.config(function($routeProvider) {

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
		})
		.when("/busca", {
        	templateUrl : "/view/busca.html",
			controller: "controllerBuscaAnuncio"
    	})
    	.when("/perfil", {
        	templateUrl : "/view/perfil.html",
			controller: "controllerPerfil"
    	})
    	.when("/addAnuncio", {
        	templateUrl : "/view/addAnuncio.html",
			controller: "controllerAddAnuncio"
    	})
    	.when("/notificacoes", {
        	templateUrl : "/view/notificacoes.html",
			controller: ""
    	})
    	.otherwise({
          redirectTo: '/'
        });
});

app.config(function ($httpProvider) {
	$httpProvider.interceptors.push("tokenInterceptador");
});
