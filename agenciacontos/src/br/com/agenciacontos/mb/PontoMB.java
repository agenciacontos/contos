package br.com.agenciacontos.mb;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioIdentificacaoTipoEnum;
import br.com.agenciacontos.facade.PessoaFacade;
import br.com.agenciacontos.facade.PontoFacade;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.model.Ponto;
import br.com.agenciacontos.seguranca.ControleAcesso;
import br.com.agenciacontos.util.Utils;

@RequestScoped
@Named
public class PontoMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private PontoFacade pontoFacade;
	@Inject private PessoaFacade pessoaFacade;
	
	@Inject private ControleAcesso controleAcesso;

	private PontoForm pontoForm;

	@PostConstruct
	protected void init() {  
		
		if(pontoForm == null){
			pontoForm = new PontoForm();
//			pontoForm.setDocumentoTipo(DocumentoTipoEnum.CPF.getCodigo());
		}
		
	} 
	
	public String mostrarNomeCliente(){

		try {
			
			if(this.pontoForm.getEmail() != null || this.pontoForm.getCpf() != null || this.pontoForm.getCnpj() != null){

				Pessoa pessoa = null;
				
				if(this.pontoForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo()){
					
					pessoa = pessoaFacade.detalharPessoaPorEmail(this.pontoForm.getEmail());
					
				}
				if(this.pontoForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CPF.getCodigo()){
					
					pessoa = pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.CPF, this.pontoForm.getCpf());
					
				}
				if(this.pontoForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CNPJ.getCodigo()){
					
					pessoa = pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.CNPJ, this.pontoForm.getCnpj());
					
				}
				
				String nomeCliente = "Não encontrado";
				if(pessoa != null){
					nomeCliente = pessoa.getNome();
				}

				this.pontoForm.setNomeCliente(nomeCliente);
				
			}else{
				displayErrorMessageToUser("Falha no login", "Preencha corretamente os dados de login.");
				return null;
			}
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	public String fornecerPontos(){

		try {
			
			if(this.pontoForm.getEmail() != null || this.pontoForm.getCpf() != null || this.pontoForm.getCnpj() != null){

				Ponto ponto = null;
				
				Integer lojaId = controleAcesso.getLojaAtual().getId();
				
				if(this.pontoForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.EMAIL.getCodigo()){
					
					ponto = pontoFacade.cadastrarPontosPorEmail(lojaId
																, this.pontoForm.getEmail()
																, this.pontoForm.getPontos()
																, this.pontoForm.getValor()
																, Utils.utilDateToSqlDate(this.pontoForm.getValidade())
																, this.pontoForm.getDescricao()
																, Utils.getDataHoraAtual()
																, this.pontoForm.getCartao());
					
				}
				if(this.pontoForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CPF.getCodigo()){
					
					ponto = pontoFacade.cadastrarPontosPorDocumento(lojaId
																	, DocumentoTipoEnum.CPF
																	, this.pontoForm.getCpf()
																	, this.pontoForm.getPontos()
																	, this.pontoForm.getValor()
																	, Utils.utilDateToSqlDate(this.pontoForm.getValidade())
																	, this.pontoForm.getDescricao()
																	, Utils.getDataHoraAtual()
																	, this.pontoForm.getCartao());
					
				}
				if(this.pontoForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.CNPJ.getCodigo()){
					
					ponto = pontoFacade.cadastrarPontosPorDocumento(lojaId
																	, DocumentoTipoEnum.CNPJ
																	, this.pontoForm.getCnpj()
																	, this.pontoForm.getPontos()
																	, this.pontoForm.getValor()
																	, Utils.utilDateToSqlDate(this.pontoForm.getValidade())
																	, this.pontoForm.getDescricao()
																	, Utils.getDataHoraAtual()
																	, this.pontoForm.getCartao());
					
				}
				
				
				displayInfoMessageToUser("Pontos cadastrados.", "Pontos cadastrados com sucesso.");
				
			}else{
				displayErrorMessageToUser("Falha no login", "Preencha corretamente os dados de login.");
				return null;
			}
			
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