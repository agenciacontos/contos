package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.dao.EmailDAO;
import br.com.agenciacontos.dao.PessoaDAO;
import br.com.agenciacontos.dao.PontoDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.model.Ponto;

@RequestScoped
@Named
public class PontoFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private PessoaDAO pessoaDAO;
	@Inject private EmailDAO emailDAO;
	@Inject private PontoDAO pontoDAO;
	
	public Ponto cadastrarPontosPorDocumento(Integer lojaId, DocumentoTipoEnum documentoTipo, String documento, Long pontos, Double valor, Date validade, String descricao, Date data, Integer cartao) throws Exception {
		
		Pessoa pessoa = pessoaDAO.detalharPessoaPorDocumento(documentoTipo, documento);
		
		if(pessoa != null){
			return this.cadastrarPontos(lojaId, pessoa.getId(), pontos, valor, validade, descricao, data, cartao);
		}else{
			return null;
		}
		
	}	
	
	public Ponto cadastrarPontosPorEmail(Integer lojaId, String email, Long pontos, Double valor, Date validade, String descricao, Date data, Integer cartao) throws Exception {
		
		Email emailRetorno = emailDAO.detalharEmail(email);
		
		Pessoa pessoa = null;
		if(emailRetorno != null){
			pessoa = pessoaDAO.detalharPessoaPorId(emailRetorno.getPessoaId());
		}
		
		if(pessoa != null){
			return this.cadastrarPontos(lojaId, pessoa.getId(), pontos, valor, validade, descricao, data, cartao);
		}else{
			return null;
		}
		
	}	
	
	private Ponto cadastrarPontos(Integer lojaId, Integer pessoaId, Long pontos, Double valor, Date validade, String descricao, Date data, Integer cartao) throws Exception {
		
		Ponto ponto = null;
		try {
			
			beginTransaction();
			
			ponto = pontoDAO.cadastrarPonto(lojaId, pessoaId, data, descricao, pontos, valor, validade, cartao);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return ponto;
		
	}	
	
}