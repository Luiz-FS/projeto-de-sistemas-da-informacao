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

import br.edu.ufcg.computacao.si1.model.Notas;

/**
 * Created by Marcus Oliveira on 08/12/16.
 */
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
	
	// inicia null, so muda quando usuario
	// der uma nota ele deve mudar.
	@Column(name = "nota")
	private Notas nota;

	// usado apenas no Servico.
	@Column(name = "data_agendamento")
	protected Date dataDeAgendamento;
	
	// usado apenas no Emprego.
	@Column(name = "categoria")
	protected Categoria categoria;

	public Anuncio(String titulo, Date dataDeCriacao, double valor) {
		this.titulo = titulo;
		this.dataDeCriacao = dataDeCriacao;
		this.valor = valor;
	}

	public Anuncio() {
		this.titulo = "";
		this.dataDeCriacao = new Date();
		this.valor = 0;
		this.nota = Notas.NOTA_ZERO;
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

	public Notas getNota() {
		return nota;
	}

	public void setNota(Notas nota) {
		this.nota = nota;
	}

	// retorna null, pois não existe para
	// alguns tipos de anuncio.
	public String getDataDeAgendamento() {
		return null;
	}

	// nao deve ser setado para alguns tipos
	// de anuncio.
	public void setDataDeAgendamento(Date dataDeAgendamento) {
	}
	
	// retorna null, pois não existe para
	// alguns tipos de anuncio.
	public Categoria getCategoria() {
        return null;
    }
	
	// nao deve ser setado para alguns tipos
	// de anuncio.
	public void setCategoria(Categoria categoria) {
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
