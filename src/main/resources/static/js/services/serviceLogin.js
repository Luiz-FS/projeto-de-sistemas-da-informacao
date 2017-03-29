
app.service("loginService", function($location, $http, CONFIGURACAO) {
	this.caminhosUsuarioLogado = [{nome:"Perfil", rota:"#/perfil"},
    							  {nome:"Adicionar Anuncio", rota:"#/addAnuncio"},
    							  {nome:"Busca", rota:"#/busca"},
    							  {nome:"Notificacoes", rota:"#/notificacoes"}];
	this.caminhosUsuarioDeslogado = [{nome:"Login", rota:"#/login"},
	                                 {nome:"Cadastra-se", rota:"#/cadastrar-se"},
	                                 {nome:"Sobre", rota:"#/sobre"}];
	var loginFalhou = false;

	this.getLoginFalhou = function() {
		return loginFalhou;
	};
	
	this.usuarioEstaLogado = function() {
		return localStorage.tokenUsuario != undefined && localStorage.tokenUsuario != ""; 
	};
	
	this.login = function(usuario) {
		$http.post(CONFIGURACAO.URL + "/login", usuario)
         	.success(function (data, status) {
         		console.log("Sucesso: " + status);
         		
         		localStorage.setItem("tokenUsuario", data.token);
    			$location.path("/perfil");
         	})
         	.error(function (response) {
         		console.log("Falha: " + response);
         		loginFalhou = true;	
         	});
	};
	
	this.deslogar = function() {
		$http.post(CONFIGURACAO.URL + "/logout")
			.success(function(data, status) {
				console.log(status);
	     		localStorage.removeItem("tokenUsuario");
	     		loginFalhou = false;	
	     		$location.path("/login");
			})
			.error(function(data, status) {
				localStorage.removeItem("tokenUsuario");
				$location.path("/login");
				loginFalhou = true;
				console.log(status);
			});
	};
});