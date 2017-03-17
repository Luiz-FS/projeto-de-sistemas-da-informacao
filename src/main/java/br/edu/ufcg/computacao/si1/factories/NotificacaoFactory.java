package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.TipoNotificacao;

public class NotificacaoFactory {
	
	public Notificacao criarNotificacao(String mensagem, Long idComprador, TipoNotificacao tipoNotificacao) {
		return new Notificacao(mensagem, idComprador, tipoNotificacao);
	}
	
}
