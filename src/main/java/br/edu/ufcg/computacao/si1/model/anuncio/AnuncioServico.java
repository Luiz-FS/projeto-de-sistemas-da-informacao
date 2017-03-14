package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AnuncioServico extends Anuncio {

	private static final TipoAnuncio TIPO = TipoAnuncio.SERVICO;

	@Column(name = "data_agendamento")
	protected Date dataDeAgendamento;

	public AnuncioServico(String titulo, Date dataDeCriacao, double valor, Long idUsuario, String descricao) {
		super(titulo, dataDeCriacao, valor, TIPO, idUsuario, descricao);
	}

    public AnuncioServico() {
        super();
    }

	public String getDataDeAgendamento() {
		return DATE_FORMAT.format(this.dataDeAgendamento);
	}

	public void setDataDeAgendamento(Date dataDeAgendamento) {
		this.dataDeAgendamento = dataDeAgendamento;
	}
}
