package br.edu.ufcg.computacao.si1.controller.restController;

import java.util.List;

import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;

/**
 * Created by lucas on 11/03/17.
 *
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRestController {

    private final String OBTER_TODOS_USUARIOS = "/usuarios";
    private final String ADICIONAR_USUARIO = "/cadastro";

    private final String ID = "id";

    @Autowired
    private ControllerSistema controllerSistema;

    @GetMapping(value = OBTER_TODOS_USUARIOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDto>> obterTodosUsuarios() {

        List<UsuarioDto> usuarioDtos = controllerSistema.obterTodosUsuarios();

        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_USUARIO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioCriacaoDto usuario) {
        UsuarioDto usuarioDto;
		
        try {
			usuarioDto = controllerSistema.adicionarUsuario(usuario);
		} catch (UsuarioInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }

}
