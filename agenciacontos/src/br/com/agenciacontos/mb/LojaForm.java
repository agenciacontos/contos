package br.com.agenciacontos.mb;

import java.io.Serializable;
import java.util.List;

import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.model.Loja;

public class LojaForm implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer documentoTipoLoja = DocumentoTipoEnum.CNPJ.getCodigo();
	private String cpfLoja;
	private String cnpjLoja;
	private String nomeLoja;
	private Integer documentoTipoPessoa = DocumentoTipoEnum.CPF.getCodigo();
	private String cpfPessoa;
	private String cnpjPessoa;
	private String nomePessoa;
	
	private Integer documentoTipo = DocumentoTipoEnum.CNPJ.getCodigo();
	private String cpf;
	private String cnpj;
	private String nomeFantasia;
	private String email;
	private boolean indicadorMatriz = false;
	
	private List<Loja> lojas;

	public Integer getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIndicadorMatriz() {
		return indicadorMatriz;
	}

	public void setIndicadorMatriz(boolean indicadorMatriz) {
		this.indicadorMatriz = indicadorMatriz;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Integer getDocumentoTipoLoja() {
		return documentoTipoLoja;
	}

	public void setDocumentoTipoLoja(Integer documentoTipoLoja) {
		this.documentoTipoLoja = documentoTipoLoja;
	}

	public String getCpfLoja() {
		return cpfLoja;
	}

	public void setCpfLoja(String cpfLoja) {
		this.cpfLoja = cpfLoja;
	}

	public String getCnpjLoja() {
		return cnpjLoja;
	}

	public void setCnpjLoja(String cnpjLoja) {
		this.cnpjLoja = cnpjLoja;
	}

	public Integer getDocumentoTipoPessoa() {
		return documentoTipoPessoa;
	}

	public void setDocumentoTipoPessoa(Integer documentoTipoPessoa) {
		this.documentoTipoPessoa = documentoTipoPessoa;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getCnpjPessoa() {
		return cnpjPessoa;
	}

	public void setCnpjPessoa(String cnpjPessoa) {
		this.cnpjPessoa = cnpjPessoa;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	
}
