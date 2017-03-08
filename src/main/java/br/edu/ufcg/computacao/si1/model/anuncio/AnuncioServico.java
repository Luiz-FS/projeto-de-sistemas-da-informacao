package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by luiz on 07/03/17.
 */
public class AnuncioServico extends Anuncio {

    @Column(name = "data_agendamento", nullable = false)
    private Date dataDeAgendamento;

    /**
     * O atributo data de criação está ferindo a construção da classe
     * Já que o auncio de serviço quando é criado ainda não possui um agendamento.
     */
    public AnuncioServico(String titulo, Date dataDeCriacao, Date dataDeAgendamento, double valor,
                          Notas nota, String tipo) {
        super(titulo,dataDeCriacao,valor,nota, tipo);

        this.dataDeAgendamento = dataDeAgendamento;
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
