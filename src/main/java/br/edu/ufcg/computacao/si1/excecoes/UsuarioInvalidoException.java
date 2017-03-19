package br.edu.ufcg.computacao.si1.excecoes;

/**
 * Created by luiz on 15/03/17.
 */
public class UsuarioInvalidoException extends adExtremeException {

    public UsuarioInvalidoException() {
        super("Usuário não existe");
    }

    public UsuarioInvalidoException(String mensagem) {
        super(mensagem);
    }
}
