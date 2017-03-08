package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Classe que da permissão do tipo pessoa juridica.
 * 
 * @author Davi Laerte
 */
public class PermissaoPessoaJuridica implements Permissao {
	private final String TIPO_PERMISSAO = "COMPANY";
	
	@Override
	public String getTipoPermissao() {
		return TIPO_PERMISSAO;
	}

}
