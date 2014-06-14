package br.com.agenciacontos.dao;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.model.Pessoa;
import br.com.agenciacontos.util.Utils;

public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	public Pessoa cadastrarPessoa(DocumentoTipoEnum documentoTipo, String documento, String nome) throws Exception {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setDocumento(Utils.somenteNumeros(documento));
		pessoa.setDocumentoTipo(documentoTipo.getCodigo());
		pessoa.setNome(nome);
//		pessoa.setDataNascimento(dataNascimento);
		
		pessoa.setCriado(Utils.getDataHoraAtual());
		pessoa.setModificado(Utils.getDataHoraAtual());
//		pessoa.setNumeroSRF(numeroSRF);
//		pessoa.setId(id);
//		pessoa.setLojaMatrizId(lojaMatrizId);
		
		getSession().persist(pessoa);
		
		return pessoa;
		
	}
	
	public Pessoa detalharPessoaPorId(Integer pessoaId) throws Exception {

		return (Pessoa) getSession().createCriteria(Pessoa.class)
        	.add(Restrictions.eq("pessoaId", pessoaId))
        	.uniqueResult();

	}
	
	public Pessoa detalharPessoaPorDocumento(String documento) throws Exception {

		documento = Utils.somenteNumeros(documento);
		
		return (Pessoa) getSession().createCriteria(Pessoa.class)
        	.add(Restrictions.eq("documento", documento))
        	.uniqueResult();

	}
	
	public boolean isDocumentoCadastrado(String documento, DocumentoTipoEnum documentoTipoEnum){
		
		documento = Utils.somenteNumeros(documento);
		
		Long qtd = (Long) getSession()
							.createCriteria(Pessoa.class)
							.add(Restrictions.eq("documento", documento))
							.setProjection(Projections.rowCount())
							.uniqueResult();
		
		return qtd >= 1;
		
	}

}
