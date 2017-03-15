package br.edu.ufcg.computacao.si1.controller.restController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luiz on 15/03/17.
 */

@RestController
public class AutenticacaoRestController {

    @Autowired
    private ControllerSistema controllerSistema;

    @PatchMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {

        try {

            String token = controllerSistema.login(usuario);
            return new ResponseEntity<String>(token, HttpStatus.OK);

        } catch (UsuarioInvalidoException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
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
}
