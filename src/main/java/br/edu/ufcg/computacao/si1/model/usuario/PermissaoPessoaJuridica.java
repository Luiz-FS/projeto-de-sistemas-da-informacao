package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe que da permissão do tipo pessoa juridica.
 * 
 * @author Davi Laerte
 */

@Entity(name = "PermissaoPessoaJuridica")
@Table(name = "tb_PermissaoPessoaJuridica")
public class PermissaoPessoaJuridica extends Permissao {
	
	private final TiposPermissao TIPO_PERMISSAO = TiposPermissao.PERMISSAO_JURIDICA;
	
	@ElementCollection( targetClass = PermissoesUsuario.class )
	private List<PermissoesUsuario> listaDePermissoes;
	
	public PermissaoPessoaJuridica() {
		this.listaDePermissoes = new ArrayList<PermissoesUsuario>();
		
		addPermissoes();
	}
	
	@Override
	public TiposPermissao getTipoPermissao() {
		return TIPO_PERMISSAO;
	}
	
	@Override
	public List<PermissoesUsuario> getPermissoes() {
		return this.listaDePermissoes;
	}
	
	private void addPermissoes() {
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_EMPREGO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_PRODUTO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_SERVICO);
	}

}
