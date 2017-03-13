package br.edu.ufcg.computacao.si1.util;


import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.*;

/**
 * Created by luiz on 09/03/17.
 */
public class TokenCodificadorDecodificador {

    private Set<Key> chavesDeAcessso;

    public TokenCodificadorDecodificador() {
        this.chavesDeAcessso = new HashSet<Key>();
    }

    public String criarToken(String idUsuario) {

        Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);
        this.chavesDeAcessso.add(key);

        String token = Jwts.builder().setId(idUsuario)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        return token;
    }

    public boolean tokenValido(String token) {

        try {

            Jwts.parser().setSigningKey("default").parseClaimsJws(token);

        } catch (SignatureException e) {
        } catch (MalformedJwtException e) {
            return false;
        }

        return true;
    }

    /**
     * Mudar Exceção para uma mais específica
     */
    public int decodificarToken(String token) throws Exception {

        if (! tokenValido(token)) {
            throw new Exception("Token inválido!");
        }

        Iterator<Key> chavesDeAcesso = this.chavesDeAcessso.iterator();
        Claims claims = null;

        while (chavesDeAcesso.hasNext()) {

            Key chave = chavesDeAcesso.next();

            try {
                claims = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
            } catch (SignatureException e) {
            }
        }

        if (claims != null) {
            int id = Integer.parseInt(claims.getId());
            return id;

        } else
            throw new Exception("Token inválido!");
    }
}
