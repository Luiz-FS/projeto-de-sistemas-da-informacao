package br.edu.ufcg.computacao.si1.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

@Service
public class ServiceSistema {
	
	@Autowired
	private ServiceAnuncio serviceAnuncio;
	
	@Autowired
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
