package br.edu.ufcg.computacao.si1.seguranca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufcg.computacao.si1.excecoes.TokenInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * Classe para filtrar as mensagens http do sistema,
 * filtra as request, em fase de implementacao.
 */
@Component
public class FiltroSistema implements Filter {
	
	@Autowired
	private Autenticacao autenticador;

	private List<String> requisicoesNaoLiberadas;

	public FiltroSistema() {
		this.requisicoesNaoLiberadas = new ArrayList<>();
		
		addRequisicoesNaoLiberadas();
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// sem implementacao por enquanto
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

		if(verificarRequisicao(httpRequest.getServletPath())) {

	    	try {

	    		String header = httpRequest.getHeader("Authorization");
				verificarHeaderAuthorization(header);

				String token = header.substring(7);

	    		request = adicionarIdNoHeader(httpRequest, token);

				chain.doFilter(request, response);

	    	} catch (Exception e) {
	    		unauthorized(httpResponse);
			}
	    } else {
	    	chain.doFilter(request, response);
	    }
	}

	private void verificarHeaderAuthorization(String header) throws ServletException {
		if (header == null || !header.startsWith("Bearer ")) {
            throw new ServletException("Token inválido!");
        }
	}

	private HeaderMapRequest adicionarIdNoHeader(HttpServletRequest httpRequest, String token) throws TokenInvalidoException {
		Long idToken = autenticador.decodificarToken(token);

		HeaderMapRequest headerMapRequest = new HeaderMapRequest(httpRequest);
		headerMapRequest.addHeader("IdUsuario", idToken.toString());
		return headerMapRequest;
	}

	@Override
	public void destroy() {
		// sem implementacao por enquanto
	}

	private boolean verificarRequisicao(String requisicao) {
		for (String requisicaoNaoLiberada : this.requisicoesNaoLiberadas) {

			if(requisicao.contains(requisicaoNaoLiberada)) {
				return true;
			}

		}
		return false;
	}
	
	private void addRequisicoesNaoLiberadas() {
		this.requisicoesNaoLiberadas.add("/anuncios");
		this.requisicoesNaoLiberadas.add("/usuarios/perfil");
		this.requisicoesNaoLiberadas.add("/usuarios/notificacoes");
		this.requisicoesNaoLiberadas.add("/usuarios/avaliacao");
	}
	
	private void unauthorized(HttpServletResponse response) throws IOException {
		response.sendError(401);
	}
	
}
