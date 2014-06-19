package br.com.agenciacontos.facade;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.dao.PessoaLojaDAO;
import br.com.agenciacontos.enums.PessoaLojaFuncaoEnum;
import br.com.agenciacontos.model.PessoaLoja;

@RequestScoped
@Named
public class PessoaLojaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private PessoaLojaDAO pessoaLojaDAO;
	
	public PessoaLoja vincularLojaPessoa(Integer lojaId, Integer pessoaId) throws Exception {
		
		if(pessoaLojaDAO.detalhar(lojaId, pessoaId) != null){
			throw new Exception("O vínculo ja existe.");
		}
		
		PessoaLoja pessoaLoja = null;
		try {
			
			beginTransaction();
			
			Integer funcao = PessoaLojaFuncaoEnum.PROPRIETARIO.getCodigo();
			
			pessoaLoja = pessoaLojaDAO.vincularLojaPessoa(lojaId, pessoaId, funcao);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return pessoaLoja;
		
	}
	
}