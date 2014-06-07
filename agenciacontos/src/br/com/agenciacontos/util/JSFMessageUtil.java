package br.com.agenciacontos.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFMessageUtil {
	public void sendInfoMessageToUser(String message, String detalhe) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message, detalhe);
		addMessageToJsfContext(facesMessage);
	}

	public void sendErrorMessageToUser(String message, String detalhe) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, message, detalhe);
		addMessageToJsfContext(facesMessage);
	}

	private FacesMessage createMessage(Severity severity, String mensagemErro, String detalheErro) {
		return new FacesMessage(severity, mensagemErro, detalheErro);
	}

	private void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}