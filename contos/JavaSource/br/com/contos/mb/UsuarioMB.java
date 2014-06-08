package br.com.contos.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.contos.enums.DocumentoTipoEnum;
import br.com.contos.model.Usuario;

@SessionScoped
@ManagedBean(name="usuarioMB")
public class UsuarioMB implements Serializable {
	public static final String INJECTION_NAME = "#{usuarioMB}";
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Integer documentoTipo;
	private String documento;
	private String nome;
	private String email;
	private String senha;
	
	public Integer getDocumentoTipo() {
		System.out.println("getDocumentoTipo()");
		if(documentoTipo == null){
			System.out.println("documentoTipo = DocumentoTipoEnum.CPF.getCodigo();");
			documentoTipo = DocumentoTipoEnum.CPF.getCodigo();
		}
		return documentoTipo;
	}
	
	public boolean isDocumentoTipoCpf(){
		System.out.println("isDocumentoTipoCpf() "+getDocumentoTipo());
		return (getDocumentoTipo() == DocumentoTipoEnum.CPF.getCodigo());
	}
	public boolean isDocumentoTipoCnpj(){
		System.out.println("isDocumentoTipoCnpj() "+getDocumentoTipo());
		return (getDocumentoTipo() == DocumentoTipoEnum.CNPJ.getCodigo());
	}
	public String setDocumentoTipoCpf(){
		System.out.println("setDocumentoTipoCpf "+getDocumentoTipo());
		setDocumentoTipo(DocumentoTipoEnum.CPF.getCodigo());
		return "";
	}
	public String setDocumentoTipoCnpj(){
		System.out.println("setDocumentoTipoCnpj "+getDocumentoTipo());
		setDocumentoTipo(DocumentoTipoEnum.CNPJ.getCodigo());
		return "";
	}
	
	public boolean isAdmin() {
		return usuario.isAdmin();
	}

	public boolean isCliente() {
		return usuario.isCliente();
	}

	public boolean isLoja() {
		return usuario.isLoja();
	}

	public String logOut() {
		getRequest().getSession().invalidate();
		return "/pages/public/login.xhtml";
	}

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	//Usado para chamar algo qualquer no banco de dados e criar as tabelas
	//tem que configurar no persistence antes
	public String getTesteIniciaTables(){
		try {
			
//			usuarioFacade.listAll();
			
//			displayInfoMessageToUser("DB criado com sucesso.");
		} catch (Exception e) {
//			displayErrorMessageToUser("Falha ao criar BD.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setDocumentoTipo(Integer documentoTipo) {
		System.out.println("setDocumentoTipo()");
		this.documentoTipo = documentoTipo;
	}
	
}