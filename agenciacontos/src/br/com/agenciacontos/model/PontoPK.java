package br.com.agenciacontos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class PontoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public PontoPK() {
	}
	
	public PontoPK(int id, int lojaId) {
		super();
		this.id = id;
		this.lojaId = lojaId;
	}

	@Column(name = "ponto_id", nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;

	@Override
	public int hashCode() {
		return id+lojaId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PontoPK) {
			PontoPK emailPK = (PontoPK) obj;
			return emailPK.id == this.id && emailPK.lojaId == this.lojaId;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLojaId() {
		return lojaId;
	}

	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
	}

}