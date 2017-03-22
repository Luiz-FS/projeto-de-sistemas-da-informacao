package br.edu.ufcg.computacao.si1.controller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ufcg.computacao.si1.excecoes.AcessoNaoPermitidoException;
import br.edu.ufcg.computacao.si1.excecoes.AdExtremeException;
import br.edu.ufcg.computacao.si1.excecoes.ObjetoInexistenteException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInexistenteException;
import br.edu.ufcg.computacao.si1.factories.AnuncioFactory;
import br.edu.ufcg.computacao.si1.factories.UsuarioFactory;
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
     * @param email Recebe o email do usuário que será comparado com um já existente no sistema
     *                Para verificar se as credenciais estão corretas.
     * @param senha  Recebe a senha do usuário que será comparado com uma já existente no sistema
     *                Para verificar se as credenciais estão corretas.
     * @return - Retorna uma String que representa o token do usuário, caso as credenciais
     * estejam corretas.
     * @throws UsuarioInvalidoException - Gera uma exceção caso as cedenciais do usuário recebido
     * sejam inválidas.
     */
    public String login(String email, String senha) throws UsuarioInvalidoException {
        return autenticacao.autenticarUsuario(email, senha);
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

    public void contratarAnuncio(Long idComprador, Long idAnuncio) throws ObjetoInexistenteException {
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
    
    private void checaPermissaoDeCriacaoAnuncio(Long idUsuario, TipoAnuncio tipoAnuncio) throws AcessoNaoPermitidoException {
    	if(tipoAnuncio.equals(TipoAnuncio.EMPREGO)) {
    		this.sistemaService.usuarioTemPermissao(idUsuario, PermissoesUsuario.CRIAR_ANUNCIO_EMPREGO);
    	} else if(tipoAnuncio.equals(TipoAnuncio.SERVICO)) {
    		this.sistemaService.usuarioTemPermissao(idUsuario, PermissoesUsuario.CRIAR_ANUNCIO_SERVICO);
    	} else if(tipoAnuncio.equals(TipoAnuncio.PRODUTO)) {
    		this.sistemaService.usuarioTemPermissao(idUsuario, PermissoesUsuario.CRIAR_ANUNCIO_PRODUTO);
    	}
    }
}
