package br.edu.ufcg.computacao.si1.controller.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.computacao.si1.controller.controller.ControllerSistema;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInexistenteException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRestController {

    private final String ADICIONAR_USUARIO = "/cadastro";
    private final String PERFIL_USUARIO = "/perfil";
    private final String NOTIFICACOES_USUARIO = "/notificacoes";

    @Autowired
    private ControllerSistema controllerSistema;

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

    @GetMapping(value = PERFIL_USUARIO)
    public UsuarioDto obterPerfilUsuario(@RequestHeader("IdUsuario") String idUsuario) {

        long idUsuarioLogado = Long.parseLong(idUsuario);
        return controllerSistema.obterPerfilUsuario(idUsuarioLogado);
    }
    
    @GetMapping(value = NOTIFICACOES_USUARIO)
    public ResponseEntity<List<Notificacao>> getNotificacoes(@RequestHeader("IdUsuario") String idUsuario) {
        long idUsuarioLogado = Long.parseLong(idUsuario);
    	
        List<Notificacao> notificacoes;

        try {
			notificacoes = this.controllerSistema.getNotificacoesUsuario(idUsuarioLogado);
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
        return new ResponseEntity<>(notificacoes, HttpStatus.OK);
    }
}
