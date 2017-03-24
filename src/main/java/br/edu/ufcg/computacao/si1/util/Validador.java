package br.edu.ufcg.computacao.si1.util;

import java.util.Date;

import br.edu.ufcg.computacao.si1.excecoes.AnuncioInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.ObjetoInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.anuncio.CategoriaAnuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.TipoAnuncio;
import br.edu.ufcg.computacao.si1.model.dto.AnuncioCriacaoDto;
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
        if( isObjetoNulo(usuario) ||
        	!isStringValida(usuario.getNome()) ||
            !isEmailValido(usuario.getEmail()) ||
            !isStringValida(usuario.getSenha()) ||
            isObjetoNulo(usuario.getPermissao())){

            throw new UsuarioInvalidoException();
        }
    }
	
	public static void isAnuncioValido(AnuncioCriacaoDto anuncio) throws AnuncioInvalidoException {
		
		if( isObjetoNulo(anuncio) ||
			!isStringValida(anuncio.getTitulo()) ||
			isValorNegativo(anuncio.getValor()) ||
			isObjetoNulo(anuncio.getTipo()) ||
			!isStringValida(anuncio.getDescricao()) ||
			isObjetoNulo(anuncio.getCategoriaAnuncio())) {
			
			throw new AnuncioInvalidoException();
		}
		
		if(anuncio.getTipo().equals(TipoAnuncio.PRODUTO)) {
			if(anuncio.getCategoriaAnuncio().equals(CategoriaAnuncio.DEFAULT)) {
				throw new AnuncioInvalidoException();
			}
		}
	}
	
	public static void isAvaliacaoValida(Avaliacao avaliacao) throws ObjetoInvalidoException {
		if(isObjetoNulo(avaliacao) ||
		   isObjetoNulo(avaliacao.getNota()) ||	
		   !isStringValida(avaliacao.getComentarios())) {
			
			throw new ObjetoInvalidoException();
		}
	}
	
	public static void isDataValida(Date data) throws ObjetoInvalidoException {
		if(Validador.isObjetoNulo(data)) {
    		throw new ObjetoInvalidoException();
    	}
	}
}
