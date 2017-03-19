package br.edu.ufcg.computacao.si1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
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
		
		this.addNotificacoesCompra(idDonoAnuncio, idComprador, idAnuncio);
		
		this.serviceAnuncio.deletarAnuncioPorId(idAnuncio);
	}
	
	public void addDataDeAgendamento(Long idAnuncio, Date dataDeAgendamento) {
		this.serviceAnuncio.addDataAgendamento(idAnuncio, dataDeAgendamento);
	}
	
	public void salvarUsuario(Usuario usuario) {
		this.serviceUsuario.criarUsuario(usuario);
	}
	
	public void salvarAnuncio(Anuncio anuncio) {
		this.serviceAnuncio.salvarAnuncio(anuncio);
	}
	
	public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) {
		return this.serviceAnuncio.getAnunciosPorUsuario(idUsuario);
	}
	
	public List<Usuario> getUsuarios() {
		return this.serviceUsuario.getUsuarios();
	}
	
	private void addNotificacoesCompra(Long idDonoAnuncio, Long idComprador, Long idAnuncio) { 
		
		String mensagemNotificacaoCompra = this.serviceAnuncio.gerarDescricaoAnuncio(idAnuncio);
	
		this.serviceUsuario.gerarNotificacoesDeContratacao(idDonoAnuncio, idComprador, mensagemNotificacaoCompra);
	}
	
}
