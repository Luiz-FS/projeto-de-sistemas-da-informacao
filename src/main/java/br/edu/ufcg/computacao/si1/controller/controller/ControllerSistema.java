package br.edu.ufcg.computacao.si1.controller.controller;

import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.seguranca.Autenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by luiz on 13/03/17.
 */
@Controller
public class ControllerSistema {

    @Autowired
    private Autenticacao autenticacao;

    public ControllerSistema() {
        this.autenticacao = new Autenticacao();
    }

    public String login(Usuario usuario) throws UsuarioInvalidoException {
        return autenticacao.autenticarUsuario(usuario);
    }

    public boolean logout(String token) {
        return autenticacao.fazerLogout(token);
    }
}
