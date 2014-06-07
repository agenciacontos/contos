package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "usuario_id", nullable = false, length = 11)
	private int usuarioId;

	@Column(name = "ddi", nullable = true, length = 5)
	private String ddi;

	@Column(name = "ddd", nullable = true, length = 5)
	private String ddd;

	@Column(name = "telefone", nullable = true, length = 15)
	private String telefone;

	@Column(name = "telefone_tipo", nullable = true, length = 20)
	private String telefoneTipo;

	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {

		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	
	/**
	 * GETS e SETS
	 * */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneTipo() {
		return telefoneTipo;
	}

	public void setTelefoneTipo(String telefoneTipo) {
		this.telefoneTipo = telefoneTipo;
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