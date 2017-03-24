package br.edu.ufcg.computacao.si1.controller.restController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.*;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.dto.AnuncioCriacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pedro on 12/03/17.
 */
@RestController
@RequestMapping(value="/anuncios")
public class AnuncioRestController {

	private final String ADICIONAR_ANUNCIO = "/cadastro/{idUsuarioLogado}";
	private final String ANUNCIO_POR_USUARIO = "/usuario/{idUsuario}/{idUsuarioLogado}";
	private final String CONTRATAR_ANUNCIO = "/contrato/{idAnuncio}/{idComprador}";
	
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
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
    	return new ResponseEntity<List<Anuncio>>(anuncios, HttpStatus.OK);
    }

    @PostMapping(value = ADICIONAR_ANUNCIO)
    public ResponseEntity<Anuncio> adicionarAnuncio(@RequestBody AnuncioCriacaoDto anuncioCriacao, @PathVariable("idUsuarioLogado")Long idUsuario) {
    	
    	Anuncio anuncio;
    	
    	try {
    		anuncio = this.controllerSistema.adicionarAnuncio(anuncioCriacao, idUsuario);
    	    		
    	} catch (AnuncioInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}

        return new ResponseEntity<Anuncio>(anuncio, HttpStatus.OK);
    }
    
    @DeleteMapping(value=CONTRATAR_ANUNCIO)
    public ResponseEntity<?> contratarAnuncio(@PathVariable("idComprador")Long idComprador, @PathVariable("idAnuncio")Long idAnuncio) {
    	 
    	try {
			this.controllerSistema.contratarAnuncio(idComprador, idAnuncio);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}  catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
    	
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}
