package br.com.contos.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.contos.facade.UsuarioFacade;
import br.com.contos.model.Loja;
import br.com.contos.model.Usuario;

@RequestScoped
@ManagedBean
public class LoginMB extends AbstractMB {
	
	@ManagedProperty(value = UsuarioMB.INJECTION_NAME)
	private UsuarioMB usuarioMB;
	@ManagedProperty(value = AcessoMB.INJECTION_NAME)
	private AcessoMB acessoMB;

	private String emailDocumento;
	private String senha;
	private List<Loja> lojas;
	private Usuario usuario;
	private Loja loja;

	public String loginUsuario() {
		
		String email = null;
		String documento = null;
		if(emailDocumento != null){
			
			if(emailDocumento.contains("@")){
				email = emailDocumento;
			}else{
				documento = emailDocumento;
			}
			
		}else{
			displayErrorMessageToUser("Preencha corretamente os dados de login.");
			return null;
		}
		
		try {
			
			UsuarioFacade usuarioFacade = new UsuarioFacade();
			
			usuario = usuarioFacade.verificarDadosLogin(email, documento, senha);
			
			if(usuario != null){
				
//				lojas = lojaFacade.listarLojasPorUsuario(usuario.getId());
				
				if(lojas.size() > 0){
					
					return "escolherPerfilLogin";
					
				}else{
					
					acessoMB.gravarDadosLogin(usuario);
					return ""; 
					
				}
				
			}
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao efetuar login." + e.getLocalizedMessage());
			e.printStackTrace();
		}

		return null;
	}

	public UsuarioMB getUsuarioMB() {
		return usuarioMB;
	}

	public void setUsuarioMB(UsuarioMB usuarioMB) {
		this.usuarioMB = usuarioMB;
	}

	public AcessoMB getAcessoMB() {
		return acessoMB;
	}

	public void setAcessoMB(AcessoMB acessoMB) {
		this.acessoMB = acessoMB;
	}

	public String getEmailDocumento() {
		return emailDocumento;
	}

	public void setEmailDocumento(String emailDocumento) {
		this.emailDocumento = emailDocumento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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