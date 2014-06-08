package br.com.contos.enums;


public enum UsuarioTipoEnum {
	
	ADMIN(1, "Administrador"), 
	CLIENTE(2, "Cliente"), 
	LOJA(3, "Loja");
	
	private int codigo;
	private String texto;
	
	private UsuarioTipoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public static UsuarioTipoEnum getUsuarioTipoFromCodigo(int codigo){
		
		for (UsuarioTipoEnum usuarioTipo : values()) {

			if (usuarioTipo.getCodigo() == codigo) {

				return usuarioTipo;

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