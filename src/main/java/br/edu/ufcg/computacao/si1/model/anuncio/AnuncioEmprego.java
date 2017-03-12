package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by luiz on 07/03/17.
 */
@Entity
public class AnuncioEmprego extends Anuncio {

	private static final Double VALOR_ZERO = 0.0;

	public AnuncioEmprego(String titulo, Date dataCriacao, Notas nota) {
		super(titulo, dataCriacao, VALOR_ZERO, nota);
	}

	public AnuncioEmprego() {
		super();
	}
}
