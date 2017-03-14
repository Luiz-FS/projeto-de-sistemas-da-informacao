package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AnuncioEmprego extends Anuncio {

	private static final TipoAnuncio TIPO = TipoAnuncio.EMPREGO;
	private static final Double VALOR_ZERO = 0.0;

	public AnuncioEmprego(String titulo, Date dataCriacao, Long idUsuario) {
		super(titulo, dataCriacao, VALOR_ZERO, TIPO, idUsuario);
	}

	public AnuncioEmprego() {
		super();
	}
}
