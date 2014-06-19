package br.com.agenciacontos.enums;


public enum PessoaLojaFuncaoEnum {
	
	PROPRIETARIO(1, "Proprietário"), 
	VENDEDOR(2, "Vendedor");
	
	private int codigo;
	private String texto;
	
	private PessoaLojaFuncaoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public static PessoaLojaFuncaoEnum getPessoaLojaFuncaoFromCodigo(int codigo){
		
		for (PessoaLojaFuncaoEnum pessoaLojaFuncao : values()) {

			if (pessoaLojaFuncao.getCodigo() == codigo) {

				return pessoaLojaFuncao;

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