package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AnuncioProduto extends Anuncio {

	private static final TipoAnuncio TIPO = TipoAnuncio.PRODUTO;

	@Column(name = "categoria")
	private CategoriaAnuncio categoriaAnuncio;

	public AnuncioProduto(String titulo, Date dataCriacao, double valor, CategoriaAnuncio categoria, Long idUsuario, String descricao) {
		super(titulo, dataCriacao, valor, TIPO, idUsuario, descricao);
		this.categoriaAnuncio = categoria;
	}

	public AnuncioProduto() {
		super();
		this.categoriaAnuncio = CategoriaAnuncio.DEFAULT;
	}

	public CategoriaAnuncio getCategoria() {
        return this.categoriaAnuncio;
    }

	public void setCategoria(CategoriaAnuncio categoria) {
		this.categoriaAnuncio = categoria;
	}
	
	@Override
	public String gerarMensagemNotificacaoContratacao() {
		String gerarDescricao = "";
		
		gerarDescricao += "O anuncio: " + this.getTitulo() + 
				          " criado:" + super.getDataDeCriacao() +	
						  "Do tipo: Produto, foi contratado" + 
						  "Pelo valor de: R$"+ this.getValor();
		
		return gerarDescricao;
	}
}
