package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Entity;
import java.util.Date;

@Entity
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
