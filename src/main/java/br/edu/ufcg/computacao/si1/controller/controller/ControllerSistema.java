package br.edu.ufcg.computacao.si1.controller.controller;

import br.edu.ufcg.computacao.si1.excecoes.*;
import br.edu.ufcg.computacao.si1.factories.AnuncioFactory;
import br.edu.ufcg.computacao.si1.factories.UsuarioFactory;
import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.TipoAnuncio;
import br.edu.ufcg.computacao.si1.model.dto.AnuncioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import br.edu.ufcg.computacao.si1.model.usuario.PermissoesUsuario;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.seguranca.Autenticacao;
import br.edu.ufcg.computacao.si1.service.ServiceSistema;
import br.edu.ufcg.computacao.si1.util.Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerSistema {

    @Autowired
    private Autenticacao autenticacao;

    @Autowired
    private ServiceSistema sistemaService;

    private UsuarioFactory fabricaUsuario;
    
    private AnuncioFactory facricaAnuncio;

    public ControllerSistema() {
        this.fabricaUsuario = new UsuarioFactory();
        this.facricaAnuncio = new AnuncioFactory();
    }
    
    /**
     * Método que autentica o usuário caso suas credenciais esteja corretas.
     *
     * @return - Retorna uma String que representa o token do usuário, caso as credenciais
     * estejam corretas.
     * @throws UsuarioInvalidoException - Gera uma exceção caso as cedenciais do usuário recebido
     * sejam inválidas.
     */
    public String login(UsuarioCriacaoDto usuario) throws UsuarioInvalidoException {
        return autenticacao.autenticarUsuario(usuario);
    }

    /**
     * Método que realiza a desautenticação do usuário no sistema, se o mesmo estiver autenticado.
     *
     * @param token - Recebe o token do usuário logado no sistema.
     * @return - Retorna um boolean indicando se a desautenticação foi feita com sucesso ou não.
     */
    public boolean logout(String token) {
        return autenticacao.fazerLogout(token);
    }

    public List<UsuarioDto> obterTodosUsuarios() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();

        List<Usuario> usuarios = this.sistemaService.getUsuarios();

        for (Usuario usuario : usuarios) {
            usuarioDtos.add(this.fabricaUsuario.criaUsuarioDto(usuario));
        }

        return usuarioDtos;
    }

    public UsuarioDto adicionarUsuario(UsuarioCriacaoDto usuarioCriacaoDto) throws UsuarioInvalidoException {
    	Validador.isUsuarioValido(usuarioCriacaoDto);
    	
        Usuario usuario = this.fabricaUsuario.criaUsuario(usuarioCriacaoDto);

        UsuarioDto usuarioDto = this.fabricaUsuario.criaUsuarioDto(this.sistemaService.salvarUsuario(usuario));

        return usuarioDto;
    }
    
    public Anuncio adicionarAnuncio(AnuncioCriacaoDto anuncioCriacao, Long idUsuario) throws AdExtremeException {
    	Validador.isAnuncioValido(anuncioCriacao);
    	this.sistemaService.idUsuarioExiste(idUsuario);
    	checaPermissaoDeCriacaoAnuncio(idUsuario, anuncioCriacao.getTipo());
    	
    	Anuncio anuncio = this.facricaAnuncio.criaAnuncio(anuncioCriacao, idUsuario);
    	
    	return this.sistemaService.salvarAnuncio(anuncio);
    }

    public void contratarAnuncio(Long idComprador, Long idAnuncio) throws AdExtremeException {
    	this.sistemaService.idUsuarioExiste(idComprador);
    	this.sistemaService.idAnuncioExiste(idAnuncio);
    	
    	this.sistemaService.contratarAnuncio(idComprador, idAnuncio);
    }
    
    public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) throws UsuarioInexistenteException {
    	this.sistemaService.idUsuarioExiste(idUsuario);
    	
      	return this.sistemaService.getAnunciosPorUsuario(idUsuario);
    }
    
    public List<Anuncio> getAnuncios() {
    	return this.sistemaService.getAnuncios();
    }
    
    public Avaliacao addAvaliacaoAnuncio(Long idAnuncio, Long idUsuario, Avaliacao avaliacao) throws AdExtremeException {
    	Validador.isAvaliacaoValida(avaliacao);
    	this.sistemaService.idAnuncioExiste(idAnuncio);
    	this.sistemaService.idUsuarioExiste(idUsuario);
    	
    	return this.sistemaService.addAvaliacaAnuncio(idAnuncio, idUsuario, avaliacao);
    }
    
    public List<Avaliacao> getAvaliacoesAnuncio(Long idAnuncio) throws AnuncioInexistenteException {
    	this.sistemaService.idAnuncioExiste(idAnuncio);
    	
    	return this.sistemaService.getAvaliacoesAnuncio(idAnuncio);
    }
    
    public void addAvaliacaoUsuario(Long idUsuario, Long idNotificacao, Avaliacao avaliacao) throws AdExtremeException {
    	Validador.isAvaliacaoValida(avaliacao);
    	this.sistemaService.idUsuarioExiste(idUsuario);
    	
    	this.sistemaService.addAvaliacaoUsuario(idUsuario, idNotificacao, avaliacao);
    }
    
    public List<Notificacao> getNotificacoesUsuario(Long idUsuario) throws UsuarioInexistenteException {
    	this.sistemaService.idUsuarioExiste(idUsuario);
    	
    	return this.sistemaService.getNotificacoesUsuario(idUsuario);
    }
    
    public List<Avaliacao> getAvaliacoesUsuario(Long idUsuario) throws UsuarioInexistenteException {
    	this.sistemaService.idUsuarioExiste(idUsuario);
    	
    	return this.sistemaService.getAvaliacoesUsuario(idUsuario);
    }
    
    public void addDataDeAgendamento(Long idAnuncio, Date dataDeAgendamento) throws AdExtremeException {
    	Validador.isDataValida(dataDeAgendamento);
       	this.sistemaService.idAnuncioExiste(idAnuncio);
    	
    	this.sistemaService.addDataDeAgendamento(idAnuncio, dataDeAgendamento);
    }
    
    private void checaPermissaoDeCriacaoAnuncio(Long idUsuario, TipoAnuncio tipoAnuncio) throws AcaoNaoPermitidaException {
    	if(tipoAnuncio.equals(TipoAnuncio.EMPREGO)) {
    		this.sistemaService.usuarioTemPermissao(idUsuario, PermissoesUsuario.CRIAR_ANUNCIO_EMPREGO);
    	} else if(tipoAnuncio.equals(TipoAnuncio.SERVICO)) {
    		this.sistemaService.usuarioTemPermissao(idUsuario, PermissoesUsuario.CRIAR_ANUNCIO_SERVICO);
    	} else if(tipoAnuncio.equals(TipoAnuncio.PRODUTO)) {
    		this.sistemaService.usuarioTemPermissao(idUsuario, PermissoesUsuario.CRIAR_ANUNCIO_PRODUTO);
    	}
    }
}
