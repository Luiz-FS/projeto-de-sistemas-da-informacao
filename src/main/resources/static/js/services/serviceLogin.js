
app.service("loginService", function() {
	this.usuarioEstaLogado = false;
	this.caminhosUsuarioLogado = [{nome:"Perfil", rota:"/perfil"},
    							  {nome:"Adicionar Anuncio", rota:"/addAnuncio"},
    							  {nome:"Busca", rota:"/busca"},
    							  {nome:"Notificacoes", rota:"/notificacoes"}];
	this.caminhosUsuarioDeslogado = [{nome:"Login", rota:"/login"},
	                                 {nome:"Cadastra-se", rota:"/cadastrar-se"},
	                                 {nome:"Sobre", rota:"/sobre"}];
	this.getCaminhos = function() {
		if(this.usuarioEstaLogado) {
			return this.caminhosUsuarioLogado;
		} else {
			return this.caminhosUsuarioDeslogado;
		}
	};
});