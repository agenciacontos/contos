package br.com.agenciacontos.mb;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.agenciacontos.util.JSFMessageUtil;

public class AbstractMB {
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	public AbstractMB() {
		super();
	}
	
	@Inject private Conversation conversation;
	
	/**
     * Inicia o conversation scope.
     */
    public void initConversation() {
        if (!conversation.isTransient()) {
            conversation.begin();
        }
    }
    
    /**
     * Termina o conversation scoped.
     */
    public void endConversation() {
        if (conversation.isTransient()) {
            conversation.end();
        }
    }
	
//	public ControleAcesso getControleAcesso(){
//		
//		ControleAcesso controleAcesso = (ControleAcesso) getSession().getAttribute("controleAcesso");
//		
//		if(controleAcesso == null){
//			controleAcesso = new ControleAcesso();
//			getSession().setAttribute("controleAcesso", controleAcesso);
//		}
//		
//		return (ControleAcesso) getSession().getAttribute("controleAcesso");
//	}

//	public HttpServletRequest getRequest() {
//		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//	}

//	public FacesContext getContext() {
//		return (FacesContext) FacesContext.getCurrentInstance();
//	}

//	public HttpSession getSession() {
//		return (HttpSession) getContext().getExternalContext().getSession(false);
//	}
	
	
	/**
	 * Ja estavam no exemplo, ver se continuarão
	 * */

	protected void displayErrorMessageToUser(String message, String detalhe) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message, detalhe);
	}
	
	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message, null);
	}

	protected void displayInfoMessageToUser(String message, String detalhe) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message, detalhe);
	}
	
	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message, null);
	}
	
	protected void closeDialog(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}
	
	protected void keepDialogOpen(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}
	
	protected RequestContext getRequestContext(){
		return RequestContext.getCurrentInstance();
	}
}