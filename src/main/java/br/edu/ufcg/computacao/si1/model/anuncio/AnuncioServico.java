package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Column;
import java.util.Date;

public class AnuncioServico extends Anuncio {

    public AnuncioServico(String titulo, Date dataDeCriacao, double valor, Notas nota) {
        super(titulo, dataDeCriacao, valor, nota);
    }

    public AnuncioServico() {
        super();
    }

    @Override
    public Date getDataDeAgendamento() {
        return super.dataDeAgendamento;
    }

    @Override
    public void setDataDeAgendamento(Date dataDeAgendamento) {
        super.dataDeAgendamento = dataDeAgendamento;
    }
}
