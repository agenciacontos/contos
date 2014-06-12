package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import br.com.agenciacontos.dao.EmailDAO;
import br.com.agenciacontos.dao.LojaDAO;
import br.com.agenciacontos.dao.PessoaDAO;
import br.com.agenciacontos.dao.UsuarioDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioTipoEnum;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.model.Usuario;

public class UsuarioFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private UsuarioDAO usuarioDAO;
	@Inject private PessoaDAO pessoaDAO;
	@Inject private EmailDAO emailDAO;
	@Inject private LojaDAO lojaDAO;
	
	public boolean autenticarUsuarioPorEmail(String email, String senha) throws Exception {
		
		Email emailRetorno = emailDAO.detalharEmail(email);
		return autenticarUsuario(emailRetorno.getPessoaId(), senha);
		
	}
	
	public boolean autenticarUsuarioPorDocumento(String documento, String senha) throws Exception {
		
		Pessoa pessoa = pessoaDAO.detalharPessoaPorDocumento(documento);
		return autenticarUsuario(pessoa.getId(), senha);
		
	}
	
	private boolean autenticarUsuario(Integer pessoaId, String senha) throws Exception {
		
		try {
			
			if(pessoaId != null){
				
				beginTransaction();
				
				return usuarioDAO.autenticarUsuarioPorPessoaId(pessoaId, senha) != null;
				
			}else{
				throw new Exception("Dados para login insuficientes.");
			}
			
		} catch (Exception e) {
			rollback();
			throw e;
		}
		
	}
	
	public Usuario detalharUsuarioCompletoPorEmail(String email, String senha) throws Exception {
		
		return detalharUsuarioCompleto(null, emailDAO.detalharEmail(email));
		
	}
	
	public Usuario detalharUsuarioCompletoPorDocumento(String documento, String senha) throws Exception {
		
		return detalharUsuarioCompleto(pessoaDAO.detalharPessoaPorDocumento(documento), null);
		
	}
	
	private Usuario detalharUsuarioCompleto(Pessoa pessoa, Email email) throws Exception {
		
		try {
			
			beginTransaction();
			
			Integer pessoaId = null;
			if(pessoa != null) {
				
				pessoaId = pessoa.getId();
				
			} else if(email != null){
				
				pessoaId = email.getPessoaId();
				
			}else{
				throw new Exception("Dados para login insuficientes.");
			}
			
			Usuario usuario = usuarioDAO.buscarUsuarioPorPessoaId(pessoaId);
			
			if(pessoa == null)
				pessoa = pessoaDAO.detalharPessoaPorId(pessoaId);
			
			if(email == null)
				email = emailDAO.detalharEmailPorPessoaId(pessoaId);
			
			if(email != null){
				Collection<Email> emails = new ArrayList<Email>();
				emails.add(email);
				pessoa.setEmails(emails);
			}
			
			pessoa.setLojas(lojaDAO.detalharLojaPorPessoaId(pessoaId));
			usuario.setPessoa(pessoa);
			
			usuario.setSenha(null);
			
			return usuario;
			
		} catch (Exception e) {
			rollback();
			throw e;
		}
		
	}	
	
	public Usuario cadastrarCliente(DocumentoTipoEnum documentoTipo, String documento, String nome, String email, String senha) throws Exception {
		
		if(emailDAO.isEmailExistente(email)){
		throw new Exception("O e-mail utilizado ja consta na base de dados.");
		}
		if(pessoaDAO.isDocumentoCadastrado(documento, documentoTipo)){
			throw new Exception("O documento utilizado ja consta na base de dados.");
		}
		
		Usuario usuario = null;
		try {
			
			beginTransaction();
			
			Pessoa pessoa = pessoaDAO.cadastrarPessoa(documentoTipo, documento, nome);
			
			Email emailRetorno = emailDAO.cadastrarEmail(pessoa.getId(), email, true);
			Collection<Email> emails = new ArrayList<Email>();
			emails.add(emailRetorno);
			pessoa.setEmails(emails);
			
			usuario = usuarioDAO.cadastrarUsuario(pessoa.getId(), senha, UsuarioTipoEnum.CLIENTE.getCodigo());
			
			usuario.setPessoa(pessoa);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		usuario.setSenha(null);
		
		return usuario;
		
	}

	public LojaDAO getLojaDAO() {
		return lojaDAO;
	}

	public void setLojaDAO(LojaDAO lojaDAO) {
		this.lojaDAO = lojaDAO;
	}

}