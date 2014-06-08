package br.com.agenciacontos.mb;

import java.io.Serializable;

import br.com.agenciacontos.enums.DocumentoTipoEnum;

public class UsuarioForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8745326714505189940L;
	private Integer documentoTipo;
	private String documento;
	private String nome;
	private String email;
	private String senha;
	
	public boolean isDocumentoTipoCpf(){
		System.out.println("isDocumentoTipoCpf() "+documentoTipo);
		return (documentoTipo == DocumentoTipoEnum.CPF.getCodigo());
	}
	public boolean isDocumentoTipoCnpj(){
		System.out.println("isDocumentoTipoCnpj() "+documentoTipo);
		return (documentoTipo == DocumentoTipoEnum.CNPJ.getCodigo());
	}
	public void setDocumentoTipoCpf(){
		System.out.println("setDocumentoTipoCpf "+documentoTipo);
		documentoTipo = DocumentoTipoEnum.CPF.getCodigo();
//		return "";
	}
	public void setDocumentoTipoCnpj(){
		System.out.println("setDocumentoTipoCnpj "+documentoTipo);
		documentoTipo = DocumentoTipoEnum.CNPJ.getCodigo();
//		return "";
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getDocumentoTipo() {
		System.out.println("getDocumentoTipo()");
		return documentoTipo;
	}
	public void setDocumentoTipo(Integer documentoTipo) {
		System.out.println("setDocumentoTipo()");
		this.documentoTipo = documentoTipo;
	}
	
}
