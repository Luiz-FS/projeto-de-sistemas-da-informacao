package br.edu.ufcg.computacao.si1.service;

import java.util.List;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

public class ServiceSistema {
	
	private ServiceAnuncio serviceAnuncio;
	
	private ServiceUsuario serviceUsuario;
	
	public void contratarAnuncio(Long idUsuario, Long idAnuncio) {
		Anuncio anuncio = this.serviceAnuncio.getAnuncioPorId(idAnuncio);
		
		this.serviceUsuario.debitarSaldoUsuario(idUsuario, anuncio.getValor());
		
		this.serviceUsuario.creditarSaldoUsuario(anuncio.getIdUsuario(), anuncio.getValor());
		
		this.serviceAnuncio.deletarAnuncioPorId(idAnuncio);
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
}
