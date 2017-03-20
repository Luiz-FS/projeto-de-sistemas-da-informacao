package br.edu.ufcg.computacao.si1.factories;

import java.util.Date;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioProduto;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioServico;
import br.edu.ufcg.computacao.si1.model.anuncio.CategoriaAnuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.TipoAnuncio;
import br.edu.ufcg.computacao.si1.model.dto.AnuncioCriacaoDto;

public class AnuncioFactory {
	
	public Anuncio criaAnuncio(AnuncioCriacaoDto anuncioCriacao, Long idUsuario) {
		String titulo = anuncioCriacao.getTitulo();
		Date dataDeCriacao = new Date();
		double valor = anuncioCriacao.getValor();
		TipoAnuncio tipoAnuncio = anuncioCriacao.getTipo();
		String descricao = anuncioCriacao.getDescricao();
		CategoriaAnuncio categoriaAnuncio = anuncioCriacao.getCategoriaAnuncio();
		
		return criaInstaciaDeAnuncio(titulo, dataDeCriacao, valor, tipoAnuncio, idUsuario, descricao, categoriaAnuncio);
	}
	
	private Anuncio criaInstaciaDeAnuncio(String titulo, Date dataDeCriacao, double valor, TipoAnuncio tipoAnuncio,
			Long idUsuario, String descricao, CategoriaAnuncio categoriaAnuncio) {
		
		if(tipoAnuncio.equals(TipoAnuncio.EMPREGO)) {
			return new AnuncioEmprego(titulo, dataDeCriacao, idUsuario, descricao);
		} else if(tipoAnuncio.equals(TipoAnuncio.PRODUTO)) {
			return new AnuncioProduto(titulo, dataDeCriacao, valor, categoriaAnuncio, idUsuario, descricao);
		} else {
			return new AnuncioServico(titulo, dataDeCriacao, valor, idUsuario, descricao);
		}
	}
}
