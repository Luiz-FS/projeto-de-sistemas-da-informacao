package br.edu.ufcg.computacao.si1.experts;

import java.util.Date;


/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class AnuncioExpert {


    public static boolean adiciona(String titulo, Date dataCriacao, double valor, String nota, String tipo, String idUsuario){
        return false;
    }

    public static boolean remove(Long idAnuncio){
        return false;
    }


    public static boolean editarTitulo(Long idAnuncio, String novoTitulo){
        //TODO Fazer validacao da string do novo titulo
        return false;
    }

    public static boolean editarValor(Long idAnuncio, double novoValor){
        //TODO Fazer validacao do novo valor
        //TODO Criar a logica para alterar o valor do anuncio para o novo valor

        return false;
    }

    public static boolean contratar(Long idAnuncio, Long idUsuarioComprador){
        //TODO Verificar se o usuario comprador possui saldo suficiente
        //TODO Criar a logica para creditar o valor do anuncio no usuario dono do anuncio
        //TODO Criar a logica para debitar o valor do anuncio do usuario comprador
        //TODO Criar a logica para remover anuncio do banco

        return false;
    }




}
