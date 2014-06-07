package br.com.agenciacontos.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.model.Loja;

public class LojaDAO extends GenericDAO<Loja> {
	private static final long serialVersionUID = 1L;

	public LojaDAO() {
		super(Loja.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Loja> listarLojasPorId(List<Integer> lojas_id){
		
//		beginTransaction();
		
		Criteria criteria = getSession().createCriteria(Loja.class);
		Criterion paramUsuarioId = Restrictions.in("id", lojas_id);
		criteria.add(paramUsuarioId);
		
		return criteria.list();

	}
	
	public Loja buscarLojaPorDocumento(String documento){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("documento", documento);
		Loja loja = super.findOneResult(Loja.BUSCAR_LOJA_POR_DOCUMENTO, parameters);
		
		return loja;
	}
	
	public void delete(Loja loja) {
        	super.delete(loja.getId(), Loja.class);
	}
}
