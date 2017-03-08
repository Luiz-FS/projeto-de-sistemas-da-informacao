package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Classe que da permissão do tipo pessoa fisica.
 * 
 * @author Davi Laerte
 */
public class PermissaoPessoaFisica implements Permissao {
	private final String TIPO_PERMISSAO = "USER";

	@Override
	public String getTipoPermissao() {
		return TIPO_PERMISSAO;
	}

}
