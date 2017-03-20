package br.edu.ufcg.computacao.si1.controller.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.AcessoNaoPermitidoException;
import br.edu.ufcg.computacao.si1.excecoes.AdExtremeException;
import br.edu.ufcg.computacao.si1.excecoes.AnuncioInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioNaoExisteException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.dto.AnuncioCriacaoDto;

/**
 * Created by pedro on 12/03/17.
 */
@RestController
@RequestMapping(value="/anuncios")
public class AnuncioRestController {

	private final String ADICIONAR_ANUNCIO = "/cadastro/{idUsuario}";
	private final String ANUNCIO_POR_USUARIO = "/usuario/{idUsuario}";
	
    @Autowired
    private ControllerSistema controllerSistema;

    @GetMapping
    public ResponseEntity<List<Anuncio>> getTodosAnuncios(){
    	
    	List<Anuncio> anuncios = this.controllerSistema.getAnuncios();
    	
        return new ResponseEntity<List<Anuncio>>(anuncios ,HttpStatus.OK);
    }
    
    @GetMapping(value = ANUNCIO_POR_USUARIO)
    public ResponseEntity<List<Anuncio>> getAnunciosPorUsuario(@PathVariable("idUsuario")Long idUsuario) {
    	
    	List<Anuncio> anuncios;
		
    	try {
			anuncios = this.controllerSistema.getAnunciosPorUsuario(idUsuario);
		} catch (UsuarioNaoExisteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
    	return new ResponseEntity<List<Anuncio>>(anuncios, HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_ANUNCIO)
    public ResponseEntity<Anuncio> adicionarAnuncio(@RequestBody AnuncioCriacaoDto anuncioCriacao, @PathVariable("idUsuario")Long idUsuario) {
    	
    	Anuncio anuncio;
    	
    	try {
    		anuncio = this.controllerSistema.adicionarAnuncio(anuncioCriacao, idUsuario);
    	    		
    	} catch (AnuncioInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (UsuarioNaoExisteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcessoNaoPermitidoException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}

        return new ResponseEntity<Anuncio>(anuncio, HttpStatus.OK);
    }
}
