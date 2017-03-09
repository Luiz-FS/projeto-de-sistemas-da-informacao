package br.edu.ufcg.computacao.si1.model.usuario;

import br.edu.ufcg.computacao.si1.util.Constantes;

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

	@ElementCollection(targetClass = PermissoesUsuario.class )
	private List<PermissoesUsuario> listaDePermissoes;

	public PermissaoPessoaFisica() {
		this.listaDePermissoes = new ArrayList<PermissoesUsuario>();

		addPermissoes();
	}

	@Override
	public TiposPermissao getTipoPermissao() {
		return Constantes.PERMISSAO_PESSOA_FISICA;
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
