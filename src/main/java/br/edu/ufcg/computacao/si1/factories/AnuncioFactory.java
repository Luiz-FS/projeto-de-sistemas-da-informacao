package br.edu.ufcg.computacao.si1.factories;

import java.util.Date;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioProduto;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioServico;
import br.edu.ufcg.computacao.si1.model.anuncio.CategoriaAnuncioProduto;

/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class AnuncioFactory {

    public static Anuncio criaEmprego(Long idUsuario, String titulo, Date dataCriacao, double valor) {

        return new AnuncioEmprego(titulo, dataCriacao);
    }

    public static Anuncio criaProduto(String titulo, Date dataCriacao, double valor,
                                      CategoriaAnuncioProduto categoria) {

        return new AnuncioProduto(titulo, dataCriacao, valor, categoria);
    }

    public static Anuncio criaServico(Long idUsuario, String titulo, Date dataDeCriacao, double valor,String tipo) {

        return new AnuncioServico(titulo, dataDeCriacao, valor);
    }
}
