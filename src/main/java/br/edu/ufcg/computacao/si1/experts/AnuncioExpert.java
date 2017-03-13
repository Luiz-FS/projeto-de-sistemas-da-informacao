package br.edu.ufcg.computacao.si1.experts;

import br.edu.ufcg.computacao.si1.model.anuncio.AvaliacaoDeAnuncio;
import br.edu.ufcg.computacao.si1.util.Validador;

import java.util.Date;


/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class AnuncioExpert {


    public static boolean adiciona(String titulo, Date dataCriacao, double valor, AvaliacaoDeAnuncio nota, String tipo, String idUsuario){

        if(Validador.isStringNull(titulo) || Validador.isStringNull(tipo) || Validador.isStringNull(idUsuario)
                || Validador.isStringVazia(titulo) || Validador.isStringVazia(tipo) || Validador.isStringVazia(idUsuario)){
            return false;
        }

        if(Validador.isValorNegativo(valor)){
            return false;
        }

        return false;
    }

    public static boolean remove(Long idAnuncio){

        if(Validador.isValorNegativo(idAnuncio)){
            return false;
        }

        return false;
    }


    public static boolean editarTitulo(Long idAnuncio, String novoTitulo){

        if(Validador.isValorNegativo(idAnuncio) || Validador.isStringNull(novoTitulo) || Validador.isStringVazia(novoTitulo)){
            return false;
        }

        //TODO Fazer validacao da string do novo titulo
        return false;
    }

    public static boolean editarValor(Long idAnuncio, double novoValor){
        //TODO Fazer validacao do novo valor
        //TODO Criar a logica para alterar o valor do anuncio para o novo valor

        if(Validador.isValorNegativo(idAnuncio) || Validador.isValorNegativo(novoValor)){
            return false;
        }

        return false;
    }

    public static boolean contratar(Long idAnuncio, Long idUsuarioComprador){

        if(Validador.isValorNegativo(idAnuncio) || Validador.isValorNegativo(idUsuarioComprador)){
            return false;
        }

        //TODO Verificar se o usuario comprador possui saldo suficiente
        //TODO Criar a logica para creditar o valor do anuncio no usuario dono do anuncio
        //TODO Criar a logica para debitar o valor do anuncio do usuario comprador
        //TODO Criar a logica para remover anuncio do banco

        return false;
    }

    public static boolean darNota(Long idAnuncio, Long idUsuarioComprador, AvaliacaoDeAnuncio nota){
        if(Validador.isValorNegativo(idAnuncio) || Validador.isValorNegativo(idUsuarioComprador)){
            return false;
        }

        //TODO Criar a logica para dar uma nota ao anuncio


        return false;
    }



}
