package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 11/03/17.
 *
 */
@RestController
public class UsuarioController {

    private final String OBTER_TODOS_USUARIOS = "/usuarios";
    private final String OBTER_USUARIO = "/usuarios/{id}";
    private final String ADICIONAR_USUARIO = "/adicionarUsuario";
    private final String ATUALIZAR_USUARIO = "/atualizarUsuario";
    private final String DELETAR_TODOS_USUARIOS = "/deletarUsuarios";
    private final String DELETAR_USUARIO = "/deletarUsuario";

    @GetMapping(value = OBTER_TODOS_USUARIOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDto>> obterTodosUsuarios() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();

        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @GetMapping(value = OBTER_USUARIO, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> obterUsuario(@PathVariable("id") String id) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_USUARIO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> adicionarUsuario(@RequestBody Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto(usuario);

        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }

    @PutMapping(value = ATUALIZAR_USUARIO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> atualizarUsuario(@RequestBody Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto(usuario);

        return new ResponseEntity<>(usuarioDto, HttpStatus.GONE);
    }

    @DeleteMapping(value = DELETAR_TODOS_USUARIOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletarTodosUsuarios() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = DELETAR_USUARIO, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletarUsuario() {

        return new ResponseEntity<>(HttpStatus.OK);
    }


}

