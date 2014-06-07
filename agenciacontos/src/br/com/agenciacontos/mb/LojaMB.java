package br.com.agenciacontos.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.facade.LojaFacade;
import br.com.agenciacontos.facade.PontosGeradosFacade;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.PontosGerados;
import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.seguranca.ControleAcesso;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
	@Inject private PontosGeradosFacade pontosGeradosFacade;
	
	private List<Loja> lojas;
	@Inject private Usuario usuario;
	@Inject private PontosGerados pontosGerados;
	
	@PostConstruct
	protected void init2() {  
	    
//		initConversation();
		
//		if(usuario == null){
//			usuario = new Usuario();
//			usuario.setIdentificacaoTipo(UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo());
//		}

		if(pontosGerados == null){
			pontosGerados = new PontosGerados();
			pontosGerados.setPontos(1L);
		}
		
	} 
	
	public List<Loja> getLojas(){

		try {
			
			if(lojas == null)
				lojas = lojaFacade.listarLojasPorUsuario(controleAcesso.getUsuarioAtual().getId());
			
			return lojas;
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<Loja>();
		
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
	
	public void fornecerPontos(){
		
		try {
			
			usuario.setNome("TESTE DE NOME");
			
			pontosGerados.setLojaId(controleAcesso.getLojaAtual().getId());
//			pontosGerados.setUsuarioExecutanteId(controleAcesso.getUsuario().getId());
			
			//buscar id do usuario para mandar 
			pontosGerados.setUsuarioId(1);
			
			pontosGeradosFacade.incluirPontos(pontosGerados);
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao incluir pontos.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
//		endConversation();
		
	}
	

	/**
	 * SETS e GETS
	 */
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
//			usuario.setIdentificacaoTipo(UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo());
		}
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PontosGerados getPontosGerados() {
		return pontosGerados;
	}

	public void setPontosGerados(PontosGerados pontosGerados) {
		this.pontosGerados = pontosGerados;
	} 

}