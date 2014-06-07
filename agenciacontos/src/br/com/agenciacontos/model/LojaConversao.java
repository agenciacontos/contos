package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loja_conversao")
public class LojaConversao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;

	@Id
	@Column(name = "campanha_id", nullable = false, length = 11)
	private int camapanhaId;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return lojaId+camapanhaId;
	}

	@Override
	public boolean equals(Object obj) {

		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public int getLojaId() {
		return lojaId;
	}

	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
	}

	public int getCamapanhaId() {
		return camapanhaId;
	}

	public void setCamapanhaId(int camapanhaId) {
		this.camapanhaId = camapanhaId;
	}

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}
}