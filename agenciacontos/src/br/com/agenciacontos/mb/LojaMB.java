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
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.seguranca.ControleAcesso;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
	@Inject private PessoaFacade pessoaFacade;
	
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
			
			String documentoLoja = null;
			if(lojaForm.getDocumentoTipoLoja().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documentoLoja = lojaForm.getCpfLoja();
			}else{
				documentoLoja = lojaForm.getCnpjLoja();
			}
			
			String documentoPessoa = null;
			if(lojaForm.getDocumentoTipoPessoa().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documentoPessoa = lojaForm.getCpfPessoa();
			}else{
				documentoPessoa = lojaForm.getCnpjPessoa();
			}
		
			// TODO fazer a vinculacao
//			Loja loja = lojaFacade.cadastrarLoja(DocumentoTipoEnum.getDocumentoTipoFromCodigo(lojaForm.getDocumentoTipo())
//												, documento
//												, lojaForm.getNomeFantasia()
//												, lojaForm.getEmail()
//												, lojaForm.isIndicadorMatriz());
			
//			displayInfoMessageToUser("Cadastro efetuado com sucesso!", loja.getNomeFantasia());
			
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
	
	public Collection<Loja> getTodasLojas(){

		try {
			
			if(this.lojaForm.getTodasLojas() == null)
				this.getLojaForm().setTodasLojas(lojaFacade.listarTodasLojas());
			
			return this.lojaForm.getTodasLojas();
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<Loja>();
		
	}
	

	public LojaForm getLojaForm() {
		return lojaForm;
	}

	public void setLojaForm(LojaForm lojaForm) {
		this.lojaForm = lojaForm;
	}
	
}