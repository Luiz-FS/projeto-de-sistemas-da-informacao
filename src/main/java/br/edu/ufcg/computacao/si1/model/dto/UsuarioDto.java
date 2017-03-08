package br.edu.ufcg.computacao.si1.model.dto;

/**
 * Created by antonioabreu on 08/03/17.
 */

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private String permissao;

    public UsuarioDto(Long id, String nome, String email, String permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.permissao = permissao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
