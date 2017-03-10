package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Notas;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by luiz on 07/03/17.
 */
@Entity
public class AnuncioProduto extends Anuncio {

    private Categoria categoria;

    public enum Categoria {
        MOVEL, IMOVEL;
    }

    public AnuncioProduto (String titulo, Date dataCriacao, double valor, Notas nota, Categoria categoria) {
        super(titulo, dataCriacao,valor,nota);
        this.categoria = categoria;
    }

    public AnuncioProduto(Categoria categoria) {
        super();
        this.categoria = categoria;
    }

    public AnuncioProduto() {
        super();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
