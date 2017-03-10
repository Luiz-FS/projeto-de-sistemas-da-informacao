package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Created by luiz on 07/03/17.
 */

@Entity
public class AnuncioProduto extends Anuncio {

	public AnuncioProduto(String titulo, Date dataCriacao, double valor, Categoria categoria) {
		super(titulo, dataCriacao, valor);
		super.categoria = categoria;
	}

	public AnuncioProduto() {
		super();
	}

	@Override
	public Categoria getCategoria() {
		return super.categoria;
	}

	@Override
	public void setCategoria(Categoria categoria) {
		super.categoria = categoria;
	}
}
