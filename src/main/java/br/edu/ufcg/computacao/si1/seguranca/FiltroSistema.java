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
		this.requisicoesNaoLiberadas = new ArrayList(Arrays.asList("/anuncios/cadastro/",
				"/anuncios/usuario/"));
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

				long idRequisicao = pegarIdRequisicao(httpRequest.getServletPath());
				long idToken = autenticador.decodificarToken(httpRequest.getHeader("Authorization"));

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
		for (String requisicaoNaoLiberada : this. requisicoesNaoLiberadas) {

			if(requisicao.contains(requisicaoNaoLiberada)) {
				return true;
			}

		}
		return false;
	}

	private long pegarIdRequisicao(String requisicao) {

		long id;

		for (String requisicaoNaoLiberada : this. requisicoesNaoLiberadas) {

			if(requisicao.contains(requisicaoNaoLiberada)) {
				requisicao = requisicao.replace(requisicaoNaoLiberada, "");

				String idRequisicao = requisicao;

				id = Long.parseLong(idRequisicao);
				return id;
			}

		}

		return -1;

	}
	
	private List<String> toStringDoParaguai(Enumeration<String> enumeration) {
		List<String> lista = new ArrayList<>();
	
		while(enumeration.hasMoreElements()) {
			lista.add(enumeration.nextElement());
		}
		
		return lista;
	}
	
	private void unauthorized(HttpServletResponse response) throws IOException {
		response.sendError(401);
	}
	
}
