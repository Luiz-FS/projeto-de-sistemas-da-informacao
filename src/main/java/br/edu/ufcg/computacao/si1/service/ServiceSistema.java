package br.edu.ufcg.computacao.si1.service;

import java.util.Date;
import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufcg.computacao.si1.model.TipoNotificacao;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

@Service
public class ServiceSistema {
	
	private static final String FIM_LINHA = System.lineSeparator();
	
	@Autowired
	private ServiceAnuncio serviceAnuncio;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	public void contratarAnuncio(Long idComprador, Long idAnuncio) {
		Anuncio anuncio = this.serviceAnuncio.getAnuncioPorId(idAnuncio);
		
		this.serviceUsuario.debitarSaldoUsuario(idComprador, anuncio.getValor());
		
		this.serviceUsuario.creditarSaldoUsuario(anuncio.getIdUsuario(), anuncio.getValor());
		
		this.addNotificacoesCompra(anuncio.getIdUsuario(), idComprador, idAnuncio);
		
		this.serviceAnuncio.deletarAnuncioPorId(idAnuncio);
	}
	
	public void addDataDeAgendamento(Long idAnuncio, Date dataDeAgendamento) {
		this.serviceAnuncio.addDataAgendamento(idAnuncio, dataDeAgendamento);
	}
	
	public void salvarUsuario(Usuario usuario) {
		this.serviceUsuario.create(usuario);
	}
	
	public void salvarAnuncio(Anuncio anuncio) {
		this.serviceAnuncio.salvarAnuncio(anuncio);
	}
	
	public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) {
		return this.serviceAnuncio.getAnunciosPorUsuario(idUsuario);
	}
	
	private String gerarDescricaoAvaliacaoCompra(Long idComprador) {
		Usuario comprador = this.serviceUsuario.getById(idComprador);
		
		String string = "";
		
		string += "Seu anuncio foi contratado !" + FIM_LINHA 
				  + "Avalie o Comprador: " + comprador.getNome();
		
		return string;
	}
	
	private void addNotificacoesCompra(Long idUsuario, Long idComprador, Long idAnuncio) { 
		
		String mensagemNotificacaoCompra = this.serviceAnuncio.gerarDescricaoAnuncio(idAnuncio);
		String mensagemNotificacaoAvaliacaoCompra = this.gerarDescricaoAvaliacaoCompra(idComprador);
		
		this.serviceUsuario.addNovaNotificao(idUsuario, idComprador, mensagemNotificacaoCompra, TipoNotificacao.COMPRA);
		this.serviceUsuario.addNovaNotificao(idUsuario, idComprador, mensagemNotificacaoAvaliacaoCompra, TipoNotificacao.AVALIACAO_COMPRA);
	}
	
}
