package br.edu.ufcg.computacao.si1.experts;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;

/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class AnuncioExpert {
	
	@Autowired
	private AnuncioRepository repositorioAnuncio;
	
	
	public Anuncio salvarAnuncio(Anuncio anuncio) {
		return repositorioAnuncio.save(anuncio);
	}
	
	

}
