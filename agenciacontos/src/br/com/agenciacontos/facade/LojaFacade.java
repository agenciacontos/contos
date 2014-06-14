package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.dao.EmailDAO;
import br.com.agenciacontos.dao.LojaDAO;
import br.com.agenciacontos.dao.PessoaDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Pessoa;

@RequestScoped
@Named
public class LojaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private LojaDAO lojaDAO;
	@Inject private EmailDAO emailDAO;
	@Inject private PessoaDAO pessoaDAO;
	
	public Loja cadastrarLoja(DocumentoTipoEnum documentoTipo, String documento, String nomeFantasia, String email, boolean indicadorMatriz) throws Exception {
		
		if(emailDAO.isEmailExistente(email)){
		throw new Exception("O e-mail utilizado ja consta na base de dados.");
		}
		if(pessoaDAO.isDocumentoCadastrado(documento, documentoTipo)){
			throw new Exception("O documento utilizado ja consta na base de dados.");
		}
		
		Loja loja = null;
		try {
			
			beginTransaction();
			
			Pessoa pessoa = pessoaDAO.cadastrarPessoa(documentoTipo, documento, nomeFantasia);
			
			Email emailRetorno = emailDAO.cadastrarEmail(pessoa.getId(), email, true);
			Collection<Email> emails = new ArrayList<Email>();
			emails.add(emailRetorno);
			pessoa.setEmails(emails);
			
			loja = lojaDAO.cadastrarLoja(pessoa.getId(), nomeFantasia, indicadorMatriz);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return loja;
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Loja> listarLojasPorUsuario(Integer usuario_id) throws Exception {
		
		//buscando o id das lojas
//		List<PessoaLoja> usuarioLojas = lojaDAO.detalharLojaPorPessoaId(pessoaId);

		// TODO corrigir
//		List<Integer> lojas_id = new ArrayList<Integer>();
//		for (Object usuarioLoja : usuarioLojas.toArray()) {
//			PessoaLoja uLoja = (PessoaLoja) usuarioLoja;
//			lojas_id.add(uLoja.getId());
//		}
//		
//		if(lojas_id == null || lojas_id.size() <= 0)
//			return new ArrayList<Loja>();
		
//		return lojaDAO.listarLojasPorId(lojas_id);
		return null;
	}	
	
	public Loja findLoja(int lojaId) throws Exception {
//		lojaDAO.beginTransaction();
//		Loja loja = lojaDAO.find(lojaId);
//		lojaDAO.closeTransaction();
//		return loja;
		return null;
	}

	public List<Loja> listAll() throws Exception {
//		lojaDAO.beginTransaction();
//		List<Loja> result = lojaDAO.findAll();
//		lojaDAO.closeTransaction();
//		return result;
		return null;
	}

	public void deleteLoja(Loja loja) throws Exception {
//		lojaDAO.beginTransaction();
//		Loja persistedLoja = lojaDAO.findReferenceOnly(loja.getId());
//		lojaDAO.delete(persistedLoja);
//		lojaDAO.commitAndCloseTransaction();
	}
}