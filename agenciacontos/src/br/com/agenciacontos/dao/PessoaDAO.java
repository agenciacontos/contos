package br.com.agenciacontos.dao;

import br.com.agenciacontos.model.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	

	public void delete(Pessoa pessoa) {
//        	super.delete(pessoa.getId(), PEssoa.class);
	}
}
