package br.com.agenciacontos.filter;

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
import javax.servlet.http.HttpSession;

import br.com.agenciacontos.model.Usuario;

/**
 * Servlet Filter implementation class UserCheckFilter
 */
public class LoginCheckFilter extends AbstractFilter implements Filter {
	private static List<String> allowedURIs;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		if(allowedURIs == null){
			
			/**
			 * TODO
			 * colocar aqui como no 
			 * allowedURIs.add(fConfig.getInitParameter("loginActionURI"));
			 * adicionado a url no web.xml
			 * 
			 * MODIFICAR ESTA CLASSE TODA PARA CONFIGURAR ACESSO A FUNCIONALIDADES NO QUAL
			 * AS MESMAS DAO ACESSO A URL A EXEMPLO DO BANCO
			 * 
			 * USER1 USER2 ou USERINSERT USERDELETE
			 * 
			 * EM PRINCIPIO FAZER COM CONSTANTES PARA POSTERIORMENTE SER POSSIVEL MODIFICAR DINAMICAMENTE
			 *  
			 * */
			
			allowedURIs = new ArrayList<String>();
			allowedURIs.add(fConfig.getInitParameter("loginActionURI"));
			allowedURIs.add("/contos/javax.faces.resource/main.css.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/theme.css.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/primefaces.js.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/primefaces.css.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/jquery/jquery.js.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/messages/messages.png.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/images/ui-icons_2e83ff_256x240.png.xhtml");
			allowedURIs.add("/contos/javax.faces.resource/images/ui-icons_38667f_256x240.png.xhtml");
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.isNew()) {
			doLogin(request, response, req);
			return;
		}

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario == null && !allowedURIs.contains(req.getRequestURI())) {
			System.out.println(req.getRequestURI());
			doLogin(request, response, req);
			return;
		}

		chain.doFilter(request, response);
	}
}