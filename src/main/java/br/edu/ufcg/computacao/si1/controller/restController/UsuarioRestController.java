package br.edu.ufcg.computacao.si1.controller.restController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRestController {

    private final String ADICIONAR_USUARIO = "/cadastro";

    @Autowired
    private ControllerSistema controllerSistema;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obterTodosUsuarios() {

        List<UsuarioDto> usuarioDtos = controllerSistema.obterTodosUsuarios();

        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_USUARIO)
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
