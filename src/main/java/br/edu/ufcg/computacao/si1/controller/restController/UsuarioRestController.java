package br.edu.ufcg.computacao.si1.controller.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;

/**
 * Created by lucas on 11/03/17.
 *
 */
@RestController(value = "/usuario")
public class UsuarioRestController {

    private final String OBTER_TODOS_USUARIOS = "/usuarios";
    private final String ADICIONAR_USUARIO = "/cadastrarUsuario";

    private final String ID = "id";

    @Autowired
    private ControllerSistema controllerSistema;

    @GetMapping(value = OBTER_TODOS_USUARIOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDto>> obterTodosUsuarios() {

        List<UsuarioDto> usuarioDtos = controllerSistema.obterTodosUsuarios();

        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_USUARIO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto usuario) {
        UsuarioDto usuarioDto = controllerSistema.cadastrarUsuario(usuario);

        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }

}
