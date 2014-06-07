package br.com.agenciacontos.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.agenciacontos.model.Usuario;

public class DefaultUsuarioPagesFilter extends AbstractFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Usuario usuario = (Usuario) req.getSession(true).getAttribute("usuario");

		if(!usuario.isVendedor() && !usuario.isAdmin()){
			accessDenied(request, response, req);
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}