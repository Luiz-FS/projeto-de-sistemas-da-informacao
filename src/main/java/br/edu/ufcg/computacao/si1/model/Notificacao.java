package br.edu.ufcg.computacao.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Notificacao")
@Table(name = "tb_notificacao")
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String mensagem;
	
	@Column
	private Long idComprador;
	
	@Column
	private TipoNotificacao tipoNotificacao;
	
	public Notificacao(String mensagem, Long idComprador, TipoNotificacao tipoNotificacao) {
		this.mensagem = mensagem;
		this.idComprador = idComprador;
		this.tipoNotificacao = tipoNotificacao;
	}
	
	public Notificacao() {
		
	}

	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Long getIdComprador() {
		return idComprador;
	}
	
	public Long getId() {
		return id;
	}

	public TipoNotificacao getTipoNotificacao() {
		return tipoNotificacao;
	}
}
