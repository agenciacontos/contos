package br.com.contos.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import br.com.contos.model.Usuario;

@SessionScoped
@ManagedBean(name="acessoMB")
public class AcessoMB extends AbstractMB implements Serializable {
	public static final String INJECTION_NAME = "#{acessoMB}";
	private static final long serialVersionUID = 1L;

	public boolean isUsuarioLogado(){
		HttpSession session = getRequest().getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario == null) {
			return false;
		}
		
		return true;
	}
	
	public void gravarDadosLogin(Usuario usuario){
		getRequest().getSession().setAttribute("usuario", usuario);
	}
	
}