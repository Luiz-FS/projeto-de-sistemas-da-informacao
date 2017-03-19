package br.edu.ufcg.computacao.si1.controller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.factories.UsuarioFactory;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.seguranca.Autenticacao;
import br.edu.ufcg.computacao.si1.service.ServiceSistema;

/**
 * Created by luiz on 13/03/17.
 */
@Controller
public class ControllerSistema {

    @Autowired
    private Autenticacao autenticacao;

    @Autowired
    private ServiceSistema sistemaService;

    private UsuarioFactory fabricaUsuario;

    public ControllerSistema() {
        this.fabricaUsuario = new UsuarioFactory();
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

    public UsuarioDto adicionarUsuario(UsuarioCriacaoDto usuarioCriacaoDto) {

        Usuario usuario = this.fabricaUsuario.criaUsuario(usuarioCriacaoDto);

        UsuarioDto usuarioDto = this.fabricaUsuario.criaUsuarioDto(this.sistemaService.salvarUsuario(usuario));

        return usuarioDto;
    }

    public void contratarAnuncio(Long idComprador, Long idAnuncio) {
    	this.sistemaService.contratarAnuncio(idComprador, idAnuncio);
    }
}
