package br.edu.ufcg.computacao.si1.util;

public class Validador {

    private static final String REGEX_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String REGEX_PALAVRAS = "[a-zA-Z\\s,]+";

    public static boolean isStringNull(String string){
        return (string == null);
    }

    public static boolean isStringVazia(String string){
        return string.isEmpty();
    }

    public static boolean isValorNegativo(double valor){
        return (valor < 0);
    }

    public static boolean isPalavrasInvalidas(String string) {
        return string.matches(REGEX_PALAVRAS);
    }

    public static boolean isEmailInvalido(String email) {
        return email.matches(REGEX_EMAIL);
    }
}
