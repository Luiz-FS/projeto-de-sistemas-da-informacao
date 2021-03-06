package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AnuncioServico extends Anuncio {

	private static final TipoAnuncio TIPO = TipoAnuncio.SERVICO;

	@Column(name = "data_agendamento")
	private Date dataDeAgendamento;

	public AnuncioServico(String titulo, Date dataDeCriacao, double valor, Long idUsuario, String descricao) {
		super(titulo, dataDeCriacao, valor, TIPO, idUsuario, descricao);
		this.dataDeAgendamento = new Date();
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
	
	@Override
	public String gerarMensagemNotificacaoContratacao() {
		String gerarDescricao = "";
		
		gerarDescricao += "O anuncio: "+ this.getTitulo() +
				          " criado:" + super.getDataDeCriacao() +	 
						  " do tipo: Servico, foi contratado" + 
						  " com data de agendamento para: "+ this.getDataDeAgendamento();
		
		return gerarDescricao;
	}
}
