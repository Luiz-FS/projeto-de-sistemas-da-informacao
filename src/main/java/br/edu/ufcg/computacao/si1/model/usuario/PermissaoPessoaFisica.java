package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe que da permissão do tipo pessoa fisica.
 * 
 * @author Davi Laerte
 */

@Entity(name = "PermissaoPessoaFisica")
@Table(name = "tb_PermissaoPessoaFisica")
public class PermissaoPessoaFisica extends Permissao {

	private final TiposPermissao TIPO_PERMISSAO = TiposPermissao.PERMISSAO_PESSOA_FISICA;

	@ElementCollection(targetClass = PermissoesUsuario.class )
	private List<PermissoesUsuario> listaDePermissoes;

	public PermissaoPessoaFisica() {
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
