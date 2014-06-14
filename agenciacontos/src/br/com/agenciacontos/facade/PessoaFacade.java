package br.com.agenciacontos.facade;

import java.io.Serializable;

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
	
	public Pessoa detalharPessoaPorDocumento(DocumentoTipoEnum documentoTipo, String documento) throws Exception {
		
		return pessoaDAO.detalharPessoaPorDocumento(documentoTipo, documento);
		
	}
	
	public Pessoa detalharPessoaPorEmail(String email) throws Exception {
		
		Email emailRetorno = emailDAO.detalharEmail(email);
		
		if(emailRetorno != null){
			return pessoaDAO.detalharPessoaPorId(emailRetorno.getPessoaId());
		}
		
		return null;
		
	}
	
}