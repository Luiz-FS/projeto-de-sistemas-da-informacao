package br.edu.ufcg.computacao.si1.seguranca;

import br.edu.ufcg.computacao.si1.excecoes.TokenInvalidoException;
import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by luiz on 15/03/17.
 */
@Component
public class Autenticacao {

    @Autowired
    private ServiceUsuario serviceUsuario;

    private TokenCodificadorDecodificador tokenCodificadorDecodificador;

    public Autenticacao() {
        this.tokenCodificadorDecodificador =  new TokenCodificadorDecodificador();
    }

    /**
     * Método que verifica e autentica os dados do usuário que está tentando logar no sistema.
     *
     * @return - Retora uma String representando o token de login do usuário caso os dados sejam válidos.
     * @throws UsuarioInvalidoException Gera uma exceção caso os dados do usuário recebidos sejam inválidos.
     */
    public String autenticarUsuario(UsuarioCriacaoDto usuario) throws UsuarioInvalidoException {

        Usuario usuarioBuscado = serviceUsuario.getUsuarioPorEmail(usuario.getEmail());

        String tokenDeLoginValido = "";

        if(usuarioBuscado != null && usuarioBuscado.isSenhaValida(usuario.getSenha())) {

            tokenDeLoginValido = tokenCodificadorDecodificador.criarToken(usuarioBuscado.getId());

        } else {
            throw new UsuarioInvalidoException("Dados do usuário inválidos!");
        }

        return tokenDeLoginValido;
    }

    /**
     * Método que verifica se um determinado token existe no sistema.
     *
     * @param token - Recebe o token a ser verificado.
     * @return - Retorna um boolean indicando se o token existe ou não.
     */
    public boolean isTokenValido(String token) {
        return tokenCodificadorDecodificador.isTokenValido(token);
    }

    /**
     * Método que descritografa o token retna o id do usuário logado.
     *
     * @param token - Recebe o token refente ao usuário que fez a requisição.
     * @return - Retorna um Long que representa o id do usuário que fez a requisição.
     * @throws TokenInvalidoException - Gera uma exceção caso o token sejá inválido.
     */
    public long decodificarToken(String token) throws TokenInvalidoException {

        long idUsuario = tokenCodificadorDecodificador.decodificarToken(token);

        return idUsuario;
    }

    /**
     * Método que desautentica o usuário do sistema caso o token recebido seja válido.
     *
     * @param token - Recebe o token do usuário que está logado.
     * @return - Retorna um boolean indicando se o usuário foi desautenticado com sucesso ou não.
     */
    public boolean fazerLogout(String token) {
        return tokenCodificadorDecodificador.removerToken(token);
    }
}
