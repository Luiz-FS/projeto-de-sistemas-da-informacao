package br.edu.ufcg.computacao.si1.excecoes;

public class AnuncioInexistenteException extends ObjetoInexistenteException {
	
	public AnuncioInexistenteException() {
		super("Anuncio não existe!");
	}
}
