package br.edu.ufcg.computacao.si1.seguranca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufcg.computacao.si1.excecoes.TokenInvalidoException;
/**
 * 
 * Classe para filtrar as mensagens http do sistema,
 * filtra as request, em fase de implementacao.
 */
@Component
public class FiltroSistema implements Filter {
	
	@Autowired
	private Autenticacao autenticador;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// sem implementacao por enquanto
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    	    
	    if(!httpRequest.getServletPath().equals("/login") && !httpRequest.getServletPath().equals("/logout")) {
	    	try {
	    		// testando ainda, seria melhor com Cookies.
				//autenticador.decodificarToken(httpRequest.getReader().readLine());
				//httpRequest.getReader().close();
				chain.doFilter(request, response);
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
