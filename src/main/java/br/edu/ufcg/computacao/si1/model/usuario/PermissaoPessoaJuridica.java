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
 * Classe que da permissão do tipo pessoa juridica.
 * 
 * @author Davi Laerte
 */

@Entity(name = "PermissaoPessoaJuridica")
@Table(name = "tb_PermissaoPessoaJuridica")
public class PermissaoPessoaJuridica implements Permissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private final String TIPO_PERMISSAO = "COMPANY";
	
	@OneToMany
	private List<PermissoesUsuario> listaDePermissoes;
	
	public PermissaoPessoaJuridica() {
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
