package br.edu.ufcg.computacao.si1.model.dto;

import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

/**
 * Created by antonioabreu on 08/03/17.
 */

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private Permissao permissao;

    public UsuarioDto(Long id, String nome, String email, Permissao permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.permissao = permissao;
    }

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.permissao = usuario.getPermissao();
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

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
