package br.edu.ufcg.computacao.si1.controller.restController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
public class AutenticacaoRestController {

    @Autowired
    private ControllerSistema controllerSistema;

    @PostMapping(value = "/login")
    public ResponseToken login(@RequestBody UsuarioCriacaoDto usuario)
            throws ServletException {

        try {

            String token = controllerSistema.login(usuario);

            return new ResponseToken(token);

        } catch (UsuarioInvalidoException e) {
            throw new ServletException(e.getMessage());
        }
    }

    @PostMapping(value = "/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String token) {

        token = token.substring(7);

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
