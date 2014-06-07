package br.com.agenciacontos.enums;

public enum UsuarioIdentificacaoTipoEnum {
	
	CPF(1, "CPF"), 
	CNPJ(2, "CNPJ"),
	EMAIL(3, "E-Mail");
	
	private int codigo;
	private String texto;
	
	private UsuarioIdentificacaoTipoEnum(int codigo, String texto) {
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