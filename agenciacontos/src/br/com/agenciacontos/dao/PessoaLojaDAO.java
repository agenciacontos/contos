package br.com.agenciacontos.dao;

import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.model.PessoaLoja;
import br.com.agenciacontos.util.Utils;

public class PessoaLojaDAO extends GenericDAO<PessoaLoja> {
	private static final long serialVersionUID = 1L;

	public PessoaLojaDAO() {
		super(PessoaLoja.class);
	}
	
	public PessoaLoja detalhar(Integer lojaId, Integer pessoaId) throws Exception {

		return (PessoaLoja) getSession().createCriteria(PessoaLoja.class)
	        	.add(Restrictions.eq("lojaId", lojaId))
	        	.add(Restrictions.eq("pessoaId", pessoaId))
	        	.uniqueResult();

	}
	
	public PessoaLoja vincularLojaPessoa(Integer lojaId, Integer pessoaId, Integer funcao) throws Exception {
		
		PessoaLoja pessoaLoja = new PessoaLoja();
		
		pessoaLoja.setPessoaId(pessoaId);
		pessoaLoja.setLojaId(lojaId);
		pessoaLoja.setFuncao(funcao);
		pessoaLoja.setCriado(Utils.getDataHoraAtual());
		pessoaLoja.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(pessoaLoja);
		
		return pessoaLoja;
		
	}
	
	public void delete(PessoaLoja pessoaLoja) {
//        	super.delete(pessoaLoja.getId(), PessoaLoja.class);
	}
}
