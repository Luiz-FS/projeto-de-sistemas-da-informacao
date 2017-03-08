package br.edu.ufcg.computacao.si1.experts;

import br.edu.ufcg.computacao.si1.util.Validacoes;

import java.util.Date;


/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class AnuncioExpert {


    public static boolean adiciona(String titulo, Date dataCriacao, double valor, String nota, String tipo, String idUsuario){

        if(Validacoes.isStringNull(titulo) || Validacoes.isStringNull(nota) || Validacoes.isStringNull(tipo) || Validacoes.isStringNull(idUsuario)
                || Validacoes.isStringVazia(titulo) || Validacoes.isStringVazia(nota) || Validacoes.isStringVazia(tipo) || Validacoes.isStringVazia(idUsuario)){
            return false;
        }

        if(Validacoes.isValorNegativo(valor)){
            return false;
        }

        return false;
    }

    public static boolean remove(Long idAnuncio){

        if(Validacoes.isValorNegativo(idAnuncio)){
            return false;
        }

        return false;
    }


    public static boolean editarTitulo(Long idAnuncio, String novoTitulo){

        if(Validacoes.isValorNegativo(idAnuncio) || Validacoes.isStringNull(novoTitulo) || Validacoes.isStringVazia(novoTitulo)){
            return false;
        }

        //TODO Fazer validacao da string do novo titulo
        return false;
    }

    public static boolean editarValor(Long idAnuncio, double novoValor){
        //TODO Fazer validacao do novo valor
        //TODO Criar a logica para alterar o valor do anuncio para o novo valor

        if(Validacoes.isValorNegativo(idAnuncio) || Validacoes.isValorNegativo(novoValor)){
            return false;
        }

        return false;
    }

    public static boolean contratar(Long idAnuncio, Long idUsuarioComprador){

        if(Validacoes.isValorNegativo(idAnuncio) || Validacoes.isValorNegativo(idUsuarioComprador)){
            return false;
        }

        //TODO Verificar se o usuario comprador possui saldo suficiente
        //TODO Criar a logica para creditar o valor do anuncio no usuario dono do anuncio
        //TODO Criar a logica para debitar o valor do anuncio do usuario comprador
        //TODO Criar a logica para remover anuncio do banco

        return false;
    }




}
