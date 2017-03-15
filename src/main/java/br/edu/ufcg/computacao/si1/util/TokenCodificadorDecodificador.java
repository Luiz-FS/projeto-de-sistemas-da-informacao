package br.edu.ufcg.computacao.si1.util;


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

    public String criarToken(long idUsuario) {

        String idUsr = String.valueOf(idUsuario);
        Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);

        String token = Jwts.builder().setId(idUsr)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        this.chavesDeAcessso.put(token, key);

        return token;
    }

    public boolean existeToken(String token) {
        return this.chavesDeAcessso.containsKey(token);
    }

    /**
     * Mudar Exceção para uma mais específica
     */
    public long decodificarToken(String token) throws Exception {

        Claims claims = null;

        if (existeToken(token)) {
            Key chave = this.chavesDeAcessso.get(token);
            claims = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
        }

        if (claims != null) {
            long id = Long.parseLong(claims.getId());
            return id;

        } else
            throw new Exception("Token inválido!");
    }

    public boolean removerToken(String token) {

        if (existeToken(token)) {
            this.chavesDeAcessso.remove(token);
            return true;
        } else {
            return false;
        }

    }
}
