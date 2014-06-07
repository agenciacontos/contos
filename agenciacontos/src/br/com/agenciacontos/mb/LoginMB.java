package br.com.agenciacontos.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.agenciacontos.facade.LojaFacade;
import br.com.agenciacontos.facade.UsuarioFacade;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.seguranca.ControleAcesso;


@Named
@ConversationScoped
public class LoginMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private Conversation conversation;
	@Inject private HttpServletRequest httpServletRequest;
	
	@Inject private ControleAcesso controleAcesso;
	
	@Inject private UsuarioFacade usuarioFacade;
	@Inject private LojaFacade lojaFacade;
	
	private String emailDocumento;
	private String senha;
	private List<Loja> lojas;
	private Usuario usuario;
	private Loja loja;

	public String loginUsuario() {
		
		if(conversation.isTransient())
			conversation.begin();
		
		String email = null;
		String documento = null;
		if(getEmailDocumento() != null){
			
			if(getEmailDocumento().contains("@")){
				email = getEmailDocumento();
			}else{
				documento = getEmailDocumento();
			}
			
		}else{
			displayErrorMessageToUser("Falha no login", "Preencha corretamente os dados de login.");
			return null;
		}
		
		try {
			
			usuario = usuarioFacade.verificarDadosLogin(email, documento, senha);
			
			if(getUsuario() != null){
				
				lojas = lojaFacade.listarLojasPorUsuario(usuario.getId());
				
				if(lojas.size() > 0){
					
					return "escolherPerfilLogin";
					
				}else{
					
					return this.gravarDadosLogin();
					
				}
				
			}
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao efetuar login.", e.getLocalizedMessage());
			e.printStackTrace();
		}

		return null;
	}

	public String escolherPerfilLogin(){
		return gravarDadosLogin();
	}
	
	public String gravarDadosLogin(){
		
		if(getUsuario() != null){
			controleAcesso.carregaAcessosPreDefinidosUsuario(getUsuario());
			controleAcesso.gravaUsuarioLogado(getUsuario());
			controleAcesso.gravaLojaLogado(getLoja());
		}else{
			displayErrorMessageToUser("Falha ao efetuar login.", "Usuário está nulo.");
		}
		
		if(!conversation.isTransient())
		conversation.end();
		
		return "/index.xhtml";
		
	}
	
	public String logOut() {
		controleAcesso.logout();
		httpServletRequest.getSession().invalidate();
		return "/index.xhtml";
	}

	/**
	 * GETs e SETs
	 * */
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmailDocumento() {
		return emailDocumento;
	}

	public void setEmailDocumento(String emailDocumento) {
		this.emailDocumento = emailDocumento;
	}


	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}