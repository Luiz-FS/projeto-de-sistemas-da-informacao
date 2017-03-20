package br.edu.ufcg.computacao.si1.excecoes;

public class ObjetoInvalidoException extends AdExtremeException {
	
	public ObjetoInvalidoException() {
		super("Objeto invalido!");
	}
	
	public ObjetoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
