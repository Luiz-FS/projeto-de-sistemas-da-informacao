package br.edu.ufcg.computacao.si1.util;

import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;

public class Validador {

    private static final String REGEX_EMAIL = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String REGEX_PALAVRAS = "[a-zA-Z\\u00C0-\\u00FF ]+";

    public static boolean isStringNull(String string){
        return (string == null);
    }

    public static boolean isStringVazia(String string){
        return string.isEmpty();
    }
    
    public static boolean isStringValida(String string) {
    	return !isStringNull(string) && !isStringVazia(string);
    }

    public static boolean isValorNegativo(double valor){
        return (valor < 0);
    }
    
    public static boolean isObjetoNulo(Object objeto) {
    	return (objeto == null);
    }

    public static boolean isPalavrasInvalidas(String string) {
        return string.matches(REGEX_PALAVRAS);
    }

    public static boolean isEmailValido(String email) {
        return isStringValida(email) && email.matches(REGEX_EMAIL);
    }
    
	public static void isUsuarioValido(UsuarioCriacaoDto usuario) throws UsuarioInvalidoException {
        if(!isStringValida(usuario.getNome()) ||
            isEmailValido(usuario.getEmail()) ||
            !isStringValida(usuario.getSenha()) ||
            isObjetoNulo(usuario.getTiposPermissao())){

            throw new UsuarioInvalidoException();
        }
    }
}
