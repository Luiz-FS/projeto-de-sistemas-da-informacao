package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.Notas;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioProduto;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioServico;

import java.util.Date;

/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class AnuncioFactory {

    public static Anuncio criaEmprego(Long idUsuario, String titulo, Date dataCriacao, double valor, Notas nota) {

        return new AnuncioEmprego(titulo, dataCriacao, nota);
    }

    public static Anuncio criaProduto(String titulo, Date dataCriacao, double valor, Notas nota,
                                      AnuncioProduto.Categoria categoria) {

        return new AnuncioProduto(titulo, dataCriacao, valor, nota, categoria);
    }

    public static Anuncio criaServico(Long idUsuario, String titulo, Date dataDeCriacao, double valor,
                                      Notas nota, String tipo) {

        return new AnuncioServico(titulo, dataDeCriacao, valor, nota, tipo);
    }
}
