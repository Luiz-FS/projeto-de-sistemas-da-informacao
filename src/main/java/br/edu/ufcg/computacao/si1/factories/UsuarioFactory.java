package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.dto.UsuarioCriacaoDto;
import br.edu.ufcg.computacao.si1.model.dto.UsuarioDto;
import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.TiposPermissao;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

/**
 * Created by lucas on 08/03/17.
 *
 */

public class UsuarioFactory {

    public Usuario criaUsuario(String nome, String email, String senha, TiposPermissao tipoPermissao) {
    	Permissao permissao = criaPermissaoUsuario(tipoPermissao);
        
    	return new Usuario(nome, email, senha, permissao);
    }
    
    public Usuario criaUsuario(UsuarioCriacaoDto usuarioCriacao) {
    	
    	String nome = usuarioCriacao.getNome();
    	String email = usuarioCriacao.getEmail();
    	String senha = usuarioCriacao.getSenha();
    	TiposPermissao tipoPermissao = usuarioCriacao.getTiposPermissao();
    	
    	Permissao permissao = criaPermissaoUsuario(tipoPermissao);
        
    	return new Usuario(nome, email, senha, permissao);
    }

    public UsuarioDto criaUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario);
    }
    
    private Permissao criaPermissaoUsuario(TiposPermissao permissao) {
    	if(permissao.equals(TiposPermissao.PERMISSAO_PESSOA_FISICA)) {
    		return new PermissaoPessoaFisica();
    	} else {
    		return new PermissaoPessoaJuridica();
    	}
    }
}
