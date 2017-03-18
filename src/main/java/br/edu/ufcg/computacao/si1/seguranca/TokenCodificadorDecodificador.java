package br.edu.ufcg.computacao.si1.seguranca;


import br.edu.ufcg.computacao.si1.excecoes.TokenInvalidoException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.*;

/**
 * Created by luiz on 09/03/17.
 */
public class TokenCodificadorDecodificador {

    private Map<String, Key> chavesDeAcessso;

    public TokenCodificadorDecodificador() {
        this.chavesDeAcessso = new HashMap<>();
    }

    /**
     * Método que cria o token do usuário para que ele possa acessar as funções do sistema.
     *
     * @param idUsuario - Recebe o id do usuário para fazer a criação do token.
     * @return - Retorna a String representando o token criado para o usuário.
     */
    public String criarToken(long idUsuario) {

        String idUsr = String.valueOf(idUsuario);
        Key chave = MacProvider.generateKey(SignatureAlgorithm.HS512);

        String token = Jwts.builder().setId(idUsr)
                .signWith(SignatureAlgorithm.HS512, chave)
                .compact();

        this.chavesDeAcessso.put(token, chave);

        return token;
    }

    /**
     * Método que verifica se um determinado token existe no sistema.
     *
     * @param token - Recebe o token a ser verificado.
     * @return - Retorna um boolean indicando se o token existe ou não.
     */
    public boolean isTokenValido(String token) {
        return this.chavesDeAcessso.containsKey(token);
    }

    /**
     * Método que descriptografa o token e resgata as informações contidas no mesmo.
     *
     * @param token - Recebe o token a ser decodificado.
     * @return - Retorna um valor long representando o id do usuário que estava contido no token.
     * @throws TokenInvalidoException - Gera uma exceção caso o token seja inválido.
     */
    public long decodificarToken(String token) throws TokenInvalidoException {

        Claims claims = null;

        if (isTokenValido(token)) {
            Key chave = this.chavesDeAcessso.get(token);
            claims = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
        }

        if (claims != null) {
            long id = Long.parseLong(claims.getId());
            return id;

        } else
            throw new TokenInvalidoException();
    }

    /**
     * Método que remove um token do sistema de modo a torná-lo inválido em novas requisições.
     *
     * @param token - Recebe o token a ser removido.
     * @return - Retorna um boolean indicando se o token foi removido com sucesso ou não.
     */
    public boolean removerToken(String token) {

        if (isTokenValido(token)) {
            this.chavesDeAcessso.remove(token);
            return true;
        } else {
            return false;
        }

    }
}
