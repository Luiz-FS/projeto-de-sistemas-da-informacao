package br.edu.ufcg.computacao.si1.model.anuncio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_anuncio")
public abstract class Anuncio {

	protected final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private Long _id;

	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "data_criacao")
	private Date dataDeCriacao;

	@Column(name = "valor")
	private double valor;
	
	@Column(name = "tipo")
	private TipoAnuncio tipo;
	
	public Anuncio(String titulo, Date dataDeCriacao, double valor, TipoAnuncio tipo) {
		this.titulo = titulo;
		this.dataDeCriacao = dataDeCriacao;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Anuncio() {
		this.titulo = "";
		this.dataDeCriacao = new Date();
		this.valor = 0;
		this.tipo = TipoAnuncio.DEFAULT;
	}

	/**
	 * Retorna o id do anuncio
	 * 
	 * @return o id do anuncio
	 */
	public Long getId() {
		return _id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataDeCriacao() {
		return DATE_FORMAT.format(dataDeCriacao);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoAnuncio getTipo() {
		return tipo;
	}

	public void setTipo(TipoAnuncio tipo) {
		this.tipo = tipo;
	}
}
