package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

/**
 * Created by lucas on 08/03/17.
 *
 */

public class UsuarioFactory {

    public static Usuario criaUsuario(String nome, String email, String senha, Permissao permissao) {
        return new Usuario(nome, email, senha, permissao);
    }

    public static UsuarioDto criaUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario);
    }
}
