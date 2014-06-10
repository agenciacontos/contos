package br.com.agenciacontos.mb;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.facade.EmailFacade;
import br.com.agenciacontos.facade.UsuarioFacade;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.util.Utils;

@RequestScoped
@Named
public class UsuarioMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioFacade usuarioFacade;
	@Inject private EmailFacade emailFacade;

	private UsuarioForm usuarioForm;

	@PostConstruct
	protected void init() {  
		
		if(usuarioForm == null){
			usuarioForm = new UsuarioForm();
			usuarioForm.setDocumentoTipo(DocumentoTipoEnum.CPF.getCodigo());
		}
		
	} 
	
	public String getTesteIniciaTables(){
		try {
			
			Email email = emailFacade.detalharEmail("chopsss@gmail.com");
			
			displayInfoMessageToUser("DB criado com sucesso.");
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar BD.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";
	}
	
	public String cadastrarUsuario(){

		try {
			
			String documento = null;
			if(usuarioForm.getDocumentoTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documento = Utils.cpfSomenteNumeros(usuarioForm.getCpf());
			}else{
				documento = Utils.cnpjSomenteNumeros(usuarioForm.getCnpj());
			}
			
			usuarioFacade.cadastrarUsuario(DocumentoTipoEnum.getDocumentoTipoFromCodigo(usuarioForm.getDocumentoTipo())
											, documento
											, usuarioForm.getNome()
											, usuarioForm.getEmail()
											, usuarioForm.getSenha());
			
			displayInfoMessageToUser("Usuário criado com sucesso.");
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar usuário.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	public LabelValue[] getDocumentoTiposLabelValue(){
		
		LabelValue labelValue[] = new LabelValue[DocumentoTipoEnum.values().length];
		int i = 0;
		for (DocumentoTipoEnum documentoTipoEnum : DocumentoTipoEnum.values()) {
			labelValue[i] = new LabelValue(documentoTipoEnum.getTexto(), String.valueOf(documentoTipoEnum.getCodigo()));
			i++;
		}
		
		return labelValue;
			
	}

	public UsuarioForm getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(UsuarioForm usuarioForm) {
		this.usuarioForm = usuarioForm;
	} 

}