package br.edu.ufcg.computacao.si1.controller.controller;

import br.edu.ufcg.computacao.si1.excecoes.UsuarioInvalidoException;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.seguranca.Autenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by luiz on 13/03/17.
 */
@Controller
public class ControllerSistema {

    @Autowired
    private Autenticacao autenticacao;

    /**
     * Método que autentica o usuário caso suas credenciais esteja corretas.
     *
     * @param usuario Recebe o usuário que será comparado com um já existente no sistema
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
}
