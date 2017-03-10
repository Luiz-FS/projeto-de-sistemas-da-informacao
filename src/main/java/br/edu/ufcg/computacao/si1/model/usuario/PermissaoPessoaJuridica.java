package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

/**
 * Classe que da permissão do tipo pessoa juridica.
 * 
 * @author Davi Laerte
 */

@Entity
public class PermissaoPessoaJuridica extends Permissao {
	

	@ElementCollection( targetClass = PermissoesUsuario.class )
	private List<PermissoesUsuario> listaDePermissoes;
	
	public PermissaoPessoaJuridica() {
		this.listaDePermissoes = new ArrayList<PermissoesUsuario>();
		
		addPermissoes();
	}
	
	@Override
	public TiposPermissao getTipoPermissao() {
		return TiposPermissao.PERMISSAO_JURIDICA;
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
