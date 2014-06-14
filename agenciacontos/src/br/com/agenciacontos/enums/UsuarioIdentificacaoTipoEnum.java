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
	
	public static UsuarioIdentificacaoTipoEnum getUsuarioIdentificacaoTipoFromCodigo(int codigo){
		
		for (UsuarioIdentificacaoTipoEnum usuarioIdentificacaoTipo : values()) {

			if (usuarioIdentificacaoTipo.getCodigo() == codigo) {

				return usuarioIdentificacaoTipo;

			}

		}

		return null;
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