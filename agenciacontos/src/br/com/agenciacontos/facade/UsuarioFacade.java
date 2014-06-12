package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import br.com.agenciacontos.dao.EmailDAO;
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
	
	public Usuario verificarDadosLogin(String email, String documento, String senha) throws Exception {
		
		Usuario usuario = usuarioDAO.verificarDadosLogin(email, documento, senha);
		
		return usuario;
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
		
		return usuario;
		
	}

}