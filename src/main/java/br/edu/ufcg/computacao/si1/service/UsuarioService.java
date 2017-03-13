package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario create(Usuario usuario);

    Usuario getById(Long id);

    Usuario getByEmail(String email);

    List<Usuario> getAll();

    boolean update(Usuario usuario);

    boolean delete(Long id);
}
