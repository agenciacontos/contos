package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.dao.EmailDAO;
import br.com.agenciacontos.dao.LojaDAO;
import br.com.agenciacontos.dao.PessoaDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Pessoa;

@RequestScoped
@Named
public class LojaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private LojaDAO lojaDAO;
	@Inject private EmailDAO emailDAO;
	@Inject private PessoaDAO pessoaDAO;
	
	public Loja cadastrarLoja(DocumentoTipoEnum documentoTipo, String documento, String nomeFantasia, String email, boolean indicadorMatriz) throws Exception {
		
		if(emailDAO.isEmailExistente(email)){
			throw new Exception("O e-mail utilizado ja consta na base de dados.");
		}
		if(pessoaDAO.isDocumentoCadastrado(documento, documentoTipo)){
			throw new Exception("O documento utilizado ja consta na base de dados.");
		}
		
		Loja loja = null;
		try {
			
			beginTransaction();
			
			Pessoa pessoa = pessoaDAO.cadastrarPessoa(documentoTipo, documento, nomeFantasia);
			
			Email emailRetorno = emailDAO.cadastrarEmail(pessoa.getId(), email, true);
			Collection<Email> emails = new ArrayList<Email>();
			emails.add(emailRetorno);
			pessoa.setEmails(emails);
			
			loja = lojaDAO.cadastrarLoja(pessoa.getId(), nomeFantasia, indicadorMatriz);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return loja;
		
	}
	
	public List<Loja> listarLojasPorUsuario(Integer pessoaId) throws Exception {

		
		
		return null;
	}	
	
	public Collection<Loja> listarTodasLojas() throws Exception {

		return lojaDAO.listarTodasLojas();
	}	
	
}