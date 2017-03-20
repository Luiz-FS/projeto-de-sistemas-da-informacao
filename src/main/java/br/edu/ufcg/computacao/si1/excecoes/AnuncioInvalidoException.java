package br.edu.ufcg.computacao.si1.excecoes;

/**
 * Created by pedro on 16/03/17.
 */
public class AnuncioInvalidoException extends ObjetoInvalidoException {

    public AnuncioInvalidoException() {
        super("Anuncio Invalido");
    }

    public AnuncioInvalidoException(String mensagem) {
        super(mensagem);
    }
}
