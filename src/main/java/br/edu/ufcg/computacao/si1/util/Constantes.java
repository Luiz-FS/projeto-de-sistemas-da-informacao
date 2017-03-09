package br.edu.ufcg.computacao.si1.util;

import br.edu.ufcg.computacao.si1.model.usuario.TiposPermissao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by antonioabreu on 09/03/17.
 */
public class Constantes {

    public static final String USUARIO_DEFAULT = "default";



    public static final  DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");



    public static final TiposPermissao PERMISSAO_PESSOA_FISICA = TiposPermissao.PERMISSAO_PESSOA_FISICA;
    public static final TiposPermissao PERMISSAO_JURIDICA = TiposPermissao.PERMISSAO_JURIDICA;




}
