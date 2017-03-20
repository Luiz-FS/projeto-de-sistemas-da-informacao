package br.edu.ufcg.computacao.si1.model.dto;

import br.edu.ufcg.computacao.si1.model.anuncio.CategoriaAnuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.TipoAnuncio;

public class AnuncioCriacaoDto {
	
    private String titulo;

    private TipoAnuncio tipo;

    private String descricao;

	private double valor;
    
    private CategoriaAnuncio categoriaAnuncio;
    
    
    public AnuncioCriacaoDto() {
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public TipoAnuncio getTipo() {
		return tipo;
	}


	public void setTipo(TipoAnuncio tipo) {
		this.tipo = tipo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public CategoriaAnuncio getCategoriaAnuncio() {
		return categoriaAnuncio;
	}


	public void setCategoriaAnuncio(CategoriaAnuncio categoriaAnuncio) {
		this.categoriaAnuncio = categoriaAnuncio;
	}
}
