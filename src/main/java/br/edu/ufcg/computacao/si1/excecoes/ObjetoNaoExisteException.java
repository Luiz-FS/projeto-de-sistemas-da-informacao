package br.edu.ufcg.computacao.si1.excecoes;

public class ObjetoNaoExisteException extends AdExtremeException {
	
	public ObjetoNaoExisteException() {
		super("Objeto nao existe no sistema!");
	}
	
	public ObjetoNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
