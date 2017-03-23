package br.edu.ufcg.computacao.si1.seguranca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	    		String header = httpRequest.getHeader("Autorizacao");

	    		if (header == null || !header.startsWith("Bearer ")) {
	    			throw new ServletException("Token inválido!");
				}

				String token = header.substring(7);

	    		long idRequisicao = pegarIdRequisicao(httpRequest.getServletPath());
				long idToken = autenticador.decodificarToken(token);
								
				if (idRequisicao == idToken)
					chain.doFilter(request, response);
				else
					unauthorized(httpResponse);

	    	} catch (Exception e) {
	    		unauthorized(httpResponse);
			}
	    } else {
	    	chain.doFilter(request, response);
	    }
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

	private long pegarIdRequisicao(String requisicao) {

		long id;

		String[] teste = requisicao.split("/");

		id = Long.parseLong(teste[teste.length - 1]);

		return id;
	}
	
	private void addRequisicoesNaoLiberadas() {
		this.requisicoesNaoLiberadas.add("/anuncios/");
	}
	
	private void unauthorized(HttpServletResponse response) throws IOException {
		response.sendError(401);
	}
	
}
