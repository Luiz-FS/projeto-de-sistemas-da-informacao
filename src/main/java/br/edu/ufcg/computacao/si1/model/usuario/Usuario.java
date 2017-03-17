package br.edu.ufcg.computacao.si1.model.usuario;

import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.Notificacao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;

	@Column(unique = true)
	private String email;

	@Column
	private String senha;

	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	private Permissao permissao;

	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	private SaldoDeUsuario saldoDeUsuario;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Avaliacao> listaDeAvaliacoes;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Notificacao> listaDeNotificacoes;
	
	public Usuario() {}

	public Usuario(String nome, String email, String senha, Permissao permissao) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.permissao = permissao;
		this.saldoDeUsuario = new SaldoDeUsuario();
		this.listaDeAvaliacoes = new ArrayList<>();
		this.listaDeNotificacoes = new ArrayList<>();
	}

	public boolean isSenhaValida(String senha) {
		return this.senha.equals(senha);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (! this.senha.equals(senha)) {
			this.senha = senha;
		}
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
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

	public List<Notificacao> getListaDeNotificacoes() {
		return listaDeNotificacoes;
	}
}
