package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AnuncioEmprego extends Anuncio {
	
	private static final TipoAnuncio TIPO = TipoAnuncio.EMPREGO;
	private static final Double VALOR_NULO = 0.0;

	public AnuncioEmprego(String titulo, Date dataCriacao, Long idUsuario, String descricao) {
		super(titulo, dataCriacao, VALOR_NULO, TIPO, idUsuario, descricao);
	}

	public AnuncioEmprego() {
		super();
	}

	@Override
	public String gerarMensagemNotificacaoContratacao() {
		String gerarDescricao = "";
		
		gerarDescricao += "O anuncio: "+ this.getTitulo() + FIM_LINHA
						  + "Do tipo: Emprego, foi contratado";
		
		return gerarDescricao;
	}
}