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
@Table(name = "usuario_loja")
public class UsuarioLoja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "usuario_id", nullable = false, length = 11)
	private int usuarioId;
	
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;
	
	@Column(name = "vigencia", nullable = true)
	private Date vigencia;
	
	@Column(name = "ativo", nullable = true, length = 1)
	private boolean ativo;
	
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

	public int getLojaId() {
		return lojaId;
	}

	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
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

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}