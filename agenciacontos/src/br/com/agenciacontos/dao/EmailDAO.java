package br.com.agenciacontos.dao;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.util.Utils;

public class EmailDAO extends GenericDAO<Email> {

	private static final long serialVersionUID = 1L;

	public EmailDAO() {
		super(Email.class);
	}
	
	private int getNovoId(int pessoaId){
		
		Integer retorno = (Integer) getSession().createCriteria(Email.class)
	        	.add(Restrictions.eq("pessoaId", pessoaId))
	        	  .setProjection( Projections.max("id") )
	        	  .uniqueResult();
	        
		if(retorno != null){
			return ++retorno;
		}
		return 0;
		
	}
	
	public Email cadastrarEmail(Integer pessoaId, String email, boolean indicadorPreferencial) throws Exception {
		
		Email emailGravar = new Email();
		
		emailGravar.setId(getNovoId(pessoaId));
		emailGravar.setPessoaId(pessoaId);
		emailGravar.setData_fim(null);
		emailGravar.setEmail(email);
		emailGravar.setIndicadorEmailPreferencial(indicadorPreferencial);
		
		emailGravar.setData_inicio(Utils.getDataHoraAtual());
		emailGravar.setCriado(Utils.getDataHoraAtual());
		emailGravar.setModificado(Utils.getDataHoraAtual());
			
		getSession().persist(emailGravar);
		
		return emailGravar;
		
	}
	
	public Email detalharEmail(String email) throws Exception {

		return (Email) getSession().createCriteria(Email.class)
        	.add(Restrictions.eq("email", email))
        	.uniqueResult();

	}
	
	public boolean isEmailExistente(String email){
		
		Long qtd = (Long) getSession()
							.createCriteria(Email.class)
							.add(Restrictions.eq("email", email))
							.setProjection(Projections.rowCount())
							.uniqueResult();
		
		return qtd >= 1;
		
	}
	
}
