package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class AnuncioServico extends Anuncio {

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");//isso sera removido pois temos uma classe CONSTANTES


    @Column(name = "data_agendamento")
    private Date dataDeAgendamento;

    public AnuncioServico(String titulo, Date dataDeCriacao, double valor, AvaliacaoDeAnuncio nota) {
        super(titulo, dataDeCriacao, valor, nota);
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
