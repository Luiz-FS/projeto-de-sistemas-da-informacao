package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.Notas;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 12/03/17.
 */
@RestController
public class AnuncioController {

    private final String OBTER_TODOS_ANUNCIOS = "/anuncios";
    private final String OBTER_ANUNCIO_POR_ID = "/anuncios/{id}";
    private final String OBTER_ANUNCIO_POR_USUARIO = "/usuarios/anuncios/{id}";
    private final String OBTER_ANUNCIO_POR_TITULO = "/anuncios/{titulo}";
    private final String ATUALIZAR_ANUNCIO = "/anuncios/atualizarAnuncio";
    private final String ADICIONAR_ANUNCIO = "/anuncios/adicionar";
    private final String REMOVER_ANUNCIO = "/anuncios/remover";
    private final String REMOVER_TODOS_ANUNCIOS_USUARIO = "/anuncios/remover";


    @GetMapping(value = OBTER_TODOS_ANUNCIOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Anuncio>> obterTodosAnuncios(){

        return new ResponseEntity<List<Anuncio>>(HttpStatus.OK);
    }

    @GetMapping(value = OBTER_ANUNCIO_POR_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> obterAnuncio(@PathVariable("id") Long id){
        Anuncio anuncios = null;

        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }


    @GetMapping(value = OBTER_ANUNCIO_POR_USUARIO , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> obterAnuncioPorUsuario(@PathVariable("id") Long id){


        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }

    @GetMapping(value = OBTER_ANUNCIO_POR_TITULO , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Anuncio>> obterAnuncioPorTitulo(@PathVariable("titulo") String titulo){


        return new ResponseEntity<List<Anuncio>>(HttpStatus.OK);
    }


    @PostMapping(value = ATUALIZAR_ANUNCIO , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> atualizarAnuncio(@RequestBody Anuncio anuncio){


        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_ANUNCIO , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> adicionarAnuncio(@RequestBody Anuncio anuncio){


        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }

    @PostMapping(value = REMOVER_ANUNCIO , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> removerAnuncio(@RequestBody Anuncio anuncio){
        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }









}
