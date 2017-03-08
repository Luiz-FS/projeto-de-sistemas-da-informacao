package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import java.util.Date;

/**
 * Created by luiz on 07/03/17.
 */
public class AnuncioEmprego extends Anuncio {

    public AnuncioEmprego(String titulo, Date dataCriacao, Notas nota) {
        super(titulo, dataCriacao, 0, nota, "emprego");
    }

    public AnuncioEmprego() {
        super();
    }
}
