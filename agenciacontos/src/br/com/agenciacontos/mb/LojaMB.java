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
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.seguranca.ControleAcesso;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
	
	private LojaForm lojaForm;
	
	
	@PostConstruct
	protected void init() {  
		
		if(lojaForm == null){
			lojaForm = new LojaForm();
			lojaForm.setLojas(new ArrayList<Loja>());
		}
		
	} 
	
	public String cadastrarLoja(){
		
		try {
			
			String documento = null;
			if(lojaForm.getDocumentoTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documento = lojaForm.getCpf();
			}else{
				documento = lojaForm.getCnpj();
			}
		
			Loja loja = lojaFacade.cadastrarLoja(DocumentoTipoEnum.getDocumentoTipoFromCodigo(lojaForm.getDocumentoTipo())
												, documento
												, lojaForm.getNomeFantasia()
												, lojaForm.getEmail()
												, lojaForm.isIndicadorMatriz());
			
			displayInfoMessageToUser("Cadastro efetuado com sucesso!", loja.getNomeFantasia());
			
		} catch (Exception e) {
			
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
			
		}
		
		return "";
	}
	
	
	public List<Loja> getLojas(){

		try {
			
//			if(lojas == null)
//				lojas = lojaFacade.listarLojasPorUsuario(controleAcesso.getUsuarioAtual().getId());
			
			return lojaForm.getLojas();
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<Loja>();
		
	}
	
	public String fornecerPontos(){
		
		try {
			
//			usuario.setNome("TESTE DE NOME");
			
//			pontosGerados.setLojaId(controleAcesso.getLojaAtual().getId());
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

	public LojaForm getLojaForm() {
		return lojaForm;
	}

	public void setLojaForm(LojaForm lojaForm) {
		this.lojaForm = lojaForm;
	}
	
}