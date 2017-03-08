package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luiz on 07/03/17.
 */

@RestController
public class AdExtremeController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping(value = "/teste")
    public ResponseEntity<List<Anuncio>> mostrarTodos() {

        List<Anuncio> anuncios = anuncioRepository.findAll();

        return new ResponseEntity<>(anuncios, HttpStatus.OK);
    }
}
