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
@Table(name = "contrato_loja")
public class ContratoLoja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;
	
	@Column(name = "usuario_executante_id", nullable = false, length = 11)
	private int usuarioExecutanteId;
	
	@Column(name = "inicio_vigencia", nullable = true)
	private Date inicioVigencia;
	
	@Column(name = "fim_vigencia", nullable = true)
	private Date fimVigencia;
	
	@Column(name = "status", nullable = true, length = 2)
	private Integer status;
	
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

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public int getUsuarioExecutanteId() {
		return usuarioExecutanteId;
	}

	public void setUsuarioExecutanteId(int usuarioExecutanteId) {
		this.usuarioExecutanteId = usuarioExecutanteId;
	}
	
}