package br.edu.ufcg.computacao.si1.model.dto;

import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.usuario.SaldoDeUsuario;
import br.edu.ufcg.computacao.si1.model.usuario.TiposPermissao;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import java.util.List;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private TiposPermissao permissao;
    private SaldoDeUsuario saldoDeUsuario;
    private List<Avaliacao> listaDeAvaliacoes;
    private List<Notificacao> listaDeNotificacoes;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.permissao = usuario.getPermissao().getTipoPermissao();
        this.saldoDeUsuario = usuario.getSaldoDeUsuario();
        this.listaDeAvaliacoes = usuario.getListaDeAvaliacoes();
        this.listaDeNotificacoes = usuario.getListaDeNotificacoes();
    }

    public Long getId() {
        return id;
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

    public TiposPermissao getPermissao() {
        return permissao;
    }

    public void setPermissao(TiposPermissao permissao) {
        this.permissao = permissao;
    }

    public SaldoDeUsuario getSaldoDeUsuario() {
        return saldoDeUsuario;
    }

    public void setSaldoDeUsuario(SaldoDeUsuario saldoDeUsuario) {
        this.saldoDeUsuario = saldoDeUsuario;
    }

    public List<Avaliacao> getListaDeAvaliacoes() {
        return listaDeAvaliacoes;
    }

    public void setListaDeAvaliacoes(List<Avaliacao> listaDeAvaliacoes) {
        this.listaDeAvaliacoes = listaDeAvaliacoes;
    }

    public List<Notificacao> getListaDeNotificacoes() {
        return listaDeNotificacoes;
    }

    public void setListaDeNotificacoes(List<Notificacao> listaDeNotificacoes) {
        this.listaDeNotificacoes = listaDeNotificacoes;
    }
}
