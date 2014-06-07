package br.com.agenciacontos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.model.PessoaLoja;

public class PessoaLojaDAO extends GenericDAO<PessoaLoja> {
	private static final long serialVersionUID = 1L;

	public PessoaLojaDAO() {
		super(PessoaLoja.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaLoja> listarLojasPorUsuario(Integer usuario_id){
		
//		beginTransaction();
		
		Criteria criteria = getSession().createCriteria(PessoaLoja.class);
		Criterion paramUsuarioId = Restrictions.eq("usuarioId", usuario_id);
		criteria.add(paramUsuarioId);
		
//		closeTransaction();
		
		return criteria.list();

	}
	
	public void delete(PessoaLoja pessoaLoja) {
//        	super.delete(pessoaLoja.getId(), PessoaLoja.class);
	}
}
