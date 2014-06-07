package br.com.agenciacontos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.model.UsuarioLoja;

public class UsuarioLojaDAO extends GenericDAO<UsuarioLoja> {
	private static final long serialVersionUID = 1L;

	public UsuarioLojaDAO() {
		super(UsuarioLoja.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioLoja> listarLojasPorUsuario(Integer usuario_id){
		
//		beginTransaction();
		
		Criteria criteria = getSession().createCriteria(UsuarioLoja.class);
		Criterion paramUsuarioId = Restrictions.eq("usuarioId", usuario_id);
		criteria.add(paramUsuarioId);
		
//		closeTransaction();
		
		return criteria.list();

	}
	
	public void delete(UsuarioLoja usuarioLoja) {
        	super.delete(usuarioLoja.getId(), UsuarioLoja.class);
	}
}
