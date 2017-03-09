package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.ArrayList;
import java.util.List;

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
	
	private final TiposPermissao TIPO_PERMISSAO = TiposPermissao.PERMISSAO_JURIDICA;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<PermissoesUsuario> listaDePermissoes;
	
	public PermissaoPessoaJuridica() {
		this.listaDePermissoes = new ArrayList<PermissoesUsuario>();
		
		addPermissoes();
	}
	
	@Override
	public TiposPermissao getTipoPermissao() {
		return TIPO_PERMISSAO;
	}
	
	private void addPermissoes() {
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_EMPREGO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_PRODUTO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_SERVICO);
	}

}
