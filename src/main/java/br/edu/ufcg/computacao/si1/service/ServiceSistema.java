package br.edu.ufcg.computacao.si1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.computacao.si1.excecoes.AcaoNaoPermitidaException;
import br.edu.ufcg.computacao.si1.excecoes.AnuncioInexistenteException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInexistenteException;
import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.PermissoesUsuario;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

@Service
public class ServiceSistema {
	
	@Autowired
	private ServiceAnuncio serviceAnuncio;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	public void contratarAnuncio(Long idComprador, Long idAnuncio) throws AcaoNaoPermitidaException {
		Long idDonoAnuncio = this.serviceAnuncio.getIdDonoAnuncio(idAnuncio);
		
		if(!idComprador.equals(idDonoAnuncio)) {
			Double valorAnuncio = this.serviceAnuncio.getValorAnuncioPorId(idAnuncio);
						
			this.serviceUsuario.comprarAnuncio(idDonoAnuncio, idComprador, valorAnuncio);
			
			this.addNotificacoesContratacao(idDonoAnuncio, idComprador, idAnuncio);
			
			this.serviceAnuncio.deletarAnuncioPorId(idAnuncio);
		
		} else {
			throw new AcaoNaoPermitidaException();
		}
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
	
	public void idUsuarioExiste(Long idUsuario) throws UsuarioInexistenteException {
		this.serviceUsuario.idUsuarioExiste(idUsuario);
	}
	
	public void idAnuncioExiste(Long idAnuncio) throws AnuncioInexistenteException {
		this.serviceAnuncio.idAnuncioExiste(idAnuncio);
	}
		
	public void usuarioTemPermissao(Long idUsuario, PermissoesUsuario permissao) throws AcaoNaoPermitidaException {
		this.serviceUsuario.usuarioTemPermissao(idUsuario, permissao);
	}

	public void addAvaliacaAnuncio(Long idAnuncio, Long idUsuario, Avaliacao avaliacao) throws AcaoNaoPermitidaException {
		this.serviceAnuncio.addAvaliacao(idAnuncio, idUsuario, avaliacao);
	}
	
	public List<Avaliacao> getAvaliacoesAnuncio(Long idAnuncio) {
		return this.serviceAnuncio.getAvaliacoesAnuncio(idAnuncio);
	}
	
	public void addAvaliacaoUsuario(Long idUsuario, Long idNotificacao, Avaliacao avaliacao) throws AcaoNaoPermitidaException {
		this.serviceUsuario.addAvaliacao(idUsuario, idNotificacao, avaliacao);
	}
	
	public List<Notificacao> getNotificacoesUsuario(Long idUsuario) {
		return this.serviceUsuario.getNotificacoes(idUsuario);
	}
	
	public List<Avaliacao> getAvaliacoesUsuario(Long idUsuario) {
		return this.serviceUsuario.getAvaliacoes(idUsuario);
	}
	
	private void addNotificacoesContratacao(Long idDonoAnuncio, Long idComprador, Long idAnuncio) { 
		
		String mensagemNotificacaoContratacao = this.serviceAnuncio.gerarMensagemNotificacaoContratacao(idAnuncio);
	
		this.serviceUsuario.gerarNotificacoesDeContratacao(idDonoAnuncio, idComprador, mensagemNotificacaoContratacao);
	}
}
