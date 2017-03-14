package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findOne(id);
    }

    @Override
    public Usuario getByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean update(Usuario usuario) {
        if (usuarioRepository.exists(usuario.getId())) {
            usuarioRepository.save(usuario);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (usuarioRepository.exists(id)) {
            usuarioRepository.delete(id);
            return true;
        }

        return false;
    }
}
