package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	// comentei pois ele não achou o tipo, foi tirado de anuncio.
    //@Query("select anuncio from Anuncio anuncio where anuncio.tipo = :tipo")
    //public List<Anuncio> findByTipo(String tipo);
}
