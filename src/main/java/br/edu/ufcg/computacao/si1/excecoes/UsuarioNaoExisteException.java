package br.edu.ufcg.computacao.si1.excecoes;

public class UsuarioNaoExisteException extends ObjetoNaoExisteException {
	
	public UsuarioNaoExisteException() {
		super("Usuario não existe no sistema!");
	}
}
