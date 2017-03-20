package br.edu.ufcg.computacao.si1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.computacao.si1.excecoes.AcessoNaoPermitidoException;
import br.edu.ufcg.computacao.si1.excecoes.AnuncioNaoExisteException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioNaoExisteException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.PermissoesUsuario;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

@Service
public class ServiceSistema {
	
	@Autowired
	private ServiceAnuncio serviceAnuncio;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	public void contratarAnuncio(Long idComprador, Long idAnuncio) {
		
		Double valorAnuncio = this.serviceAnuncio.getValorAnuncioPorId(idAnuncio);
		Long idDonoAnuncio = this.serviceAnuncio.getIdDonoAnuncio(idAnuncio);
		
		this.serviceUsuario.comprarAnuncio(idDonoAnuncio, idComprador, valorAnuncio);
		
		this.addNotificacoesContratacao(idDonoAnuncio, idComprador, idAnuncio);
		
		this.serviceAnuncio.deletarAnuncioPorId(idAnuncio);
	}
	
	public void addDataDeAgendamento(Long idAnuncio, Date dataDeAgendamento) {
		this.serviceAnuncio.addDataAgendamento(idAnuncio, dataDeAgendamento);
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		return this.serviceUsuario.criarUsuario(usuario);
	}
	
	public Anuncio salvarAnuncio(Anuncio anuncio) {
		return this.serviceAnuncio.salvarAnuncio(anuncio);
	}
	
	public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) {
		return this.serviceAnuncio.getAnunciosPorUsuario(idUsuario);
	}
	
	public List<Anuncio> getAnuncios() {
		return this.serviceAnuncio.getAnuncios();
	}
	
	public List<Usuario> getUsuarios() {
		return this.serviceUsuario.getUsuarios();
	}
	
	public void idUsuarioExiste(Long idUsuario) throws UsuarioNaoExisteException {
		this.serviceUsuario.idUsuarioExiste(idUsuario);
	}
	
	public void idAnuncioExiste(Long idAnuncio) throws AnuncioNaoExisteException {
		this.serviceAnuncio.idAnuncioExiste(idAnuncio);
	}
		
	public void usuarioTemPermissao(Long idUsuario, PermissoesUsuario permissao) throws AcessoNaoPermitidoException {
		this.serviceUsuario.usuarioTemPermissao(idUsuario, permissao);
	}

	private void addNotificacoesContratacao(Long idDonoAnuncio, Long idComprador, Long idAnuncio) { 
		
		String mensagemNotificacaoContratacao = this.serviceAnuncio.gerarMensagemNotificacaoContratacao(idAnuncio);
	
		this.serviceUsuario.gerarNotificacoesDeContratacao(idDonoAnuncio, idComprador, mensagemNotificacaoContratacao);
	}
}
