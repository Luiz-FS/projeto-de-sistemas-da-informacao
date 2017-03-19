package br.edu.ufcg.computacao.si1.model.usuario;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PermissaoPessoaJuridica extends Permissao {

	@ElementCollection( targetClass = PermissoesUsuario.class )
	private List<PermissoesUsuario> listaDePermissoes;
	
	public PermissaoPessoaJuridica() {
		this.listaDePermissoes = new ArrayList<>();
		
		addPermissoes();
	}
	
	@Override
	public TiposPermissao getTipoPermissao() {
		return TiposPermissao.PERMISSAO_PESSOA_JURIDICA;
	}
	
	@Override
	public List<PermissoesUsuario> getPermissoes() {
		return this.listaDePermissoes;
	}
	
	@Override
	public boolean temPermissao(PermissoesUsuario permissao) {
		return this.listaDePermissoes.contains(permissao);
	}
	
	private void addPermissoes() {
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_EMPREGO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_PRODUTO);
		this.listaDePermissoes.add(PermissoesUsuario.CRIAR_ANUNCIO_SERVICO);
	}
}
