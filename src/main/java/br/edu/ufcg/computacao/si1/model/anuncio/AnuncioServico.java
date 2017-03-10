package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AnuncioServico extends Anuncio {

	public AnuncioServico(String titulo, Date dataDeCriacao, double valor) {
		super(titulo, dataDeCriacao, valor);
	}

	public AnuncioServico() {
		super();
	}

	@Override
	public String getDataDeAgendamento() {
		return DATE_FORMAT.format(super.dataDeAgendamento);
	}

	@Override
	public void setDataDeAgendamento(Date dataDeAgendamento) {
		super.dataDeAgendamento = dataDeAgendamento;
	}
}
