package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Created by luiz on 07/03/17.
 */

@Entity
public class AnuncioEmprego extends Anuncio {

	private static final Double VALOR_ZERO = 0.0;

	public AnuncioEmprego(String titulo, Date dataCriacao) {
		super(titulo, dataCriacao, VALOR_ZERO);
	}

	public AnuncioEmprego() {
		super();
	}
}
