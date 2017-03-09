package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Created by luiz on 08/03/17.
 */
public enum TiposPermissao {

    PERMISSAO_PESSOA_FISICA("USER"), PERMISSAO_JURIDICA("COMPANY");

    private String permissao;

    private TiposPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return this.permissao;
    }
}
