package br.edu.ufcg.computacao.si1.model.dto;

import br.edu.ufcg.computacao.si1.model.anuncio.CategoriaAnuncioProduto;
import br.edu.ufcg.computacao.si1.model.anuncio.TipoAnuncio;

import java.util.Date;

/**
 * Created by luiz on 16/03/17.
 */
public class AnuncioDto {

    private long idUsuario;

    private String titulo;

    private Date dataDeCriação;

    private TipoAnuncio tipo;

    private String descricao;

    private CategoriaAnuncioProduto categoriaAnuncioProduto;

    public AnuncioDto() {
    }

    public Date getDataDeCriação() {
        return dataDeCriação;
    }

    public void setDataDeCriação(Date dataDeCriação) {
        this.dataDeCriação = dataDeCriação;
    }

    public TipoAnuncio getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnuncio tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaAnuncioProduto getCategoriaAnuncioProduto() {
        return categoriaAnuncioProduto;
    }

    public void setCategoriaAnuncioProduto(CategoriaAnuncioProduto categoriaAnuncioProduto) {
        this.categoriaAnuncioProduto = categoriaAnuncioProduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
