package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import br.com.agenciacontos.dao.PessoaDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioTipoEnum;
import br.com.agenciacontos.model.Email;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.util.Utils;

public class PessoaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private PessoaDAO pessoaDAO;
	
	public Pessoa cadastrarPessoa(DocumentoTipoEnum documentoTipo, Integer documento, String nome, String email) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setUsuarioTipo(UsuarioTipoEnum.CLIENTE.getCodigo());
		
		Pessoa pessoa = new Pessoa();
		pessoa.setDocumento(String.valueOf(documento));
		pessoa.setDocumentoTipo(documentoTipo.getCodigo());
		pessoa.setNome(nome);
//		pessoa.setDataNascimento(dataNascimento);
		Collection<Email> emails = new ArrayList<Email>();
//		emails.add(new Email());
//		pessoa.setEmails(emails);
		pessoa.setCriado(Utils.getDataHoraAtual());
		pessoa.setModificado(Utils.getDataHoraAtual());
//		pessoa.setNumeroSRF(numeroSRF);
//		pessoa.setId(id);
//		pessoa.setLojaMatrizId(lojaMatrizId);
//		
		pessoaDAO.beginTransaction();
		pessoaDAO.save(pessoa);
		pessoaDAO.commit();
		
		// TODO Pegar aqui a pessoa que foi cadastrada, com ID etc
		return pessoa;
		
	}

}