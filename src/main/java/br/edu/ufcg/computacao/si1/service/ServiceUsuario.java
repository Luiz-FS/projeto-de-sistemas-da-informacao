package br.edu.ufcg.computacao.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.computacao.si1.excecoes.AcessoNaoPermitidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInexistenteException;
import br.edu.ufcg.computacao.si1.factories.NotificacaoFactory;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.TipoNotificacao;
import br.edu.ufcg.computacao.si1.model.usuario.PermissoesUsuario;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	
	private static final String FIM_LINHA = System.lineSeparator();

    @Autowired
    private UsuarioRepository repositorioUsuario;
    
    private NotificacaoFactory fabricaNotificacao;
    
    public ServiceUsuario() {
    	this.fabricaNotificacao = new NotificacaoFactory();
	}

    public Usuario criarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }
    
    public List<Usuario> getUsuarios() {
        return repositorioUsuario.findAll();
    }
    
    public Usuario getUsuarioPorEmail(String email) {
    	return this.repositorioUsuario.findByEmail(email);
    }

    public void atualizar(Usuario usuario) {
        repositorioUsuario.save(usuario);
    }

    public void delete(Long id) {
        repositorioUsuario.delete(id);
    }

    public void debitarSaldoUsuario(Long idUsuario, double valor) {
        Usuario usuario = this.repositorioUsuario.findOne(idUsuario);

        usuario.getSaldoDeUsuario().debitar(valor);
        atualizar(usuario);
    }

    public void creditarSaldoUsuario(Long idUsuario, double valor) {
        Usuario usuario = this.repositorioUsuario.findOne(idUsuario);

        usuario.getSaldoDeUsuario().creditar(valor);
        atualizar(usuario);
    }
    
    public void comprarAnuncio(Long idDonoAnuncio, Long idComprador, double valor) {
    	this.debitarSaldoUsuario(idComprador, valor);
    	this.creditarSaldoUsuario(idDonoAnuncio, valor);
    }
        
    public void addNovaNotificao(Long idDonoAnuncio, Long idComprador, String mensagem, TipoNotificacao tipoNotificacao) {
    	Usuario usuario = this.repositorioUsuario.findOne(idDonoAnuncio);
    	
    	Notificacao notificacao = fabricaNotificacao.criarNotificacao(mensagem, idComprador, tipoNotificacao);
    	
    	usuario.addNotificacao(notificacao);
       	
    	this.atualizar(usuario);
    }
    
    public void idUsuarioExiste(Long idUsuario) throws UsuarioInexistenteException {
    	if(!this.repositorioUsuario.exists(idUsuario)) {
    		throw new UsuarioInexistenteException();
    	}
    }
    
    public void usuarioTemPermissao(Long idUsuario, PermissoesUsuario permissao) throws AcessoNaoPermitidoException {
    	Usuario usuario = this.repositorioUsuario.findOne(idUsuario);
   
    	if(!usuario.temPermissao(permissao)) {
    		throw new AcessoNaoPermitidoException();
    	}
    }
    
    public void gerarNotificacoesDeContratacao(Long idDonoAnuncio, Long idComprador, String mensagemCompra) {
    	String mensagemAvalicao = this.gerarMensagemNotificacaoAvaliacao(idComprador);
    	
    	this.addNovaNotificao(idDonoAnuncio, idComprador, mensagemCompra, TipoNotificacao.COMPRA);
    	this.addNovaNotificao(idDonoAnuncio, idComprador, mensagemAvalicao, TipoNotificacao.AVALIACAO_COMPRA);
    }
    
	private String gerarMensagemNotificacaoAvaliacao(Long idComprador) {
		
		Usuario comprador = this.repositorioUsuario.findOne(idComprador);
		
		String string = "";
		
		string += "Seu anuncio foi contratado!" + FIM_LINHA 
				  + "Avalie o usuario que contratou seu anuncio: " + comprador.getNome();
		
		return string;
	}
}