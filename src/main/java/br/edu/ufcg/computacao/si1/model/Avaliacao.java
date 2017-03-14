package br.edu.ufcg.computacao.si1.model;

import br.edu.ufcg.computacao.si1.model.anuncio.AvaliacaoDeAnuncio;

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
	@Column(name = "_id")
	private Long _id;
	
	@Column(name = "nota")
	private AvaliacaoDeAnuncio nota;
	
	@Column(name = "comentarios")
	private String comentarios;
	
	public Avaliacao(AvaliacaoDeAnuncio nota, String comentarios) {
		this.nota = nota;
		this.comentarios = comentarios;
	}
	
	public Avaliacao() {

	}

	public AvaliacaoDeAnuncio getNota() {
		return nota;
	}

	public void setNota(AvaliacaoDeAnuncio nota) {
		this.nota = nota;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Long get_id() {
		return _id;
	}
}
