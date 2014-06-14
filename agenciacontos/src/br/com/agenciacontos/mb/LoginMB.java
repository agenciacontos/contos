package br.com.agenciacontos.mb;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioIdentificacaoTipoEnum;
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
	
	private String email;
	private String cpf;
	private String cnpj;
	private String senha;
	private Integer usuarioIdentificacaoTipo = UsuarioIdentificacaoTipoEnum.CPF.getCodigo();
	
	private Collection<Loja> lojas;
	private Usuario usuario;
	private Loja loja;

	public String loginUsuario() {
		
		try {
			
			boolean usuarioAutenticado = false;
			if(this.getEmail() != null || this.getCpf() != null || this.getCnpj() != null){
				
				if(this.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo()){
					
					usuarioAutenticado = usuarioFacade.autenticarUsuarioPorEmail(this.getEmail(), this.getSenha());
					
				}
				if(this.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CPF.getCodigo()){
					
					usuarioAutenticado = usuarioFacade.autenticarUsuarioPorDocumento(DocumentoTipoEnum.CPF, this.getCpf(), this.getSenha());
					
				}
				if(this.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CNPJ.getCodigo()){
					
					usuarioAutenticado = usuarioFacade.autenticarUsuarioPorDocumento(DocumentoTipoEnum.CNPJ, this.getCnpj(), this.getSenha());
					
				}

			}else{
				displayErrorMessageToUser("Falha no login", "Preencha corretamente os dados de login.");
				return null;
			}
			
			if(usuarioAutenticado) {
				
				if(this.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo()){
					
					this.usuario = usuarioFacade.detalharUsuarioCompletoPorEmail(this.getEmail());
					
				}
				if(this.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CPF.getCodigo()){
					
					this.usuario = usuarioFacade.detalharUsuarioCompletoPorDocumento(DocumentoTipoEnum.CPF, this.getCpf());
					
				}
				if(this.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CNPJ.getCodigo()){
					
					this.usuario = usuarioFacade.detalharUsuarioCompletoPorDocumento(DocumentoTipoEnum.CNPJ, this.getCnpj());
					
				}
				
				if(this.usuario.getPessoa().getLojas() != null){
					
					lojas = this.usuario.getPessoa().getLojas();
					
					if(lojas.size() > 0){
						
						return "escolherPerfilLogin";
						
					}else{
						
						return this.gravarDadosLogin();
						
					}
					
				}
			}else{
				displayErrorMessageToUser("Falha no login", "Os dados de autenticação não são válidos.");
				return null;
			}
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao efetuar login.", e.getLocalizedMessage());
			e.printStackTrace();
		}

		return null;
	}
	
	public String gravarDadosLogin(){
		
		if(getUsuario() != null){
			controleAcesso.carregaAcessosPreDefinidosUsuario(getUsuario()); // Ainda não está implementado por completo as permissões
			controleAcesso.gravaUsuarioLogado(getUsuario());
			controleAcesso.gravaLojaLogado(getLoja());
		}else{
			displayErrorMessageToUser("Falha ao efetuar login.", "Usuário está nulo.");
			return null;
		}
		
		if(!conversation.isTransient())
		conversation.end();
		
		return "/index.xhtml";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String escolherPerfilLogin(){
		return gravarDadosLogin();
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

	public Collection<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(Collection<Loja> lojas) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getUsuarioIdentificacaoTipo() {
		return usuarioIdentificacaoTipo;
	}

	public void setUsuarioIdentificacaoTipo(Integer usuarioIdentificacaoTipo) {
		this.usuarioIdentificacaoTipo = usuarioIdentificacaoTipo;
	}

}