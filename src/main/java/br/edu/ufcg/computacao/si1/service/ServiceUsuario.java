package br.edu.ufcg.computacao.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.computacao.si1.factories.NotificacaoFactory;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.TipoNotificacao;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;

@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    private NotificacaoFactory fabricaNotificacao;
    
    public ServiceUsuario() {
    	this.fabricaNotificacao = new NotificacaoFactory();
	}

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
    
    public void addNovaNotificao(Long idUsuario, Long idComprador, String mensagem, TipoNotificacao tipoNotificacao) {
    	Usuario usuario = this.getById(idUsuario);
    	
    	Notificacao notificacao = fabricaNotificacao.criarNotificacao(mensagem, idComprador, tipoNotificacao);
    	
    	usuario.getListaDeNotificacoes().add(notificacao);
       	
    	this.update(usuario);
    }    
}
