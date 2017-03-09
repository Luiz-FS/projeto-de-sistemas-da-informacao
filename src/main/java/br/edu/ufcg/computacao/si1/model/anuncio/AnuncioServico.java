package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Column;
import java.util.Date;

public class AnuncioServico extends Anuncio {

    @Column(name = "data_agendamento")
    private Date dataDeAgendamento;

    public AnuncioServico(String titulo, Date dataDeCriacao, double valor, Notas nota) {
        super(titulo, dataDeCriacao, valor, nota);
    }

    public AnuncioServico() {
        super();
    }

    public Date getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(Date dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }
}
