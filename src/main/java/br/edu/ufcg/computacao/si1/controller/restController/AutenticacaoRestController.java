package br.edu.ufcg.computacao.si1.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;

import javax.servlet.ServletException;

/**
 * Created by luiz on 15/03/17.
 */

@RestController
public class AutenticacaoRestController {

    @Autowired
    private ControllerSistema controllerSistema;

    @PatchMapping(value = "/login/{usrEmail}/{usrPassword}")
    public ResponseToken login(@PathVariable("usrEmail") String email, @PathVariable("usrPassword") String senha)
            throws ServletException {

        try {

            String token = controllerSistema.login(email, senha);
            return new ResponseToken(token);

        } catch (UsuarioInvalidoException e) {
            throw new ServletException(e.getMessage());
        }
    }

    @PatchMapping(value = "/logout")
    public ResponseEntity logout(@RequestBody String token) {

        if (controllerSistema.logout(token)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    private class ResponseToken {

        public String token;

        public ResponseToken(String token) {
            this.token = token;
        }
    }
}
