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
import br.com.agenciacontos.model.Ponto;
import br.com.agenciacontos.seguranca.ControleAcesso;
import br.com.agenciacontos.util.Utils;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
//	@Inject private PontosFacade pontosFacade;
	
	private LojaForm lojaForm;
	
	private List<Loja> lojas;
	@Inject private Ponto pontosGerados;
	
	@PostConstruct
	protected void init() {  
		
		if(lojaForm == null){
			lojaForm = new LojaForm();
			lojaForm.setUsuarioIdentificacaoTipo(UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo());
			lojaForm.setPontos(1L);
			lojaForm.setValidade(Utils.getDataHoraAtual());
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
	public Ponto getPontosGerados() {
		return pontosGerados;
	}

	public void setPontosGerados(Ponto pontosGerados) {
		this.pontosGerados = pontosGerados;
	}

	public LojaForm getLojaForm() {
		return lojaForm;
	}

	public void setLojaForm(LojaForm lojaForm) {
		this.lojaForm = lojaForm;
	} 

}