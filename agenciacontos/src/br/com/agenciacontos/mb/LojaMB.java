package br.com.agenciacontos.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.facade.LojaFacade;
import br.com.agenciacontos.facade.PessoaFacade;
import br.com.agenciacontos.facade.PessoaLojaFacade;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.model.PessoaLoja;
import br.com.agenciacontos.seguranca.ControleAcesso;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
	@Inject private PessoaFacade pessoaFacade;
	@Inject private PessoaLojaFacade pessoaLojaFacade;
	
	private LojaForm lojaForm;
	
	@PostConstruct
	protected void init() {  
		
		if(lojaForm == null){
			lojaForm = new LojaForm();
		}
		
	} 
	
	public String mostrarNomePessoa(){

		try {
			
			String documentoPessoa = null;
			if(lojaForm.getDocumentoTipoPessoa().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documentoPessoa = lojaForm.getCpfPessoa();
			}else{
				documentoPessoa = lojaForm.getCnpjPessoa();
			}
			
			Pessoa pessoa =  pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.getDocumentoTipoFromCodigo(lojaForm.getDocumentoTipoPessoa()) , documentoPessoa);
			
			String nomePessoa = "Não encontrado";
			if(pessoa != null){
				nomePessoa = pessoa.getNome();
			}
			
			lojaForm.setNomePessoa(nomePessoa);
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	public String mostrarNomeLoja(){

		try {
			
			String documentoLoja = null;
			if(lojaForm.getDocumentoTipoLoja().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documentoLoja = lojaForm.getCpfLoja();
			}else{
				documentoLoja = lojaForm.getCnpjLoja();
			}
			
			Pessoa pessoa =  pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.getDocumentoTipoFromCodigo(lojaForm.getDocumentoTipoLoja()) , documentoLoja);
			
			String nomeLoja = "Não encontrado";
			if(pessoa != null){
				nomeLoja = pessoa.getNome();
			}
			
			lojaForm.setNomeLoja(nomeLoja);
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	public String vincularLojaPessoa(){
		
		try {
			
			String documento = null;
			if(lojaForm.getLojaVincularSelecionada().getDocumentoTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documento = lojaForm.getLojaVincularSelecionada().getCpf();
			}else{
				documento = lojaForm.getLojaVincularSelecionada().getCnpj();
			}
			
			Pessoa pessoa = pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.getDocumentoTipoFromCodigo(lojaForm.getLojaVincularSelecionada().getDocumentoTipo()), documento);
			if(pessoa == null){
				displayErrorMessageToUser("Falha", "Usuário não encontrado.");
				return "";
			}
			
			PessoaLoja pessoaLoja = pessoaLojaFacade.vincularLojaPessoa(lojaForm.getLojaVincularSelecionada().getLoja().getId(), pessoa.getId());
			
			displayInfoMessageToUser("Sucesso.", "Agora é representante.");
			
		} catch (Exception e) {
			
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
			
		}
		
		return "";
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
	
	public Collection<LojaVincular> getListaLojaVincular(){

		try {
			
			if(this.lojaForm.getListaLojaVincular() == null){
				
				Collection<Loja> lojas = lojaFacade.listarTodasLojas();

				Collection<LojaVincular> listaLojaVincularForm = new ArrayList<LojaVincular>();
				for (Loja loja : lojas) {
					
					LojaVincular lojaVincularForm = new LojaVincular();
					lojaVincularForm.setLoja(loja);
					
					listaLojaVincularForm.add(lojaVincularForm);
					
				}
				
				this.getLojaForm().setListaLojaVincular(listaLojaVincularForm);
				
			}
			
			
			return this.getLojaForm().getListaLojaVincular();
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<LojaVincular>();
		
	}
	

	public LojaForm getLojaForm() {
		return lojaForm;
	}

	public void setLojaForm(LojaForm lojaForm) {
		this.lojaForm = lojaForm;
	}
	
}