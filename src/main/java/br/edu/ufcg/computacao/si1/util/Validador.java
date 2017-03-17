package br.edu.ufcg.computacao.si1.util;

import br.edu.ufcg.computacao.si1.excecoes.AnuncioInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioServico;
import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

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

    public static boolean isValorNegativo(double valor){
        return (valor < 0);
    }

    public static boolean isPalavrasInvalidas(String string) {
        return string.matches(REGEX_PALAVRAS);
    }

    public static boolean isEmailInvalido(String email) {
        return email.matches(REGEX_EMAIL);
    }

    public static boolean isAutorizado(Usuario usuario, Permissao permissao) {
        return (usuario.getPermissao() == permissao);

    }

    public static boolean isAnuncioValido(Anuncio anuncio) throws AnuncioInvalidoException {

        if(isStringNull(anuncio.getTitulo()) ||
                isStringVazia(anuncio.getTitulo()) ||
                isStringNull(anuncio.getDataDeCriacao()) ||
                isStringVazia(anuncio.getDataDeCriacao())||
                isStringVazia(anuncio.getDescricao()) ||
                isStringNull(anuncio.getDescricao()) ||
                isValorNegativo(anuncio.getValor())){
            throw new AnuncioInvalidoException();
        }

        return true;

    }

    public static void isUsuarioValido(Usuario usuario) throws UsuarioInvalidoException {

        if(isStringVazia(usuario.getEmail()) ||
                isStringNull(usuario.getEmail()) ||
                isStringVazia(usuario.getNome()) ||
                isStringNull(usuario.getNome())){

            throw new UsuarioInvalidoException();

        }


    }

    public static void isAnuncioServicoValido(Anuncio anuncio) throws AnuncioInvalidoException {

        if(isAnuncioValido(anuncio) &&
                !(isStringVazia(((AnuncioServico)anuncio).getDataDeAgendamento())) ||
                isStringNull(((AnuncioServico)anuncio).getDataDeAgendamento())){


        }else {
            throw new AnuncioInvalidoException();
        }
    }


}
