package br.com.agenciacontos.dao;

import java.util.Collection;

import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.util.Utils;

public class LojaDAO extends GenericDAO<Loja> {
	private static final long serialVersionUID = 1L;

	public LojaDAO() {
		super(Loja.class);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Loja> detalharLojaPorPessoaId(Integer pessoaId) throws Exception {

		return getSession().createCriteria(Loja.class)
        	.add(Restrictions.eq("pessoaId", pessoaId))
        	.list();

	}
	
	public Loja cadastrarLoja(Integer pessoaId, String nomeFantasia, boolean indicadorMatriz) throws Exception {
		
		Loja loja = new Loja();
		
		loja.setPessoaId(pessoaId);
		loja.setNomeFantasia(nomeFantasia);
		loja.setIndicadorMatriz(indicadorMatriz);
		loja.setCriado(Utils.getDataHoraAtual());
		loja.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(loja);
		
		return loja;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@SuppressWarnings("unchecked")
//	public List<Loja> listarLojasPorId(List<Integer> lojas_id){
//		
////		beginTransaction();
//		
//		Criteria criteria = getSession().createCriteria(Loja.class);
//		Criterion paramUsuarioId = Restrictions.in("id", lojas_id);
//		criteria.add(paramUsuarioId);
//		
//		return criteria.list();
//
//	}
//	
//	public Loja buscarLojaPorDocumento(String documento){
//		
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("documento", documento);
////		Loja loja = super.findOneResult(Loja.BUSCAR_LOJA_POR_DOCUMENTO, parameters);
//		
////		return loja;
//		return null;
//	}
//	
//	public void delete(Loja loja) {
//        	super.delete(loja.getId(), Loja.class);
//	}
}
