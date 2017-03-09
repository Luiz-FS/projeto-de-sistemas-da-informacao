package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que da permissão do tipo pessoa fisica.
 * 
 * @author Davi Laerte
 */

@Entity(name = "PermissaoPessoaFisica")
@Table(name = "tb_PermissaoPessoaFisica")
public class PermissaoPessoaFisica implements Permissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private final String TIPO_PERMISSAO = "USER";

	@OneToMany
	private List<PermissoesUsuario> listaDePermissoes;
	
	public PermissaoPessoaFisica() {
		this.listaDePermissoes = new ArrayList<PermissoesUsuario>();
		
		addPermissoes();
	}
	
	@Override
	public String getTipoPermissao() {
		return TIPO_PERMISSAO;
	}
	
	private void addPermissoes() {
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_EMPREGO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_PRODUTO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_SERVICO);
	}
}
