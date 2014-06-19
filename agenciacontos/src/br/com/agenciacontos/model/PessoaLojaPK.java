package br.com.agenciacontos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class PessoaLojaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public PessoaLojaPK() {
	}
	
	public PessoaLojaPK(int pessoaId, int lojaId) {
		super();
		this.pessoaId = pessoaId;
		this.lojaId = lojaId;
	}
	
	@Id
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;
	
	@Id
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;

	@Override
	public int hashCode() {
		return pessoaId+lojaId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PessoaLojaPK) {
			PessoaLojaPK emailPK = (PessoaLojaPK) obj;
			return emailPK.pessoaId == this.pessoaId && emailPK.lojaId == this.lojaId;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public int getLojaId() {
		return lojaId;
	}

	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
	}


}