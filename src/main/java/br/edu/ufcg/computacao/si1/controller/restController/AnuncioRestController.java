package br.edu.ufcg.computacao.si1.controller.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.*;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.AcaoNaoPermitidaException;
import br.edu.ufcg.computacao.si1.excecoes.AdExtremeException;
import br.edu.ufcg.computacao.si1.excecoes.AnuncioInexistenteException;
import br.edu.ufcg.computacao.si1.excecoes.AnuncioInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.ObjetoInexistenteException;
import br.edu.ufcg.computacao.si1.excecoes.ObjetoInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInexistenteException;
import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.dto.AnuncioCriacaoDto;


@RestController
@RequestMapping(value = "/anuncios")
public class AnuncioRestController {

	private final String ADICIONAR_ANUNCIO = "/cadastro";
	private final String ANUNCIO_POR_USUARIO = "/usuario/{idUsuario}";
	private final String CONTRATAR_ANUNCIO = "/contrato/{idAnuncio}";
	private final String ADICIONAR_AVALIACAO = "/avaliacao/{idAnuncio}";
	private final String OBTER_AVALIACOES_ANUNCIO = "/avaliacoes/{idAnuncio}";
	private final String MUDAR_DATA_AGEDAMENTO = "/data/{idAnuncio}";

	@Autowired
	private ControllerSistema controllerSistema;


	@GetMapping
	public ResponseEntity<List<Anuncio>> getTodosAnuncios() {

		//System.out.println("Aeeeeeeeeeeeeeee Deu Certooooooooooo!");
		//System.out.println(idUsuario);

		List<Anuncio> anuncios = this.controllerSistema.getAnuncios();

		return new ResponseEntity<List<Anuncio>>(anuncios, HttpStatus.OK);
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
	public ResponseEntity<Anuncio> adicionarAnuncio(@RequestBody AnuncioCriacaoDto anuncioCriacao,
													@RequestHeader(value = "IdUsuario") String idUsuario) {

		long idUsuarioLogado = Long.parseLong(idUsuario);

		Anuncio anuncio;

		try {
			anuncio = this.controllerSistema.adicionarAnuncio(anuncioCriacao, idUsuarioLogado);

		} catch (AnuncioInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}

		return new ResponseEntity<Anuncio>(anuncio, HttpStatus.CREATED);
	}

	@DeleteMapping(value = CONTRATAR_ANUNCIO)
	public ResponseEntity<?> contratarAnuncio(@RequestHeader(value = "IdUsuario") String idUsuario,
			@PathVariable("idAnuncio") Long idAnuncio) {
		
		long idComprador = Long.parseLong(idUsuario);
		
		try {
			this.controllerSistema.contratarAnuncio(idComprador, idAnuncio);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = ADICIONAR_AVALIACAO)
	public ResponseEntity<Avaliacao> addAvaliacaoAnuncio(@PathVariable("idAnuncio") Long idAnuncio,
			@RequestHeader(value = "IdUsuario") String idUsuarioLogado, @RequestBody Avaliacao avaliacao) {
		
		long idUsuario = Long.parseLong(idUsuarioLogado);
		
		Avaliacao avaliacaoSalva;

		try {
			avaliacaoSalva = this.controllerSistema.addAvaliacaoAnuncio(idAnuncio, idUsuario, avaliacao);

		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}

		return new ResponseEntity<Avaliacao>(avaliacaoSalva, HttpStatus.CREATED);
	}
	
	@GetMapping(value=OBTER_AVALIACOES_ANUNCIO)
	public ResponseEntity<List<Avaliacao>> getAvaliacoesAnuncio(@PathVariable("idAnuncio")Long idAnuncio) {
		List<Avaliacao> avaliacoes;
		
		try {
			avaliacoes = this.controllerSistema.getAvaliacoesAnuncio(idAnuncio);
		} catch (AnuncioInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<List<Avaliacao>>(avaliacoes, HttpStatus.OK);
	}
	
	// falta testar ainda
	@PostMapping(value=MUDAR_DATA_AGEDAMENTO)
	public ResponseEntity<?> addDataDeAgendamento(@PathVariable("idAnuncio")Long idAnuncio, @RequestBody Date dataDeAgendamento) {
		
		try {
			this.controllerSistema.addDataDeAgendamento(idAnuncio, dataDeAgendamento);
	
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (AnuncioInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (AdExtremeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
	
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
