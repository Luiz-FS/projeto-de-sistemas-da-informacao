package br.edu.ufcg.computacao.si1.controller.restController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lucas on 11/03/17.
 *
 */
@RestController
public class UsuarioRestController {

    private final String OBTER_TODOS_USUARIOS = "/usuarios";
    private final String ADICIONAR_USUARIO = "/adicionarUsuario";
    private final String ATUALIZAR_USUARIO = "/atualizarUsuario";
    private final String DELETAR_USUARIO = "/deletarUsuario/{id}";

    private final String ID = "id";

    @Autowired
    private ControllerSistema controllerSistema;

    @GetMapping(value = OBTER_TODOS_USUARIOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDto>> obterTodosUsuarios() {

        List<UsuarioDto> usuarioDtos = controllerSistema.obterTodosUsuarios();

        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_USUARIO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> adicionarUsuario(@RequestBody Usuario usuario) {
        UsuarioDto usuarioDto = controllerSistema.adicionarUsuario(usuario);

        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }

    @PutMapping(value = ATUALIZAR_USUARIO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> atualizarUsuario(@RequestBody Usuario usuario) {
        UsuarioDto usuarioDto = controllerSistema.atualizarUsuario(usuario);

        return new ResponseEntity<>(usuarioDto, HttpStatus.GONE);
    }

    @DeleteMapping(value = DELETAR_USUARIO, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletarUsuario(@PathVariable(ID) Long id) {
        controllerSistema.deletarUsuario(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
