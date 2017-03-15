package br.edu.ufcg.computacao.si1.model;

import br.edu.ufcg.computacao.si1.model.anuncio.ConceitoDoAnuncio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nota")
	private ConceitoDoAnuncio nota;
	
	@Column(name = "comentarios")
	private String comentarios;
	
	public Avaliacao(ConceitoDoAnuncio nota, String comentarios) {
		this.nota = nota;
		this.comentarios = comentarios;
	}
	
	public Avaliacao() {

	}

	public ConceitoDoAnuncio getNota() {
		return nota;
	}

	public void setNota(ConceitoDoAnuncio nota) {
		this.nota = nota;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}
}
