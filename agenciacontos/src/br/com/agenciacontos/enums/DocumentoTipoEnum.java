package br.com.agenciacontos.enums;

public enum DocumentoTipoEnum {
	
	CPF(1, "CPF"), 
	CNPJ(2, "CNPJ");
	
	private int codigo;
	private String texto;
	
	private DocumentoTipoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getTexto() {
		return texto;
	}
	
	@Override
	public String toString() {
		return this.getTexto();
	}
	
}