package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AnuncioProduto extends Anuncio {

	private static final TipoAnuncio TIPO = TipoAnuncio.PRODUTO;

	@Column(name = "categoria")
	private CategoriaAnuncioProduto categoria;

	public AnuncioProduto(String titulo, Date dataCriacao, double valor, CategoriaAnuncioProduto categoria, Long idUsuario, String descricao) {
		super(titulo, dataCriacao, valor, TIPO, idUsuario, descricao);
		this.categoria = categoria;
	}

	public AnuncioProduto() {
		super();
		this.categoria = CategoriaAnuncioProduto.DEFAULT;
	}

	public CategoriaAnuncioProduto getCategoria() {
        return this.categoria;
    }

	public void setCategoria(CategoriaAnuncioProduto categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String gerarStringNotificacaoCompra() {
		String gerarDescricao = "";
		
		gerarDescricao += "O seu anuncio: " + this.getTitulo() + FIM_LINHA
						  + "Do tipo: Produto, foi contratado" + FIM_LINHA 
						  + "Com valor: "+ this.getValor();
		
		return gerarDescricao;
	}
}
