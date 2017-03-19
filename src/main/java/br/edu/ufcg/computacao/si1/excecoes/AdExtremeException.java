package br.edu.ufcg.computacao.si1.excecoes;

public class AdExtremeException extends Exception {
	
	public AdExtremeException() {
		super("Erro no sistema");
	}
	
	public AdExtremeException(String mensagem) {
		super(mensagem);
	}
}
