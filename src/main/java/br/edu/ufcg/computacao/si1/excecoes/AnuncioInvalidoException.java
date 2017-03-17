package br.edu.ufcg.computacao.si1.excecoes;

/**
 * Created by pedro on 16/03/17.
 */
public class AnuncioInvalidoException extends Exception {

    public AnuncioInvalidoException() {

        super("Anuncio Invalido");

    }

    public AnuncioInvalidoException(String mensagem) {

        super(mensagem);

    }

    public void idUsuarioInvalidoException() throws Exception {

        throw new AnuncioInvalidoException("Atributo idUsuario invalido");

    }

    public void idUsuarioInvalidoException(String mensagem) throws Exception {

        throw new AnuncioInvalidoException(mensagem);

    }

    public void tituloInvalidoException() throws Exception {

        throw new AnuncioInvalidoException("Atributo titulo invalido");

    }

    public void tituloInvalidoException(String mensagem) throws Exception {

        throw new AnuncioInvalidoException(mensagem);

    }

    public void dataCriacaoInvalidoException() throws Exception {

        throw new AnuncioInvalidoException("Atributo dataDeCriacao invalido");

    }

    public void dataCriacaoInvalidoException(String mensagem) throws Exception {

        throw new AnuncioInvalidoException(mensagem);

    }


    public void valorInvalidoException() throws Exception {

        throw new AnuncioInvalidoException("Atributo valor invalido");

    }

    public void valorInvalidoException(String mensagem) throws Exception {

        throw new AnuncioInvalidoException(mensagem);

    }


    public void tipoInvalidoException() throws Exception {

        throw new AnuncioInvalidoException("Atributo tipo invalido");

    }

    public void tipoInvalidoException(String mensagem) throws Exception {

        throw new AnuncioInvalidoException(mensagem);

    }

    public void descricaoInvalidoException() throws Exception {

        throw new AnuncioInvalidoException("Atributo descricao invalido");

    }

    public void descricaoInvalidoException(String mensagem) throws Exception {

        throw new AnuncioInvalidoException(mensagem);

    }




}
