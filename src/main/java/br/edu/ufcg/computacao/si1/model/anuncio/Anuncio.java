package br.edu.ufcg.computacao.si1.model.anuncio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ufcg.computacao.si1.model.Avaliacao;

@Entity
@Table(name = "tb_anuncio")
public abstract class Anuncio {
	
	protected static final String FIM_LINHA = System.lineSeparator();
	protected final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "data_criacao", nullable = false)
	private Date dataDeCriacao;

	@Column(name = "valor")
	private double valor;

	@Column(name = "tipo")
	private TipoAnuncio tipo;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Avaliacao> avaliacoes;

	public Anuncio(String titulo, Date dataDeCriacao, double valor, TipoAnuncio tipo, Long idUsuario, String descricao) {
		this.titulo = titulo;
		this.dataDeCriacao = dataDeCriacao;
		this.valor = valor;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.avaliacoes = new ArrayList<>();
	}

	public Anuncio() {
		this.titulo = "";
		this.dataDeCriacao = new Date();
		this.valor = 0;
		this.tipo = TipoAnuncio.DEFAULT;
	}

	public Long getId() {
		return id;
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public abstract String gerarMensagemNotificacaoContratacao();
}