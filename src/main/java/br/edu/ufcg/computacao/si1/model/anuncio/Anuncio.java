package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.*;
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

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", nullable = false, unique = true)
	private Long _id;

	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "data_criacao", nullable = false)
	private Date dataDeCriacao;

	@Column(name = "valor")
	private double valor;

	@Column(name = "nota")
	private AvaliacaoDeAnuncio nota;

	public Anuncio(String titulo, Date dataDeCriacao, double valor, AvaliacaoDeAnuncio nota) {

	@Column(name = "tipo")
	private TipoAnuncio tipo;

	public Anuncio(String titulo, Date dataDeCriacao, double valor, TipoAnuncio tipo, Long idUsuario) {
		this.titulo = titulo;
		this.dataDeCriacao = dataDeCriacao;
		this.valor = valor;
		this.nota = nota;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}

	public Anuncio() {
		this.titulo = "";
		this.dataDeCriacao = new Date();
		this.valor = 0;
		this.tipo = TipoAnuncio.DEFAULT;
		this.nota = AvaliacaoDeAnuncio.NOTA_ZERO;
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
	public AvaliacaoDeAnuncio getNota() {
		return nota;
	}

	public void setTipo(TipoAnuncio tipo) {
		this.tipo = tipo;
	public void setNota(AvaliacaoDeAnuncio nota) {
		this.nota = nota;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}


	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof Anuncio))
			return false;

		Anuncio anuncio = (Anuncio) object;

		if (Double.compare(anuncio.getValor(), getValor()) != 0)
			return false;
		if (!_id.equals(anuncio._id))
			return false;
		if (!idUsuario.equals(anuncio.idUsuario))
			return false;
		if (!getTitulo().equals(anuncio.getTitulo()))
			return false;
		if (!getDataDeCriacao().equals(anuncio.getDataDeCriacao()))
			return false;
		return getNota() == anuncio.getNota();
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = _id.hashCode();
		result = 31 * result + idUsuario.hashCode();
		result = 31 * result + getTitulo().hashCode();
		result = 31 * result + getDataDeCriacao().hashCode();
		temp = Double.doubleToLongBits(getValor());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + getNota().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Anuncio{" + "_id=" + _id + ", titulo='" + titulo + '\'' + ", dataDeCriacao=" + getDataDeCriacao()
				+ ", valor=" + valor + ", nota=" + nota +
				/* ", tipo='" + tipo + '\'' */ +'}';
	}
}
