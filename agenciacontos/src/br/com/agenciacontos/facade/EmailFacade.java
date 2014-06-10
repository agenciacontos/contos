package br.com.agenciacontos.facade;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.agenciacontos.dao.EmailDAO;
import br.com.agenciacontos.model.Email;

public class EmailFacade extends AbstractFacade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private EmailDAO emailDAO;
	
	public Email cadastrarEmail(Integer pessoaId, String email, boolean indicadorPreferencial) throws Exception {
		
		if(emailDAO.detalharEmail(email) != null){
			throw new Exception("Nâo é possível cadastar pois o e-mail ja está sendo utilizado.");
		}
		
		Email emailRetorno = null;
		try {
		
			beginTransaction();
			emailRetorno = emailDAO.cadastrarEmail(pessoaId, email, indicadorPreferencial);
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return emailRetorno;
		
	}
	
	public Email detalharEmail(String email) throws Exception {

		Email emailRetorno = null;
		try {
		
			beginTransaction();
			emailRetorno = emailDAO.detalharEmail(email);
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return emailRetorno;
		
	}
	

}