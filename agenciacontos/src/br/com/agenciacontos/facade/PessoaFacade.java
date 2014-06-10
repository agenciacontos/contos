package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import br.com.agenciacontos.dao.EmailDAO;
import br.com.agenciacontos.dao.PessoaDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.model.Pessoa;

public class PessoaFacade extends AbstractFacade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private PessoaDAO pessoaDAO;
	@Inject private EmailDAO emailDAO;
	
	public Pessoa cadastrarPessoa(DocumentoTipoEnum documentoTipo, String documento, String nome, String email) throws Exception {
		
		if(emailDAO.detalharEmail(email) != null){
			throw new Exception("Nâo é possível cadastar pois o e-mail ja está sendo utilizado.");
		}
		
		Pessoa pessoa = null;
		try {
			
			beginTransaction();
			pessoa = pessoaDAO.cadastrarPessoa(documentoTipo, documento, nome, email);
			Email emailRetorno = emailDAO.cadastrarEmail(22, email, true);
			Collection<Email> emails = new ArrayList<Email>();
			emails.add(emailRetorno);
			pessoa.setEmails(emails);
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return pessoa;
		
	}

}