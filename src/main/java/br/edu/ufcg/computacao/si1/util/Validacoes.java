package br.edu.ufcg.computacao.si1.util;

/**
 * Created by Antonio Pedro on 07/03/2017.
 */
public class Validacoes {


    public static boolean isStringNull(String string){

        if(string == null){
            return true;
        }
        return false;
    }

    public static boolean isStringVazia(String string){

        return string.isEmpty();

    }

    public static boolean isValorNegativo(double valor){

        if(valor < 0){
            return true;
        }

        return false;

    }

}
