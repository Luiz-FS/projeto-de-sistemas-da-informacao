package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by luiz on 07/03/17.
 */
@Entity
public class AnuncioEmprego extends Anuncio {

    public AnuncioEmprego(String titulo, Date dataCriacao, Notas nota) {
        super(titulo, dataCriacao, 0, nota);
    }

    public AnuncioEmprego() {
        super();
    }
}
