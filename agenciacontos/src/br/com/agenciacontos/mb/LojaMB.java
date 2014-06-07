package br.com.agenciacontos.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioIdentificacaoTipoEnum;
import br.com.agenciacontos.facade.LojaFacade;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Pontos;
import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.seguranca.ControleAcesso;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
//	@Inject private PontosFacade pontosFacade;
	
	private List<Loja> lojas;
	@Inject private Usuario usuario;
	@Inject private Pontos pontosGerados;
	
	@PostConstruct
	protected void init2() {  
	    
		if(usuario == null){
			usuario = new Usuario();
			usuario.setIdentificacaoTipo(UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo());
		}

		if(pontosGerados == null){
			pontosGerados = new Pontos();
			pontosGerados.setPontos(1L);
		}
		
	} 
	
	public List<Loja> getLojas(){

		try {
			
//			if(lojas == null)
//				lojas = lojaFacade.listarLojasPorUsuario(controleAcesso.getUsuarioAtual().getId());
			
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
	
	public String fornecerPontos(){
		
		try {
			
//			usuario.setNome("TESTE DE NOME");
			
			pontosGerados.setLojaId(controleAcesso.getLojaAtual().getId());
//			pontosGerados.setUsuarioExecutanteId(controleAcesso.getUsuario().getId());
			
			//buscar id do usuario para mandar 
//			pontosGerados.setUsuarioId(1);
			
//			pontosGeradosFacade.incluirPontos(pontosGerados);
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao incluir pontos.", e.getLocalizedMessage());
			e.printStackTrace();
		}

		return "";
		
	}
	

	/**
	 * SETS e GETS
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pontos getPontosGerados() {
		return pontosGerados;
	}

	public void setPontosGerados(Pontos pontosGerados) {
		this.pontosGerados = pontosGerados;
	} 

}