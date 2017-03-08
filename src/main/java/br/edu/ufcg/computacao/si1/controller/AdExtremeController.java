package br.edu.ufcg.computacao.si1.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;

/**
 * Created by luiz on 07/03/17.
 */

@RestController
public class AdExtremeController {

    @Autowired
    private AnuncioRepository anuncioRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/anuncios")
    public ResponseEntity<List<Anuncio>> mostrarTodosAnuncios() {

        List<Anuncio> anuncios = anuncioRepository.findAll();

        return new ResponseEntity<>(anuncios, HttpStatus.OK);
    }



    @GetMapping(value = "/usuarios")
    public ResponseEntity<List<UsuarioDto>> mostrarTodosUsuarios() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioDto> usuarioDtos = new ArrayList<>();

        for(Usuario usuario : usuarios){
            usuarioDtos.add( new UsuarioDto(usuario));
        }

        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }
}
