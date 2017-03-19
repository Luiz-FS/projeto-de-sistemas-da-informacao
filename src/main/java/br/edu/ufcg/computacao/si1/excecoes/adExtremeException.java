package br.edu.ufcg.computacao.si1.excecoes;

public class adExtremeException extends Exception {
	
	public adExtremeException() {
		super("Erro no sistema");
	}
	
	public adExtremeException(String mensagem) {
		super(mensagem);
	}
}
