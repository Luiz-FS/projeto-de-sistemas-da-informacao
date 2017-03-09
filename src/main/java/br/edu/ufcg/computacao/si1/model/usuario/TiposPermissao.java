package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Created by luiz on 08/03/17.
 * Susgestão para organizar as permissões de usuário
 * Dessa forma nós podemos definir as constantes  e pega-las
 * posteriormente sem problema.
 */
public enum TiposPermissao {

    PERMISSAO_USUARIO("USER"), PERMISSAO_JURIDICA("COMPANY");

    private String permissao;

    private TiposPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return this.permissao;
    }
}
