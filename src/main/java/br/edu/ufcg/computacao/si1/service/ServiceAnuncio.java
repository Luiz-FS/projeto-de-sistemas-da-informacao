package br.edu.ufcg.computacao.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;

public class ServiceAnuncio {

	@Autowired
	private AnuncioRepository repositorioAnuncio;


	public Anuncio salvarAnuncio(Anuncio anuncio) {
		return this.repositorioAnuncio.save(anuncio);
	}
	
	public Anuncio getAnuncioPorId(Long idAnuncio) {
		return this.repositorioAnuncio.findOne(idAnuncio);
	}

	public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) {
		return this.repositorioAnuncio.findByIdUsuario(idUsuario);
	}

	public void deletarAnuncio(Anuncio anuncio) {
		this.repositorioAnuncio.delete(anuncio);
	}
	
	public void deletarAnuncioPorId(Long idAnuncio) {
		this.repositorioAnuncio.delete(idAnuncio);
	}
}
