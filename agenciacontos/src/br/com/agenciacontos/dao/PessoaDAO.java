package br.com.agenciacontos.dao;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioTipoEnum;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.util.Utils;

public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	public Pessoa cadastrarPessoa(DocumentoTipoEnum documentoTipo, String documento, String nome, String email) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setUsuarioTipo(UsuarioTipoEnum.CLIENTE.getCodigo());
		
		Pessoa pessoa = new Pessoa();
		pessoa.setDocumento(documento);
		pessoa.setDocumentoTipo(documentoTipo.getCodigo());
		pessoa.setNome(nome);
//		pessoa.setDataNascimento(dataNascimento);
		
		
//		pessoa.setEmails(emails);
		pessoa.setCriado(Utils.getDataHoraAtual());
		pessoa.setModificado(Utils.getDataHoraAtual());
//		pessoa.setNumeroSRF(numeroSRF);
//		pessoa.setId(id);
//		pessoa.setLojaMatrizId(lojaMatrizId);
		
		getSession().persist(pessoa);
		
		return pessoa;
		
	}
	
	

	public void delete(Pessoa pessoa) {
//        	super.delete(pessoa.getId(), PEssoa.class);
	}
}
