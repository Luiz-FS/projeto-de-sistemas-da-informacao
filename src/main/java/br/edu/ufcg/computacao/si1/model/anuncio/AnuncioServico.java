package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Entity;

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
