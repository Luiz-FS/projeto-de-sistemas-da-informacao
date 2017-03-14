package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getById(Long id) {
        return usuarioRepository.findOne(id);
    }

    public Usuario getByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(id);
    }

    public void debitarSaldoUsuario(Long idUsuario, double valor) {
        Usuario usuario = getById(idUsuario);

        usuario.getSaldoDeUsuario().debitar(valor);
        update(usuario);
    }

    public void creditarSaldoUsuario(Long idUsuario, double valor) {
        Usuario usuario = getById(idUsuario);

        usuario.getSaldoDeUsuario().creditar(valor);
        update(usuario);
    }
}
