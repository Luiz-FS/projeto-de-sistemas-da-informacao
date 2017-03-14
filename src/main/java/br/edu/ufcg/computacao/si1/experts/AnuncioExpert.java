package br.edu.ufcg.computacao.si1.experts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;

/**
 */
public class AnuncioExpert {

	@Autowired
	private AnuncioRepository repositorioAnuncio;


	public Anuncio salvarAnuncio(Anuncio anuncio) {
		return repositorioAnuncio.save(anuncio);
	}

	public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) {
		return repositorioAnuncio.findByIdUsuario(idUsuario);
	}

	public void contratarAnuncio(Anuncio anuncio) {
		// debita e credita usuario

		deletarAnuncio(anuncio);
	}

	private void deletarAnuncio(Anuncio anuncio) {
		repositorioAnuncio.delete(anuncio);
	}
}
