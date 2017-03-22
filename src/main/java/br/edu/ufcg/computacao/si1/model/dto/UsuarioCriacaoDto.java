package br.edu.ufcg.computacao.si1.model.dto;

import br.edu.ufcg.computacao.si1.model.usuario.TiposPermissao;

/**
 * Created by luiz on 19/03/17.
 */
public class UsuarioCriacaoDto {

    private String nome;

    private String email;

    private String senha;

    private TiposPermissao permissao;

    public  UsuarioCriacaoDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TiposPermissao getPermissao() {
        return permissao;
    }

    public void setPermissao(TiposPermissao permissao) {
        this.permissao = permissao;
    }
}
