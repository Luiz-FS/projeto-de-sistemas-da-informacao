package br.edu.ufcg.computacao.si1.excecoes;

public class ObjetoInexistenteException extends AdExtremeException {
	
	public ObjetoInexistenteException() {
		super("Objeto nao existe no sistema!");
	}
	
	public ObjetoInexistenteException(String mensagem) {
		super(mensagem);
	}
}
