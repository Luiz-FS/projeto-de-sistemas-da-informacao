package br.edu.ufcg.computacao.si1.excecoes;

public class AnuncioNaoExisteException extends ObjetoNaoExisteException {
	
	public AnuncioNaoExisteException() {
		super("Anuncio não existe!");
	}
}
