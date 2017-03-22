package br.edu.ufcg.computacao.si1.excecoes;

public class UsuarioInexistenteException extends ObjetoInexistenteException {
	
	public UsuarioInexistenteException() {
		super("Usuario não existe no sistema!");
	}
}
