package br.edu.ufcg.computacao.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Usuario>> mostrarTodosUsuarios() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
