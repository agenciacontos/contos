package br.com.agenciacontos.mb;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class PontoMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Inject private PontoFacade pontoFacade;

	private PontoForm pontoForm;

	@PostConstruct
	protected void init() {  
		
//		if(pontoForm == null){
//			pontoForm = new PontoForm();
//			pontoForm.setDocumentoTipo(DocumentoTipoEnum.CPF.getCodigo());
//		}
		
	} 
	
	public String fornecerPontos(){

		try {
			
			/*
			String documento = null;
			if(usuarioForm.getDocumentoTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documento = usuarioForm.getCpf();
			}else{
				documento = usuarioForm.getCnpj();
			}
			
			Usuario usuario = usuarioFacade.cadastrarCliente(DocumentoTipoEnum.getDocumentoTipoFromCodigo(usuarioForm.getDocumentoTipo())
											, documento
											, usuarioForm.getNome()
											, usuarioForm.getEmail()
											, usuarioForm.getSenha());
			displayInfoMessageToUser("Cadastro efetuado.", usuario.getPessoa().getNome() + " agora você está cadastrado no sistema, por favor efetue o login.");
			 */
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar usuário.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}

	public PontoForm getPontoForm() {
		return pontoForm;
	}

	public void setPontoForm(PontoForm pontoForm) {
		this.pontoForm = pontoForm;
	}
	
}